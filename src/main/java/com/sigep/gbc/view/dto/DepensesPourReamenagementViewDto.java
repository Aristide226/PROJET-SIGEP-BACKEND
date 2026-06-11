package com.sigep.gbc.view.dto;

import lombok.Data;

@Data
public class DepensesPourReamenagementViewDto {
	private String codBud;
	private String intitule;
	private long dotInitiale;
	private long caajout;
	private long caannul;
	private long ream;
	private long totalEngag;
	private Long dotN1;
	private Long execN1;
	private Long dotN2;
	private Long execN2;
	private Long dotN3;
	private Long execN3;
	private Long ouvert;
	private Long annule;
	private short gestion;
	private String numNo;
	private int idBudget;
	private String idPlan;
	private Long dotationCorrigee;
	private Long dotationDefinitive;
}
