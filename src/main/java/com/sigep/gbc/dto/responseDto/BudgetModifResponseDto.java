package com.sigep.gbc.dto.responseDto;


import lombok.Data;

@Data
public class BudgetModifResponseDto {
	private Long codBma;
	private String codBud;
	private Long ajoute;
	private Long annule;
	private Boolean nouvelle;
}
