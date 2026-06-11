package com.sigep.gbc.dto.responseDto;


import java.util.Date;
import java.util.List;

import com.sigep.gbc.entity.PpmBudgId;
import com.sigep.gbc.entity.PpmOldId;

import lombok.Data;

@Data
public class PpmResponseDto {
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
	private List<PpmOldId> ppmOldIds;
	private List<String> idDacs;
	private List<PpmBudgId> ppmBudgIds;
}
