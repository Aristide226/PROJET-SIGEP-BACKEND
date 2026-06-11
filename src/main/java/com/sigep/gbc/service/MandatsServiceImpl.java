package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.model.IdMandsIdBordEmis;
import com.sigep.gbc.model.InfosPourAbandonnerLiquidation;
import com.sigep.gbc.model.InfosPourRetrograderLiquidation;
import com.sigep.gbc.model.InfosPourValiderLiquidation;
import com.sigep.gbc.dto.requestDto.MandatsRequestDto;
import com.sigep.gbc.dto.responseDto.MandatsResponseDto;
import com.sigep.gbc.entity.BordereauEmismandats;
import com.sigep.gbc.entity.Budget;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.CompteDestinataire;
import com.sigep.gbc.entity.Contrats;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.Engagements;
import com.sigep.gbc.entity.EtatDossier;
import com.sigep.gbc.entity.EtatTransmission;
import com.sigep.gbc.entity.Gestion;
import com.sigep.gbc.entity.Mandats;
import com.sigep.gbc.repository.MandatsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MandatsServiceImpl implements MandatsService {
	
	private final MandatsRepository repository;
	private final EtatTransmissionService etatTransmissionService;
	private final BordereauEmismandatsService bordereauEmismandatsService;
	private final BudgetService budgetService;
	private final BudgetTypeService budgetTypeService;
	private final CompteDestinataireService compteDestinataireService;
	private final ContratsService contratsService;
	private final DestinatairesService destinatairesService;
	private final GestionService gestionService;
	private final EngagementsService engagementsService;
	private final EtatDossierService etatDossierService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public MandatsResponseDto add(MandatsRequestDto mandatsRequestDto) {
		Mandats entity = new Mandats();
		entity.setNumMand(repository.getNumMand());
		entity.setMandNum(repository.getMandNum(mandatsRequestDto.getGestion()));
		entity.setDateMand(mandatsRequestDto.getDateMand());
		entity.setMontant(mandatsRequestDto.getMontant());
		entity.setDateEtat(mandatsRequestDto.getDateEtat());
		entity.setDatePaie(mandatsRequestDto.getDatePaie());
		entity.setMontantPaie(mandatsRequestDto.getMontantPaie());
		entity.setIdCompte(mandatsRequestDto.getIdCompte());
		entity.setIdUser(mandatsRequestDto.getIdUser());
		entity.setDatePosition(mandatsRequestDto.getDatePosition());
		entity.setBenum(mandatsRequestDto.getBenum());
		if (engagementsService.get(mandatsRequestDto.getNumBe()).getProcedures().getProced().equals("EN01")) {
			entity.setNumBl(repository.getNumBlEN01(mandatsRequestDto.getNumBe()));
		} else {
			entity.setNumBl(1);
		}
		entity.setObjet(mandatsRequestDto.getObjet());
		entity.setMontEngage(mandatsRequestDto.getMontEngage());
		entity.setMontDjaLiq(mandatsRequestDto.getMontDjaLiq());
		entity.setDateEtatBl(mandatsRequestDto.getDateEtatBl());
		entity.setDatePec(mandatsRequestDto.getDatePec());
		entity.setReceptionne(mandatsRequestDto.getReceptionne());
		entity.setGenererOv(mandatsRequestDto.getGenererOv());
		entity.setAvecReversement(mandatsRequestDto.getAvecReversement());
		entity.setPrecompte(mandatsRequestDto.getPrecompte());
		entity.setDatePrecompte(mandatsRequestDto.getDatePrecompte());
		entity.setUserPrecompte(mandatsRequestDto.getUserPrecompte());
		entity.setDateValid(mandatsRequestDto.getDateValid());
		entity.setIdFiche(mandatsRequestDto.getIdFiche());
		entity.setMontantTotalPec(mandatsRequestDto.getMontantTotalPec());
		entity.setDateCreat(mandatsRequestDto.getDateCreat());
		entity.setEstOrdre(mandatsRequestDto.getEstOrdre());
		entity.setMandNumApresVisaCf(mandatsRequestDto.getMandNumApresVisaCf());
		
		if (mandatsRequestDto.getIdEtatTransL() == null) {
			throw new IllegalArgumentException("Mandats need a EtatTransmission L");
		}
		EtatTransmission etatTransmissionL = etatTransmissionService.get(mandatsRequestDto.getIdEtatTransL());
		entity.setEtatTransmissionByIdEtatTransL(etatTransmissionL);
		
		if (mandatsRequestDto.getIdEtatTransM() == null) {
			throw new IllegalArgumentException("Mandats need a EtatTransmission M");
		}
		EtatTransmission etatTransmissionM = etatTransmissionService.get(mandatsRequestDto.getIdEtatTransM());
		entity.setEtatTransmissionByIdEtatTransM(etatTransmissionM);
		
		if (mandatsRequestDto.getIdBordEmis() == null) {
			entity.setBordereauEmismandats(null);
		} else {
			BordereauEmismandats bordereauEmismandats = bordereauEmismandatsService.get(mandatsRequestDto.getIdBordEmis());
			entity.setBordereauEmismandats(bordereauEmismandats);
		}
		
		entity.setIdBord(mandatsRequestDto.getIdBord());
		
		if (mandatsRequestDto.getCodBud() == null) {
			throw new IllegalArgumentException("Mandats need a Budget");
		}
		Budget budget = budgetService.get(mandatsRequestDto.getCodBud());
		entity.setBudget(budget);
		
		if (mandatsRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("Mandats need a BudgetType");
		}
		BudgetType budgetType = budgetTypeService.get(mandatsRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		if (mandatsRequestDto.getCompteFourn() == null) {
			entity.setCompteDestinataire(null);
		} else {
			CompteDestinataire compteDestinataire = compteDestinataireService.get(mandatsRequestDto.getCompteFourn());
			entity.setCompteDestinataire(compteDestinataire);
		}
		
		if (mandatsRequestDto.getIdContrat() == null) {
			entity.setContrats(null);
		} else {
			Contrats contrat = contratsService.get(mandatsRequestDto.getIdContrat());
			entity.setContrats(contrat);
		}
		
		if (mandatsRequestDto.getIdFourn() == null) {
			throw new IllegalArgumentException("Mandats need a Destinataire");
		}
		Destinataires destinataires = destinatairesService.get(mandatsRequestDto.getIdFourn());
		entity.setDestinataires(destinataires);
		
		if (mandatsRequestDto.getGestion() == null) {
			throw new IllegalArgumentException("Mandats need a Gestion");
		}
		Gestion gestion = gestionService.get(mandatsRequestDto.getGestion());
		entity.setGestion(gestion);
		
		entity.setCodLiq(mandatsRequestDto.getCodLiq()); 
		entity.setIdLettrage(mandatsRequestDto.getIdLettrage()); 
		entity.setIdModePaie(mandatsRequestDto.getIdModePaie()); 
		
		if (mandatsRequestDto.getNumBe() == null) {
			throw new IllegalArgumentException("Mandats need a Engagement");
		}
		Engagements engagements = engagementsService.get(mandatsRequestDto.getNumBe());
		entity.setEngagements(engagements);
		
		if (mandatsRequestDto.getEtat() == null) {
			throw new IllegalArgumentException("Mandats need a EtatDossier By Etat");
		}
		EtatDossier etatDossierByEtat = etatDossierService.get(mandatsRequestDto.getEtat());
		entity.setEtatDossierByEtat(etatDossierByEtat);
		
		if (mandatsRequestDto.getEtatBl() == null) {
			throw new IllegalArgumentException("Mandats need a EtatDossier By Etat Bl");
		}
		EtatDossier etatDossierByEtatBl = etatDossierService.get(mandatsRequestDto.getEtatBl());
		entity.setEtatDossierByEtatBl(etatDossierByEtatBl);
		
		if (mandatsRequestDto.getNumMandParent() == null) {
			entity.setMandats(null);
		} else {
			Mandats mandats = get(mandatsRequestDto.getNumMandParent());
			entity.setMandats(mandats);
		}
		
		repository.save(entity);
		return GbcMapper2.mandatToMandatResponseDto(entity);
	}
	
	@Override
	public List<MandatsResponseDto> getAll() {
		List<Mandats> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.mandatToMandatResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public Mandats get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Mandat with id: " + id + " could not be found"));
	}
	
	@Override
	public MandatsResponseDto getById(Long id) {
		Mandats entity = get(id);
		return GbcMapper2.mandatToMandatResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public MandatsResponseDto delete(Long id) {
		Mandats entity = get(id);
		repository.delete(entity);
		return GbcMapper2.mandatToMandatResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public MandatsResponseDto edit(Long id, MandatsRequestDto mandatsRequestDto) {
		Mandats entity = get(id);
		entity.setDateMand(mandatsRequestDto.getDateMand());
		entity.setMontant(mandatsRequestDto.getMontant());
		entity.setDateEtat(mandatsRequestDto.getDateEtat());
		entity.setDatePaie(mandatsRequestDto.getDatePaie());
		entity.setMontantPaie(mandatsRequestDto.getMontantPaie());
		entity.setIdCompte(mandatsRequestDto.getIdCompte());
		entity.setIdUser(mandatsRequestDto.getIdUser());
		entity.setDatePosition(mandatsRequestDto.getDatePosition());
		entity.setBenum(mandatsRequestDto.getBenum());
		
		// NumBl CHANGE PENDANT LA MODIFICATION DANS LE SEUL CAS OU L'ON CHANGE L'ENGAGEMENT
		if (entity.getEngagements().getNumBe()!= mandatsRequestDto.getNumBe()) {
			if (engagementsService.get(mandatsRequestDto.getNumBe()).getProcedures().getProced().equals("EN01")) {
				entity.setNumBl(repository.getNumBlEN01(mandatsRequestDto.getNumBe()));
			} else {
				entity.setNumBl(1);
			}
		}
		
		entity.setObjet(mandatsRequestDto.getObjet());
		entity.setMontEngage(mandatsRequestDto.getMontEngage());
		entity.setMontDjaLiq(mandatsRequestDto.getMontDjaLiq());
		entity.setDateEtatBl(mandatsRequestDto.getDateEtatBl());
		entity.setDatePec(mandatsRequestDto.getDatePec());
		entity.setReceptionne(mandatsRequestDto.getReceptionne());
		entity.setGenererOv(mandatsRequestDto.getGenererOv());
		entity.setAvecReversement(mandatsRequestDto.getAvecReversement());
		entity.setPrecompte(mandatsRequestDto.getPrecompte());
		entity.setDatePrecompte(mandatsRequestDto.getDatePrecompte());
		entity.setUserPrecompte(mandatsRequestDto.getUserPrecompte());
		entity.setDateValid(mandatsRequestDto.getDateValid());
		entity.setIdFiche(mandatsRequestDto.getIdFiche());
		entity.setMontantTotalPec(mandatsRequestDto.getMontantTotalPec());
		entity.setEstOrdre(mandatsRequestDto.getEstOrdre());
		entity.setMandNumApresVisaCf(mandatsRequestDto.getMandNumApresVisaCf());
		
		if (mandatsRequestDto.getIdEtatTransL() != null) {
			EtatTransmission etatTransmissionL = etatTransmissionService.get(mandatsRequestDto.getIdEtatTransL());
			entity.setEtatTransmissionByIdEtatTransL(etatTransmissionL);
		}
		
		if (mandatsRequestDto.getIdEtatTransM() != null) {
			EtatTransmission etatTransmissionM = etatTransmissionService.get(mandatsRequestDto.getIdEtatTransM());
			entity.setEtatTransmissionByIdEtatTransM(etatTransmissionM);
		}
		
		if (mandatsRequestDto.getIdBordEmis() == null) {
			entity.setBordereauEmismandats(null);
		} else {
			BordereauEmismandats bordereauEmismandats = bordereauEmismandatsService.get(mandatsRequestDto.getIdBordEmis());
			entity.setBordereauEmismandats(bordereauEmismandats);
		}
		
		entity.setIdBord(mandatsRequestDto.getIdBord());
		
		if (mandatsRequestDto.getCodBud() != null) {
			Budget budget = budgetService.get(mandatsRequestDto.getCodBud());
			entity.setBudget(budget);
		}
		
		if (mandatsRequestDto.getIdBudget() != null) {
			BudgetType budgetType = budgetTypeService.get(mandatsRequestDto.getIdBudget());
			entity.setBudgetType(budgetType);
		}
		
		if (mandatsRequestDto.getCompteFourn() == null) {
			entity.setCompteDestinataire(null);
		} else {
			CompteDestinataire compteDestinataire = compteDestinataireService.get(mandatsRequestDto.getCompteFourn());
			entity.setCompteDestinataire(compteDestinataire);
		}
		
		if (mandatsRequestDto.getIdContrat() == null) {
			entity.setContrats(null);
		} else {
			Contrats contrat = contratsService.get(mandatsRequestDto.getIdContrat());
			entity.setContrats(contrat);
		}
		
		if (mandatsRequestDto.getIdFourn() != null) {
			Destinataires destinataires = destinatairesService.get(mandatsRequestDto.getIdFourn());
			entity.setDestinataires(destinataires);
		}
		
		if (mandatsRequestDto.getGestion() != null) {
			Gestion gestion = gestionService.get(mandatsRequestDto.getGestion());
			entity.setGestion(gestion);
		}
		
		entity.setCodLiq(mandatsRequestDto.getCodLiq()); 
		entity.setIdLettrage(mandatsRequestDto.getIdLettrage()); 
		entity.setIdModePaie(mandatsRequestDto.getIdModePaie()); 
		
		if (mandatsRequestDto.getNumBe() != null) {
			Engagements engagements = engagementsService.get(mandatsRequestDto.getNumBe());
			entity.setEngagements(engagements);
		}
		
		if (mandatsRequestDto.getEtat() != null) {
			EtatDossier etatDossierByEtat = etatDossierService.get(mandatsRequestDto.getEtat());
			entity.setEtatDossierByEtat(etatDossierByEtat);
		}
		
		if (mandatsRequestDto.getEtatBl() != null) {
			EtatDossier etatDossierByEtatBl = etatDossierService.get(mandatsRequestDto.getEtatBl());
			entity.setEtatDossierByEtatBl(etatDossierByEtatBl);
		}
		
		if (mandatsRequestDto.getNumMandParent() == null) {
			entity.setMandats(null);
		} else {
			Mandats mandats = get(mandatsRequestDto.getNumMandParent());
			entity.setMandats(mandats);
		}
		
		return GbcMapper2.mandatToMandatResponseDto(entity);
	}

	@Override
	public MandatsResponseDto getByEngagements(Long numBe) {
		Engagements engagement = engagementsService.get(numBe);
		Mandats mandats = repository.findByEngagements(engagement);
		return GbcMapper2.mandatToMandatResponseDto(mandats);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public Boolean abandonnerLiquidation(InfosPourAbandonnerLiquidation infosPourAbandonnerLiquidation) {
		try {
			Mandats entity = get(infosPourAbandonnerLiquidation.getId());
			entity.setEtatDossierByEtat(etatDossierService.get("M9"));
			entity.setDateEtat(infosPourAbandonnerLiquidation.getDate());
			entity.setIdUser(infosPourAbandonnerLiquidation.getIdUser());
			entity.setEtatDossierByEtatBl(etatDossierService.get("L9"));
			entity.setDateEtatBl(infosPourAbandonnerLiquidation.getDate());
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public Boolean validerLiquidation(InfosPourValiderLiquidation infosPourValiderLiquidation) {
		try {
			for (Long id : infosPourValiderLiquidation.getIds()) {
				Mandats entity = get(id);
				if (!entity.getEtatDossierByEtat().getEtat().equals("M3")) {
					entity.setEtatDossierByEtat(etatDossierService.get("M2"));
					entity.setDateEtat(infosPourValiderLiquidation.getDate());
					entity.setIdUser(infosPourValiderLiquidation.getIdUser());
					entity.setEtatDossierByEtatBl(etatDossierService.get("L2"));
					entity.setDateEtatBl(infosPourValiderLiquidation.getDate());
					entity.setEtatTransmissionByIdEtatTransM(etatTransmissionService.get(0));
					entity.setEtatTransmissionByIdEtatTransL(etatTransmissionService.get(0));
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
	public Boolean retrograderLiquidation(InfosPourRetrograderLiquidation infosPourRetrograderLiquidation) {
		try {
			for (Long id : infosPourRetrograderLiquidation.getIds()) {
				Mandats entity = get(id);
				if (entity.getEtatDossierByEtat().getEtat().equals("M2")) {
					// ETAT EST A M2, C'EST A DIRE VALIDE MAIS NON TRANSMIS
					entity.setEtatDossierByEtat(etatDossierService.get("M0"));
					entity.setDateEtat(infosPourRetrograderLiquidation.getDate());
					entity.setIdUser(infosPourRetrograderLiquidation.getIdUser());
					entity.setEtatDossierByEtatBl(etatDossierService.get("L0"));
					entity.setDateEtatBl(infosPourRetrograderLiquidation.getDate());
					entity.setEtatTransmissionByIdEtatTransM(etatTransmissionService.get(0));
					entity.setEtatTransmissionByIdEtatTransL(etatTransmissionService.get(0));
				} else {
					// ETAT EST A M3, C'EST A DIRE REJETE MAIS NON TRANSMIS 
					// IL FAUT SUPPRIMER LE MOTIF REJET DOSSIER CREE SI ETAT EST A E3
					//if (entity.getEtatDossier().getEtat().equals("E3")) motifsRejetDossierService.deleteLastRecord(entity.getNumBe());
					
					entity.setEtatDossierByEtat(etatDossierService.get("M2"));
					entity.setDateEtat(infosPourRetrograderLiquidation.getDate());
					entity.setIdUser(infosPourRetrograderLiquidation.getIdUser());
					entity.setEtatDossierByEtatBl(etatDossierService.get("L2"));
					entity.setDateEtatBl(infosPourRetrograderLiquidation.getDate());
					entity.setEtatTransmissionByIdEtatTransM(etatTransmissionService.get(1));
					entity.setEtatTransmissionByIdEtatTransL(etatTransmissionService.get(1));
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
	public Boolean transmettre(IdMandsIdBordEmis idMandsIdBordEmis) {
		try {
			for (Long id : idMandsIdBordEmis.getIds()) {
				Mandats entity = get(id);
				entity.setBordereauEmismandats(bordereauEmismandatsService.get(idMandsIdBordEmis.getIdBordEmis()));
				entity.setEtatTransmissionByIdEtatTransM(etatTransmissionService.get(1));
				entity.setEtatTransmissionByIdEtatTransL(etatTransmissionService.get(1));	
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
