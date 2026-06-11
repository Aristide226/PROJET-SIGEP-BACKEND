package com.sigep.gbc.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class TypeDecisionResponseDto {
	private Integer idType;
	private String libelle;
	private List<Integer> rangVisas;
}
