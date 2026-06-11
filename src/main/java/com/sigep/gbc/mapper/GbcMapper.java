package com.sigep.gbc.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sigep.gbc.dto.AccesCodeDto;
import com.sigep.gbc.dto.BordMandDto;
import com.sigep.gbc.dto.BordTitreDto;
import com.sigep.gbc.dto.CompteDto;
import com.sigep.gbc.dto.CoupureMonnaieDto;
import com.sigep.gbc.dto.DecisionSArticleDto;
import com.sigep.gbc.dto.DecisionSVisaDto;
import com.sigep.gbc.dto.InstitutFinAgenceDto;
import com.sigep.gbc.dto.RetenuTypeDto;
import com.sigep.gbc.dto.StElementsNomenclaDto;
import com.sigep.gbc.dto.responseDto.AccesCodeNiveauResponseDto;
import com.sigep.gbc.dto.responseDto.AccesLigneBudgetaireResponseDto;
import com.sigep.gbc.dto.responseDto.AgentsResponseDto;
import com.sigep.gbc.dto.responseDto.BordTransmisResponseDto;
import com.sigep.gbc.dto.responseDto.BordereauEmismandatsResponseDto;
import com.sigep.gbc.dto.responseDto.BudgetResponseDto;
import com.sigep.gbc.dto.responseDto.BudgetTypeGestionResponseDto;
import com.sigep.gbc.dto.responseDto.BudgetTypeResponseDto;
import com.sigep.gbc.dto.responseDto.DecisionSAmpliationResponseDto;
import com.sigep.gbc.dto.responseDto.DestinatairesResponseDto;
import com.sigep.gbc.dto.responseDto.DirectionServiceNiveauResponseDto;
import com.sigep.gbc.dto.responseDto.DirectionServiceResponseDto;
import com.sigep.gbc.dto.responseDto.EngagementsResponseDto;
import com.sigep.gbc.dto.responseDto.EnteteResponseDto;
import com.sigep.gbc.dto.responseDto.EnteteStructureResponseDto;
import com.sigep.gbc.dto.responseDto.EtatDossierResponseDto;
import com.sigep.gbc.dto.responseDto.EtatTransmissionResponseDto;
import com.sigep.gbc.dto.responseDto.FactureTypeResponseDto;
import com.sigep.gbc.dto.responseDto.FacturesResponseDto;
import com.sigep.gbc.dto.responseDto.GestionResponsetDto;
import com.sigep.gbc.dto.responseDto.GrpeCodeResponseDto;
import com.sigep.gbc.dto.responseDto.InstitutFinancierResponseDto;
import com.sigep.gbc.dto.responseDto.NiveauPlanComptableResponseDto;
import com.sigep.gbc.dto.responseDto.NomenclatureDResponseDto;
import com.sigep.gbc.dto.responseDto.NumerotationMandatResponseDto;
import com.sigep.gbc.dto.responseDto.PjResponseDto;
import com.sigep.gbc.dto.responseDto.PlanComptableResponseDto;
import com.sigep.gbc.dto.responseDto.ProcedureResponseDto;
import com.sigep.gbc.dto.responseDto.RetenueCategorieResponseDto;
import com.sigep.gbc.dto.responseDto.StElementsResponseDto;
import com.sigep.gbc.dto.responseDto.TitreDetailResponseDto;
import com.sigep.gbc.dto.responseDto.TitreRegulApartirResponseDto;
import com.sigep.gbc.dto.responseDto.TypeDecisionResponseDto;
import com.sigep.gbc.entity.AccesCode;
import com.sigep.gbc.entity.AccesCodeNiveau;
import com.sigep.gbc.entity.AccesLigneBudgetaire;
import com.sigep.gbc.entity.AccesLigneBudgetaireId;
import com.sigep.gbc.entity.AcompteFrais;
import com.sigep.gbc.entity.Agents;
import com.sigep.gbc.entity.BordMand;
import com.sigep.gbc.entity.BordMandId;
import com.sigep.gbc.entity.BordTitre;
import com.sigep.gbc.entity.BordTitreId;
import com.sigep.gbc.entity.BordTransRecouv;
import com.sigep.gbc.entity.BordTransRecouvId;
import com.sigep.gbc.entity.BordTransmis;
import com.sigep.gbc.entity.BordereauEmismandats;
import com.sigep.gbc.entity.Budget;
import com.sigep.gbc.entity.BudgetModif;
import com.sigep.gbc.entity.BudgetModifId;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.BudgetTypeGestion;
import com.sigep.gbc.entity.Compte;
import com.sigep.gbc.entity.CompteMouvement;
import com.sigep.gbc.entity.CoupureMonnaie;
import com.sigep.gbc.entity.Decision;
import com.sigep.gbc.entity.DecisionSampliation;
import com.sigep.gbc.entity.DecisionSarticle;
import com.sigep.gbc.entity.DecisionSvisa;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.DirectionService;
import com.sigep.gbc.entity.DirectionServiceNiveau;
import com.sigep.gbc.entity.Engagements;
import com.sigep.gbc.entity.Entete;
import com.sigep.gbc.entity.EnteteStructure;
import com.sigep.gbc.entity.EtatDossier;
import com.sigep.gbc.entity.EtatTransmission;
import com.sigep.gbc.entity.FactureDetail;
import com.sigep.gbc.entity.FactureType;
import com.sigep.gbc.entity.Factures;
import com.sigep.gbc.entity.Gestion;
import com.sigep.gbc.entity.GrpeCode;
import com.sigep.gbc.entity.InstitutFinAgence;
import com.sigep.gbc.entity.InstitutFinancier;
import com.sigep.gbc.entity.Liquidation;
import com.sigep.gbc.entity.Mandats;
import com.sigep.gbc.entity.MotifsRejetDossier;
import com.sigep.gbc.entity.NiveauPlanComptable;
import com.sigep.gbc.entity.NomenclatureD;
import com.sigep.gbc.entity.NumerotationMandat;
import com.sigep.gbc.entity.Pj;
import com.sigep.gbc.entity.PjengBrseZz;
import com.sigep.gbc.entity.PjengBrseZzId;
import com.sigep.gbc.entity.PlanComptable;
import com.sigep.gbc.entity.Procedures;
import com.sigep.gbc.entity.Recouvrements;
import com.sigep.gbc.entity.RetenuType;
import com.sigep.gbc.entity.RetenueCategorie;
import com.sigep.gbc.entity.StElements;
import com.sigep.gbc.entity.StElementsNomencla;
import com.sigep.gbc.entity.StElementsNomenclaId;
import com.sigep.gbc.entity.TitreDetail;
import com.sigep.gbc.entity.TitreEmis;
import com.sigep.gbc.entity.TitreRegulApartir;
import com.sigep.gbc.entity.TypeDecision;
import com.sigep.gbc.model.Grpe;

public class GbcMapper {
	
	public static NumerotationMandatResponseDto nmToNmResponseDto(NumerotationMandat entity) {
		NumerotationMandatResponseDto responseDto = new NumerotationMandatResponseDto();
		responseDto.setMandNumApresVisaCf(entity.getMandNumApresVisaCf());
		responseDto.setDescriptions(entity.getDescriptions());
		List<String> abrevEpes = new ArrayList<>();
		List<EnteteStructure> enteteStructures = entity.getEnteteStructures();
		for (EnteteStructure enteteStructure: enteteStructures) {
			abrevEpes.add(enteteStructure.getAbrevEpe());
		}
		responseDto.setEnteteStructureAbrevEpes(abrevEpes);
		return responseDto;
	}
	
	public static EnteteStructureResponseDto esToEsResponseDto(EnteteStructure entity) {
		EnteteStructureResponseDto responseDto = new EnteteStructureResponseDto();
		responseDto.setAbrevEpe(entity.getAbrevEpe());
		responseDto.setSection(entity.getSection());
		responseDto.setEpe(entity.getEpe());
		responseDto.setLieu(entity.getLieu());
		responseDto.setLogo(entity.getLogo());
		responseDto.setSignataireDg(entity.getSignataireDg());
		responseDto.setNomSignataireDg(entity.getNomSignataireDg());
		responseDto.setTitreHonorifiqueDg(entity.getTitreHonorifiqueDg());
		responseDto.setSignataireDaf(entity.getSignataireDaf());
		responseDto.setNomSignataireDaf(entity.getNomSignataireDaf());
		responseDto.setTitreHonorifiqueDaf(entity.getTitreHonorifiqueDaf());
		responseDto.setSignataireCf(entity.getSignataireCf());
		responseDto.setNomSignataireCf(entity.getNomSignataireCf());
		responseDto.setTitreHonorifiqueCf(entity.getTitreHonorifiqueCf());
		responseDto.setSignataireAc(entity.getSignataireAc());
		responseDto.setNomSignataireAc(entity.getNomSignataireAc());
		responseDto.setTitreHonorifiqueAc(entity.getTitreHonorifiqueAc());
		responseDto.setCfresident(entity.getCfresident());
		responseDto.setSignatPenal(entity.getSignatPenal());
		responseDto.setAdresse(entity.getAdresse());
		responseDto.setTelephone(entity.getTelephone());
		responseDto.setFax(entity.getFax());
		responseDto.setEmail(entity.getEmail());
		responseDto.setVisa(entity.getVisa());
		responseDto.setArticleStruct(entity.getArticleStruct());
		responseDto.setNomPays(entity.getNomPays());
		responseDto.setDevisePays(entity.getDevisePays());
		responseDto.setMleCnss(entity.getMleCnss());
		responseDto.setMleCarfo(entity.getMleCarfo());
		responseDto.setTypeSupport(entity.getTypeSupport());
		responseDto.setAvecReception(entity.isAvecReception());
		responseDto.setQuitFiligrane(entity.getQuitFiligrane());
		responseDto.setTauxTva(entity.getTauxTva());
		responseDto.setTypeAmmortDefaut(entity.getTypeAmmortDefaut());
		responseDto.setGbc(entity.isGbc());
		responseDto.setGim(entity.isGim());
		responseDto.setGrh(entity.isGrh());
		responseDto.setSectionNum(entity.getSectionNum());
		responseDto.setFilgraneL276cmH185cm(entity.getFilgraneL276cmH185cm());
		responseDto.setSignataireDrh(entity.getSignataireDrh());
		responseDto.setNomSignataireDrh(entity.getNomSignataireDrh());
		responseDto.setTitreHonorifiqueDrh(entity.getTitreHonorifiqueDrh());
		responseDto.setIdCircuitGrh(entity.getIdCircuitGrh());
		responseDto.setDrhsigneEtat(entity.isDrhsigneEtat());
		responseDto.setLibAnnee(entity.getLibAnnee());
		responseDto.setMandNumApresVisaCf(entity.getNumerotationMandat().getMandNumApresVisaCf());
		List<String> codUsers = new ArrayList<>();
		List<Entete> entetes = entity.getEntetes();
		for (Entete entete: entetes) {
			codUsers.add(entete.getCodUser());
		}
		responseDto.setEnteteCodUsers(codUsers);
		return responseDto;
	}
	
	public static EnteteResponseDto eToeResponseDto(Entete entity) {
		EnteteResponseDto responseDto = new EnteteResponseDto();
		responseDto.setCodUser(entity.getCodUser());
		responseDto.setNiveau1(entity.getNiveau1());
		responseDto.setNiveau2(entity.getNiveau2());
		responseDto.setNiveau3(entity.getNiveau3());
		responseDto.setNiveau4(entity.getNiveau4());
		responseDto.setAbv1(entity.getAbv1());
		responseDto.setAbv2(entity.getAbv2());
		responseDto.setAbv3(entity.getAbv3());
		responseDto.setAbv4(entity.getAbv4());
		responseDto.setComplementNum(entity.getComplementNum());
		responseDto.setAbrevEpe(entity.getEnteteStructure().getAbrevEpe());
		return responseDto;
	}

	public static DestinatairesResponseDto dToDResponseDto(Destinataires entity) {
		DestinatairesResponseDto responseDto = new DestinatairesResponseDto();
		responseDto.setIdDest(entity.getIdDest());
		responseDto.setIfumle(entity.getIfumle());
		responseDto.setFtype(entity.getFtype());
		responseDto.setContactTel(entity.getContactTel());
		responseDto.setContactEmail(entity.getContactEmail());
		responseDto.setNom(entity.getNom());
		if (entity.getAgents() != null) responseDto.setMle(entity.getAgents().getMle());
		return responseDto;
	}

	public static DirectionServiceResponseDto dsToDsResponseDto(DirectionService entity) {
		DirectionServiceResponseDto responseDto = new DirectionServiceResponseDto();
		responseDto.setIdService(entity.getIdService());
		responseDto.setLibelle(entity.getLibelle());
		responseDto.setAbrev(entity.getAbrev());
		responseDto.setIdHerachique(entity.getIdHerachique());
		responseDto.setIdNiveau(entity.getDirectionServiceNiveau().getIdNiveau());
		responseDto.setCodStruct(entity.getEnteteStructure().getAbrevEpe());
		
		if (entity.getDirectionService() != null) {
			responseDto.setIdParent(entity.getDirectionService().getIdService());
		}
		
		List<Integer> idServices = new ArrayList<>();
		List<DirectionService> directionServices = entity.getDirectionServices();
		for (DirectionService directionService: directionServices) {
			idServices.add(directionService.getIdService());
		}
		responseDto.setIdServices(idServices);
		
		List<Long> mles = new ArrayList<>();
		List<Agents> agentss = entity.getAgents();
		for (Agents agents: agentss) {
			mles.add(agents.getMle());
		}
		responseDto.setMles(mles);
		
		return responseDto;
	}

	public static DirectionServiceNiveauResponseDto dsnToDsnResponseDto(DirectionServiceNiveau entity) {
		DirectionServiceNiveauResponseDto responseDto = new DirectionServiceNiveauResponseDto();
		responseDto.setIdNiveau(entity.getIdNiveau());
		responseDto.setLibelleNiveau(entity.getLibelleNiveau());
		List<Integer> idServices = new ArrayList<>();
		List<DirectionService> directionServices = entity.getDirectionServices();
		for (DirectionService directionService: directionServices) {
			idServices.add(directionService.getIdService());
		}
		responseDto.setIdServices(idServices);
		return responseDto;
	}

	public static AgentsResponseDto aToAResponseDto(Agents entity) {
		AgentsResponseDto responseDto = new AgentsResponseDto();
		responseDto.setMle(entity.getMle());
		responseDto.setNom(entity.getNom());
		responseDto.setPrenom(entity.getPrenom());
		responseDto.setSexe(entity.getSexe());
		responseDto.setSignataire(entity.getSignataire());
		responseDto.setTitreHonoSign(entity.getTitreHonoSign());
		responseDto.setActif(entity.isActif());
		responseDto.setIdService(entity.getDirectionService().getIdService());
		
		List<String> userNames = new ArrayList<>();
		List<AccesCode> accesCodes = entity.getAccesCodes();
		for (AccesCode accesCode: accesCodes) {
			userNames.add(accesCode.getUserName());
		}
		responseDto.setUserNames(userNames);
		return responseDto;
	}

	public static AccesCodeDto acToAcDto(AccesCode accesCode) {
		AccesCodeDto accesCodeDto = new AccesCodeDto();
		accesCodeDto.setUserName(accesCode.getUserName());
		accesCodeDto.setMotPasse(accesCode.getMotPasse());
		accesCodeDto.setMotDePasse(accesCode.getMotDePasse());
		accesCodeDto.setStatu(accesCode.getStatu());
		accesCodeDto.setDateChangement(accesCode.getDateChangement());
		accesCodeDto.setNbreDeFois(accesCode.getNbreDeFois());
		accesCodeDto.setRangCod(accesCode.getRangCod());
		accesCodeDto.setDateCreat(accesCode.getDateCreat());
		if (accesCode.getAgents() != null) accesCodeDto.setMle(accesCode.getAgents().getMle());
		accesCodeDto.setCode(accesCode.getAccesCodeNiveau().getCode());
		accesCodeDto.setGrpe(accesCode.getGrpeCode().getGrpe());
		return accesCodeDto;
	}

	public static AccesCodeNiveauResponseDto acnToAcnResponseDto(AccesCodeNiveau entity) {
		AccesCodeNiveauResponseDto responseDto = new AccesCodeNiveauResponseDto();
		responseDto.setCode(entity.getCode());
		responseDto.setIntituleCode(entity.getIntituleCode());
		responseDto.setNomStruct(entity.getNomStruct());
		
		List<Grpe> grpes = new ArrayList<>();
		List<GrpeCode> grpeCodes = entity.getGrpeCodes();
		for (GrpeCode grpeCode: grpeCodes) {
			grpes.add(new Grpe(grpeCode.getGrpe(), grpeCode.getLibelleGrpe()));
		}
		responseDto.setGrpes(grpes);
			
		List<String> userNames = new ArrayList<>();
		List<AccesCode> accesCodes = entity.getAccesCodes();
		for (AccesCode accesCode: accesCodes) {
			userNames.add(accesCode.getUserName());
		}
		responseDto.setUserNames(userNames);
		
		return responseDto;
	}

	public static GrpeCodeResponseDto gcToGcResponse(GrpeCode entity) {
		GrpeCodeResponseDto responseDto = new GrpeCodeResponseDto();
		responseDto.setGrpe(entity.getGrpe());
		responseDto.setLibelleGrpe(entity.getLibelleGrpe());
		
		List<String> userNames = new ArrayList<>();
		List<AccesCode> accesCodes = entity.getAccesCodes();
		for (AccesCode accesCode: accesCodes) {
			userNames.add(accesCode.getUserName());
		}
		responseDto.setUserNames(userNames);
		
		List<String> codes = new ArrayList<>();
		List<AccesCodeNiveau> accesCodeNiveaus = entity.getAccesCodeNiveaus();
		for (AccesCodeNiveau accesCodeNiveau: accesCodeNiveaus) {
			codes.add(accesCodeNiveau.getCode());
		}
		responseDto.setCodes(codes);
		return responseDto;
	}
	
	public static GestionResponsetDto gToGResponseDto(Gestion entity) {
		GestionResponsetDto responseDto = new GestionResponsetDto();
		responseDto.setCourante(entity.getCourante());
		responseDto.setLibelle(entity.getLibelle());
		responseDto.setEtat(entity.getEtat());
		responseDto.setUtilisation(entity.getUtilisation());
		List<AccesLigneBudgetaireId> idAccesLigneBudgetaires = new ArrayList<>();
		List<AccesLigneBudgetaire> accesLigneBudgetaires = entity.getAccesLigneBudgetaires();
		for (AccesLigneBudgetaire accesLigneBudgetaire: accesLigneBudgetaires) {
			idAccesLigneBudgetaires.add(accesLigneBudgetaire.getId());
		}
		responseDto.setIdAccesLigneBudgetaires(idAccesLigneBudgetaires);
		return responseDto;
	}
	
	public static NomenclatureDResponseDto noDToNoDResponseDto(NomenclatureD entity) {
		NomenclatureDResponseDto responseDto = new NomenclatureDResponseDto();
		responseDto.setNumNo(entity.getNumNo());
		responseDto.setTitre(entity.getTitre());
		responseDto.setSection(entity.getSection());
		responseDto.setChap(entity.getChap());
		responseDto.setArt(entity.getArt());
		responseDto.setParag(entity.getParag());
		responseDto.setRub(entity.getRub());
		responseDto.setIntitule(entity.getIntitule());
		responseDto.setIdPlan(entity.getIdPlan());
		responseDto.setDotEstExec(entity.getDotEstExec());
		responseDto.setCodHierarchiq(entity.getCodHierarchiq());
		return responseDto;
	}

	public static AccesLigneBudgetaireResponseDto aLbToAlBResponseDto(AccesLigneBudgetaire entity) {
		AccesLigneBudgetaireResponseDto responseDto = new AccesLigneBudgetaireResponseDto();
		responseDto.setUserName(entity.getId().getUserName());
		responseDto.setCourante(entity.getId().getGestion());
		responseDto.setNumNo(entity.getId().getNumNo());
		responseDto.setIdBudgett(entity.getIdBudgett());
		return responseDto;
	}

	public static NiveauPlanComptableResponseDto npcToNpcResponseDto(NiveauPlanComptable entity) {
		NiveauPlanComptableResponseDto responseDto = new NiveauPlanComptableResponseDto();
		responseDto.setNiveau(entity.getNiveau());
		responseDto.setIntituleNiveau(entity.getIntituleNiveau());
		responseDto.setDescription(entity.getDescription());
		List<String> idPlans = new ArrayList<>();
		List<PlanComptable> planComptables = entity.getPlanComptables();
		for (PlanComptable planComptable: planComptables) {
			idPlans.add(planComptable.getIdPlan());
		}
		responseDto.setIdPlans(idPlans);
		return responseDto;
	}

	public static PlanComptableResponseDto pcToPcResponseDto(PlanComptable entity) {
		PlanComptableResponseDto responseDto = new PlanComptableResponseDto();
		responseDto.setIdPlan(entity.getIdPlan().trim());
		responseDto.setIntitulePlan(entity.getIntitulePlan());
		responseDto.setNiveau(entity.getNiveauPlanComptable().getNiveau());
		
		List<String> codBuds = new ArrayList<>();
		List<Budget> budgets = entity.getBudgets();
		for (Budget budget: budgets) {
			codBuds.add(budget.getCodBud());
		}
		responseDto.setCodBuds(codBuds);
		return responseDto;
	}

	public static BudgetTypeResponseDto btToBtResponseDto(BudgetType entity) {
		BudgetTypeResponseDto responseDto = new BudgetTypeResponseDto();
		responseDto.setIdBudget(entity.getIdBudget());
		responseDto.setLibelleBudget(entity.getLibelleBudget());
		responseDto.setLibelleDecision(entity.getLibelleDecision());
		
		/*List<BudgetTypeGestionId> budgetTypeGestionIds = new ArrayList<>();
		List<BudgetTypeGestion> budgetTypeGestions = entity.getBudgetTypeGestions();
		for (BudgetTypeGestion budgetTypeGestion: budgetTypeGestions) {
			budgetTypeGestionIds.add(budgetTypeGestion.getId());
		}
		responseDto.setBudgetTypeGestionIds(budgetTypeGestionIds);
		
		List<String> codBuds = new ArrayList<>();
		List<Budget> budgets = entity.getBudgets();
		for (Budget budget: budgets) {
			codBuds.add(budget.getCodBud());
		}
		responseDto.setCodBuds(codBuds);*/
		
		return responseDto;
	}

	public static BudgetResponseDto BToBResponseDto(Budget entity) {
		BudgetResponseDto responseDto = new BudgetResponseDto();
		responseDto.setCodBud(entity.getCodBud());
		responseDto.setIntitule(entity.getIntitule());
		responseDto.setDotInitiale(entity.getDotInitiale());
		responseDto.setCaajout(entity.getCaajout());
		responseDto.setCaannul(entity.getCaannul());
		responseDto.setReam(entity.getReam());
		responseDto.setTotalEngag(entity.getTotalEngag());
		responseDto.setDotN1(entity.getDotN1());
		responseDto.setExecN1(entity.getExecN1());
		responseDto.setDotN2(entity.getDotN2());
		responseDto.setExecN2(entity.getExecN2());
		responseDto.setDotN3(entity.getDotN3());
		responseDto.setExecN3(entity.getExecN3());
		responseDto.setGestion(entity.getGestion().getCourante());
		responseDto.setNumNo(entity.getNomenclatureD().getNumNo());
		responseDto.setIdPlan(entity.getPlanComptable().getIdPlan());
		responseDto.setIdBudget(entity.getBudgetType().getIdBudget());
		
		List<BudgetModifId> budgetModifIds = new ArrayList<>();
		List<BudgetModif> budgetModifs = entity.getBudgetModifs();
		for (BudgetModif budgetModif: budgetModifs) {
			budgetModifIds.add(budgetModif.getId());
		}
		responseDto.setBudgetModifIds(budgetModifIds);
		
		return responseDto;
	}

	public static BudgetTypeGestionResponseDto btgToBtgResponseDto(BudgetTypeGestion entity) {
		BudgetTypeGestionResponseDto responseDto = new BudgetTypeGestionResponseDto();
		responseDto.setIdBudget(entity.getBudgetType().getIdBudget());
		responseDto.setAnnee(entity.getGestion().getCourante());
		responseDto.setDateMiseEnPlace(entity.getDateMiseEnPlace());
		responseDto.setDateCloture(entity.getDateCloture());
		responseDto.setFermer(entity.isFermer());
		responseDto.setPageCommencantA(entity.getPageCommencantA());
		responseDto.setEteteD(entity.getEteteD());
		responseDto.setEteteM(entity.getEteteM());
		responseDto.setPiedD(entity.getPiedD());
		responseDto.setPiedM(entity.getPiedM());
		responseDto.setSignataireBud(entity.getSignataireBud());
		responseDto.setNomSignataire(entity.getNomSignataire());
		responseDto.setHonoSignataire(entity.getHonoSignataire());
		return responseDto;
	}

	public static PjResponseDto PjToPjResponseDto(Pj entity) {
		PjResponseDto responseDto = new PjResponseDto();
		responseDto.setCodPj(entity.getCodPj());
		responseDto.setPj(entity.getPj());
		responseDto.setAvecMontant(entity.isAvecMontant());
		return responseDto;
	}

	public static InstitutFinancierResponseDto iFtoIfResponseDto(InstitutFinancier entity) {
		InstitutFinancierResponseDto responseDto = new InstitutFinancierResponseDto();
		responseDto.setAbreviation(entity.getAbreviation());
		responseDto.setLibelle(entity.getLibelle());
		responseDto.setAddresseA(entity.getAddresseA());
		responseDto.setTransiArct(entity.getTransiArct());
		responseDto.setCodeBanque(entity.getCodeBanque());
		responseDto.setLibCourtMajus(entity.getLibCourtMajus());
		responseDto.setLibCourtMinus(entity.getLibCourtMinus());
		if (entity.getDestinataires() != null) responseDto.setIdDest(entity.getDestinataires().getIdDest());
		
		List<String> idAgences = new ArrayList<>();
		List<InstitutFinAgence> institutFinAgences = entity.getInstitutFinAgences();
		for (InstitutFinAgence institutFinAgence: institutFinAgences) {
			idAgences.add(institutFinAgence.getIdAgence());
		}
		responseDto.setIdAgences(idAgences);
		
		return responseDto;
	}

	public static InstitutFinAgenceDto ifAtoIfAResponseDto(InstitutFinAgence entity) {
		InstitutFinAgenceDto responseDto = new InstitutFinAgenceDto();
		responseDto.setIdAgence(entity.getIdAgence());
		responseDto.setCodeAgence(entity.getCodeAgence());
		responseDto.setLibelleAgence(entity.getLibelleAgence());
		responseDto.setDomicilieA(entity.getDomicilieA());
		responseDto.setAbreviation(entity.getInstitutFinancier().getAbreviation());
		return responseDto;
	}

	public static CompteDto cToCResponseDto(Compte entity) {
		CompteDto responseDto = new CompteDto();
		responseDto.setCodCpte(entity.getCodCpte());
		responseDto.setNumCompte(entity.getNumCompte());
		responseDto.setIntitule(entity.getIntitule());
		responseDto.setAttente(entity.getAttente());
		responseDto.setAbreviation(entity.getAbreviation());
		responseDto.setCodeBanque(entity.getCodeBanque());
		responseDto.setCodeAgence(entity.getCodeAgence());
		responseDto.setCleRib(entity.getCleRib());
		responseDto.setCaissePop(entity.getCaissePop());
		responseDto.setNumCaissePop(entity.getNumCaissePop());
		responseDto.setSolde(entity.getSolde());
		responseDto.setLibCompte(entity.getLibCompte());
		return responseDto;
	}

	public static RetenueCategorieResponseDto RcToRcResponseDto(RetenueCategorie entity) {
		RetenueCategorieResponseDto responseDto = new RetenueCategorieResponseDto();
		responseDto.setIdCategorie(entity.getIdCategorie());
		responseDto.setLibelle(entity.getLibelle());
		
		List<Integer> idTypRetenus = new ArrayList<>();
		List<RetenuType> retenuTypes = entity.getRetenuTypes();
		for (RetenuType retenuType: retenuTypes) {
			idTypRetenus.add(retenuType.getIdTypRetenu());
		}
		responseDto.setIdTypRetenus(idTypRetenus);
		
		return responseDto;
	}

	public static RetenuTypeDto RtToRtResponseDto(RetenuType entity) {
		RetenuTypeDto responseDto = new RetenuTypeDto();
		responseDto.setIdTypRetenu(entity.getIdTypRetenu());
		responseDto.setLibelle(entity.getLibelle());
		responseDto.setTaux(entity.getTaux());
		responseDto.setLibelleCpte(entity.getCompte().getLibCompte());
		responseDto.setCodCpte(entity.getCompte().getCodCpte());
		responseDto.setIdCategorie(entity.getRetenueCategorie().getIdCategorie());
		return responseDto;
	}

	public static CoupureMonnaieDto cMToCmResponseDto(CoupureMonnaie entity) {
		CoupureMonnaieDto responseDto = new CoupureMonnaieDto();
		responseDto.setDesigna(entity.getId().getDesigna());
		responseDto.setIdCoupure(entity.getId().getIdCoupure());
		return responseDto;
	}

	public static TypeDecisionResponseDto tdToTdResponseDto(TypeDecision entity) {
		TypeDecisionResponseDto responseDto = new TypeDecisionResponseDto();
		responseDto.setIdType(entity.getIdType());
		responseDto.setLibelle(entity.getLibelle());
		
		List<Integer> rangVisas = new ArrayList<>();
		List<DecisionSvisa> decisionSvisas = entity.getDecisionSvisas();
		for (DecisionSvisa decisionSvisa: decisionSvisas) {
			rangVisas.add(decisionSvisa.getRangVisa());
		}
		responseDto.setRangVisas(rangVisas);
		return responseDto;
	}

	public static DecisionSVisaDto dsvToDsvDto(DecisionSvisa entity) {
		DecisionSVisaDto responseDto = new DecisionSVisaDto();
		responseDto.setRangVisa(entity.getRangVisa());
		responseDto.setLibelleVisa(entity.getLibelleVisa());
		responseDto.setIdType(entity.getTypeDecision().getIdType());
		return responseDto;
	}

	public static DecisionSArticleDto dsaToDsaDto(DecisionSarticle entity) {
		DecisionSArticleDto responseDto = new DecisionSArticleDto();
		responseDto.setNumArticle(entity.getNumArticle());
		responseDto.setIntituleArticle(entity.getIntituleArticle());
		responseDto.setIntituleArticleReam(entity.getIntituleArticleReam());
		return responseDto;
	}

	public static DecisionSAmpliationResponseDto dsamToDsamDto(DecisionSampliation entity) {
		DecisionSAmpliationResponseDto responseDto = new DecisionSAmpliationResponseDto();
		responseDto.setId(entity.getId());
		responseDto.setAmpliataire(entity.getAmpliataire());
		responseDto.setAmpliataireReam(entity.getAmpliataireReam());
		return responseDto;
	}

	public static StElementsResponseDto steToSteResponseDto(StElements entity) {
		StElementsResponseDto responseDto = new StElementsResponseDto();
		responseDto.setIdStElts(entity.getIdStElts());
		responseDto.setPartie(entity.getPartie());
		responseDto.setRangStElts(entity.getRangStElts());
		responseDto.setLibelleStElts(entity.getLibelleStElts());
		responseDto.setCompletLib(entity.getCompletLib());
		
		List<StElementsNomenclaId> stElementsNomenclaIds = new ArrayList<>();
		List<StElementsNomencla> stElementsNomenclas = entity.getStElementsNomenclas();
		for (StElementsNomencla stElementsNomencla: stElementsNomenclas) {
			stElementsNomenclaIds.add(stElementsNomencla.getId());
		}
		responseDto.setStElementsNomenclaIds(stElementsNomenclaIds);
		return responseDto;
	}

	public static StElementsNomenclaDto stenToStenResponseDto(StElementsNomencla entity) {
		StElementsNomenclaDto responseDto = new StElementsNomenclaDto();
		responseDto.setIdStElts(entity.getId().getIdStElts());
		responseDto.setGestion(entity.getId().getGestion());
		responseDto.setIdPlan(entity.getId().getIdPlan().trim());
		responseDto.setOp(entity.getOp());
		return responseDto;
	}

	public static EtatTransmissionResponseDto etToEtResponseDto(EtatTransmission entity) {
		EtatTransmissionResponseDto responseDto = new EtatTransmissionResponseDto();
		responseDto.setIdEtatTrans(entity.getIdEtatTrans());
		responseDto.setLibEtatTrans(entity.getLibEtatTrans());
		
		List<Long> idDetailTitres = new ArrayList<>();
		List<TitreDetail> titreDetails = entity.getTitreDetails();
		for (TitreDetail titreDetail: titreDetails) {
			idDetailTitres.add(titreDetail.getIdDetailTitre());
		}
		responseDto.setIdDetailTitres(idDetailTitres);
		
		List<String> codRecouvs = new ArrayList<>();
		List<Recouvrements> recouvrements = entity.getRecouvrements();
		for (Recouvrements recouvrement: recouvrements) {
			codRecouvs.add(recouvrement.getCodRecouv());
		}
		responseDto.setCodRecouvs(codRecouvs);
		
		List<Long> numBes = new ArrayList<>();
		List<Engagements> engagements = entity.getEngagements();
		for (Engagements engagement: engagements) {
			numBes.add(engagement.getNumBe());
		}
		responseDto.setNumBes(numBes);
		
		List<Long> numMandByIdEtatTransMs = new ArrayList<>();
		List<Mandats> mandatsByIdEtatTransMs = entity.getMandatsByIdEtatTransM();
		for (Mandats mandatsByIdEtatTransM: mandatsByIdEtatTransMs) {
			numMandByIdEtatTransMs.add(mandatsByIdEtatTransM.getNumMand());
		}
		responseDto.setNumMandByIdEtatTransMs(numMandByIdEtatTransMs);
		
		List<Long> numMandByIdEtatTransLs = new ArrayList<>();
		List<Mandats> mandatsByIdEtatTransLs = entity.getMandatsByIdEtatTransL();
		for (Mandats mandatsByIdEtatTransL: mandatsByIdEtatTransLs) {
			numMandByIdEtatTransLs.add(mandatsByIdEtatTransL.getNumMand());
		}
		responseDto.setNumMandByIdEtatTransLs(numMandByIdEtatTransLs);
		
		return responseDto;
	}

	public static EtatDossierResponseDto edToEdResponseDto(EtatDossier entity) {
		EtatDossierResponseDto responseDto = new EtatDossierResponseDto();
		responseDto.setEtat(entity.getEtat());
		responseDto.setLibEtat(entity.getLibEtat());
		responseDto.setAvecMotifR(entity.isAvecMotifR());
		
		List<String> codRecouvs = new ArrayList<>();
		List<Recouvrements> recouvrements = entity.getRecouvrements();
		for (Recouvrements recouvrement: recouvrements) {
			codRecouvs.add(recouvrement.getCodRecouv());
		}
		responseDto.setCodRecouvs(codRecouvs);
		
		List<Long> numBes = new ArrayList<>();
		List<Engagements> engagements = entity.getEngagements();
		for (Engagements engagement: engagements) {
			numBes.add(engagement.getNumBe());
		}
		responseDto.setNumBes(numBes);
		
		List<Long> idDetailTitres = new ArrayList<>();
		List<TitreDetail> titreDetails = entity.getTitreDetails();
		for (TitreDetail titreDetail: titreDetails) {
			idDetailTitres.add(titreDetail.getIdDetailTitre());
		}
		responseDto.setIdDetailTitres(idDetailTitres);
		
		List<Long> numMandsByEtats = new ArrayList<>();
		List<Mandats> mandatsByEtats = entity.getMandatsByEtat();
		for (Mandats mandatsByIdEtat: mandatsByEtats) {
			numMandsByEtats.add(mandatsByIdEtat.getNumMand());
		}
		responseDto.setNumMandsByEtats(numMandsByEtats);
		
		List<Long> numMandsByEtatBls = new ArrayList<>();
		List<Mandats> mandatsByEtatBls = entity.getMandatsByEtatBl();
		for (Mandats mandatsByEtatBl: mandatsByEtatBls) {
			numMandsByEtatBls.add(mandatsByEtatBl.getNumMand());
		}
		responseDto.setNumMandsByEtatBls(numMandsByEtatBls);
		
		List<Long> idompteMouvements = new ArrayList<>();
		List<CompteMouvement> compteMouvements = entity.getCompteMouvements();
		for (CompteMouvement compteMouvement: compteMouvements) {
			idompteMouvements.add(compteMouvement.getIdBord());
		}
		responseDto.setIdompteMouvements(idompteMouvements);
		
		return responseDto;
	}

	public static TitreRegulApartirResponseDto traToTraResponseDto(TitreRegulApartir entity) {
		TitreRegulApartirResponseDto responseDto = new TitreRegulApartirResponseDto();
		responseDto.setIdApartir(entity.getIdApartir());
		responseDto.setLibelleApartir(entity.getLibelleApartir());
		responseDto.setRegularisation(entity.isRegularisation());
		
		List<Long> idDetailTitres = new ArrayList<>();
		List<TitreDetail> titreDetails = entity.getTitreDetails();
		for (TitreDetail titreDetail: titreDetails) {
			idDetailTitres.add(titreDetail.getIdDetailTitre());
		}
		responseDto.setIdDetailTitres(idDetailTitres);
		
		return responseDto;
	}

	public static ProcedureResponseDto proToProResponseDto(Procedures entity) {
		ProcedureResponseDto responseDto = new ProcedureResponseDto();
		responseDto.setProced(entity.getProced());
		responseDto.setLibProced(entity.getLibProced());
		
		List<Long> numBes = new ArrayList<>();
		List<Engagements> engagements = entity.getEngagements();
		for (Engagements engagement: engagements) {
			numBes.add(engagement.getNumBe());
		}
		responseDto.setNumBes(numBes);
		
		return responseDto;
	}

	public static BordTransmisResponseDto bordtToBordtResponseDto(BordTransmis entity) {
		BordTransmisResponseDto responseDto = new BordTransmisResponseDto();
		responseDto.setCodBord(entity.getCodBord());
		responseDto.setGestion(entity.getGestion());
		responseDto.setDossier(entity.getDossier());
		responseDto.setDateCreation(entity.getDateCreation());
		responseDto.setExpeditaire(entity.getExpeditaire());
		responseDto.setDestinataire(entity.getDestinataire());
		responseDto.setIdLogin(entity.getIdLogin());
		responseDto.setDateReception(entity.getDateReception());
		responseDto.setIdLoginRecep(entity.getIdLoginRecep());
		responseDto.setNumero(entity.getNumero());
		responseDto.setIdentiteRecept(entity.getIdentiteRecept());
		responseDto.setIdBudget(entity.getBudgetType().getIdBudget());
		
		List<Long> numBesBordTransEng = new ArrayList<>();
		List<Engagements> engagementsBordTransEng = entity.getEngagementsBordTransEng();
		for (Engagements engagement: engagementsBordTransEng) {
			numBesBordTransEng.add(engagement.getNumBe());
		}
		responseDto.setNumBesBordTransEng(numBesBordTransEng);
		
		List<Long> numMandsBordTransMand = new ArrayList<>();
		List<Mandats> mandatsBordTransMand = entity.getMandatsBordTransMand();
		for (Mandats mandat: mandatsBordTransMand) {
			numMandsBordTransMand.add(mandat.getNumMand());
		}
		responseDto.setNumMandsBordTransMand(numMandsBordTransMand);
		
		List<Long> numMandsBordTransLiq = new ArrayList<>();
		List<Mandats> mandatsBordTransLiq = entity.getMandatsBordTransLiq();
		for (Mandats mandat: mandatsBordTransLiq) {
			numMandsBordTransLiq.add(mandat.getNumMand());
		}
		responseDto.setNumMandsBordTransLiq(numMandsBordTransLiq);
		
		List<String> idMotifs = new ArrayList<>();
		List<MotifsRejetDossier> motifsRejetDossiers = entity.getMotifsRejetDossiers();
		for (MotifsRejetDossier motifsRejetDossier: motifsRejetDossiers) {
			idMotifs.add(motifsRejetDossier.getIdMotif());
		}
		responseDto.setNumMandsBordTransLiq(numMandsBordTransLiq);
		
		List<Long> idDetailTitres = new ArrayList<>();
		List<TitreDetail> titreDetails = entity.getTitreDetails();
		for (TitreDetail titreDetail: titreDetails) {
			idDetailTitres.add(titreDetail.getIdDetailTitre());
		}
		responseDto.setIdDetailTitres(idDetailTitres);
		
		/*List<Long> numBes = new ArrayList<>();
		List<Engagements> engagements = entity.getEngagements();
		for (Engagements engagement: engagements) {
			numBes.add(engagement.getNumBe());
		}
		responseDto.setNumBes(numBes);*/
		
		/*List<Long> numMands = new ArrayList<>();
		List<Mandats> mandats = entity.getMandats();
		for (Mandats mandat: mandats) {
			numMands.add(mandat.getNumMand());
		}
		responseDto.setNumMands(numMands);*/
		
		List<BordTransRecouvId> bordTransRecouvIds = new ArrayList<>();
		List<BordTransRecouv> bordTransRecouvs = entity.getBordTransRecouvs();
		for (BordTransRecouv bordTransRecouv: bordTransRecouvs) {
			bordTransRecouvIds.add(bordTransRecouv.getId());
		}
		responseDto.setBordTransRecouvIds(bordTransRecouvIds);
		
		return responseDto;
	}

	public static EngagementsResponseDto engToEngResponseDto(Engagements entity) {
		EngagementsResponseDto responseDto = new EngagementsResponseDto();
		responseDto.setNumBe(entity.getNumBe());
		responseDto.setBenum(entity.getBenum());
		responseDto.setDateCreation(entity.getDateCreation());
		responseDto.setNatDepense(entity.getNatDepense());
		responseDto.setAuProfit(entity.getAuProfit());
		responseDto.setMontant(entity.getMontant());
		responseDto.setDotInitiale(entity.getDotInitiale());
		responseDto.setDispoAvant(entity.getDispoAvant());
		responseDto.setDateEtat(entity.getDateEtat());
		responseDto.setIdUser(entity.getIdUser());
		responseDto.setAvecDecision(entity.isAvecDecision());
		responseDto.setApartirDemandLiq(entity.isApartirDemandLiq());
		responseDto.setGrh(entity.isGrh());
		responseDto.setReceptionne(entity.isReceptionne());
		responseDto.setDateValid(entity.getDateValid());
		responseDto.setDateCreat(entity.getDateCreat());
		responseDto.setCodLiq(entity.getCodLiq());
		responseDto.setIdBord(entity.getIdBord());
		if (entity.getContrats() != null) responseDto.setIdContrat(entity.getContrats().getIdContrat());
		if (entity.getEngagementsByIdEng() != null) responseDto.setIdEngParent(entity.getEngagementsByIdEng().getNumBe());
		responseDto.setEtat(entity.getEtatDossier().getEtat());
		responseDto.setIdEtatTrans(entity.getEtatTransmission().getIdEtatTrans());
		responseDto.setProced(entity.getProcedures().getProced());
		responseDto.setCodBud(entity.getBudget().getCodBud());
		responseDto.setIdBudget(entity.getBudgetType().getIdBudget());
		responseDto.setIdFourn(entity.getDestinataires().getIdDest());
		responseDto.setGestion(entity.getGestion().getCourante());
		
		List<Long> codBords = new ArrayList<>();
		List<BordTransmis> bordTransmis = entity.getBordTransmiss();
		for (BordTransmis bordTransmi: bordTransmis) {
			codBords.add(bordTransmi.getCodBord());
		}
		responseDto.setCodBords(codBords);
		
		List<Long> numBesFils = new ArrayList<>();
		List<Engagements> engagements = entity.getEngagementsForIdEng();
		for (Engagements engagement: engagements) {
			numBesFils.add(engagement.getNumBe());
		}
		responseDto.setNumBesFils(numBesFils);
		
		List<Long> codLiqs = new ArrayList<>();
		List<Liquidation> liquidations = entity.getLiquidations();
		for (Liquidation liquidation: liquidations) {
			codLiqs.add(liquidation.getCodLiq());
		}
		responseDto.setCodLiqs(codLiqs);
		
		List<String> idDecisions = new ArrayList<>();
		List<Decision> decisions = entity.getDecisions();
		for (Decision decision: decisions) {
			idDecisions.add(decision.getIdDecision());
		}
		responseDto.setIdDecisions(idDecisions);
		
		List<PjengBrseZzId> idPjengBrseZzs = new ArrayList<>();
		List<PjengBrseZz> pjengBrseZzs = entity.getPjengBrseZzs();
		for (PjengBrseZz pjengBrseZz: pjengBrseZzs) {
			idPjengBrseZzs.add(pjengBrseZz.getId());
		}
		responseDto.setIdPjengBrseZzs(idPjengBrseZzs);
		
		List<Long> numMands = new ArrayList<>();
		List<Mandats> mandats = entity.getMandats();
		for (Mandats mandat: mandats) {
			numMands.add(mandat.getNumMand());
		}
		responseDto.setNumMands(numMands);
		
		return responseDto;
	}

	public static BordereauEmismandatsResponseDto BordereauEmismandatsToBordereauEmismandatsResponseDto(BordereauEmismandats entity) {
		BordereauEmismandatsResponseDto responseDto = new BordereauEmismandatsResponseDto();
		responseDto.setId(entity.getId());
		responseDto.setGestion(entity.getGestion());
		responseDto.setNum(entity.getNum());
		responseDto.setJournee(entity.getJournee());
		responseDto.setTotal(entity.getTotal());
		responseDto.setTotalAnterieur(entity.getTotalAnterieur());
		responseDto.setTotalCumul(entity.getTotalCumul());
		responseDto.setIdLogin(entity.getIdLogin());
		responseDto.setDossier(entity.getDossier());
		responseDto.setActif(entity.isActif());
		responseDto.setMontDeduit(entity.getMontDeduit());
		responseDto.setDateReception(entity.getDateReception());
		responseDto.setUserReception(entity.getUserReception());
		responseDto.setIdentiteRecept(entity.getIdentiteRecept());
		responseDto.setIdBudget(entity.getBudgetType().getIdBudget());
		
		List<Long> numMands = new ArrayList<>();
		List<Mandats> mandats = entity.getMandats();
		for (Mandats mandat: mandats) {
			numMands.add(mandat.getNumMand());
		}
		responseDto.setNumMands(numMands);
		
		List<BordTitreId> bordTitreIds = new ArrayList<>();
		List<BordTitre> bordTitres = entity.getBordTitres();
		for (BordTitre bordTitre: bordTitres) {
			bordTitreIds.add(bordTitre.getId());
		}
		responseDto.setBordTitreIds(bordTitreIds);
		
		List<BordMandId> bordMandIds = new ArrayList<>();
		List<BordMand> bordMands = entity.getBordMands();
		for (BordMand bordMand: bordMands) {
			bordMandIds.add(bordMand.getId());
		}
		responseDto.setBordMandIds(bordMandIds);
		
		List<Long> idDetailTitres = new ArrayList<>();
		List<TitreDetail> titreDetails = entity.getTitreDetails();
		for (TitreDetail titreDetail: titreDetails) {
			idDetailTitres.add(titreDetail.getIdDetailTitre());
		}
		responseDto.setIdDetailTitres(idDetailTitres);
		
		return responseDto;
	}

	public static TitreDetailResponseDto titreDetailToTitreDetailResponseDto(TitreDetail entity) {
		TitreDetailResponseDto responseDto = new TitreDetailResponseDto();
		responseDto.setIdDetailTitre(entity.getIdDetailTitre());
		responseDto.setMontant(entity.getMontant());
		responseDto.setGestion(entity.getGestion());
		responseDto.setDate(entity.getDate());
		responseDto.setReftitre(entity.getReftitre());
		responseDto.setIdLogin(entity.getIdLogin());
		responseDto.setDateEtat(entity.getDateEtat());
		responseDto.setNumero(entity.getNumero());
		responseDto.setNumAuto(entity.getNumAuto());
		responseDto.setTitreSignataire(entity.getTitreSignataire());
		responseDto.setNumComplema(entity.getNumComplema());
		responseDto.setDatePec(entity.getDatePec());
		responseDto.setReceptionne(entity.isReceptionne());
		responseDto.setDateValid(entity.getDateValid());
		if (entity.getAgents() != null) responseDto.setMle(entity.getAgents().getMle());
		responseDto.setIdBudget(entity.getBudgetType().getIdBudget());
		if (entity.getBudget() != null) responseDto.setCodBud(entity.getBudget().getCodBud());
		if (entity.getBordereauEmismandats() != null) responseDto.setIdBordEmis(entity.getBordereauEmismandats().getId());
		if (entity.getBordTransmis() != null) responseDto.setCodBord(entity.getBordTransmis().getCodBord());
		responseDto.setEtat(entity.getEtatDossier().getEtat());
		responseDto.setIdEtatTrans(entity.getEtatTransmission().getIdEtatTrans());
		responseDto.setIdApartir(entity.getTitreRegulApartir().getIdApartir());
		
		List<BordTitreId> bordTitreIds = new ArrayList<>();
		List<BordTitre> bordTitres = entity.getBordTitres();
		for (BordTitre bordTitre: bordTitres) {
			bordTitreIds.add(bordTitre.getId());
		}
		responseDto.setBordTitreIds(bordTitreIds);
		
		List<String> codTitrs = new ArrayList<>();
		List<TitreEmis> titreEmis = entity.getTitreEmis();
		for (TitreEmis titreEmi: titreEmis) {
			codTitrs.add(titreEmi.getCodTitr());
		}
		responseDto.setCodTitrs(codTitrs);
		
		List<Long> idAcomptes = new ArrayList<>();
		List<AcompteFrais> acompteFrais = entity.getAcompteFrais();
		for (AcompteFrais acompteFrai: acompteFrais) {
			idAcomptes.add(acompteFrai.getIdAcompte());
		}
		responseDto.setIdAcomptes(idAcomptes);
		
		return responseDto;
	}

	public static BordTitreDto bordTitreToBordTitreResponseDto(BordTitre entity) {
		BordTitreDto responseDto = new BordTitreDto();
		responseDto.setDatePaieRecouv(entity.getDatePaieRecouv());
		responseDto.setObservation(entity.getObservation());
		responseDto.setActifSurBord(entity.isActifSurBord());
		responseDto.setIdBord(entity.getBordereauEmismandats().getId());
		responseDto.setIdDetailTitre(entity.getTitreDetail().getIdDetailTitre());
		
		return responseDto;
	}
	
	public static BordMandDto bordMandToBordMandResponseDto(BordMand entity) {
		BordMandDto responseDto = new BordMandDto();
		responseDto.setDatePaieRecouv(entity.getDatePaieRecouv());
		responseDto.setObservation(entity.getObservation());
		responseDto.setActifSurBord(entity.isActifSurBord());
		responseDto.setIdBord(entity.getBordereauEmismandats().getId());
		responseDto.setNumMand(entity.getMandats().getNumMand());
		
		return responseDto;
	}

	public static FactureTypeResponseDto factureTypeToFactureTypeResponseDto(FactureType entity) {
		FactureTypeResponseDto responseDto = new FactureTypeResponseDto();
		responseDto.setIdTypFact(entity.getIdTypFact());
		responseDto.setLibelleTypFact(entity.getLibelleTypFact());
		
		List<Long> idFacts = new ArrayList<>();
		List<Factures> factures = entity.getFactures();
		for (Factures facture: factures) {
			idFacts.add(facture.getIdFact());
		}
		responseDto.setIdFacts(idFacts);
		
		return responseDto;
	}

	public static FacturesResponseDto facturesToFacturesResponseDto(Factures entity) {
		FacturesResponseDto responseDto = new FacturesResponseDto();
		responseDto.setIdFact(entity.getIdFact());
		responseDto.setObjetFact(entity.getObjetFact());
		responseDto.setDateFact(entity.getDateFact());
		responseDto.setNumeroFact(entity.getNumeroFact());
		responseDto.setMontant(entity.getMontant());
		responseDto.setRemise(entity.getRemise());
		responseDto.setTauxTva(entity.getTauxTva());
		responseDto.setMontantHt(entity.getMontantHt());
		responseDto.setMontantTtc(entity.getMontantTtc());
		responseDto.setMontantTva(entity.getMontantTva());
		responseDto.setAvecTva(entity.isAvecTva());
		responseDto.setIdSignataire(entity.getIdSignataire());
		responseDto.setSignataire(entity.getSignataire());
		responseDto.setNomSign(entity.getNomSign());
		responseDto.setTitreHonoSign(entity.getTitreHonoSign());
		responseDto.setNumChrono(entity.getNumChrono());
		responseDto.setComplemaNum(entity.getComplemaNum());
		responseDto.setIdFactParent(entity.getIdFactParent());
		responseDto.setValide(entity.isValide());
		responseDto.setNumeroContate(entity.getNumeroContate());
		responseDto.setActif(entity.isActif());
		
		List<String> codTitrs = new ArrayList<>();
		List<TitreEmis> titreEmis = entity.getTitreEmis();
		for (TitreEmis titreEmi: titreEmis) {
			codTitrs.add(titreEmi.getCodTitr());
		}
		responseDto.setCodTitrs(codTitrs);
		
		List<String> idFactDetails = new ArrayList<>();
		List<FactureDetail> factureDetails = entity.getFactureDetails();
		for (FactureDetail factureDetail: factureDetails) {
			idFactDetails.add(factureDetail.getIdFactDetail());
		}
		responseDto.setIdFactDetails(idFactDetails);
		
		return responseDto;
	}
}