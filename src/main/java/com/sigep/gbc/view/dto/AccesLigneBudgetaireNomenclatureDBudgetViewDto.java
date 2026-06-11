package com.sigep.gbc.view.dto;

import lombok.Data;

@Data
public class AccesLigneBudgetaireNomenclatureDBudgetViewDto {
	private String codBud;
	private String intitule;
	private long dotInitiale;
	private long caajout;
	private long caannul;
	private long ream;
	private long totalEngag;
	private short gestion;
	private String numNo;
	private int idBudget;
	private String idPlan;
	private String userName;
	private String titre;
	private String section;
	private String chap;
	private String art;
	private String parag;
	private String rub;
	private Boolean dotEstExec;
	private String codHierarchiq;
}
