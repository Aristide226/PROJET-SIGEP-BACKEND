package com.sigep.common.histoGbk.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sigep.common.histoGbk.entity.EnteteStructure;


@Repository
public interface HistoGbkEnteteStructureRepository extends JpaRepository<EnteteStructure, String>{
	
	@Modifying
	@Query(value = """ 
			UPDATE EnteteStructureS SET
			AbrevEpe = :newAbrevEpe,
			Section = :Section,
			EPE = :EPE,
			Lieu = :Lieu,
			logo = :logo,
			SignataireDG = :SignataireDG,
			NomSignataireDG = :NomSignataireDG,
			TitreHonorifiqueDG = :TitreHonorifiqueDG,
			SignataireDAF = :SignataireDAF,
			NomSignataireDAF = :NomSignataireDAF,
			TitreHonorifiqueDAF = :TitreHonorifiqueDAF,
			SignataireCF = :SignataireCF,
			NomSignataireCF = :NomSignataireCF,
			TitreHonorifiqueCF = :TitreHonorifiqueCF,
			SignataireAC = :SignataireAC,
			NomSignataireAC = :NomSignataireAC,
			TitreHonorifiqueAC = :TitreHonorifiqueAC,
			CFResident = :CFResident,
			SignatPenal = :SignatPenal,
			Adresse = :Adresse,
			Telephone = :Telephone,
			Fax = :Fax,
			Email = :Email,
			visa = :visa,
			ArticleStruct = :ArticleStruct,
			NomPays = :NomPays,
			DevisePays = :DevisePays,
			mleCNSS = :mleCNSS,
			mleCARFO = :mleCARFO,
			TypeSupport = :TypeSupport,
			AvecReception = :AvecReception,
			QuitFiligrane = :QuitFiligrane,
			TauxTVA = :TauxTVA,
			TypeAmmortDefaut = :TypeAmmortDefaut,
			GBC = :GBC,
			GIM = :GIM,
			GRH = :GRH,
			SectionNum = :SectionNum,
			FilgraneL27_6cmH18_5cm = :FilgraneL27_6cmH18_5cm,
			SignataireDRH = :SignataireDRH,
			NomSignataireDRH = :NomSignataireDRH,
			TitreHonorifiqueDRH = :TitreHonorifiqueDRH,
			idCircuitGRH = :idCircuitGRH,
			DRHSigneEtat = :DRHSigneEtat,
			LibAnnee = :LibAnnee,
			MandNumApresVisaCf = :MandNumApresVisaCf
			WHERE AbrevEpe = :oldAbrevEpe
			""", nativeQuery = true)
	void update(
			@Param("newAbrevEpe") String newAbrevEpe,
			@Param("oldAbrevEpe") String oldAbrevEpe,
			@Param("Section") String Section,
			@Param("EPE") String EPE,
			@Param("Lieu") String Lieu,
			@Param("logo") byte[] logo,
			@Param("SignataireDG") String SignataireDG,
			@Param("NomSignataireDG") String NomSignataireDG,
			@Param("TitreHonorifiqueDG") String TitreHonorifiqueDG,
			@Param("SignataireDAF") String SignataireDAF,
			@Param("NomSignataireDAF") String NomSignataireDAF,
			@Param("TitreHonorifiqueDAF") String TitreHonorifiqueDAF,
			@Param("SignataireCF") String SignataireCF,
			@Param("NomSignataireCF") String NomSignataireCF,
			@Param("TitreHonorifiqueCF") String TitreHonorifiqueCF,
			@Param("SignataireAC") String SignataireAC,
			@Param("NomSignataireAC") String NomSignataireAC,
			@Param("TitreHonorifiqueAC") String TitreHonorifiqueAC,
			@Param("CFResident") Boolean CFResident,
			@Param("SignatPenal") Boolean SignatPenal,
			@Param("Adresse") String Adresse,
			@Param("Telephone") String Telephone,
			@Param("Fax") String Fax,
			@Param("Email") String Email,
			@Param("visa") String visa,
			@Param("ArticleStruct") String ArticleStruct,
			@Param("NomPays") String NomPays,
			@Param("DevisePays") String DevisePays,
			@Param("mleCNSS") String mleCNSS,
			@Param("mleCARFO") String mleCARFO,
			@Param("TypeSupport") Integer TypeSupport,
			@Param("AvecReception") Boolean AvecReception,
			@Param("QuitFiligrane") byte[] QuitFiligrane,
			@Param("TauxTVA") BigDecimal TauxTVA,
			@Param("TypeAmmortDefaut") char TypeAmmortDefaut,
			@Param("GBC") Boolean GBC,
			@Param("GIM") Boolean GIM,
			@Param("GRH") Boolean GRH,
			@Param("SectionNum") String SectionNum,
			@Param("FilgraneL27_6cmH18_5cm") byte[] FilgraneL27_6cmH18_5cm,
			@Param("SignataireDRH") String SignataireDRH,
			@Param("NomSignataireDRH") String NomSignataireDRH,
			@Param("TitreHonorifiqueDRH") String TitreHonorifiqueDRH,
			@Param("idCircuitGRH") int idCircuitGRH,
			@Param("DRHSigneEtat") Boolean DRHSigneEtat,
			@Param("LibAnnee") String LibAnnee,
			@Param("MandNumApresVisaCf") Integer MandNumApresVisaCf
		);
}
