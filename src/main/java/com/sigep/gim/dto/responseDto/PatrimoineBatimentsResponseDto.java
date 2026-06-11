package com.sigep.gim.dto.responseDto;

import lombok.Data;

@Data
public class PatrimoineBatimentsResponseDto {
	private String mle;
	private Integer nbrePiece;
	private Boolean installTelephone;
	private Boolean aniveau;
	private Integer nbNiveau;
	private Integer codMatereiaux;
	private Integer codeUsage;
	private Integer codeEauCourant;
	private Integer codeElectricite;
}
