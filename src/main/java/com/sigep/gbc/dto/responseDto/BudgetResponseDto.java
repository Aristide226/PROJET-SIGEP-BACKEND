package com.sigep.gbc.dto.responseDto;


import java.util.List;

import com.sigep.gbc.entity.BudgetModifId;

import lombok.Data;

@Data
public class BudgetResponseDto {
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
	private List<BudgetModifId> budgetModifIds;
}
