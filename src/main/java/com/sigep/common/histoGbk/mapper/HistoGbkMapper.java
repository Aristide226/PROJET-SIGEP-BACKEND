package com.sigep.common.histoGbk.mapper;

import com.sigep.common.histoGbk.dto.responseDto.EnteteResponseDto;
import com.sigep.common.histoGbk.entity.Entete;

public class HistoGbkMapper {
	
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
}
