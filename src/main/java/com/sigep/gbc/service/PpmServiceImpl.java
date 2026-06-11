package com.sigep.gbc.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.PpmRequestDto;
import com.sigep.gbc.dto.responseDto.PpmResponseDto;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.Ppm;
import com.sigep.gbc.entity.PpmActe;
import com.sigep.gbc.entity.PpmModePass;
import com.sigep.gbc.repository.PpmRepository;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


@Service
@RequiredArgsConstructor
public class PpmServiceImpl implements PpmService{
	
	private final PpmRepository repository;
	private final PpmModPassService ppmModPassService;
	private final PpmActeService ppmActeService;
	private final BudgetTypeService budgetTypeService;
	
	//Aristide
	@Autowired
	private DataSource dataSource;
	
	public int getNextNumForBudgetAndExercice(int idBudget, short exercice) {
	    
	    Integer maxNum = repository.findMaxNumByIdBudgetAndExercice(idBudget, exercice);
	    return (maxNum == null) ? 1 : maxNum + 1;
	}
	
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmResponseDto add(PpmRequestDto ppmRequestDto) {
		//Aristide
		//verifier si le ppm existe déja
		if(repository.existsById(ppmRequestDto.getIdPpm())) {
			throw new IllegalArgumentException("ce ppm existe déja");
			
		}
		//verifier le creditDispo,presente saisie...
		if(ppmRequestDto.getMontantEstime()== null
				|| ppmRequestDto.getMontDepEngNonLiq()==null
				|| ppmRequestDto.getCreditDispo()== null) {
			throw new IllegalArgumentException("les montants sont requis");
		}
		 if (ppmRequestDto.getMontantEstime() <= 0 
		            || ppmRequestDto.getMontDepEngNonLiq() < 0 
		            || ppmRequestDto.getCreditDispo() < 0) {
		        throw new IllegalArgumentException("Les montants  doivent être positifs");
		    }
		
		
		Ppm entity = new Ppm();
		entity.setIdPpm(ppmRequestDto.getIdPpm());
		entity.setExercice(ppmRequestDto.getExercice());
		entity.setNum(ppmRequestDto.getNum());
		entity.setMontantEstime(ppmRequestDto.getMontantEstime());
		entity.setMontDepEngNonLiq(ppmRequestDto.getMontDepEngNonLiq());
		entity.setCreditDispo(ppmRequestDto.getCreditDispo());
		entity.setNatPrestation(ppmRequestDto.getNatPrestation());
		entity.setNbLot(ppmRequestDto.getNbLot());
		entity.setDateLancement(ppmRequestDto.getDateLancement());
		entity.setDateRemiseOffre(ppmRequestDto.getDateRemiseOffre());
		entity.setNbJrsEvaluation(ppmRequestDto.getNbJrsEvaluation());
		entity.setDateProbDemar(ppmRequestDto.getDateProbDemar());
		entity.setDelaiExecJrs(ppmRequestDto.getDelaiExecJrs());
		entity.setDateButoire(ppmRequestDto.getDateButoire());
		entity.setDateEffectLance(ppmRequestDto.getDateEffectLance());
		entity.setDateAttribution(ppmRequestDto.getDateAttribution());
		entity.setMontantPasse(ppmRequestDto.getMontantPasse());
		
		if (ppmRequestDto.getIdPpmM() == null) {
			throw new IllegalArgumentException("Ppm need a PpmActe");
		}
		PpmActe ppmActe = ppmActeService.get(ppmRequestDto.getIdPpmM());
		entity.setPpmActe(ppmActe);
		
		if (ppmRequestDto.getAbrevMp() == null) {
			entity.setPpmModePass(null);
		} else {
			PpmModePass ppmModePass = ppmModPassService.get(ppmRequestDto.getAbrevMp());
			entity.setPpmModePass(ppmModePass);
		}
		
		if (ppmRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("Ppm need a BudgetType");
		}
		BudgetType budgetType = budgetTypeService.get(ppmRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		repository.save(entity);
		return GbcMapper2.ppmToPpmResponseDto(entity);
	}
	
	@Override
	public List<PpmResponseDto> getAll() {
		List<Ppm> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.ppmToPpmResponseDto(element))
				.collect(Collectors.toList());
	}
	
	
	
	@Override
	public Ppm get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Ppm with id: " + id + " could not be found"));
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmResponseDto getById(String id) {
		Ppm entity = get(id);
		return GbcMapper2.ppmToPpmResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmResponseDto delete(String id) {
		Ppm entity = get(id);
		repository.delete(entity);
		return GbcMapper2.ppmToPpmResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmResponseDto edit(String id, PpmRequestDto ppmRequestDto) {
		Ppm entity = get(id);
		entity.setExercice(ppmRequestDto.getExercice());
		entity.setNum(ppmRequestDto.getNum());
		entity.setMontantEstime(ppmRequestDto.getMontantEstime());
		entity.setMontDepEngNonLiq(ppmRequestDto.getMontDepEngNonLiq());
		entity.setCreditDispo(ppmRequestDto.getCreditDispo());
		entity.setNatPrestation(ppmRequestDto.getNatPrestation());
		entity.setNbLot(ppmRequestDto.getNbLot());
		entity.setDateLancement(ppmRequestDto.getDateLancement());
		entity.setDateRemiseOffre(ppmRequestDto.getDateRemiseOffre());
		entity.setNbJrsEvaluation(ppmRequestDto.getNbJrsEvaluation());
		entity.setDateProbDemar(ppmRequestDto.getDateProbDemar());
		entity.setDelaiExecJrs(ppmRequestDto.getDelaiExecJrs());
		entity.setDateButoire(ppmRequestDto.getDateButoire());
		entity.setDateEffectLance(ppmRequestDto.getDateEffectLance());
		entity.setDateAttribution(ppmRequestDto.getDateAttribution());
		entity.setMontantPasse(ppmRequestDto.getMontantPasse());
		
		if (ppmRequestDto.getIdPpmM() != null) {
			PpmActe ppmActe = ppmActeService.get(ppmRequestDto.getIdPpmM());
			entity.setPpmActe(ppmActe);
		}
		
		if (ppmRequestDto.getAbrevMp() == null) {
			entity.setPpmModePass(null);
		} else {
			PpmModePass ppmModePass = ppmModPassService.get(ppmRequestDto.getAbrevMp());
			entity.setPpmModePass(ppmModePass);
		}
		
		if (ppmRequestDto.getIdBudget() == null) {
			BudgetType budgetType = budgetTypeService.get(ppmRequestDto.getIdBudget());
			entity.setBudgetType(budgetType);
		}
		
		return GbcMapper2.ppmToPpmResponseDto(entity);
	}
	
	//Aristide
	@Override
	public List<PpmResponseDto> getByIdBudgetAndExercice (Integer idBudget, Short exercice) {
		List<Ppm> list = repository.findByBudgetTypeIdBudgetAndExercice(idBudget, exercice);
		return list.stream()
				.map(GbcMapper2::ppmToPpmResponseDto)
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmResponseDto addReam(PpmRequestDto ppmRequestDto) {
		//Aristide
		//verifier si le ppm existe déja
		if(repository.existsById(ppmRequestDto.getIdPpm())) {
			throw new IllegalArgumentException("ce ppm existe déja");
			
		}
		//verifier le creditDispo,presente saisie...
		if(ppmRequestDto.getMontantEstime()== null
				|| ppmRequestDto.getMontDepEngNonLiq()==null
				|| ppmRequestDto.getCreditDispo()== null) {
			throw new IllegalArgumentException("les montants sont requis");
		}
		 if (ppmRequestDto.getReam() <= 0 
		            || ppmRequestDto.getMontDepEngNonLiq() < 0 
		            || ppmRequestDto.getCreditDispo() < 0) {
		        throw new IllegalArgumentException("Les montants  doivent être positifs");
		    }
		
		
		Ppm entity = new Ppm();
		entity.setIdPpm(ppmRequestDto.getIdPpm());
		entity.setExercice(ppmRequestDto.getExercice());
		entity.setNum(ppmRequestDto.getNum());
		entity.setMontantEstime(ppmRequestDto.getMontantEstime());
		entity.setMontDepEngNonLiq(ppmRequestDto.getMontDepEngNonLiq());
		entity.setCreditDispo(ppmRequestDto.getCreditDispo());
		entity.setNatPrestation(ppmRequestDto.getNatPrestation());
		entity.setNbLot(ppmRequestDto.getNbLot());
		entity.setDateLancement(ppmRequestDto.getDateLancement());
		entity.setDateRemiseOffre(ppmRequestDto.getDateRemiseOffre());
		entity.setNbJrsEvaluation(ppmRequestDto.getNbJrsEvaluation());
		entity.setDateProbDemar(ppmRequestDto.getDateProbDemar());
		entity.setDelaiExecJrs(ppmRequestDto.getDelaiExecJrs());
		entity.setDateButoire(ppmRequestDto.getDateButoire());
		entity.setDateEffectLance(ppmRequestDto.getDateEffectLance());
		entity.setDateAttribution(ppmRequestDto.getDateAttribution());
		entity.setMontantPasse(ppmRequestDto.getMontantPasse());
		entity.setReam(ppmRequestDto.getReam());
		
		if (ppmRequestDto.getIdPpmM() == null) {
			throw new IllegalArgumentException("Ppm need a PpmActe");
		}
		PpmActe ppmActe = ppmActeService.get(ppmRequestDto.getIdPpmM());
		entity.setPpmActe(ppmActe);
		
		if (ppmRequestDto.getAbrevMp() == null) {
			entity.setPpmModePass(null);
		} else {
			PpmModePass ppmModePass = ppmModPassService.get(ppmRequestDto.getAbrevMp());
			entity.setPpmModePass(ppmModePass);
		}
		
		if (ppmRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("Ppm need a BudgetType");
		}
		BudgetType budgetType = budgetTypeService.get(ppmRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		repository.save(entity);
		return GbcMapper2.ppmToPpmResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmResponseDto editReam(String id, PpmRequestDto ppmRequestDto) {
		Ppm entity = get(id);
		entity.setExercice(ppmRequestDto.getExercice());
		entity.setNum(ppmRequestDto.getNum());
		entity.setMontantEstime(ppmRequestDto.getMontantEstime());
		entity.setMontDepEngNonLiq(ppmRequestDto.getMontDepEngNonLiq());
		entity.setCreditDispo(ppmRequestDto.getCreditDispo());
		entity.setNatPrestation(ppmRequestDto.getNatPrestation());
		entity.setNbLot(ppmRequestDto.getNbLot());
		entity.setDateLancement(ppmRequestDto.getDateLancement());
		entity.setDateRemiseOffre(ppmRequestDto.getDateRemiseOffre());
		entity.setNbJrsEvaluation(ppmRequestDto.getNbJrsEvaluation());
		entity.setDateProbDemar(ppmRequestDto.getDateProbDemar());
		entity.setDelaiExecJrs(ppmRequestDto.getDelaiExecJrs());
		entity.setDateButoire(ppmRequestDto.getDateButoire());
		entity.setDateEffectLance(ppmRequestDto.getDateEffectLance());
		entity.setDateAttribution(ppmRequestDto.getDateAttribution());
		entity.setMontantPasse(ppmRequestDto.getMontantPasse());
		entity.setReam(ppmRequestDto.getReam());
		
		if (ppmRequestDto.getIdPpmM() != null) {
			PpmActe ppmActe = ppmActeService.get(ppmRequestDto.getIdPpmM());
			entity.setPpmActe(ppmActe);
		}
		
		if (ppmRequestDto.getAbrevMp() == null) {
			entity.setPpmModePass(null);
		} else {
			PpmModePass ppmModePass = ppmModPassService.get(ppmRequestDto.getAbrevMp());
			entity.setPpmModePass(ppmModePass);
		}
		
		if (ppmRequestDto.getIdBudget() == null) {
			BudgetType budgetType = budgetTypeService.get(ppmRequestDto.getIdBudget());
			entity.setBudgetType(budgetType);
		}
		
		return GbcMapper2.ppmToPpmResponseDto(entity);
	}
	
	@Override
	public byte[] generatePpmReport(Integer anneePPM) throws JRException,FileNotFoundException {
		final String mainReportResource = "reports/ppm-principal.jrxml";
	    final String subReportResource = "reports/sous-rapport-ppm.jrxml";
	    
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
		/*
		//definition des chemins
		String reportBaseDir = "classpath:reports/";
		String mainReportPath = reportBaseDir + "ppm-principal.jrxml";
		String subReportPath = reportBaseDir + "sous-rapport-ppm.jrxml";
		
		File mainReportFile = ResourceUtils.getFile(mainReportPath);
		File subReportFile = ResourceUtils.getFile(subReportPath);
		
		//obtenir le chemin absolu du répertoire des sous-rapports 
		String subReportDirectory = subReportFile.getParentFile().getAbsolutePath() + File.separator;
		
		//compilation
		JasperReport mainReport = JasperCompileManager.compileReport(mainReportFile.getAbsolutePath());
		JasperReport subReport = JasperCompileManager.compileReport(subReportFile.getAbsolutePath());
		
		Locale reportLocale = Locale.FRANCE;
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("anneePPM", anneePPM);
		parameters.put("SUBREPORT_PARAM", subReport);
		parameters.put("SUBREPORT_DIR", subReportDirectory);
		parameters.put("REPORT_LOCALE", reportLocale);
		
		try (Connection connection = dataSource.getConnection()){
			JasperPrint jasperPrint = JasperFillManager.fillReport(mainReport, parameters, connection);
			
			//exporter le rapport en format pdf
			return JasperExportManager.exportReportToPdf(jasperPrint);
		} catch (Exception e) {
			 e.printStackTrace();
			 throw new JRException("Erreur lors de la génération du rapport: " + e.getMessage());
		}*/
	}
	
}
