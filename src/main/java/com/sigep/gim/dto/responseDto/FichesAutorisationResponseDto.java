package com.sigep.gim.dto.responseDto;

import lombok.Data;

@Data
public class FichesAutorisationResponseDto {
	private Long idFiche;
	private String objetDepense;
	private long montantHtva;
	private boolean avecTva;
	private long montantTtc;
	private long montantAutori;
}
