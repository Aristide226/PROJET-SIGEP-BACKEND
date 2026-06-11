package com.sigep.gbc.dto.requestDto;

import java.util.Date;

import lombok.Data;

@Data
public class BudgetTypeGestionRequestDto {
	private Integer idBudget;
	private Short annee;
	private Date dateMiseEnPlace;
	private Date dateCloture;
	private Boolean fermer;
	private Integer pageCommencantA;
	private String eteteD;
	private String eteteM;
	private String piedD;
	private String piedM;
	private String signataireBud;
	private String nomSignataire;
	private String honoSignataire;
}
