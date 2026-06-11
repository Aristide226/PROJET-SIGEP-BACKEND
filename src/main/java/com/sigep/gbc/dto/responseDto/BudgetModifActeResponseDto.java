package com.sigep.gbc.dto.responseDto;


import java.util.Date;
import java.util.List;

import com.sigep.gbc.entity.BudgetModifId;

import lombok.Data;

@Data
public class BudgetModifActeResponseDto {
	private Long codBma;
	private Date dateSaisie;
	private Boolean valide;
	private String acteBma;
	private String numActeBma;
	private Date dateActeBma;
	private String idLogin;
	private Short gestion;
	private Date dateValid;
	private String idValid;
	private Integer idBudget;
	private List<BudgetModifId> budgetModifIds;
}
