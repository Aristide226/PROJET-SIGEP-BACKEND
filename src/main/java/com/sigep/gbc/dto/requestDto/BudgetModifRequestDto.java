package com.sigep.gbc.dto.requestDto;


import lombok.Data;

@Data
public class BudgetModifRequestDto {
	private Long codBma;
	private String codBud;
	private Long ajoute;
	private Long annule;
	private Boolean nouvelle;
}
