package com.sigep.gbc.dto.requestDto;


import lombok.Data;

@Data
public class BudgetRequestDto {
	private String codBud;
	private String intitule;
	private Long dotInitiale;
	private Long caajout;
	private Long caannul;
	private Long ream;
	private Long totalEngag;
	private Short gestion;
	private String numNo;
	private Integer idBudget;
	private String idPlan;
}
