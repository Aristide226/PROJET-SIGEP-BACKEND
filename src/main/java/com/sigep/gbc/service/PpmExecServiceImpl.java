//Aristide
package com.sigep.gbc.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.PpmExecBudgRequestDto;
import com.sigep.gbc.dto.requestDto.PpmExecRequestDto;
import com.sigep.gbc.dto.responseDto.PpmExecBudgResponseDto;
import com.sigep.gbc.dto.responseDto.PpmExecResponseDto;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.Ppm;
import com.sigep.gbc.entity.PpmBudg;
import com.sigep.gbc.entity.PpmExec;
import com.sigep.gbc.entity.PpmExecId;
import com.sigep.gbc.entity.PpmModePass;
import com.sigep.gbc.repository.PpmExecRepository;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
@RequiredArgsConstructor
public class PpmExecServiceImpl implements PpmExecService{
	
	@Autowired
	private DataSource dataSource;
	
	private final PpmExecRepository repository;
	private final PpmModPassService ppmModPassService;
	private final PpmService ppmService;
	@Lazy
	private final PpmExecBudgService ppmExecBudgService;
	private final DestinatairesService destinatairesService;
	
	private final PpmBudgService ppmBudgservice;
	
	@Override
	@Transactional
	public PpmExecResponseDto add(PpmExecRequestDto ppmExecRequestDto) {
		
		String idPpm = ppmExecRequestDto.getIdPpm();
	    if (idPpm == null) {
	        throw new IllegalArgumentException("PpmExec need a IdPpm");
	    }
	    
	    Ppm ppmEntiy = ppmService.get(idPpm);
	    if(ppmEntiy == null) {
	    	throw new ResourceNotFoundException("IdPpm :"+ idPpm + " est introuvable");
	    }
	    
	    int newIdPpmExec = ppmExecRequestDto.getIdPpmExec();
	    if(newIdPpmExec <= 0) {
	    	Integer maxIdPpmExec = repository.findMaxIdPpmExec();
	    	newIdPpmExec = (maxIdPpmExec == null ) ? 1 : maxIdPpmExec + 1;
	    }
	    
	    //VÉRIFICATION DE L'EXISTENCE ET DE LA CONTRAINTE NBLOT
	    List<PpmExec> existingLots = repository.findByPpmKeyAndBudgetAndExercice(idPpm, ppmExecRequestDto.getIdBudget(),ppmExecRequestDto.getExercice());
	    int nbLotPrevu = ppmExecRequestDto.getNbLot();
	    int lotsEnregistres = existingLots.size();
	    if(lotsEnregistres >= nbLotPrevu) {
	    	throw new IllegalArgumentException("Le nombre maximum de lots prévus a été atteint pour ce PPM");
	    }
	    
	    //determiner l'ID du nouveau lot
	    int newIdLot = lotsEnregistres + 1;
	    
	    //calcul du montantAttrib du lot (somme des PpmExecBudg)
	    Long montantAttribNouveauLot = ppmExecRequestDto.getLignesBudgetaires().stream()
	            .mapToLong(PpmExecBudgRequestDto::getMontantEstime)
	            .sum();
	    
	    for (PpmExecBudgRequestDto budgDto : ppmExecRequestDto.getLignesBudgetaires()) {
	    	PpmBudg ppmBudg = ppmBudgservice.get(idPpm, budgDto.getCodBud(), budgDto.getIdSrceFin());
	    	
	    	Long montantEstimePpmBudg = ppmBudg.getMontantEstime();
	    	Long montantSaisiPourCeLot = budgDto.getMontantEstime();
	    	
	    	Long montantDejaAttribue = ppmExecBudgService.getMontantCumuleByIdPpmBudg(
	                idPpm, budgDto.getCodBud(), budgDto.getIdSrceFin()
	            );
	    	Long nouveauCumulTotal = montantDejaAttribue + montantSaisiPourCeLot;
	    	
	    	if (nouveauCumulTotal > montantEstimePpmBudg) {
	    		Long montantDisponible = montantEstimePpmBudg - montantDejaAttribue;
	            throw new IllegalArgumentException(
	                "La ligne budgétaire (" + budgDto.getCodBud() + ") dépasse le budget PPM initial. " +
	                "Montant disponible pour cette ligne: " + montantDisponible + "."
	            );
	        }
	    }
	    
	    Long montantEstimeGlobal = ppmExecRequestDto.getMontantEstime();
	    Long montantAttribCumule = existingLots.stream()
	            .mapToLong(PpmExec::getMontantAttrib)
	            .sum();
	    
	    Long nouveauMontantAttribTotal = montantAttribCumule + montantAttribNouveauLot;
	    if (nouveauMontantAttribTotal > montantEstimeGlobal) {
            Long montantRestantDisponible = montantEstimeGlobal - montantAttribCumule;
            throw new IllegalArgumentException(
                "Le montant attribué cumulé (" + nouveauMontantAttribTotal + ") dépasse le montant estimé (" + montantEstimeGlobal + 
                "). Montant maximum autorisé pour ce lot : " + montantRestantDisponible + "."
            );
       }
		
		PpmModePass ppmModePass = null;
        if (ppmExecRequestDto.getAbrevMp() != null) {
            ppmModePass = ppmModPassService.get(ppmExecRequestDto.getAbrevMp());
        }
       
        Ppm ppmEntity = ppmService.get(idPpm);
        if (ppmEntity == null) {
            throw new ResourceNotFoundException(" IdPpm :" + idPpm + " est introuvable");
       }
       
        long idFourn = ppmExecRequestDto.getIdFourn();
        Destinataires fournisseur = null;
        if (idFourn >= 0) {
        	try {
        		fournisseur = destinatairesService.get(idFourn);
        		if (!"F".equals(fournisseur.getFtype())) {
                    throw new IllegalArgumentException("L'ID destinataire " + idFourn + " n'est pas un fournisseur ");
                }
        	} catch (IllegalArgumentException e) {
        		throw new ResourceNotFoundException("Fournisseur avec ID: " + idFourn + " est introuvable.");
        	}
        }
        
			PpmExec lotEntity = new PpmExec();
		
			lotEntity.setId(new PpmExecId(
					newIdPpmExec,
					newIdLot,
					ppmExecRequestDto.getIdBudget(),
					ppmExecRequestDto.getExercice()
					));
            lotEntity.setNbLot(nbLotPrevu);
            lotEntity.setNum(ppmExecRequestDto.getNum());
            lotEntity.setMontantEstime(ppmExecRequestDto.getMontantEstime());
            lotEntity.setMontDepEngNonLiq(ppmExecRequestDto.getMontDepEngNonLiq());
            lotEntity.setCreditDispo(ppmExecRequestDto.getCreditDispo());
            lotEntity.setNatPrestation(ppmExecRequestDto.getNatPrestation());
            lotEntity.setDateCreation(ppmExecRequestDto.getDateCreation());
            lotEntity.setDateButoire(ppmExecRequestDto.getDateButoire());
            lotEntity.setExecution(ppmExecRequestDto.isExecution());
            lotEntity.setMontantTtc(ppmExecRequestDto.getMontantTtc());
            lotEntity.setMontantHtva(ppmExecRequestDto.getMontantHtva());
            lotEntity.setMontantMaxTtc(ppmExecRequestDto.getMontantMaxTtc());
            lotEntity.setMontantMaxHtva(ppmExecRequestDto.getMontantMaxHtva());
            lotEntity.setMontantMinTtc(ppmExecRequestDto.getMontantMinTtc());
            lotEntity.setMontantMinHtva(ppmExecRequestDto.getMontantMinHtva());
            lotEntity.setPpmModePass(ppmModePass);
            lotEntity.setPpm(ppmEntity);
            
            lotEntity.setObjetLot(ppmExecRequestDto.getObjetLot());
            lotEntity.setIdFourm(ppmExecRequestDto.getIdFourn());
            lotEntity.setMontantAttrib(montantAttribNouveauLot);
            lotEntity.setDateNotificationProvisoire(ppmExecRequestDto.getDateNotificationProvisoire());
            lotEntity.setDateApprobContrat(ppmExecRequestDto.getDateApprobContrat());
            lotEntity.setNiveauMiseEnOeuvreEtObservation(ppmExecRequestDto.getNiveauMiseEnOeuvreEtObservation());
            lotEntity.setDateReception(ppmExecRequestDto.getDateReception());
            lotEntity.setDateLancementMarchePrevisionnel(ppmExecRequestDto.getDateLancementMarchePrevisionnel());
            lotEntity.setDateLanceEffect(ppmExecRequestDto.getDateLanceEffect());
            lotEntity.setNbJoursRetardLancement(ppmExecRequestDto.getNbJoursRetardLancement());
            lotEntity.setDateRemiseEtOuvertureDesPlis(ppmExecRequestDto.getDateRemiseEtOuvertureDesPlis());
            PpmExec saveEntity = repository.save(lotEntity);
            
            
            for (PpmExecBudgRequestDto ppmExecBudgRequestDto : ppmExecRequestDto.getLignesBudgetaires()) {
            	ppmExecBudgRequestDto.setIdPpmExe(newIdPpmExec);
            	ppmExecBudgRequestDto.setIdLot(newIdLot);
            	ppmExecBudgRequestDto.setIdBudget(ppmExecRequestDto.getIdBudget());
            	ppmExecBudgRequestDto.setExercice(ppmExecRequestDto.getExercice());
            	
            	try {
                	ppmExecBudgService.add(ppmExecBudgRequestDto);
                } catch(Exception e) {
                	
                }
            }
      
            return GbcMapper2.PpmExecToPpmExecResponseDto(saveEntity);       
	}
	
	@Override
	public List<PpmExecResponseDto> getAll() {
		List<PpmExec> list = repository.findAll();
		return list
				.stream().map(element -> GbcMapper2.PpmExecToPpmExecResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public PpmExec get(int idPpmExec,int idLot, Integer idBudget, short exercice) {
		PpmExecId id = new PpmExecId();
		id.setIdPpmExec(idPpmExec);
		id.setIdLot(idLot);
		id.setIdBudget(idBudget);
		id.setExercice(exercice);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("PpmExec ith id: " + id + " could not be found"));
	}
	
	@Override
	public PpmExecResponseDto getById(int idPpmExec,int idLot, Integer idBudget, short exercice) {
		PpmExecId id = new PpmExecId();
		id.setIdPpmExec(idPpmExec);
		id.setIdLot(idLot);
		id.setIdBudget(idBudget);
		id.setExercice(exercice);
		PpmExec entity = repository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Lot avec IdPPMExec: " + idPpmExec + ", IdLot: " + idLot + " n'a pas été trouvé."));
		    
		return GbcMapper2.PpmExecToPpmExecResponseDto(entity);
		
	}
	
	@Override
	@Transactional
	public void delete(int idPpmExec,int idLot, Integer idBudget, short exercice) {
		ppmExecBudgService.deleteAllByLotId(idPpmExec, idLot, idBudget, exercice);
		PpmExecId id = new PpmExecId();
		id.setIdPpmExec(idPpmExec);
		id.setIdLot(idLot);
		id.setIdBudget(idBudget);
		id.setExercice(exercice);
		repository.deleteById(id);
	}
	
	@Override
	@Transactional
	public PpmExecResponseDto edit(int idPpmExec,int idLot, Integer idBudget, short exercice, PpmExecRequestDto ppmExecRequestDto) {
		
        String idPpm = ppmExecRequestDto.getIdPpm(); 
        if (idPpm == null || idPpm.trim().isEmpty()) {
            throw new IllegalArgumentException("PpmExec need a IdPpm");
        }
        
        //recuperation du lot existant à modifier
        PpmExecId id = new PpmExecId(idPpmExec, idLot, idBudget, exercice);
           
        PpmExec lotEntity = repository.findById(id).orElseThrow(() -> 
        	new ResourceNotFoundException("Lot avec ID: " + id + " n'existe pas ou a été supprimé."));
        
        Long montantAttribNouveauLot = ppmExecRequestDto.getLignesBudgetaires().stream()
        		.mapToLong(PpmExecBudgRequestDto::getMontantEstime)
        		.sum();
        
        //recuperation des lots existants
        List<PpmExec> existingLots = repository.findByIdPpmExecAndIdBudgetAndExercice(idPpmExec, idBudget, exercice);
        
        // Calcul du montant attribué cumulé des autres lots (hors celui-ci)
        Long montantAttribCumuleDesAutresLots = existingLots.stream()
        		.filter(lot -> !lot.getId().equals(id))
        		.mapToLong(PpmExec::getMontantAttrib)
        		.sum();
        
        for (PpmExecBudgRequestDto budgDto : ppmExecRequestDto.getLignesBudgetaires()) {
        	budgDto.setIdPpmExe(idPpmExec);
        	budgDto.setIdLot(idLot);
        	budgDto.setIdBudget(idBudget);
        	budgDto.setExercice(exercice);
        	
        	PpmBudg ppmBudg = ppmBudgservice.get(idPpm, budgDto.getCodBud(),budgDto.getIdSrceFin());
        	Long montantEstimePpmBudg = ppmBudg.getMontantEstime();
        	Long montantSaisiPourCeLot = budgDto.getMontantEstime();
        	
        	Long montantDejaAttribue = ppmExecBudgService.getMontantCumuleExcluantLotEnCours(
                    idPpm, budgDto.getCodBud(), budgDto.getIdSrceFin(), idPpmExec, idLot, idBudget, exercice
                );
        	if (montantDejaAttribue == null) montantDejaAttribue = 0L;
        	
        	Long nouveauCumulTotal = montantDejaAttribue + montantSaisiPourCeLot;
        	if (nouveauCumulTotal > montantEstimePpmBudg) {
                throw new IllegalArgumentException(
                    "La ligne budgétaire (" + budgDto.getCodBud() + ") dépasse le budget PPM initial" 
                );
            }
        }
        Long montantEstimeGlobal = ppmExecRequestDto.getMontantEstime();
        Long nouveauMontantAttribTotal = montantAttribCumuleDesAutresLots + montantAttribNouveauLot;
        
        if (nouveauMontantAttribTotal > montantEstimeGlobal) {
            throw new IllegalArgumentException(
                "Le montant attribué cumulé (" + nouveauMontantAttribTotal + ") dépasse le montant estimé (" + montantEstimeGlobal
            );
        }
        
        PpmModePass ppmModePass = null;
        if (ppmExecRequestDto.getAbrevMp() != null) {
            ppmModePass = ppmModPassService.get(ppmExecRequestDto.getAbrevMp());
        }
        
        Ppm ppmEntity = ppmService.get(idPpm);
        if (ppmEntity == null) {
             throw new ResourceNotFoundException("ID: " + idPpm + "introuvable.");
        }
        
            lotEntity.setNum(ppmExecRequestDto.getNum());
            lotEntity.setMontantEstime(ppmExecRequestDto.getMontantEstime());
            lotEntity.setMontDepEngNonLiq(ppmExecRequestDto.getMontDepEngNonLiq());
            lotEntity.setCreditDispo(ppmExecRequestDto.getCreditDispo());
            lotEntity.setNatPrestation(ppmExecRequestDto.getNatPrestation());
            lotEntity.setDateCreation(ppmExecRequestDto.getDateCreation());
            lotEntity.setDateButoire(ppmExecRequestDto.getDateButoire());
            lotEntity.setExecution(ppmExecRequestDto.isExecution());
            lotEntity.setMontantTtc(ppmExecRequestDto.getMontantTtc());
            lotEntity.setMontantHtva(ppmExecRequestDto.getMontantHtva());
            lotEntity.setMontantMaxTtc(ppmExecRequestDto.getMontantMaxTtc());
            lotEntity.setMontantMaxHtva(ppmExecRequestDto.getMontantMaxHtva());
            lotEntity.setMontantMinTtc(ppmExecRequestDto.getMontantMinTtc());
            lotEntity.setMontantMinHtva(ppmExecRequestDto.getMontantMinHtva());
            lotEntity.setPpmModePass(ppmModePass);
            lotEntity.setPpm(ppmEntity);
            
            lotEntity.setObjetLot(ppmExecRequestDto.getObjetLot());
            lotEntity.setIdFourm(ppmExecRequestDto.getIdFourn());
            lotEntity.setMontantAttrib(montantAttribNouveauLot);
            lotEntity.setDateNotificationProvisoire(ppmExecRequestDto.getDateNotificationProvisoire());
            lotEntity.setDateApprobContrat(ppmExecRequestDto.getDateApprobContrat());
            lotEntity.setNiveauMiseEnOeuvreEtObservation(ppmExecRequestDto.getNiveauMiseEnOeuvreEtObservation());
            lotEntity.setDateReception(ppmExecRequestDto.getDateReception());
            lotEntity.setDateLancementMarchePrevisionnel(ppmExecRequestDto.getDateLancementMarchePrevisionnel());
            lotEntity.setDateLanceEffect(ppmExecRequestDto.getDateLanceEffect());
            lotEntity.setNbJoursRetardLancement(ppmExecRequestDto.getNbJoursRetardLancement());
            lotEntity.setDateRemiseEtOuvertureDesPlis(ppmExecRequestDto.getDateRemiseEtOuvertureDesPlis());
            PpmExec updatedEntity = repository.save(lotEntity);
            
            //recuperation des anciennes lignes budgétaires
            List<PpmExecBudgResponseDto> anciennesLignesDto = ppmExecBudgService.getLignesByLot(idPpmExec, idLot, idBudget, exercice);
            
            List<String> anciennesCles = anciennesLignesDto.stream()
                    .map(l -> l.getCodBud() + "_" + l.getIdSrceFin())
                    .collect(Collectors.toList());
            
            List<String> nouvellesCles = ppmExecRequestDto.getLignesBudgetaires().stream()
                    .map(l -> l.getCodBud() + "_" + l.getIdSrceFin())
                    .collect(Collectors.toList());
            
            //suppression des anciennes lignes qui ne sont plus dans le dto
            for (PpmExecBudgResponseDto ancienneLigne : anciennesLignesDto) {
                String cle = ancienneLigne.getCodBud() + "_" + ancienneLigne.getIdSrceFin();
                if (!nouvellesCles.contains(cle)) {
                    ppmExecBudgService.delete(idPpmExec, idLot, idBudget, exercice, ancienneLigne.getCodBud(), ancienneLigne.getIdSrceFin());
                }
            }
            //ajout ou mises à jours des nouvelles lignes
            for (PpmExecBudgRequestDto budgDto : ppmExecRequestDto.getLignesBudgetaires()) {
            	String cle = budgDto.getCodBud() + "_" + budgDto.getIdSrceFin();
            	try {
            		if(anciennesCles.contains(cle)) {
            			ppmExecBudgService.edit(idPpmExec, idLot, idBudget, exercice, budgDto.getCodBud(), budgDto.getIdSrceFin(), budgDto);
            		} else {
            			ppmExecBudgService.add(budgDto);
            		}
            	} catch(Exception e) {
            		throw new RuntimeException("Erreur lors de la synchronisation de PpmExecBudg ");
            	}
            }
            return GbcMapper2.PpmExecToPpmExecResponseDto(updatedEntity);
    }
	
	@Override
	public List<PpmExecResponseDto> getAllLotsByIdPpmAndIdBudgetAndExercice(String idPpm, Integer idBudget, short exercice) {
	    
	    List<PpmExec> entity = repository.findByPpmKeyAndBudgetAndExercice(idPpm, idBudget, exercice);
	    return entity.stream()
	        .map(GbcMapper2::PpmExecToPpmExecResponseDto) 
	        .collect(Collectors.toList());
	}
	
	@Override
	public List<PpmExecResponseDto> getAllLotsByIdPpmExecAndIdBudgetAndExercice(int idPpmExec,Integer idBudget, short exercice) {
		List<PpmExec> entity = repository.findByIdPpmExecAndIdBudgetAndExercice(idPpmExec, idBudget, exercice);
		if(entity.isEmpty()) {
			throw new ResourceNotFoundException("Aucun PPM trouvé ");
		}
		return entity.stream()
				.map(GbcMapper2::PpmExecToPpmExecResponseDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public byte[] generatePpmExecReport(Integer anneePPM) throws JRException, FileNotFoundException {
				
		final String mainReportResource = "reports/ppm-execution-principal.jrxml";
	    final String subReportResource = "reports/ppm-execution-sous-rapport.jrxml";
	    
	    JasperReport mainReport = null;
	    JasperReport subReport = null;

	    try (
	        InputStream mainReportStream = getClass().getClassLoader().getResourceAsStream(mainReportResource);
	        InputStream subReportStream = getClass().getClassLoader().getResourceAsStream(subReportResource);
	    ) {
	        
	        if (mainReportStream == null) {
	            throw new JRException("Ressource de rapport principal JRXML introuvable : " + mainReportResource);
	        }
	        if (subReportStream == null) {
	             throw new JRException("Ressource de sous-rapport JRXML introuvable : " + subReportResource);
	        }

	        mainReport = JasperCompileManager.compileReport(mainReportStream);
	        subReport = JasperCompileManager.compileReport(subReportStream);

	        Locale reportLocale = Locale.FRANCE;
	        
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("anneePPM", anneePPM);
	        parameters.put("SUBREPORT_PARAM", subReport);
	        parameters.put("REPORT_LOCALE", reportLocale);
	        
	        try (Connection connection = dataSource.getConnection()) {
	            
	            JasperPrint jasperPrint = JasperFillManager.fillReport(mainReport, parameters, connection);
	            return JasperExportManager.exportReportToPdf(jasperPrint);
	        }
	        
	    } catch (JRException e) {
	        e.printStackTrace();
	        throw e;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new JRException("Erreur lors de la génération du rapport : " + e.getMessage(), e); 
	    }
	}
	
	@Override
	public byte[] generateVisibilitePrm(Integer anneePPM) throws JRException, FileNotFoundException {
				//definition des chemins
						
				final String mainReportResource = "reports/visibilité-de-prm-principal.jrxml";
			    final String subReportResource = "reports/visibilité-de-prm-sous-rapport.jrxml";
			    
			    JasperReport mainReport = null;
			    JasperReport subReport = null;

			    try (
			        InputStream mainReportStream = getClass().getClassLoader().getResourceAsStream(mainReportResource);
			        InputStream subReportStream = getClass().getClassLoader().getResourceAsStream(subReportResource);
			    ) {
			        
			        if (mainReportStream == null) {
			            throw new JRException("Ressource de rapport principal JRXML introuvable : " + mainReportResource);
			        }
			        if (subReportStream == null) {
			             throw new JRException("Ressource de sous-rapport JRXML introuvable : " + subReportResource);
			        }

			        mainReport = JasperCompileManager.compileReport(mainReportStream);
			        subReport = JasperCompileManager.compileReport(subReportStream);

			        Locale reportLocale = Locale.FRANCE;
			        
			        Map<String, Object> parameters = new HashMap<>();
			        parameters.put("anneePPM", anneePPM);
			        parameters.put("SUBREPORT_PARAM", subReport);
			        parameters.put("REPORT_LOCALE", reportLocale);
			        
			        try (Connection connection = dataSource.getConnection()) {
			            
			            JasperPrint jasperPrint = JasperFillManager.fillReport(mainReport, parameters, connection);
			            return JasperExportManager.exportReportToPdf(jasperPrint);
			        }
			        
			    } catch (JRException e) {
			        e.printStackTrace();
			        throw e;
			        
			    } catch (Exception e) {
			        e.printStackTrace();
			        throw new JRException("Erreur lors de la génération du rapport : " + e.getMessage(), e); 
			    }
	}
	
}
