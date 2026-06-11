package com.sigep.gbc.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class RetenueCategorieResponseDto {
	private String idCategorie;
	private String libelle;
	private List<Integer> idTypRetenus;
}
