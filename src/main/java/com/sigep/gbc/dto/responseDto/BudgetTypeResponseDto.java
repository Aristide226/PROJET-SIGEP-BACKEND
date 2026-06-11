package com.sigep.gbc.dto.responseDto;

import java.util.List;

import com.sigep.gbc.entity.BudgetTypeGestionId;

import lombok.Data;

@Data
public class BudgetTypeResponseDto {
	private Integer idBudget;
	private String libelleBudget;
	private String libelleDecision;
	//private List<BudgetTypeGestionId> budgetTypeGestionIds;
	//private List<String> codBuds;
}
