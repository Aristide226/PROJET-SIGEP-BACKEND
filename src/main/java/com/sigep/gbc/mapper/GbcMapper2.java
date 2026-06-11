package com.sigep.gbc.mapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.sigep.gbc.dto.responseDto.ActeNatureResponseDto;
import com.sigep.gbc.dto.responseDto.BudgetModifActeResponseDto;
import com.sigep.gbc.dto.responseDto.BudgetModifResponseDto;
import com.sigep.gbc.dto.responseDto.CodEntiteContractResponseDto;
import com.sigep.gbc.dto.responseDto.CodModPassResponseDto;
import com.sigep.gbc.dto.responseDto.CodNatContratResponseDto;
import com.sigep.gbc.dto.responseDto.CodSourceFinResponseDto;
import com.sigep.gbc.dto.responseDto.CompteDestinataireResponseDto;
import com.sigep.gbc.dto.responseDto.ContratTypeResponseDto;
import com.sigep.gbc.dto.responseDto.ContratsResponseDto;
import com.sigep.gbc.dto.responseDto.FactureDetailResponseDto;
import com.sigep.gbc.dto.responseDto.HistoActionSResponseDto;
import com.sigep.gbc.dto.responseDto.HistoConSResponseDto;
import com.sigep.gbc.dto.responseDto.IdentiteExecutionResponseDto;
import com.sigep.gbc.dto.responseDto.LiquidationResponseDto;
import com.sigep.gbc.dto.responseDto.MandatsResponseDto;
import com.sigep.gbc.dto.responseDto.MotifsRejetDossierResponseDto;
import com.sigep.gbc.dto.responseDto.PieceJustifResponseDto;
import com.sigep.gbc.dto.responseDto.PpmActeResponseDto;
import com.sigep.gbc.dto.responseDto.PpmBudgOldResponseDto;
import com.sigep.gbc.dto.responseDto.PpmBudgResponseDto;
import com.sigep.gbc.dto.responseDto.PpmDacResponseDto;
import com.sigep.gbc.dto.responseDto.PpmExecBudgResponseDto;
import com.sigep.gbc.dto.responseDto.PpmExecResponseDto;
import com.sigep.gbc.dto.responseDto.PpmModPassResponseDto;
import com.sigep.gbc.dto.responseDto.PpmOldResponseDto;
import com.sigep.gbc.dto.responseDto.PpmProcedureResponseDto;
import com.sigep.gbc.dto.responseDto.PpmResponseDto;
import com.sigep.gbc.dto.responseDto.ReamHampliationResponseDto;
import com.sigep.gbc.dto.responseDto.ReamHvisaResponseDto;
import com.sigep.gbc.dto.responseDto.ReamgmtActeResponseDto;
import com.sigep.gbc.dto.responseDto.ReamgmtResponseDto;
import com.sigep.gbc.dto.responseDto.TiersCaissePopResponseDto;
import com.sigep.gbc.dto.responseDto.TypeMarcheResponseDto;
import com.sigep.gbc.entity.ActeNature;
import com.sigep.gbc.entity.Avenant;
import com.sigep.gbc.entity.BordMand;
import com.sigep.gbc.entity.BordMandId;
import com.sigep.gbc.entity.BordTransmis;
import com.sigep.gbc.entity.BudgetModif;
import com.sigep.gbc.entity.BudgetModifActe;
import com.sigep.gbc.entity.BudgetModifId;
import com.sigep.gbc.entity.ChequesVirements;
import com.sigep.gbc.entity.ChequesVirementsId;
import com.sigep.gbc.entity.CodEntiteContract;
import com.sigep.gbc.entity.CodModPass;
import com.sigep.gbc.entity.CodNatContrat;
import com.sigep.gbc.entity.CodSourceFin;
import com.sigep.gbc.entity.CompteDestinataire;
import com.sigep.gbc.entity.CompteMouvementMandR;
import com.sigep.gbc.entity.ContratType;
import com.sigep.gbc.entity.Contrats;
import com.sigep.gbc.entity.Engagements;
import com.sigep.gbc.entity.FactureDetail;
import com.sigep.gbc.entity.HistoActionS;
import com.sigep.gbc.entity.HistoActionSId;
import com.sigep.gbc.entity.HistoConS;
import com.sigep.gbc.entity.IdentiteExecution;
import com.sigep.gbc.entity.JournalPiece;
import com.sigep.gbc.entity.Justificatif;
import com.sigep.gbc.entity.Liquidation;
import com.sigep.gbc.entity.Livraisons;
import com.sigep.gbc.entity.MandatLettragPaie;
import com.sigep.gbc.entity.MandatPec;
import com.sigep.gbc.entity.MandatPecId;
import com.sigep.gbc.entity.Mandats;
import com.sigep.gbc.entity.MotifsRejetDossier;
import com.sigep.gbc.entity.Penalite;
import com.sigep.gbc.entity.PieceJustif;
import com.sigep.gbc.entity.PieceJustifComplement;
import com.sigep.gbc.entity.PieceJustifComplementId;
import com.sigep.gbc.entity.Ppm;
import com.sigep.gbc.entity.PpmActe;
import com.sigep.gbc.entity.PpmBudg;
import com.sigep.gbc.entity.PpmBudgId;
import com.sigep.gbc.entity.PpmBudgOld;
import com.sigep.gbc.entity.PpmBudgOldId;
import com.sigep.gbc.entity.PpmDac;
import com.sigep.gbc.entity.PpmExec;
import com.sigep.gbc.entity.PpmExecBudg;
import com.sigep.gbc.entity.PpmModePass;
import com.sigep.gbc.entity.PpmOld;
import com.sigep.gbc.entity.PpmOldId;
import com.sigep.gbc.entity.PpmProcedure;
import com.sigep.gbc.entity.ReamHampliation;
import com.sigep.gbc.entity.ReamHampliationId;
import com.sigep.gbc.entity.ReamHvisa;
import com.sigep.gbc.entity.ReamHvisaId;
import com.sigep.gbc.entity.Reamgmt;
import com.sigep.gbc.entity.ReamgmtActe;
import com.sigep.gbc.entity.ReamgmtId;
import com.sigep.gbc.entity.Recouvrements;
import com.sigep.gbc.entity.RetenuTitreRecouv;
import com.sigep.gbc.entity.Retenus;
import com.sigep.gbc.entity.RetenusQuitOrdre;
import com.sigep.gbc.entity.Suspension;
import com.sigep.gbc.entity.TiersCaissePop;
import com.sigep.gbc.entity.TypeMarche;
import com.sigep.gbc.view.entity.PpmExecBudgView;
import com.sigep.gbc.view.dto.PpmExecBudgViewDto;

public class GbcMapper2 {

	public static FactureDetailResponseDto factureDetailToFactureDetailResponseDto(FactureDetail entity) {
		FactureDetailResponseDto responseDto = new FactureDetailResponseDto();
		responseDto.setIdFactDetail(entity.getIdFactDetail());
		responseDto.setNumeroItem(entity.getNumeroItem());
		responseDto.setDesignation(entity.getDesignation());
		responseDto.setQtite(entity.getQtite());
		responseDto.setPrixUnitaire(entity.getPrixUnitaire());
		responseDto.setPrixTotal(entity.getPrixTotal());
		responseDto.setIdFact(entity.getFactures().getIdFact());
		return responseDto;
	}

	public static ContratTypeResponseDto contratTypeToContratTypeResponseDto(ContratType entity) {
		ContratTypeResponseDto responseDto = new ContratTypeResponseDto();
		responseDto.setTypeContrat(entity.getTypeContrat());
		responseDto.setLibelle(entity.getLibelle());
		responseDto.setAvecMiniMax(entity.isAvecMiniMax());
		
		List<Long> idContrats = new ArrayList<>();
		List<Contrats> contrats = entity.getContrats();
		for (Contrats contrat: contrats) {
			idContrats.add(contrat.getIdContrat());
		}
		responseDto.setIdContrats(idContrats);
		
		return responseDto;
	}

	public static ContratsResponseDto contratsToContratsResponseDto(Contrats entity) {
		ContratsResponseDto responseDto = new ContratsResponseDto();
		responseDto.setIdContrat(entity.getIdContrat());
		responseDto.setCod1(entity.getCod1());
		responseDto.setCod2(entity.getCod2());
		responseDto.setCod3(entity.getCod3());
		responseDto.setCod4(entity.getCod4());
		responseDto.setCod5(entity.getCod5());
		responseDto.setAnnee(entity.getAnnee());
		responseDto.setObjet(entity.getObjet());
		responseDto.setReference(entity.getReference());
		responseDto.setDelaiNbre(entity.getDelaiNbre());
		responseDto.setDelaiText(entity.getDelaiText());
		responseDto.setDateSaisie(entity.getDateSaisie());
		responseDto.setDateApprob(entity.getDateApprob());
		responseDto.setActeRef(entity.getActeRef());
		responseDto.setRefNotif(entity.getRefNotif());
		responseDto.setDateDemmar(entity.getDateDemmar());
		responseDto.setMleAuto(entity.isMleAuto());
		responseDto.setRefPassation(entity.getRefPassation());
		responseDto.setRefArt(entity.getRefArt());
		responseDto.setTauxappli(entity.getTauxappli());
		responseDto.setSuspens(entity.getSuspens());
		responseDto.setIdLogin(entity.getIdLogin());
		responseDto.setIdcompte(entity.getIdcompte());
		responseDto.setAvenant(entity.getAvenant());
		responseDto.setDegage(entity.getDegage());
		responseDto.setEngage(entity.getEngage());
		responseDto.setMandate(entity.getMandate());
		responseDto.setPaie(entity.getPaie());
		responseDto.setEngageValid(entity.getEngageValid());
		responseDto.setMandateValid(entity.getMandateValid());
		responseDto.setMontantMaxHtva(entity.getMontantMaxHtva());
		responseDto.setMontantMinHtva(entity.getMontantMinHtva());
		responseDto.setMontantMaxTtc(entity.getMontantMaxTtc());
		responseDto.setMontantMinTtc(entity.getMontantMinTtc());
		responseDto.setAvecTva(entity.isAvecTva());
		responseDto.setAvecMiniMax(entity.isAvecMiniMax());
		responseDto.setMontant(entity.getMontant());
		responseDto.setMontantCorrige(entity.getMontantCorrige());
		responseDto.setDelaiAn(entity.getDelaiAn());
		responseDto.setDelaiMois(entity.getDelaiMois());
		responseDto.setDelaiSemaine(entity.getDelaiSemaine());
		responseDto.setDelaiJours(entity.getDelaiJours());
		responseDto.setDelaiEnJours(entity.getDelaiEnJours());
		responseDto.setDateCreate(entity.getDateCreate());
		responseDto.setUserUpdate(entity.getUserUpdate());
		responseDto.setDateUpdate(entity.getDateUpdate());
		responseDto.setIdContratParent(entity.getIdContratParent());
		responseDto.setAbrevEpe(entity.getAbrevEpe());
		responseDto.setDateAttribution(entity.getDateAttribution());
		responseDto.setCodTypeMarche(entity.getCodTypeMarche());
		responseDto.setCodIdentiteExecution(entity.getCodIdentiteExecution());
		responseDto.setIdPpmExe(entity.getIdPpmExe());
		responseDto.setIdLot(entity.getIdLot());
		responseDto.setCodBud(entity.getCodBud());
		responseDto.setIdSrceFin(entity.getIdSrceFin());
		responseDto.setIdBudget(entity.getBudgetType().getIdBudget());
		responseDto.setType(entity.getContratType().getTypeContrat());
		responseDto.setIdFourn(entity.getDestinataires().getIdDest());
		if (entity.getPpmDac() != null) responseDto.setIdDac(entity.getPpmDac().getIdDac());
		
		List<Long> codLiqs = new ArrayList<>();
		List<Liquidation> liquidations = entity.getLiquidations();
		for (Liquidation liquidation: liquidations) {
			codLiqs.add(liquidation.getCodLiq());
		}
		responseDto.setCodLiqs(codLiqs);
		
		List<String> idLivraisons = new ArrayList<>();
		List<Livraisons> livraisons = entity.getLivraisons();
		for (Livraisons livraison: livraisons) {
			idLivraisons.add(livraison.getNumD());
		}
		responseDto.setIdLivraisons(idLivraisons);
		
		List<String> idPenalites = new ArrayList<>();
		List<Penalite> penalites = entity.getPenalites();
		for (Penalite penalite: penalites) {
			idPenalites.add(penalite.getId());
		}
		responseDto.setIdPenalites(idPenalites);
		
		List<String> idSus = new ArrayList<>();
		List<Suspension> suspensions = entity.getSuspensions();
		for (Suspension suspension: suspensions) {
			idSus.add(suspension.getIdSus());
		}
		responseDto.setIdSus(idSus);
		
		List<Integer> idAvenants = new ArrayList<>();
		List<Avenant> avenants = entity.getAvenants();
		for (Avenant avenant: avenants) {
			idAvenants.add(avenant.getIdAvenant());
		}
		responseDto.setIdAvenants(idAvenants);
		
		List<String> idRetenus = new ArrayList<>();
		List<Retenus> retenus = entity.getRetenus();
		for (Retenus retenu: retenus) {
			idRetenus.add(retenu.getIdRetenu());
		}
		responseDto.setIdRetenus(idRetenus);
		
		List<Long> numBes = new ArrayList<>();
		List<Engagements> engagements = entity.getEngagements();
		for (Engagements engagement: engagements) {
			numBes.add(engagement.getNumBe());
		}
		responseDto.setNumBes(numBes);
		
		List<Long> numMands = new ArrayList<>();
		List<Mandats> mandats = entity.getMandats();
		for (Mandats mandat: mandats) {
			numMands.add(mandat.getNumMand());
		}
		responseDto.setNumMands(numMands);
		
		return responseDto;
	}

	public static PpmDacResponseDto ppmDacToPpmDacResponseDto(PpmDac entity) {
		PpmDacResponseDto responseDto = new PpmDacResponseDto();
		responseDto.setIdDac(entity.getIdDac());
		responseDto.setRefPassation(entity.getRefPassation());
		responseDto.setDateCreation(entity.getDateCreation());
		responseDto.setDateDac(entity.getDateDac());
		responseDto.setDateLancement(entity.getDateLancement());
		if (entity.getPpm() != null) responseDto.setIdPpm(entity.getPpm().getIdPpm());
		
		List<Long> idContrats = new ArrayList<>();
		List<Contrats> contrats = entity.getContrats();
		for (Contrats contrat: contrats) {
			idContrats.add(contrat.getIdContrat());
		}
		responseDto.setIdContrats(idContrats);
		
		return responseDto;
	}

	public static PpmProcedureResponseDto ppmProcedureToPpmProcedureResponseDto(PpmProcedure entity) {
		PpmProcedureResponseDto responseDto = new PpmProcedureResponseDto();
		entity.setIdProc(entity.getIdProc());
		entity.setLibProcedure(entity.getLibProcedure());
		
		List<String> idCodModPasss = new ArrayList<>();
		List<CodModPass> codModPasss = entity.getCodModPasss();
		for (CodModPass codModPass: codModPasss) {
			idCodModPasss.add(codModPass.getCod4());
		}
		responseDto.setIdCodModPasss(idCodModPasss);
		
		return responseDto;
	}

	public static CodModPassResponseDto codModPassToCodModPassResponseDto(CodModPass entity) {
		CodModPassResponseDto responseDto = new CodModPassResponseDto();
		responseDto.setCod4(entity.getCod4());
		responseDto.setIntitule(entity.getIntitule());
		responseDto.setLibelleCourt(entity.getLibelleCourt());
		
		List<String> idPpmModePasss = new ArrayList<>();
		List<PpmModePass> ppmModePasss = entity.getPpmModePasss();
		for (PpmModePass ppmModePass: ppmModePasss) {
			idPpmModePasss.add(ppmModePass.getAbrevMp());
		}
		responseDto.setIdPpmModePasss(idPpmModePasss);
		
		return responseDto;
	}

	public static PpmModPassResponseDto ppmModPassToPpmModPassResponseDto(PpmModePass entity) {
		PpmModPassResponseDto responseDto = new PpmModPassResponseDto();
		responseDto.setAbrevMp(entity.getAbrevMp());
		responseDto.setLibelleLongMp(entity.getLibelleLongMp());
		responseDto.setJrsLancemtRemisO(entity.getJrsLancemtRemisO());
		responseDto.setJrsNecessaireEvalua(entity.getJrsNecessaireEvalua());
		responseDto.setCod4(entity.getCodModPass().getCod4());
		
		List<String> idPpms = new ArrayList<>();
		List<Ppm> ppms = entity.getPpms();
		for (Ppm ppm: ppms) {
			idPpms.add(ppm.getIdPpm());
		}
		responseDto.setIdPpms(idPpms);
		
		return responseDto;
	}

	public static CodSourceFinResponseDto codSourceFinToCodSourceFinResponseDto(CodSourceFin entity) {
		CodSourceFinResponseDto responseDto = new CodSourceFinResponseDto();
		responseDto.setCod5(entity.getCod5());
		responseDto.setIntituleCourt(entity.getIntituleCourt());
		responseDto.setAbrev(entity.getAbrev());
		responseDto.setIntituleLong(entity.getIntituleLong());
		
		List<PpmBudgId> ppmBudgIds = new ArrayList<>();
		List<PpmBudg> ppmBudgs = entity.getPpmBudgs();
		for (PpmBudg ppmBudg: ppmBudgs) {
			ppmBudgIds.add(ppmBudg.getId());
		}
		responseDto.setPpmBudgIds(ppmBudgIds);
		
		return responseDto;
	}

	public static PpmActeResponseDto ppmActeToPpmActeResponseDto(PpmActe entity) {
		PpmActeResponseDto responseDto = new PpmActeResponseDto();
		responseDto.setIdPpmM(entity.getIdPpmM());
		responseDto.setGestion(entity.getGestion());
		responseDto.setQuantieme(entity.getQuantieme());
		responseDto.setDateModif(entity.getDateModif());
		responseDto.setMotifModif(entity.getMotifModif());
		responseDto.setActeAutorisation(entity.getActeAutorisation());
		responseDto.setDateCreate(entity.getDateCreate());
		responseDto.setUserCreate(entity.getUserCreate());
		responseDto.setDateUpdate(entity.getDateUpdate());
		responseDto.setUserUpdate(entity.getUserUpdate());
		responseDto.setValide(entity.isValide());
		responseDto.setUserValide(entity.getUserValide());
		responseDto.setDateValide(entity.getDateValide());
		if (entity.getPpmActe() != null) responseDto.setIdPpmMMP(entity.getPpmActe().getIdPpmM());
		responseDto.setIdBudget(entity.getBudgetType().getIdBudget());
		
		List<PpmOldId> ppmOldIds = new ArrayList<>();
		List<PpmOld> ppmOlds = entity.getPpmOlds();
		for (PpmOld ppmOld: ppmOlds) {
			ppmOldIds.add(ppmOld.getId());
		}
		responseDto.setPpmOldIds(ppmOldIds);
		
		List<PpmBudgOldId> ppmBudgOldIds = new ArrayList<>();
		List<PpmBudgOld> ppmBudgOlds = entity.getPpmBudgOlds();
		for (PpmBudgOld ppmBudgOld: ppmBudgOlds) {
			ppmBudgOldIds.add(ppmBudgOld.getId());
		}
		responseDto.setPpmBudgOldIds(ppmBudgOldIds);
		
		List<String> idPpmMs = new ArrayList<>();
		List<PpmActe> ppmActes = entity.getPpmActes();
		for (PpmActe ppmActe: ppmActes) {
			idPpmMs.add(ppmActe.getIdPpmM());
		}
		responseDto.setIdPpmMs(idPpmMs);
		
		List<String> idPpms = new ArrayList<>();
		List<Ppm> ppms = entity.getPpms();
		for (Ppm ppm: ppms) {
			idPpms.add(ppm.getIdPpm());
		}
		responseDto.setIdPpms(idPpms);
		
		return responseDto;
	}

	public static PpmResponseDto ppmToPpmResponseDto(Ppm entity) {
		PpmResponseDto responseDto = new PpmResponseDto();
		responseDto.setIdPpm(entity.getIdPpm());
		responseDto.setExercice(entity.getExercice());
		responseDto.setNum(entity.getNum());
		responseDto.setMontantEstime(entity.getMontantEstime());
		responseDto.setMontDepEngNonLiq(entity.getMontDepEngNonLiq());
		responseDto.setCreditDispo(entity.getCreditDispo());
		responseDto.setNatPrestation(entity.getNatPrestation());
		responseDto.setNbLot(entity.getNbLot());
		responseDto.setDateLancement(entity.getDateLancement());
		responseDto.setDateRemiseOffre(entity.getDateRemiseOffre());
		responseDto.setNbJrsEvaluation(entity.getNbJrsEvaluation());
		responseDto.setDateProbDemar(entity.getDateProbDemar());
		responseDto.setDelaiExecJrs(entity.getDelaiExecJrs());
		responseDto.setDateButoire(entity.getDateButoire());
		responseDto.setDateEffectLance(entity.getDateEffectLance());
		responseDto.setDateAttribution(entity.getDateAttribution());
		responseDto.setMontantPasse(entity.getMontantPasse());
		responseDto.setReam(entity.getReam());
		responseDto.setIdPpmM(entity.getPpmActe().getIdPpmM());
		if (entity.getPpmModePass() != null) responseDto.setAbrevMp(entity.getPpmModePass().getAbrevMp());
		responseDto.setIdBudget(entity.getBudgetType().getIdBudget());
		
		List<PpmOldId> ppmOldIds = new ArrayList<>();
		List<PpmOld> ppmOlds = entity.getPpmOlds();
		for (PpmOld ppmOld: ppmOlds) {
			ppmOldIds.add(ppmOld.getId());
		}
		responseDto.setPpmOldIds(ppmOldIds);
		
		List<String> idDacs = new ArrayList<>();
		List<PpmDac> ppmDacs = entity.getPpmDacs();
		for (PpmDac ppmDac: ppmDacs) {
			idDacs.add(ppmDac.getIdDac());
		}
		responseDto.setIdDacs(idDacs);
		
		List<PpmBudgId> ppmBudgIds = new ArrayList<>();
		List<PpmBudg> ppmBudgs = entity.getPpmBudgs();
		for (PpmBudg ppmBudg: ppmBudgs) {
			ppmBudgIds.add(ppmBudg.getId());
		}
		responseDto.setPpmBudgIds(ppmBudgIds);
		
		return responseDto;
	}

	public static PpmBudgResponseDto ppmBudgToPpmBudgResponseDto(PpmBudg entity) {
		PpmBudgResponseDto responseDto = new PpmBudgResponseDto();
		responseDto.setMontantEstime(entity.getMontantEstime());
		responseDto.setIdPpm(entity.getPpm().getIdPpm());
		responseDto.setCodBud(entity.getBudget().getCodBud());
		responseDto.setIdSrceFin(entity.getCodSourceFin().getCod5());
		responseDto.setReam(entity.isReam());
		return responseDto;
	}

	public static PpmBudgOldResponseDto ppmBudgOldToPpmBudgOldResponseDto(PpmBudgOld entity) {
		PpmBudgOldResponseDto responseDto = new PpmBudgOldResponseDto();
		responseDto.setIdPpmM(entity.getId().getIdPpmM());
		responseDto.setIdPpm(entity.getId().getIdPpm());
		responseDto.setCodBud(entity.getId().getCodBud());
		responseDto.setIdSrceFin(entity.getId().getIdSrceFin());
		responseDto.setMontantEstime(entity.getMontantEstime());
		return responseDto;
	}

	public static PpmOldResponseDto ppmOldToPpmOldResponseDto(PpmOld entity) {
		PpmOldResponseDto responseDto = new PpmOldResponseDto();
		responseDto.setIdPpmM(entity.getId().getIdPpmM());
		responseDto.setIdPpm(entity.getId().getIdPpm());
		responseDto.setMontantEstime(entity.getMontantEstime());
		responseDto.setMontDepEngNonLiq(entity.getMontDepEngNonLiq());
		responseDto.setCreditDispo(entity.getCreditDispo());
		responseDto.setNatPrestation(entity.getNatPrestation());
		responseDto.setNbLot(entity.getNbLot());
		responseDto.setIdModPassation(entity.getIdModPassation());
		responseDto.setDateLancement(entity.getDateLancement());
		responseDto.setDateRemiseOffre(entity.getDateRemiseOffre());
		responseDto.setNbJrsEvaluation(entity.getNbJrsEvaluation());
		responseDto.setDateProbDemar(entity.getDateProbDemar());
		responseDto.setDelaiExecJrs(entity.getDelaiExecJrs());
		responseDto.setDateButoire(entity.getDateButoire());
		responseDto.setDateEffectLance(entity.getDateEffectLance());
		return responseDto;
	}

	public static BudgetModifActeResponseDto BudgetModifActeToBudgetModifActeResponseDto(BudgetModifActe entity) {
		BudgetModifActeResponseDto responseDto = new BudgetModifActeResponseDto();
		responseDto.setCodBma(entity.getCodBma());
		responseDto.setDateSaisie(entity.getDateSaisie());
		responseDto.setValide(entity.isValide());
		responseDto.setActeBma(entity.getActeBma());
		responseDto.setNumActeBma(entity.getNumActeBma());
		responseDto.setDateActeBma(entity.getDateActeBma());
		responseDto.setIdLogin(entity.getIdLogin());
		responseDto.setGestion(entity.getGestion());
		responseDto.setDateValid(entity.getDateValid());
		responseDto.setIdValid(entity.getIdValid());
		responseDto.setIdBudget(entity.getIdBudget());
		
		List<BudgetModifId> budgetModifIds = new ArrayList<>();
		List<BudgetModif> budgetModifs = entity.getBudgetModifs();
		for (BudgetModif budgetModif: budgetModifs) {
			budgetModifIds.add(budgetModif.getId());
		}
		responseDto.setBudgetModifIds(budgetModifIds);
		
		return responseDto;
	}

	public static BudgetModifResponseDto budgetModifToBudgetModifResponseDto(BudgetModif entity) {
		BudgetModifResponseDto responseDto = new BudgetModifResponseDto();
		responseDto.setCodBma(entity.getId().getCodBma());
		responseDto.setCodBud(entity.getId().getCodBud());
		responseDto.setAjoute(entity.getAjoute());
		responseDto.setAnnule(entity.getAnnule());
		responseDto.setNouvelle(entity.isNouvelle());
		return responseDto;
	}

	public static ReamHampliationResponseDto reamHampliationToReamHampliationResponseDto(ReamHampliation entity) {
		ReamHampliationResponseDto responseDto = new ReamHampliationResponseDto();
		responseDto.setCodReam(entity.getId().getCodReam());
		responseDto.setAmpliataireReam(entity.getId().getAmpliataireReam());
		return responseDto;
	}

	public static ReamHvisaResponseDto reamHvisaToReamHvisaResponseDto(ReamHvisa entity) {
		ReamHvisaResponseDto responseDto = new ReamHvisaResponseDto();
		responseDto.setCodReam(entity.getId().getCodReam());
		responseDto.setRangVisa(entity.getId().getRangVisa());
		responseDto.setLibelleVisa(entity.getLibelleVisa());
		return responseDto;
	}

	public static ActeNatureResponseDto acteNatureToActeNatureResponseDto(ActeNature entity) {
		ActeNatureResponseDto responseDto = new ActeNatureResponseDto();
		responseDto.setIdActe(entity.getIdActe());
		responseDto.setActe(entity.getActe());
		responseDto.setActeTitre(entity.getActeTitre());
		responseDto.setActeNumComplema(entity.getActeNumComplema());
		responseDto.setDernierArticleDebloc(entity.getDernierArticleDebloc());
		responseDto.setDernierArticleReam(entity.getDernierArticleReam());
		
		List<Long> idReamgmtActes = new ArrayList<>();
		List<ReamgmtActe> reamgmtActes = entity.getReamgmtActes();
		for (ReamgmtActe reamgmtActe: reamgmtActes) {
			idReamgmtActes.add(reamgmtActe.getCodReam());
		}
		responseDto.setIdReamgmtActes(idReamgmtActes);
		
		return responseDto;
	}

	public static ReamgmtActeResponseDto reamgmtActeReamgmtActeResponseDto(ReamgmtActe entity) {
		ReamgmtActeResponseDto responseDto = new ReamgmtActeResponseDto();
		responseDto.setCodReam(entity.getCodReam());
		responseDto.setDateSaisie(entity.getDateSaisie());
		responseDto.setValide(entity.isValide());
		responseDto.setActe(entity.getActe());
		responseDto.setNumero(entity.getNumero());
		responseDto.setDateActe(entity.getDateActe());
		responseDto.setIdLogin(entity.getIdLogin());
		responseDto.setDateValid(entity.getDateValid());
		responseDto.setIdValid(entity.getIdValid());
		responseDto.setDep(entity.getDep());
		responseDto.setActeTitre(entity.getActeTitre());
		responseDto.setActeAn(entity.getActeAn());
		responseDto.setActeNum(entity.getActeNum());
		responseDto.setActeNumComplema(entity.getActeNumComplema());
		responseDto.setNumAuto(entity.isNumAuto());
		responseDto.setSignataireFonct(entity.getSignataireFonct());
		responseDto.setSignataireNom(entity.getSignataireNom());
		responseDto.setSignataireTh(entity.getSignataireTh());
		responseDto.setComplemaVisa(entity.getComplemaVisa());
		responseDto.setComplemaVisaLib(entity.getComplemaVisaLib());
		responseDto.setDernierArticleReam(entity.getDernierArticleReam());
		responseDto.setIdActe(entity.getActeNature().getIdActe());
		responseDto.setGestion(entity.getGestion().getCourante());
		responseDto.setIdBudget(entity.getBudgetType().getIdBudget());
		
		List<ReamgmtId> reamgmtIds = new ArrayList<>();
		List<Reamgmt> reamgmts = entity.getReamgmts();
		for (Reamgmt reamgmt: reamgmts) {
			reamgmtIds.add(reamgmt.getId());
		}
		responseDto.setReamgmtIds(reamgmtIds);
		
		List<ReamHampliationId> reamHampliationIds = new ArrayList<>();
		List<ReamHampliation> reamHampliations = entity.getReamHampliations();
		for (ReamHampliation reamHampliation: reamHampliations) {
			reamHampliationIds.add(reamHampliation.getId());
		}
		responseDto.setReamHampliationIds(reamHampliationIds);
		
		List<ReamHvisaId> reamHvisaIds = new ArrayList<>();
		List<ReamHvisa> reamHvisas = entity.getReamHvisas();
		for (ReamHvisa reamHvisa: reamHvisas) {
			reamHvisaIds.add(reamHvisa.getId());
		}
		responseDto.setReamHvisaIds(reamHvisaIds);
		
		return responseDto;
	}

	public static ReamgmtResponseDto reamgmtToReamgmtResponseDto(Reamgmt entity) {
		ReamgmtResponseDto responseDto = new ReamgmtResponseDto();
		responseDto.setCodReam(entity.getId().getCodReam());
		responseDto.setCodBug(entity.getId().getCodBug());
		responseDto.setOuvert(entity.getOuvert());
		responseDto.setAnnule(entity.getAnnule());
		responseDto.setNouvelle(entity.isNouvelle());
		return responseDto;
	}

	public static HistoConSResponseDto histoConSToHistoConSResponseDto(HistoConS entity) {
		HistoConSResponseDto responseDto = new HistoConSResponseDto();
		responseDto.setCodH(entity.getCodH());
		responseDto.setIdl(entity.getIdl());
		responseDto.setDateConnexion(entity.getDateConnexion());
		responseDto.setPc(entity.getPc());
		responseDto.setAdressMac(entity.getAdressMac());
		
		List<HistoActionSId> histoActionSIds = new ArrayList<>();
		List<HistoActionS> histoActionSs = entity.getHistoActionSs();
		for (HistoActionS histoActionS: histoActionSs) {
			histoActionSIds.add(histoActionS.getId());
		}
		responseDto.setHistoActionSIds(histoActionSIds);
		
		return responseDto;
	}

	public static HistoActionSResponseDto histoActionSToHistoActionSResponseDto(HistoActionS entity) {
		HistoActionSResponseDto responseDto = new HistoActionSResponseDto();
		responseDto.setDateAct(entity.getId().getDateAct());
		responseDto.setCodH(entity.getId().getCodH());
		responseDto.setAction(entity.getAction());
		
		return responseDto;
	}

	public static TiersCaissePopResponseDto tcpToTcpResponseDto(TiersCaissePop entity) {
		TiersCaissePopResponseDto responseDto = new TiersCaissePopResponseDto();
		responseDto.setIdCaissePop(entity.getIdCaissePop());
		responseDto.setCaissePop(entity.getCaissePop());
		responseDto.setFolio(entity.getFolio());
		
		List<String> compteDestinatairesIds = new ArrayList<>();
		List<CompteDestinataire> compteDestinataires = entity.getCompteDestinataires();
		for (CompteDestinataire compteDestinataire: compteDestinataires) {
			compteDestinatairesIds.add(compteDestinataire.getId());
		}
		responseDto.setCompteDestinatairesIds(compteDestinatairesIds);
		
		return responseDto;
	}

	public static CompteDestinataireResponseDto cdToCdResponseDto(CompteDestinataire entity) {
		CompteDestinataireResponseDto responseDto = new CompteDestinataireResponseDto();
		responseDto.setId(entity.getId());
		responseDto.setCodeBanque(entity.getCodeBanque());
		responseDto.setCodeAgence(entity.getCodeAgence());
		responseDto.setNumCompte(entity.getNumCompte());
		responseDto.setCleRib(entity.getCleRib());
		responseDto.setCaissePop(entity.getCaissePop());
		responseDto.setNumCaissePop(entity.getNumCaissePop());
		responseDto.setCodeBic(entity.getCodeBic());
		responseDto.setIban(entity.getIban());
		responseDto.setCodeAgence(entity.getCodeAgence());
		if (entity.getTiersCaissePop() != null) responseDto.setIdCaissePop(entity.getTiersCaissePop().getIdCaissePop());
		responseDto.setAbreviation(entity.getInstitutFinancier().getAbreviation());
		responseDto.setIdAgence(entity.getInstitutFinAgence().getIdAgence());
		responseDto.setIdDest(entity.getDestinataires().getIdDest());
		
		List<Long> codLiqs = new ArrayList<>();
		List<Liquidation> liquidations = entity.getLiquidations();
		for (Liquidation liquidation: liquidations) {
			codLiqs.add(liquidation.getCodLiq());
		}
		responseDto.setCodLiqs(codLiqs);
		
		List<Long> numMands = new ArrayList<>();
		List<Mandats> mandats = entity.getMandats();
		for (Mandats mandat: mandats) {
			numMands.add(mandat.getNumMand());
		}
		responseDto.setNumMands(numMands);
		
		return responseDto;
	}

	public static PieceJustifResponseDto pieceJustifToPieceJustfiResponseDto(PieceJustif entity) {
		PieceJustifResponseDto responseDto = new PieceJustifResponseDto();
		responseDto.setCodPj(entity.getCodPj());
		responseDto.setNumBe(entity.getNumBe());
		responseDto.setCodLiq(entity.getCodLiq());
		responseDto.setNumMand(entity.getNumMand());
		responseDto.setPieceJustificative(entity.getPieceJustificative());
		responseDto.setNumero(entity.getNumero());
		responseDto.setDatePj(entity.getDatePj());
		responseDto.setMontant(entity.getMontant());
		responseDto.setIdRetenu(entity.getIdRetenu());
		responseDto.setIdBord(entity.getIdBord());
		
		return responseDto;
	}
	
	public static MandatsResponseDto mandatToMandatResponseDto(Mandats entity) {
		MandatsResponseDto responseDto = new MandatsResponseDto();
		responseDto.setNumMand(entity.getNumMand());
		responseDto.setMandNum(entity.getMandNum());
		responseDto.setDateMand(entity.getDateMand());
		responseDto.setMontant(entity.getMontant());
		responseDto.setDateEtat(entity.getDateEtat());
		responseDto.setDatePaie(entity.getDatePaie());
		responseDto.setMontantPaie(entity.getMontantPaie());
		responseDto.setIdCompte(entity.getIdCompte());
		responseDto.setIdUser(entity.getIdUser());
		responseDto.setDatePosition(entity.getDatePosition());
		responseDto.setBenum(entity.getBenum());
		responseDto.setNumBl(entity.getNumBl());
		responseDto.setObjet(entity.getObjet());
		responseDto.setMontEngage(entity.getMontEngage());
		responseDto.setMontDjaLiq(entity.getMontDjaLiq());
		responseDto.setDateEtatBl(entity.getDateEtatBl());
		responseDto.setDatePec(entity.getDatePec());
		responseDto.setReceptionne(entity.isReceptionne());
		responseDto.setGenererOv(entity.isGenererOv());
		responseDto.setAvecReversement(entity.isAvecReversement());
		responseDto.setPrecompte(entity.getPrecompte());
		responseDto.setDatePrecompte(entity.getDatePrecompte());
		responseDto.setUserPrecompte(entity.getUserPrecompte());
		responseDto.setDateValid(entity.getDateValid());
		responseDto.setIdFiche(entity.getIdFiche());
		responseDto.setMontantTotalPec(entity.getMontantTotalPec());
		responseDto.setDateCreat(entity.getDateCreat());
		responseDto.setEstOrdre(entity.isEstOrdre());
		responseDto.setMandNumApresVisaCf(entity.getMandNumApresVisaCf());
		responseDto.setIdEtatTransL(entity.getEtatTransmissionByIdEtatTransL().getIdEtatTrans());
		responseDto.setIdEtatTransM(entity.getEtatTransmissionByIdEtatTransM().getIdEtatTrans());
		if (entity.getBordereauEmismandats() != null) responseDto.setIdBordEmis(entity.getBordereauEmismandats().getId());
		responseDto.setIdBord(entity.getIdBord());
		responseDto.setCodBud(entity.getBudget().getCodBud());
		responseDto.setIdBudget(entity.getBudgetType().getIdBudget());
		if (entity.getCompteDestinataire() != null) responseDto.setCompteFourn(entity.getCompteDestinataire().getId());
		if (entity.getContrats() != null) responseDto.setIdContrat(entity.getContrats().getIdContrat());
		responseDto.setIdForun(entity.getDestinataires().getIdDest());
		responseDto.setGestion(entity.getGestion().getCourante());
		responseDto.setCodLiq(entity.getCodLiq()); // Modifiable
		responseDto.setIdLettrage(entity.getIdLettrage()); // Modifiable
		responseDto.setIdModePaie(entity.getIdModePaie()); // Modifiable
		responseDto.setNumBe(entity.getEngagements().getNumBe());
		responseDto.setEtat(entity.getEtatDossierByEtat().getEtat());
		responseDto.setEtatBl(entity.getEtatDossierByEtatBl().getEtat());
		if (entity.getMandats() != null) responseDto.setNumMandParent(entity.getMandats().getNumMand());
		
		List<Long> codBordsBordTransMand = new ArrayList<>();
		List<BordTransmis> bordTransmisBordTransMand = entity.getBordTransmisBordTransMand();
		for (BordTransmis b: bordTransmisBordTransMand) {
			codBordsBordTransMand.add(b.getCodBord());
		}
		responseDto.setCodBordsBordTransMand(codBordsBordTransMand);
		
		List<Long> codBordsBordTransLiq = new ArrayList<>();
		List<BordTransmis> bordTransmisBordTransLiq = entity.getBordTransmisBordTransLiq();
		for (BordTransmis b: bordTransmisBordTransLiq) {
			codBordsBordTransLiq.add(b.getCodBord());
		}
		responseDto.setCodBordsBordTransLiq(codBordsBordTransLiq);
		
		List<String> idRetenusQuitOrdres = new ArrayList<>();
		List<RetenusQuitOrdre> retenusQuitOrdres = entity.getRetenusQuitOrdres();
		for (RetenusQuitOrdre retenusQuitOrdre: retenusQuitOrdres) {
			idRetenusQuitOrdres.add(retenusQuitOrdre.getIdQitO());
		}
		responseDto.setIdRetenusQuitOrdres(idRetenusQuitOrdres);
		
		if (entity.getMandatsCloture() != null) responseDto.setIdMandatsCloture(entity.getMandatsCloture().getNumMand());
		
		List<PieceJustifComplementId> pieceJustifComplemenIds = new ArrayList<>();
		List<PieceJustifComplement> pieceJustifComplements = entity.getPieceJustifComplements();
		for (PieceJustifComplement pieceJustifComplement: pieceJustifComplements) {
			pieceJustifComplemenIds.add(pieceJustifComplement.getId());
		}
		responseDto.setPieceJustifComplemenIds(pieceJustifComplemenIds);
		
		List<Long> idCompteMouvementMandRs = new ArrayList<>();
		List<CompteMouvementMandR> compteMouvementMandRs = entity.getCompteMouvementMandRs();
		for (CompteMouvementMandR compteMouvementMandR: compteMouvementMandRs) {
			idCompteMouvementMandRs.add(compteMouvementMandR.getIdBord());
		}
		responseDto.setIdRetenusQuitOrdres(idRetenusQuitOrdres);
		
		List<String> idRetenuTitreRecouvs = new ArrayList<>();
		List<RetenuTitreRecouv> retenuTitreRecouvs = entity.getRetenuTitreRecouvs();
		for (RetenuTitreRecouv retenuTitreRecouv: retenuTitreRecouvs) {
			idRetenuTitreRecouvs.add(retenuTitreRecouv.getIdrtr());
		}
		responseDto.setIdRetenuTitreRecouvs(idRetenuTitreRecouvs);
		
		List<String> idMandLettragPaies = new ArrayList<>();
		List<MandatLettragPaie> mandatLettragPaies = entity.getMandatLettragPaies();
		for (MandatLettragPaie mandatLettragPaie: mandatLettragPaies) {
			idMandLettragPaies.add(mandatLettragPaie.getIdChqVir());
		}
		responseDto.setIdMandLettragPaies(idMandLettragPaies);
		
		List<ChequesVirementsId> chequesVirementsIds = new ArrayList<>();
		List<ChequesVirements> chequesVirements = entity.getChequesVirements();
		for (ChequesVirements chequesVirement: chequesVirements) {
			chequesVirementsIds.add(chequesVirement.getId());
		}
		responseDto.setChequesVirementsIds(chequesVirementsIds);
		
		List<String> codRecouvs = new ArrayList<>();
		List<Recouvrements> recouvrements = entity.getRecouvrements();
		for (Recouvrements recouvrement: recouvrements) {
			codRecouvs.add(recouvrement.getCodRecouv());
		}
		responseDto.setCodRecouvs(codRecouvs);
		
		List<Long> numMands = new ArrayList<>();
		List<Mandats> mandats = entity.getMandatss();
		for (Mandats mandat: mandats) {
			numMands.add(mandat.getNumMand());
		}
		responseDto.setNumMands(numMands);
		
		List<BigInteger> idPieceJournalsForNumMand = new ArrayList<>();
		List<JournalPiece> journalPiecesForNumMand = entity.getJournalPiecesForNumMand();
		for (JournalPiece j: journalPiecesForNumMand) {
			idPieceJournalsForNumMand.add(j.getIdPieceJournal());
		}
		responseDto.setIdPieceJournalsForNumMand(idPieceJournalsForNumMand);
		
		List<BigInteger> idPieceJournalsForIdMandRetenu = new ArrayList<>();
		List<JournalPiece> journalPiecesForIdMandRetenu = entity.getJournalPiecesForIdMandRetenu();
		for (JournalPiece j: journalPiecesForIdMandRetenu) {
			idPieceJournalsForIdMandRetenu.add(j.getIdPieceJournal());
		}
		responseDto.setIdPieceJournalsForIdMandRetenu(idPieceJournalsForIdMandRetenu);
		
		List<String> idJustifs = new ArrayList<>();
		List<Justificatif> justificatifs = entity.getJustificatifs();
		for (Justificatif justificatif: justificatifs) {
			idJustifs.add(justificatif.getIdJustif());
		}
		responseDto.setIdJustifs(idJustifs);
		
		List<MandatPecId> mandatPecIds = new ArrayList<>();
		List<MandatPec> mandatPecs = entity.getMandatPecs();
		for (MandatPec mandatPec: mandatPecs) {
			mandatPecIds.add(mandatPec.getId());
		}
		responseDto.setMandatPecIds(mandatPecIds);
		
		List<BordMandId> bordMandIds = new ArrayList<>();
		List<BordMand> bordMands = entity.getBordMands();
		for (BordMand bordMand: bordMands) {
			bordMandIds.add(bordMand.getId());
		}
		responseDto.setIdRetenuTitreRecouvs(idRetenuTitreRecouvs);
		
		List<String> idRetenus = new ArrayList<>();
		List<Retenus> retenus = entity.getRetenus();
		for (Retenus retenu: retenus) {
			idRetenus.add(retenu.getIdRetenu());
		}
		responseDto.setIdRetenus(idRetenus);
		
		return responseDto;
	}

	public static MotifsRejetDossierResponseDto mrdToMrjResponseDto(MotifsRejetDossier entity) {
		MotifsRejetDossierResponseDto responseDto = new MotifsRejetDossierResponseDto();
		responseDto.setIdMotif(entity.getIdMotif());
		responseDto.setMotifs(entity.getMotifs());
		responseDto.setDateSaisie(entity.getDateSaisie());
		responseDto.setNumBe(entity.getNumBe());
		responseDto.setNumMand(entity.getNumMand());
		responseDto.setCodLiq(entity.getCodLiq());
		responseDto.setIdTitre(entity.getIdTitre());
		responseDto.setUserName(entity.getUserName());
		responseDto.setDateEnreg(entity.getDateEnreg());
		responseDto.setActif(entity.isActif());
		
		List<Long> codBords = new ArrayList<>();
		List<BordTransmis> bordTransmis = entity.getBordTransmis();
		for (BordTransmis bordTransmis2: bordTransmis) {
			codBords.add(bordTransmis2.getCodBord());
		}
		responseDto.setCodBords(codBords);
		
		return responseDto;
	}

	public static LiquidationResponseDto liqToLiqResponseDto(Liquidation entity) {
		LiquidationResponseDto responseDto = new LiquidationResponseDto();
		responseDto.setCodLiq(entity.getCodLiq());
		responseDto.setGestion(entity.getGestion());
		responseDto.setNumBl(entity.getNumBl());
		responseDto.setDateLiq(entity.getDateLiq());
		responseDto.setObjet(entity.getObjet());
		responseDto.setMontant(entity.getMontant());
		responseDto.setMontEngage(entity.getMontEngage());
		responseDto.setMontDjaLiq(entity.getMontDjaLiq());
		responseDto.setModifiable(entity.isModifiable());
		responseDto.setIdUser(entity.getIdUser());
		responseDto.setNumeroDemande(entity.getNumeroDemande());
		responseDto.setDateModif(entity.getDateModif());
		responseDto.setActif(entity.isActif());
		responseDto.setIdBudget(entity.getIdBudget());
		if (entity.getCompteDestinataire() != null) responseDto.setCompteFourn(entity.getCompteDestinataire().getId());
		if (entity.getContrats() != null) responseDto.setIdContrat(entity.getContrats().getIdContrat());
		if (entity.getEngagements() != null) responseDto.setNumBe(entity.getEngagements().getNumBe());
		responseDto.setIdFourn(entity.getDestinataires().getIdDest());
		
		return responseDto;
	}

	public static CodEntiteContractResponseDto codEntiteContractToCodEntiteContractResponseDto(CodEntiteContract entity) {
		CodEntiteContractResponseDto responseDto = new CodEntiteContractResponseDto();
		responseDto.setCod2(entity.getCod2());
		responseDto.setIntitule(entity.getIntitule());
		
		return responseDto;
	}

	public static CodNatContratResponseDto codNatContratToCodNatContratResponseDto(CodNatContrat entity) {
		CodNatContratResponseDto responseDto = new CodNatContratResponseDto();
		responseDto.setCod3(entity.getCod3());
		responseDto.setIntitule(entity.getIntitule());
		
		return responseDto;
	}
	
	public static TypeMarcheResponseDto typeMarcheDtoToTypeMarcheResponseDto(TypeMarche entity) {
		TypeMarcheResponseDto responseDto = new TypeMarcheResponseDto();
		responseDto.setCodTypeMarche(entity.getCodTypeMarche());
		responseDto.setIntitule(entity.getIntitule());
		
		return responseDto;
	}
	
	public static IdentiteExecutionResponseDto identiteExecutionToIdentiteExecutionResponseDto(IdentiteExecution entity) {
		IdentiteExecutionResponseDto responseDto = new IdentiteExecutionResponseDto();
		responseDto.setCodIdentiteExecution(entity.getCodIdentiteExecution());
		responseDto.setIntitule(entity.getIntitule());
		
		return responseDto;
	}
	
	public static PpmExecBudgViewDto ppmExecBudgViewToPpmExecBudgViewDto(PpmExecBudgView entity) {
		PpmExecBudgViewDto responseDto = new PpmExecBudgViewDto();
		responseDto.setIdPpmExe(entity.getId().getIdPpmExe());
	    responseDto.setIdLot(entity.getId().getIdLot());
	    responseDto.setIdBudget(entity.getId().getIdBudget());
	    responseDto.setExercice(entity.getId().getExercice());
	    responseDto.setCodBud(entity.getId().getCodBud());
	    responseDto.setIdSrceFin(entity.getId().getIdSrceFin());
	    responseDto.setMontantEstime(entity.getMontantEstime()); 
	    responseDto.setAvecTva(entity.isAvecTva());
		responseDto.setAvecMiniMax(entity.isAvecMiniMax());
	    responseDto.setNbLot(entity.getNbLot());
		responseDto.setNum(entity.getNum());
		responseDto.setMontantEstimePpmExec(entity.getMontantEstimePpmExec());
		responseDto.setMontDepEngNonLiq(entity.getMontDepEngNonLiq());
		responseDto.setCreditDispo(entity.getCreditDispo());
		responseDto.setNatPrestation(entity.getNatPrestation());
		responseDto.setObjetLot(entity.getObjetLot());
		responseDto.setDateCreat(entity.getDateCreat());
		responseDto.setDateLanceEffect(entity.getDateLanceEffect());
		responseDto.setDateButoire(entity.getDateButoire());
		responseDto.setExecution(entity.isExecution());
		responseDto.setIdFourn(entity.getIdFourn()); 
		responseDto.setMontantAttrib(entity.getMontantAttrib());
		responseDto.setMontantTtc(entity.getMontantTtc());
		responseDto.setMontantHtva(entity.getMontantHtva());
		responseDto.setMontantMaxTtc(entity.getMontantMaxTtc());
		responseDto.setMontantMaxHtva(entity.getMontantMaxHtva());
		responseDto.setMontantMinTtc(entity.getMontantMinTtc());
		responseDto.setMontantMinHtva(entity.getMontantMinTtc());
		responseDto.setAbrevMp(entity.getAbrevMp());
		responseDto.setDateNotificationProvisoire(entity.getDateNotificationProvisoire());
		responseDto.setDateApprobContrat(entity.getDateApprobContrat());
		responseDto.setNiveauMiseEnOeuvreEtObservation(entity.getNiveauMiseEnOeuvreEtObservation());
		responseDto.setDateReception(entity.getDateReception());
		responseDto.setDateLancementMarchePrevisionnel(entity.getDateLancementMarchePrevisionnel());
		responseDto.setNbJoursRetardLancement(entity.getNbJoursRetardLancement());
		responseDto.setIdPpm(entity.getIdPpm());
		responseDto.setIfumle(entity.getIfumle());
		responseDto.setNom(entity.getNom());
		responseDto.setIdPlan(entity.getIdPlan());
		responseDto.setIntituleBudget(entity.getIntituleBudget());
		responseDto.setIntituleCourtCodSourceFin(entity.getIntituleCourtCodSourceFin());
		responseDto.setAbrevCodSourceFin(entity.getAbrevCodSourceFin());
		responseDto.setIntituleLongCodSourceFin(entity.getIntituleLongCodSourceFin());
		responseDto.setLibelleLongMp(entity.getLibelleLongMp());
		responseDto.setCod4(entity.getCod4());
		
	    return responseDto;
	}
	
	////aristide
public static PpmExecResponseDto PpmExecToPpmExecResponseDto (PpmExec entity) {
		
		PpmExecResponseDto responseDto = new PpmExecResponseDto();
		responseDto.setIdPpmExec(entity.getId().getIdPpmExec());
		responseDto.setIdLot(entity.getId().getIdLot());
		responseDto.setIdBudget(entity.getId().getIdBudget());
		responseDto.setExercice(entity.getId().getExercice());
		responseDto.setNbLot(entity.getNbLot());
		responseDto.setNum(entity.getNum());
		responseDto.setMontantEstime(entity.getMontantEstime());
		responseDto.setMontDepEngNonLiq(entity.getMontDepEngNonLiq());
		responseDto.setCreditDispo(entity.getCreditDispo());
		responseDto.setNatPrestation(entity.getNatPrestation());
		responseDto.setDateCreation(entity.getDateCreation());
		responseDto.setDateButoire(entity.getDateButoire());
		responseDto.setExecution(entity.isExecution());
		responseDto.setMontantTtc(entity.getMontantTtc());
		responseDto.setMontantHtva(entity.getMontantHtva());
		responseDto.setMontantMaxTtc(entity.getMontantMaxTtc());
		responseDto.setMontantMaxHtva(entity.getMontantMaxHtva());
		responseDto.setMontantMinTtc(entity.getMontantMinTtc());
		responseDto.setMontantMinHtva(entity.getMontantMinHtva());
		if (entity.getPpmModePass() != null) responseDto.setAbrevMp(entity.getPpmModePass().getAbrevMp());
		responseDto.setIdPpm(entity.getPpm().getIdPpm());
	    
		responseDto.setObjetLot(entity.getObjetLot());
		responseDto.setIdFourn(entity.getIdFourm()); 
		responseDto.setMontantAttrib(entity.getMontantAttrib());
		responseDto.setDateNotificationProvisoire(entity.getDateNotificationProvisoire());
		responseDto.setDateApprobContrat(entity.getDateApprobContrat());
		responseDto.setDateRemiseEtOuvertureDesPlis(entity.getDateRemiseEtOuvertureDesPlis());
		responseDto.setNiveauMiseEnOeuvreEtObservation(entity.getNiveauMiseEnOeuvreEtObservation());
		responseDto.setDateReception(entity.getDateReception());
		responseDto.setDateLancementMarchePrevisionnel(entity.getDateLancementMarchePrevisionnel());
		responseDto.setDateLanceEffect(entity.getDateLanceEffect());
		responseDto.setNbJoursRetardLancement(entity.getNbJoursRetardLancement());
		return responseDto;
	}
	
	public static PpmExecBudgResponseDto PpmExecBudgToPpmExecBudgResponseDto (PpmExecBudg entity) {
	    
	    PpmExecBudgResponseDto responseDto = new PpmExecBudgResponseDto();
	    
	    responseDto.setIdPpmExe(entity.getId().getIdPpmExe());
	    responseDto.setIdLot(entity.getId().getIdLot());
	    responseDto.setIdBudget(entity.getId().getIdBudget());
	    responseDto.setExercice(entity.getId().getExercice());
	    responseDto.setCodBud(entity.getId().getCodBud());
	    responseDto.setIdSrceFin(entity.getId().getIdSrceFin());
	    
	    responseDto.setMontantEstime(entity.getMontantEstime()); 
	    
	    responseDto.setMontantMaxHtva(entity.getMontantMaxHtva());
	    responseDto.setMontantMinHtva(responseDto.getMontantMinHtva());
	    responseDto.setMontantMaxTtc(entity.getMontantMaxTtc());
	    responseDto.setMontantMinTtc(entity.getMontantMinTtc());
	    responseDto.setAvecTva(entity.isAvecTva());
	    responseDto.setAvecMiniMax(entity.isAvecMiniMax());
	    return responseDto;
	}

}