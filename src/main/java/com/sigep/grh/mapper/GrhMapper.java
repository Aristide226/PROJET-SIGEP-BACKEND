package com.sigep.grh.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sigep.grh.dto.AccesCodeDto;
import com.sigep.grh.dto.responseDto.AccesCodeNiveauResponseDto;
import com.sigep.grh.dto.responseDto.GrpeCodeResponseDto;
import com.sigep.grh.entity.AccesCode;
import com.sigep.grh.entity.AccesCodeNiveau;
import com.sigep.grh.entity.GrpeCode;
import com.sigep.grh.model.Grpe;

public class GrhMapper {
	
	public static AccesCodeDto acToAcDto(AccesCode accesCode) {
		AccesCodeDto accesCodeDto = new AccesCodeDto();
		accesCodeDto.setUserName(accesCode.getUserName());
		accesCodeDto.setMotPasse(accesCode.getMotPasse());
		accesCodeDto.setMotDePasse(accesCode.getMotDePasse());
		accesCodeDto.setStatu(accesCode.getStatu());
		accesCodeDto.setDateChangement(accesCode.getDateChangement());
		accesCodeDto.setNbreDeFois(accesCode.getNbreDeFois());
		accesCodeDto.setRangCod(accesCode.getRangCod());
		//if (accesCode.getAgents() != null) accesCodeDto.setMle(accesCode.getAgents().getMle());
		accesCodeDto.setMle(accesCode.getMle());
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
		
		return responseDto;
	}

	public static GrpeCodeResponseDto gcToGcResponse(GrpeCode entity) {
		GrpeCodeResponseDto responseDto = new GrpeCodeResponseDto();
		responseDto.setGrpe(entity.getGrpe());
		responseDto.setLibelleGrpe(entity.getLibelleGrpe());
		
		return responseDto;
	}
}
