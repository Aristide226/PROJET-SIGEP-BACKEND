package com.sigep.gim.dto.requestDto;

import lombok.Data;

@Data
public class CodeBudgetaireRequestDto {
	private int codBud;
	private String intituleCodBud;
	private boolean codBudActif;
	private Integer codTyp;
}
