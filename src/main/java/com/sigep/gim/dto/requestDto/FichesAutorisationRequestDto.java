package com.sigep.gim.dto.requestDto;

import lombok.Data;

@Data
public class FichesAutorisationRequestDto {
	private Long idFiche;
	private String objetDepense;
	private long montantHtva;
	private boolean avecTva;
	private long montantTtc;
}
