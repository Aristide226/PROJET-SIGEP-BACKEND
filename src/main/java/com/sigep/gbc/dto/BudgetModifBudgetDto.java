package com.sigep.gbc.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetModifBudgetDto {
	private String codBud;
	private String intitule;
	private Long dotInitiale;
	private Long caajout;
	private Long caannul;
	private Long ream;
	private Long totalEngag;
	private Long dotN1;
	private Long execN1;
	private Long dotN2;
	private Long execN2;
	private Long dotN3;
	private Long execN3;
	private Short gestion;
	private String numNo;
	private Integer idBudget;
	private String idPlan;
	private Long codBma;
	private Long ajoute;
	private Long annule;
	private Boolean nouvelle;
}
