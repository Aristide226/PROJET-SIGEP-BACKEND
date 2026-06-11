package com.sigep.gbc.dto.requestDto;



import java.util.Date;

import lombok.Data;

@Data
public class PpmOldRequestDto {
	private String idPpmM;
	private String idPpm;
	private Long montantEstime;
	private Long montDepEngNonLiq;
	private Long creditDispo;
	private String natPrestation;
	private Integer nbLot;
	private String idModPassation;
	private Date dateLancement;
	private Date dateRemiseOffre;
	private Integer nbJrsEvaluation;
	private Date dateProbDemar;
	private Integer delaiExecJrs;
	private Date dateButoire;
	private Date dateEffectLance;
}
