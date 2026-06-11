package com.sigep.gim.dto.requestDto;

import lombok.Data;

@Data
public class CodeBudgTypeRequestDto {
	private int codTyp;
	private String intituleTyp;
	private Boolean codTypActif;
	private Integer codCategorie;
}
