package com.sigep.gbc.dto.requestDto;


import java.util.Date;

import lombok.Data;

@Data
public class BudgetModifActeRequestDto {
	private Boolean valide;
	private String acteBma;
	private String numActeBma;
	private Date dateActeBma;
	private String idLogin;
	private Short gestion;
	private Date dateValid;
	private String idValid;
	private Integer idBudget;
}
