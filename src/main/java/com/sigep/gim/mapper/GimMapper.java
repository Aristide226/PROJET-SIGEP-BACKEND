package com.sigep.gim.mapper;

import com.sigep.gim.dto.CodeAccesDto;
import com.sigep.gim.dto.responseDto.AgentsResponseDto;
import com.sigep.gim.dto.responseDto.AmorCoefficientsResponseDto;
import com.sigep.gim.dto.responseDto.BatimentMateriauxConstructCaractResponseDto;
import com.sigep.gim.dto.responseDto.CodeAccesHistoResponseDto;
import com.sigep.gim.dto.responseDto.CodeBudgTypeResponseDto;
import com.sigep.gim.dto.responseDto.CodeBudgetaireResponseDto;
import com.sigep.gim.dto.responseDto.CodeMaterielResponseDto;
import com.sigep.gim.dto.responseDto.DepartementResponseDto;
import com.sigep.gim.dto.responseDto.FicheSourceFinResponseDto;
import com.sigep.gim.dto.responseDto.FichesResponseDto;
import com.sigep.gim.dto.responseDto.FournisseursResponseDto;
import com.sigep.gim.dto.responseDto.HistoEtatResponseDto;
import com.sigep.gim.dto.responseDto.InventaireResponseDto;
import com.sigep.gim.dto.responseDto.LivreJournalResponseDto;
import com.sigep.gim.dto.responseDto.PatrimoineBatimentsResponseDto;
import com.sigep.gim.dto.responseDto.PatrimoineMaterielsResponseDto;
import com.sigep.gim.dto.responseDto.PatrimoineResponseDto;
import com.sigep.gim.dto.responseDto.PatrimoineSortieResponseDto;
import com.sigep.gim.dto.responseDto.PiecesFicheResponseDto;
import com.sigep.gim.dto.responseDto.ProvinceResponseDto;
import com.sigep.gim.dto.responseDto.RegionResponseDto;
import com.sigep.gim.dto.responseDto.SitesResponseDto;
import com.sigep.gim.dto.responseDto.TableRapportResponseDto;
import com.sigep.gim.entity.Agents;
import com.sigep.gim.entity.AmorCoefficients;
import com.sigep.gim.entity.BatimentMateriauxConstructCaract;
import com.sigep.gim.entity.CodeAcces;
import com.sigep.gim.entity.CodeAccesHisto;
import com.sigep.gim.entity.CodeBudgType;
import com.sigep.gim.entity.CodeBudgetaire;
import com.sigep.gim.entity.CodeMateriel;
import com.sigep.gim.entity.Departement;
import com.sigep.gim.entity.FicheSourceFin;
import com.sigep.gim.entity.Fiches;
import com.sigep.gim.entity.Fournisseurs;
import com.sigep.gim.entity.HistoEtat;
import com.sigep.gim.entity.Inventaire;
import com.sigep.gim.entity.LivreJournal;
import com.sigep.gim.entity.Patrimoine;
import com.sigep.gim.entity.PatrimoineBatiments;
import com.sigep.gim.entity.PatrimoineMateriels;
import com.sigep.gim.entity.PatrimoineSortie;
import com.sigep.gim.entity.PiecesFiche;
import com.sigep.gim.entity.Province;
import com.sigep.gim.entity.Region;
import com.sigep.gim.entity.Sites;
import com.sigep.gim.entity.TableRapport;

public class GimMapper {
	
	public static AgentsResponseDto AgentsToAgentsResponseDto(Agents entity) {
		AgentsResponseDto responseDto = new AgentsResponseDto();
		responseDto.setMleAgent(entity.getMleAgent());
		responseDto.setNom(entity.getNom());
		responseDto.setPrenom(entity.getPrenom());
		responseDto.setSexe(entity.getSexe());
		responseDto.setFonctActuelle(entity.getFonctActuelle());
		responseDto.setTitreHono(entity.getTitreHono());
		responseDto.setCodDirect(entity.getDirections().getCodDirect());
		return responseDto;
	}
	
	public static CodeAccesDto codeAccesDtoToCodeAccesDto(CodeAcces entity) {
		CodeAccesDto responseDto = new CodeAccesDto();
		responseDto.setIdUser(entity.getIdUser());
		responseDto.setUserName(entity.getUserName());
		responseDto.setMotDePasse(entity.getMotDePasse());
		responseDto.setEtat(entity.isEtat());
		responseDto.setNbreConnect(entity.getNbreConnect());
		responseDto.setDateChangement(entity.getDateChangement());
		responseDto.setMleAgent(entity.getAgents().getMleAgent());
		responseDto.setIdCodeAccessType(entity.getCodeAccesType().getIdCodeAccessType());
		return responseDto;
	}
	
	public static FournisseursResponseDto FournisseursToFournisseursResponseDto(Fournisseurs entity) {
		FournisseursResponseDto responseDto = new FournisseursResponseDto();
		responseDto.setIdFourn(entity.getIdFourn());
		responseDto.setFournisseur(entity.getFournisseur());
		responseDto.setNumIfu(entity.getNumIfu());
		responseDto.setTelFourn(entity.getTelFourn());
		responseDto.setBpfourn(entity.getBpfourn());
		responseDto.setTypF(entity.getFournisseurType().getTypF());
		return responseDto;
	}
	
	public static FichesResponseDto FichesToFichesResponseDto(Fiches entity) {
		FichesResponseDto responseDto = new FichesResponseDto();
		if (entity == null) {
	        return null;
	    }
	    responseDto.setIdFiche(entity.getIdFiche());
	    responseDto.setNumFiche(entity.getNumFiche());
	    responseDto.setDateSaisie(entity.getDateSaisie());
	    responseDto.setDateEtat(entity.getDateEtat());
	    responseDto.setMontantFiche(entity.getMontantFiche());
	    responseDto.setIdTypeAcq(entity.getIdTypeAcq());
	    responseDto.setCodSourceFin(entity.getCodSourceFin());
	    responseDto.setAffect(entity.getAffect());
	    responseDto.setIdMagasin(entity.getIdMagasin());
	    responseDto.setCodDirect(entity.getCodDirect());
	    responseDto.setIdService(entity.getIdService());
	    responseDto.setCodProv(entity.getCodProv());
	    responseDto.setMleAgent(entity.getMleAgent());
	    responseDto.setDateAffect(entity.getDateAffect());
	    responseDto.setCodDirectOrigi(entity.getCodDirectOrigi());
	    responseDto.setIdServiceOrigi(entity.getIdServiceOrigi());
	    responseDto.setCodProvOrigi(entity.getCodProvOrigi());
	    responseDto.setCodeSite(entity.getCodeSite());
	    responseDto.setComplementMle(entity.getComplementMle());
	    responseDto.setDateRetourPossible(entity.getDateRetourPossible());
	    responseDto.setDateRetourEffective(entity.getDateRetourEffective());
	    responseDto.setTypSortie(entity.getTypSortie());
	    responseDto.setIdFicheH(entity.getIdFicheH());
	    responseDto.setIdSourceFin(entity.getIdSourceFin());
	    responseDto.setIdBudget(entity.getIdBudget());
	    responseDto.setFonctSigna1(entity.getFonctSigna1());
	    responseDto.setPrenomNomSigna1(entity.getPrenomNomSigna1());
	    responseDto.setTitreHonoSigna1(entity.getTitreHonoSigna1());
	    responseDto.setFonctSigna2(entity.getFonctSigna2());
	    responseDto.setPrenomNomSigna2(entity.getPrenomNomSigna2());
	    responseDto.setTitreHonoSigna2(entity.getTitreHonoSigna2());
	    responseDto.setFonctSigna3(entity.getFonctSigna3());
	    responseDto.setPrenomNomSigna3(entity.getPrenomNomSigna3());
	    responseDto.setTitreHonoSigna3(entity.getTitreHonoSigna3());
	    responseDto.setNumBe(entity.getNumBe());
	    responseDto.setBenum(entity.getBenum());
	    responseDto.setNbBiens(entity.getNbBiens());
	    responseDto.setNumeroFiche(entity.getNumeroFiche());
	    responseDto.setDateEntreSortie(entity.getDateEntreSortie());
	    responseDto.setBienEnMagasin(entity.isBienEnMagasin());
	    responseDto.setCodCategorie(entity.getCategorieBien() == null ? null : entity.getCategorieBien().getCodCategorie());
	    responseDto.setEtat(entity.getEtatFiche() == null ? null : entity.getEtatFiche().getEtat());        
	    responseDto.setIdFourn(entity.getFournisseurs() == null ? null : entity.getFournisseurs().getIdFourn());      
	    responseDto.setIdTypFiche(entity.getTypFiche() == null ? null : entity.getTypFiche().getIdTypFiche());            
		
	    return responseDto;
	}
	
	public static AmorCoefficientsResponseDto AmorCoefficientsToAmorCoefficientsResponseDto(AmorCoefficients entity) {
		AmorCoefficientsResponseDto responseDto = new AmorCoefficientsResponseDto();
		responseDto.setAmorType(entity.getId().getAmorType());
		responseDto.setDureeMin(entity.getId().getDureeMin());
		responseDto.setDureeMax(entity.getDureeMax());
		responseDto.setCoefficient(entity.getCoefficient());
		return responseDto;
	}
	
	public static BatimentMateriauxConstructCaractResponseDto BatimentMateriauxConstructCaractToBatimentMateriauxConstructCaractResponseDto(BatimentMateriauxConstructCaract entity) {
		BatimentMateriauxConstructCaractResponseDto responseDto = new BatimentMateriauxConstructCaractResponseDto();
		responseDto.setCodMateriauxCaract(entity.getCodMateriauxCaract());
		responseDto.setLibelleMateriauxCaract(responseDto.getLibelleMateriauxCaract());
		responseDto.setCodMatereiaux(entity.getBatimentMateriauxConstrut().getCodMatereiaux());
		return responseDto;
	}
	
	public static CodeAccesHistoResponseDto CodeAccesHistoToCodeAccesHistoResponseDto(CodeAccesHisto entity) {
		CodeAccesHistoResponseDto responseDto = new CodeAccesHistoResponseDto();
		responseDto.setId(entity.getId().getId());
		responseDto.setDateChangement(entity.getId().getDateChangement());
		responseDto.setMotPasse(entity.getMotPasse());
		return responseDto;
	}
	
	public static CodeBudgTypeResponseDto CodeBudgTypeToCodeBudgTypeResponseDto(CodeBudgType entity) {
		CodeBudgTypeResponseDto responseDto = new CodeBudgTypeResponseDto();
		responseDto.setCodTyp(entity.getCodTyp());
		responseDto.setIntituleTyp(entity.getIntituleTyp());
		responseDto.setCodTypActif(entity.getCodTypActif());
		responseDto.setCodCategorie(entity.getCategorieBien().getCodCategorie());
		return responseDto;
	}
	
	public static CodeBudgetaireResponseDto CodeBudgetaireToCodeBudgetaireResponseDto(CodeBudgetaire entity) {
		CodeBudgetaireResponseDto responseDto = new CodeBudgetaireResponseDto();
		responseDto.setCodBud(entity.getCodBud());
		responseDto.setIntituleCodBud(entity.getIntituleCodBud());
		responseDto.setCodBudActif(entity.isCodBudActif());
		responseDto.setCodTyp(entity.getCodeBudgType().getCodTyp());
		return responseDto;
	}
	
	public static CodeMaterielResponseDto CodeMaterielToCodeMaterielResponseDto(CodeMateriel entity) {
		CodeMaterielResponseDto responseDto = new CodeMaterielResponseDto();
		responseDto.setCodMat(entity.getCodMat());
		responseDto.setNum(entity.getNum());
		responseDto.setIntituleMateriel(entity.getIntituleMateriel());
		responseDto.setDureeVieAn(entity.getDureeVieAn());
		responseDto.setTauxAmortAn(entity.getTauxAmortAn());
		responseDto.setCodBud(entity.getCodeBudgetaire().getCodBud());
		return responseDto;
	}
	
	public static DepartementResponseDto DepartementToDepartementResponseDto(Departement entity) {
		DepartementResponseDto responseDto = new DepartementResponseDto();
		responseDto.setCodDepart(entity.getCodDepart());
		responseDto.setDepartema(entity.getDepartema());
		responseDto.setChefLieuDepart(entity.getChefLieuDepart());
		responseDto.setCodProv(entity.getProvince().getCodProv());
		return responseDto;
	}
	
	public static ProvinceResponseDto ProvinceToProvinceResponseDto(Province entity) {
		ProvinceResponseDto responseDto = new ProvinceResponseDto();
		responseDto.setCodProv(entity.getCodProv());
		responseDto.setProvinc(entity.getProvinc());
		responseDto.setChefLieu(entity.getChefLieu());
		responseDto.setArticleProv(entity.getArticleProv());
		responseDto.setCodReg(entity.getRegion().getCodReg());
		return responseDto;
	}
	
	public static RegionResponseDto RegionToRegionResponseDto(Region entity) {
		RegionResponseDto responseDto = new RegionResponseDto();
		responseDto.setCodReg(entity.getCodReg());
		responseDto.setRgion(entity.getRgion());
		responseDto.setChefLieu(entity.getChefLieu());
		responseDto.setArticleRegion(entity.getArticleRegion());
		return responseDto;
	}
	
	public static FicheSourceFinResponseDto FicheSourceFinToFicheSourceFinResponseDto(FicheSourceFin entity) {
		FicheSourceFinResponseDto responseDto = new FicheSourceFinResponseDto();
		responseDto.setIdFiche(entity.getId().getIdFiche());
		responseDto.setIdSourceFin(entity.getId().getIdSourceFin());
		responseDto.setMontantSourceFin(entity.getMontantSourceFin());
		return responseDto;
	}
	
	public static HistoEtatResponseDto HistoEtatToHistoEtatResponseDto(HistoEtat entity) {
		HistoEtatResponseDto responseDto = new HistoEtatResponseDto();
		responseDto.setEtat(entity.getId().getEtat());
		responseDto.setIdFiche(entity.getId().getIdFiche());
		responseDto.setDateEtat(entity.getId().getDateEtat());
		return responseDto;
	}
	
	public static InventaireResponseDto InventaireToInventaireResponseDto(Inventaire entity) {
		InventaireResponseDto responseDto = new InventaireResponseDto();
		responseDto.setIdInvent(entity.getIdInvent());
		responseDto.setDateInvent(entity.getDateInvent());
		responseDto.setDateEtat(entity.getDateEtat());
		responseDto.setEnStock(entity.isEnStock());
		responseDto.setEtat(entity.getEtatFiche().getEtat());
		responseDto.setIdTypeInvent(entity.getInventaireType().getIdTypeInvent());
		return responseDto;
	}
	
	public static LivreJournalResponseDto LivreJournalToLivreJournalResponseDto(LivreJournal entity) {
		LivreJournalResponseDto responseDto = new LivreJournalResponseDto();
		responseDto.setIdJournal(entity.getIdJournal());
		responseDto.setDateValide(entity.getDateValide());
		responseDto.setEntree(entity.isEntree());
		responseDto.setIdFiche(entity.getFiches().getIdFiche());
		return responseDto;
	}
	
	public static PatrimoineBatimentsResponseDto PatrimoineBatimentsToPatrimoineBatimentsResponseDto(PatrimoineBatiments entity) {
		PatrimoineBatimentsResponseDto responseDto = new PatrimoineBatimentsResponseDto();
		responseDto.setMle(entity.getMle());
		responseDto.setNbrePiece(entity.getNbrePiece());
		responseDto.setInstallTelephone(entity.getInstallTelephone());
		responseDto.setAniveau(entity.getAniveau());
		responseDto.setNbNiveau(entity.getNbNiveau());
		responseDto.setCodMatereiaux(entity.getBatimentMateriauxConstrut().getCodMatereiaux());
		responseDto.setCodeUsage(entity.getBatimentUsages().getCodeUsage());
		responseDto.setCodeEauCourant(entity.getElementEauCourante().getCodeEauCourant());
		responseDto.setCodeElectricite(entity.getElementElectricite().getCodeElectricite());
		return responseDto;
	}
	
	public static PatrimoineMaterielsResponseDto PatrimoineMaterielsToPatrimoineMaterielsResponseDto(PatrimoineMateriels entity) {
		PatrimoineMaterielsResponseDto responseDto = new PatrimoineMaterielsResponseDto();
		responseDto.setMle(entity.getMle());
		responseDto.setMarqRace(entity.getMarqRace());
		responseDto.setImmatriculation(entity.getImmatriculation());
		responseDto.setIdMagasin(entity.getIdMagasin());
		responseDto.setFormat(entity.getFormat());
		return responseDto;
	}
	
	public static PatrimoineSortieResponseDto PatrimoineSortieToPatrimoineSortieResponseDto(PatrimoineSortie entity) {
		PatrimoineSortieResponseDto responseDto = new PatrimoineSortieResponseDto();
		if (entity == null) {
	        return null;
	    }
	    if (entity.getId() != null) {
	        responseDto.setIdFiche(entity.getId().getIdFiche());
	        responseDto.setMle(entity.getId().getMle());
	    }
	    responseDto.setValeurAffectation(entity.getValeurAffectation());
	    responseDto.setObserv(entity.getObserv());
	    responseDto.setTemporaire(entity.getTemporaire());
	    responseDto.setDateRetourPossible(entity.getDateRetourPossible());
	    responseDto.setDateRetourEffective(entity.getDateRetourEffective());
	    responseDto.setEtatRetour(entity.getEtatRetour());
	    responseDto.setObservRetour(entity.getObservRetour());
	    responseDto.setIdFicheH(entity.getIdFicheH());
	    responseDto.setStatPatriH(entity.getStatPatriH());
	    responseDto.setMleAffectH(entity.getMleAffectH());
	    responseDto.setIdMagasinH(entity.getIdMagasinH());
	    responseDto.setCodeSite(entity.getCodeSite());
	    responseDto.setCodDirectH(entity.getCodDirectH());
	    responseDto.setCodServiceH(entity.getCodServiceH());
	    responseDto.setCodProvH(entity.getCodProvH());
	    responseDto.setEtatActuelH(entity.getEtatActuelH());
	    responseDto.setIdInventH(entity.getIdInventH());
	    responseDto.setIdFicheRetour(entity.getIdFicheRetour());
	    responseDto.setEtatB(entity.getEtatBien() == null ? null : entity.getEtatBien().getEtatB());
		return responseDto;
	}
	
	public static PiecesFicheResponseDto PiecesFicheToPiecesFicheResponseDto(PiecesFiche entity) {
		PiecesFicheResponseDto responseDto = new PiecesFicheResponseDto();
		responseDto.setIdPieceFiche(entity.getIdPieceFiche());
		responseDto.setRefPiece(entity.getRefPiece());
		responseDto.setDatePiece(entity.getDatePiece());
		responseDto.setIdPieces(entity.getPieces().getIdPieces());
		responseDto.setIdFiche(entity.getFiches().getIdFiche());
		return responseDto;
	}
	
	public static SitesResponseDto SitesToSitesResponseDto(Sites entity) {
		SitesResponseDto responseDto = new SitesResponseDto();
		if (entity == null) {
	        return null;
	    }
	    responseDto.setCodeSite(entity.getCodeSite());
	    responseDto.setNomSite(entity.getNomSite());
	    responseDto.setSecteurCadastre(entity.getSecteurCadastre());
	    responseDto.setSectionCadastre(entity.getSectionCadastre());
	    responseDto.setLotCadastre(entity.getLotCadastre());
	    responseDto.setParcelleCadastre(entity.getParcelleCadastre());
	    responseDto.setAutresPrecision(entity.getAutresPrecision());
	    responseDto.setDateCreation(entity.getDateCreation());
	    responseDto.setSuperficie(entity.getSuperficie());
	    responseDto.setCoutTerrain(entity.getCoutTerrain());
	    responseDto.setIdTypeAcq(entity.getIdTypeAcq());
	    responseDto.setNombreMaterielH(entity.getNombreMaterielH());
	    responseDto.setNbreBatimentH(entity.getNbreBatimentH());
	    responseDto.setNbreUe(entity.getNbreUe());
	    responseDto.setNbreAutreInfras(entity.getNbreAutreInfras());
	    responseDto.setArticleSite(entity.getArticleSite());
	    responseDto.setIdDepart(entity.getDepartement() == null ? null : entity.getDepartement().getIdDepart());
		return responseDto;
	}
	
	public static TableRapportResponseDto TableRapportToTableRapportResponseDto(TableRapport entity) {
		TableRapportResponseDto responseDto = new TableRapportResponseDto();
		 if (entity == null) {
		        return null;
		}
		responseDto.setMle(entity.getMle());
	    responseDto.setId(entity.getId());
	    responseDto.setIdFiche(entity.getIdFiche());
	    responseDto.setCodCategorie(entity.getCodCategorie());
	    responseDto.setCodStruct(entity.getCodStruct());
	    responseDto.setCodSourceFin(entity.getCodSourceFin());
	    responseDto.setCodMat(entity.getCodMat());
	    responseDto.setAnneAcq(entity.getAnneAcq());
	    responseDto.setDateEntre(entity.getDateEntre());
	    responseDto.setQuantième(entity.getQuantième());
	    responseDto.setEtatEntre(entity.getEtatEntre());
	    responseDto.setValUnit(entity.getValUnit());
	    responseDto.setDureeVie(entity.getDureeVie());
	    responseDto.setAmrtisable(entity.getAmrtisable());
	    responseDto.setAmorType(entity.getAmorType());
	    responseDto.setFormat(entity.getFormat());
	    responseDto.setStatPatri(entity.getStatPatri());
	    responseDto.setIdMagasin(entity.getIdMagasin());
	    responseDto.setIdFicheAffec(entity.getIdFicheAffec());
	    responseDto.setMleAffect(entity.getMleAffect());
	    responseDto.setCodDirect(entity.getCodDirect());
	    responseDto.setCodeDir(entity.getCodeDir());
	    responseDto.setCodService(entity.getCodService());
	    responseDto.setCodeSite(entity.getCodeSite());
	    responseDto.setCodReg(entity.getCodReg());
	    responseDto.setCodProv(entity.getCodProv());
	    responseDto.setEtatActuel(entity.getEtatActuel());
	    responseDto.setIdInvent(entity.getIdInvent());
	    responseDto.setIdFicheEntreProv(entity.getIdFicheEntreProv());
	    responseDto.setIdFicheEnCours(entity.getIdFicheEnCours());
	    responseDto.setNomAgentUtil(entity.getNomAgentUtil());
	    responseDto.setMleAgentUtil(entity.getMleAgentUtil());
	    responseDto.setMarqueType(entity.getMarqueType());
		return responseDto;
	}
	
	public static PatrimoineResponseDto PatrimoineToPatrimoineResponseDto(Patrimoine entity) {
		PatrimoineResponseDto responseDto = new PatrimoineResponseDto();
		 if (entity == null) {
			 return null;
		 }

		 responseDto.setMle(entity.getMle());
		 responseDto.setCodStruct(entity.getCodStruct());
		 responseDto.setAnneAcq(entity.getAnneAcq());
		 responseDto.setDateEntre(entity.getDateEntre());
		 responseDto.setQuantieme(entity.getQuantieme());
		 responseDto.setValUnit(entity.getValUnit());
		 responseDto.setDureeVie(entity.getDureeVie());
		 responseDto.setAmrtisable(entity.isAmrtisable());
		 responseDto.setAmorType(entity.getAmorType());
		 responseDto.setTauxAmort(entity.getTauxAmort());
		 responseDto.setFormat(entity.getFormat());
		 responseDto.setIdMagasin(entity.getIdMagasin());
		 responseDto.setMleAffect(entity.getMleAffect());
		 responseDto.setCodDirect(entity.getCodDirect());
		 responseDto.setCodeDir(entity.getCodeDir());
		 responseDto.setCodService(entity.getCodService());
		 responseDto.setCodReg(entity.getCodReg());
		 responseDto.setCodProv(entity.getCodProv());
		 responseDto.setEtatActuel(entity.getEtatActuel());
		 responseDto.setIdInvent(entity.getIdInvent());
		 responseDto.setIdFicheEntreProv(entity.getIdFicheEntreProv());
		 responseDto.setIdFicheEnCours(entity.getIdFicheEnCours());
		 responseDto.setNomAgentUtil(entity.getNomAgentUtil());
		 responseDto.setMleAgentUtil(entity.getMleAgentUtil());
		 responseDto.setValActuelle(entity.getValActuelle());
		 responseDto.setDansInventaire(entity.isDansInventaire());
		 responseDto.setCodCategorie( entity.getCategorieBien() != null ? entity.getCategorieBien().getCodCategorie() : null);
		 responseDto.setCodMat( entity.getCodeMateriel() != null ? entity.getCodeMateriel().getCodMat() : null);
		 responseDto.setEtatB( entity.getEtatBien() != null? entity.getEtatBien().getEtatB() : null);
		 responseDto.setFichesByIdFicheAffec( entity.getFichesByIdFicheAffec() != null ? entity.getFichesByIdFicheAffec().getIdFiche() : null);
		 responseDto.setFichesByIdFiche( entity.getFichesByIdFiche() != null ? entity.getFichesByIdFiche().getIdFiche(): null);
		 responseDto.setStatPatri( entity.getPatrimoineStatut() != null ? entity.getPatrimoineStatut().getStatPatri() : null);
		 responseDto.setCodeSite( entity.getSites() != null ? entity.getSites().getCodeSite() : null);
		 responseDto.setCodSourceFin( entity.getSourceFinancement() != null ? entity.getSourceFinancement().getCodSourceFin() : null);

		return responseDto;
	}
}
