package com.sigep.gbc.dto.requestDto;


import java.util.Date;

import lombok.Data;

@Data
public class PpmRequestDto {
	private String idPpm;
	private Short exercice;
	private Integer num;
	private Long montantEstime;
	private Long montDepEngNonLiq;
	private Long creditDispo;
	private String natPrestation;
	private Integer nbLot;
	private Date dateLancement;
	private Date dateRemiseOffre;
	private Integer nbJrsEvaluation;
	private Date dateProbDemar;
	private Integer delaiExecJrs;
	private Date dateButoire;
	private Date dateEffectLance;
	private Date dateAttribution;
	private Long montantPasse;
	private Long ream;
	private String idPpmM;
	private String abrevMp;
	private Integer idBudget;
}
