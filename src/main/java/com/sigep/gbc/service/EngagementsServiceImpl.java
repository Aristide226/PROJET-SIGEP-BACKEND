package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.requestDto.EngagementsRequestDto;
import com.sigep.gbc.dto.responseDto.EngagementsResponseDto;
import com.sigep.gbc.entity.Budget;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.Contrats;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.Engagements;
import com.sigep.gbc.entity.EtatDossier;
import com.sigep.gbc.entity.EtatTransmission;
import com.sigep.gbc.entity.Gestion;
import com.sigep.gbc.entity.Mandats;
import com.sigep.gbc.entity.Procedures;
import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.model.IdEngAction;
import com.sigep.gbc.model.IdEngsCodBord;
import com.sigep.gbc.model.InfosPourAbandonnerEngagement;
import com.sigep.gbc.model.InfosPourRetrograderEngagement;
import com.sigep.gbc.model.InfosPourValiderEngagement;
import com.sigep.gbc.model.InfosPourValiderOuRejeterEngagement;
import com.sigep.gbc.repository.EngagementsRepository;
import com.sigep.gbc.repository.MandatsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EngagementsServiceImpl implements EngagementsService{
	
	private final EngagementsRepository repository;
	private final ContratsService contratsService;
	private final EtatDossierService etatDossierService;
	private final EtatTransmissionService etatTransmissionService;
	private final ProcedureService procedureService;
	private final BudgetService budgetService;
	private final BudgetTypeService budgetTypeService;
	private final DestinatairesService destinatairesService;
	private final GestionService gestionService;
	private final MandatsRepository mandatsRepository;
	private final MotifsRejetDossierService motifsRejetDossierService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public EngagementsResponseDto add(EngagementsRequestDto engagementsRequestDto) {
		Engagements entity = new Engagements();
		entity.setNumBe(repository.getNumBE());
		entity.setBenum(repository.getBENum(engagementsRequestDto.getGestion()));
		entity.setDateCreation(engagementsRequestDto.getDateCreation()); 
		entity.setNatDepense(engagementsRequestDto.getNatDepense());
		entity.setAuProfit(engagementsRequestDto.getAuProfit());
		entity.setMontant(engagementsRequestDto.getMontant());
		entity.setDotInitiale(engagementsRequestDto.getDotInitiale());
		entity.setDispoAvant(engagementsRequestDto.getDispoAvant());
		entity.setDateEtat(engagementsRequestDto.getDateEtat());
		entity.setIdUser(engagementsRequestDto.getIdUser());
		entity.setAvecDecision(engagementsRequestDto.getAvecDecision());
		entity.setApartirDemandLiq(engagementsRequestDto.getApartirDemandLiq());
		entity.setGrh(engagementsRequestDto.getGrh());
		entity.setReceptionne(engagementsRequestDto.getReceptionne());
		entity.setDateValid(engagementsRequestDto.getDateValid());
		entity.setDateCreat(engagementsRequestDto.getDateCreat());
		entity.setCodLiq(engagementsRequestDto.getCodLiq());
		entity.setIdBord(engagementsRequestDto.getCodBord());
		
		if (engagementsRequestDto.getIdContrat() == null) {
			entity.setContrats(null);
		} else {
			Contrats contrat = contratsService.get(engagementsRequestDto.getIdContrat());
			entity.setContrats(contrat);
		}
		
		if (engagementsRequestDto.getIdEngParent() == null) {
			entity.setEngagementsByIdEng(null);
		} else {
			Engagements engagement = get(engagementsRequestDto.getIdEngParent());
			entity.setEngagementsByIdEng(engagement);
		}
		
		if (engagementsRequestDto.getEtat() == null) {
			throw new IllegalArgumentException("Engagements need a EtatDossier");
		}
		EtatDossier etatDossier = etatDossierService.get(engagementsRequestDto.getEtat());
		entity.setEtatDossier(etatDossier);
		
		if (engagementsRequestDto.getIdEtatTrans() == null) {
			throw new IllegalArgumentException("Engagements need a EtatTransmission");
		}
		EtatTransmission etatTransmission = etatTransmissionService.get(engagementsRequestDto.getIdEtatTrans());
		entity.setEtatTransmission(etatTransmission);
		
		if (engagementsRequestDto.getProced() == null) {
			throw new IllegalArgumentException("Engagements need a Procedure");
		}
		Procedures procedure = procedureService.get(engagementsRequestDto.getProced());
		entity.setProcedures(procedure);
		
		if (engagementsRequestDto.getCodBud() == null) {
			throw new IllegalArgumentException("Engagements need a Budget");
		}
		Budget budget = budgetService.get(engagementsRequestDto.getCodBud());
		entity.setBudget(budget);
		
		if (engagementsRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("Engagements need a BudgetType");
		}
		BudgetType budgetType = budgetTypeService.get(engagementsRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		if (engagementsRequestDto.getIdFourn() == null) {
			throw new IllegalArgumentException("Engagements need a Destinataire");
		}
		Destinataires destinataires = destinatairesService.get(engagementsRequestDto.getIdFourn());
		entity.setDestinataires(destinataires);
		
		if (engagementsRequestDto.getGestion() == null) {
			throw new IllegalArgumentException("Engagements need a Gestion");
		}
		Gestion gestion = gestionService.get(engagementsRequestDto.getGestion());
		entity.setGestion(gestion);

		repository.save(entity);
		return GbcMapper.engToEngResponseDto(entity);
	}
	
	@Override
	public List<EngagementsResponseDto> getAll() {
		List<Engagements> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.engToEngResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public Engagements get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Engagements with id: " + id + " could not be found"));
	}
	
	@Override
	public EngagementsResponseDto getById(Long id) {
		Engagements entity = get(id);
		return GbcMapper.engToEngResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public EngagementsResponseDto delete(Long id) {
		Engagements entity = get(id);
		repository.delete(entity);
		return GbcMapper.engToEngResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public EngagementsResponseDto edit(Long id, EngagementsRequestDto engagementsRequestDto) {
		Engagements entity = get(id);
		entity.setDateCreation(engagementsRequestDto.getDateCreation()); 
		entity.setNatDepense(engagementsRequestDto.getNatDepense());
		entity.setAuProfit(engagementsRequestDto.getAuProfit());
		entity.setMontant(engagementsRequestDto.getMontant());
		entity.setDotInitiale(engagementsRequestDto.getDotInitiale());
		entity.setDispoAvant(engagementsRequestDto.getDispoAvant());
		entity.setDateEtat(engagementsRequestDto.getDateEtat());
		entity.setIdUser(engagementsRequestDto.getIdUser());
		entity.setAvecDecision(engagementsRequestDto.getAvecDecision());
		entity.setApartirDemandLiq(engagementsRequestDto.getApartirDemandLiq());
		entity.setGrh(engagementsRequestDto.getGrh());
		entity.setReceptionne(engagementsRequestDto.getReceptionne());
		entity.setDateValid(engagementsRequestDto.getDateValid());
		entity.setCodLiq(engagementsRequestDto.getCodLiq());
		entity.setIdBord(engagementsRequestDto.getCodBord());
		
		if (engagementsRequestDto.getIdContrat() == null) {
			entity.setContrats(null);
		} else {
			Contrats contrat = contratsService.get(engagementsRequestDto.getIdContrat());
			entity.setContrats(contrat);
		}
		
		if (engagementsRequestDto.getIdEngParent() == null) {
			entity.setEngagementsByIdEng(null);
		} else {
			Engagements engagement = get(engagementsRequestDto.getIdEngParent());
			entity.setEngagementsByIdEng(engagement);
		}
		
		if (engagementsRequestDto.getEtat() != null) {
			EtatDossier etatDossier = etatDossierService.get(engagementsRequestDto.getEtat());
			entity.setEtatDossier(etatDossier);
		}
		
		if (engagementsRequestDto.getIdEtatTrans() != null) {
			EtatTransmission etatTransmission = etatTransmissionService.get(engagementsRequestDto.getIdEtatTrans());
			entity.setEtatTransmission(etatTransmission);
		}
		
		if (engagementsRequestDto.getProced() != null) {
			Procedures procedure = procedureService.get(engagementsRequestDto.getProced());
			entity.setProcedures(procedure);
		}
		
		if (engagementsRequestDto.getCodBud() != null) {
			Budget budget = budgetService.get(engagementsRequestDto.getCodBud());
			entity.setBudget(budget);
		}
		
		if (engagementsRequestDto.getIdBudget() != null) {
			BudgetType budgetType = budgetTypeService.get(engagementsRequestDto.getIdBudget());
			entity.setBudgetType(budgetType);
		}
		
		if (engagementsRequestDto.getIdFourn() != null) {
			Destinataires destinataires = destinatairesService.get(engagementsRequestDto.getIdFourn());
			entity.setDestinataires(destinataires);
		}
		
		if (engagementsRequestDto.getGestion() != null) {
			Gestion gestion = gestionService.get(engagementsRequestDto.getGestion());
			entity.setGestion(gestion);
		}
		
		return GbcMapper.engToEngResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public Boolean abandonner(InfosPourAbandonnerEngagement infosPourAbandonnerEngagement) {
		try {
			Engagements entity = get(infosPourAbandonnerEngagement.getId());
			entity.setEtatDossier(etatDossierService.get("E9"));
			entity.setDateEtat(infosPourAbandonnerEngagement.getDate());
			entity.setIdUser(infosPourAbandonnerEngagement.getIdUser());
			
			if (entity.getProcedures().getProced().equals("EN02")) {
				Mandats mandat = mandatsRepository.findByEngagements(entity);
				if (mandat != null) {
					mandat.setEtatDossierByEtat(etatDossierService.get("M9"));
					mandat.setDateEtat(infosPourAbandonnerEngagement.getDate());
					mandat.setIdUser(infosPourAbandonnerEngagement.getIdUser());
					mandat.setEtatDossierByEtatBl(etatDossierService.get("L9"));
					mandat.setDateEtatBl(infosPourAbandonnerEngagement.getDate());
					mandatsRepository.save(mandat);
				}
			} 
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional("gbcTransactionManager")
	public Boolean valider(InfosPourValiderEngagement infosPourValiderEngagement) {
		try {
			for (Long id : infosPourValiderEngagement.getIds()) {
				Engagements entity = get(id);
				if (!entity.getEtatDossier().getEtat().equals("E3")) {
					entity.setEtatDossier(etatDossierService.get("E1"));
					entity.setDateEtat(infosPourValiderEngagement.getDate());
					entity.setIdUser(infosPourValiderEngagement.getIdUser());
					entity.setEtatTransmission(etatTransmissionService.get(0));
					
					if (entity.getProcedures().getProced().equals("EN02")) {
						Mandats mandat = mandatsRepository.findByEngagements(entity);
						if (mandat != null) {
							mandat.setEtatDossierByEtat(etatDossierService.get("M1"));
							mandat.setDateEtat(infosPourValiderEngagement.getDate());
							mandat.setIdUser(infosPourValiderEngagement.getIdUser());
							mandat.setEtatDossierByEtatBl(etatDossierService.get("L1"));
							mandat.setDateEtatBl(infosPourValiderEngagement.getDate());
							mandat.setEtatTransmissionByIdEtatTransM(etatTransmissionService.get(0));
							mandat.setEtatTransmissionByIdEtatTransL(etatTransmissionService.get(0));
							mandatsRepository.save(mandat);
						}
					}
				}	
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public Boolean retrograder(InfosPourRetrograderEngagement infosPourRetrograderEngagement) {
		try {
			for (Long id : infosPourRetrograderEngagement.getIds()) {
				Engagements entity = get(id);
				if (entity.getEtatDossier().getEtat().equals("E1")) {
					// ETAT EST A E1, C'EST A DIRE VALIDE MAIS NON TRANSMIS
					entity.setEtatDossier(etatDossierService.get("E0"));
					entity.setDateEtat(infosPourRetrograderEngagement.getDate());
					entity.setIdUser(infosPourRetrograderEngagement.getIdUser());
					entity.setEtatTransmission(etatTransmissionService.get(0));
					
					if (entity.getProcedures().getProced().equals("EN02")) {
						Mandats mandat = mandatsRepository.findByEngagements(entity);
						if (mandat != null) {
							mandat.setEtatDossierByEtat(etatDossierService.get("M0"));
							mandat.setDateEtat(infosPourRetrograderEngagement.getDate());
							mandat.setIdUser(infosPourRetrograderEngagement.getIdUser());
							mandat.setEtatDossierByEtatBl(etatDossierService.get("L0"));
							mandat.setDateEtatBl(infosPourRetrograderEngagement.getDate());
							mandat.setEtatTransmissionByIdEtatTransM(etatTransmissionService.get(0));
							mandat.setEtatTransmissionByIdEtatTransL(etatTransmissionService.get(0));
							mandatsRepository.save(mandat);
						}
					}
				} else {
					
					// ETAT EST A E2 OU E3, C'EST A DIRE VALIDE OU REJETE MAIS NON TRANSMIS 
					// IL FAUT SUPPRIMER LE MOTIF REJET DOSSIER CREE SI ETAT EST A E3
					if (entity.getEtatDossier().getEtat().equals("E3")) motifsRejetDossierService.deleteLastRecord(entity.getNumBe());
					
					entity.setEtatDossier(etatDossierService.get("E1"));
					entity.setDateEtat(infosPourRetrograderEngagement.getDate());
					entity.setIdUser(infosPourRetrograderEngagement.getIdUser());
					entity.setEtatTransmission(etatTransmissionService.get(1));
					
					if (entity.getProcedures().getProced().equals("EN02")) {
						Mandats mandat = mandatsRepository.findByEngagements(entity);
						if (mandat != null) {
							mandat.setEtatDossierByEtat(etatDossierService.get("M1"));
							mandat.setDateEtat(infosPourRetrograderEngagement.getDate());
							mandat.setIdUser(infosPourRetrograderEngagement.getIdUser());
							mandat.setEtatDossierByEtatBl(etatDossierService.get("L1"));
							mandat.setDateEtatBl(infosPourRetrograderEngagement.getDate());
							mandat.setEtatTransmissionByIdEtatTransM(etatTransmissionService.get(1));
							mandat.setEtatTransmissionByIdEtatTransL(etatTransmissionService.get(1));
							mandatsRepository.save(mandat);
						}
					}
				}	
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional("gbcTransactionManager")
	public Boolean validerOuRejeter(InfosPourValiderOuRejeterEngagement infosPourValiderOuRejeterEngagement) {
		try {
			for (IdEngAction idEngAction : infosPourValiderOuRejeterEngagement.getIdEngActions()) {
				Engagements entity = get(idEngAction.getIdEng());
				if (idEngAction.getAction().equals("V")) {
					entity.setEtatDossier(etatDossierService.get("E2"));
					entity.setDateEtat(infosPourValiderOuRejeterEngagement.getDate());
					entity.setIdUser(infosPourValiderOuRejeterEngagement.getIdUser());
					entity.setEtatTransmission(etatTransmissionService.get(0));
					
					if (entity.getProcedures().getProced().equals("EN02")) {
						Mandats mandat = mandatsRepository.findByEngagements(entity);
						if (mandat != null) {
							mandat.setEtatDossierByEtat(etatDossierService.get("M2"));
							mandat.setDateEtat(infosPourValiderOuRejeterEngagement.getDate());
							mandat.setIdUser(infosPourValiderOuRejeterEngagement.getIdUser());
							mandat.setEtatDossierByEtatBl(etatDossierService.get("L2"));
							mandat.setDateEtatBl(infosPourValiderOuRejeterEngagement.getDate());
							mandat.setEtatTransmissionByIdEtatTransM(etatTransmissionService.get(0));
							mandat.setEtatTransmissionByIdEtatTransL(etatTransmissionService.get(0));
							mandatsRepository.save(mandat);
						}
					}
				} else {
					// IMPLEMENTATION DU REJET
					if (idEngAction.getMotifsRejetDossierRequestDto().getMotifs() != null) {
						if (idEngAction.getMotifsRejetDossierRequestDto().getMotifs() != "") {
							entity.setEtatDossier(etatDossierService.get("E3"));
							entity.setDateEtat(infosPourValiderOuRejeterEngagement.getDate());
							entity.setIdUser(infosPourValiderOuRejeterEngagement.getIdUser());
							entity.setEtatTransmission(etatTransmissionService.get(0));
							
							if (entity.getProcedures().getProced().equals("EN02")) {
								Mandats mandat = mandatsRepository.findByEngagements(entity);
								if (mandat != null) {
									mandat.setEtatDossierByEtat(etatDossierService.get("M3"));
									mandat.setDateEtat(infosPourValiderOuRejeterEngagement.getDate());
									mandat.setIdUser(infosPourValiderOuRejeterEngagement.getIdUser());
									mandat.setEtatDossierByEtatBl(etatDossierService.get("L3"));
									mandat.setDateEtatBl(infosPourValiderOuRejeterEngagement.getDate());
									mandat.setEtatTransmissionByIdEtatTransM(etatTransmissionService.get(0));
									mandat.setEtatTransmissionByIdEtatTransL(etatTransmissionService.get(0));
									mandatsRepository.save(mandat);
								}
							}
							
							motifsRejetDossierService.add(idEngAction.getMotifsRejetDossierRequestDto());
						}
					}
				}
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public Boolean transmettre(IdEngsCodBord idEngsCodBord) {
		try {
			for (Long id : idEngsCodBord.getIds()) {
				Engagements entity = get(id);
				entity.setIdBord(idEngsCodBord.getCodBord());
				entity.setEtatTransmission(etatTransmissionService.get(1));
				if (entity.getEtatDossier().getEtat().equals("E3")) entity.setReceptionne(false);
				
				if (entity.getProcedures().getProced().equals("EN02")) {
					Mandats mandat = mandatsRepository.findByEngagements(entity);
					if (mandat != null) {
						mandat.setIdBord(idEngsCodBord.getCodBord());
						mandat.setEtatTransmissionByIdEtatTransM(etatTransmissionService.get(1));
						mandat.setEtatTransmissionByIdEtatTransL(etatTransmissionService.get(1));
						if (entity.getEtatDossier().getEtat().equals("E3")) mandat.setReceptionne(false);
						mandatsRepository.save(mandat);
					}
				}	
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public Boolean receptionner(List<Long> codBords) {
		try {
			for (Long codBord : codBords) {
				repository.receptionner(codBord);
				
				// SI EN02 ALORS receptionne = 1
				mandatsRepository.receptionnerEN02(codBord);	
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
