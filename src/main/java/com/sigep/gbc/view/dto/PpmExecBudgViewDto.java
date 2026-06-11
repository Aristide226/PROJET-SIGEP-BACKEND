package com.sigep.gbc.view.dto;

import java.math.BigDecimal;
import java.util.Date;


import lombok.Data;

@Data
public class PpmExecBudgViewDto {
	private int idPpmExe;
    private int idLot;
    private Integer idBudget;
    private short exercice;
    private String codBud;
    private String idSrceFin;
    private long montantEstime;
    private Boolean avecTva;
	private Boolean avecMiniMax;
	private int nbLot;
	private int num;
	private Long montantEstimePpmExec;
	private Long montDepEngNonLiq;
	private Long creditDispo;
	private String natPrestation;
	private String objetLot;
	private Date dateCreat;
	private Date dateLanceEffect;
	private Date dateButoire;
	private boolean execution;
	private int idFourn;
	private Long montantAttrib;
	private BigDecimal montantTtc;
	private BigDecimal montantHtva;
	private BigDecimal montantMaxTtc;
	private BigDecimal montantMaxHtva;
	private BigDecimal montantMinTtc;
	private BigDecimal montantMinHtva;
	private String abrevMp;
	private Date dateNotificationProvisoire;
	private Date dateApprobContrat;
	private String NiveauMiseEnOeuvreEtObservation;
	private Date dateReception;
	private Date dateLancementMarchePrevisionnel;
	private int nbJoursRetardLancement;
	private String idPpm;
	private String ifumle;
	private String nom;
	private String idPlan;
	private String intituleBudget;
	private String intituleCourtCodSourceFin;
	private String abrevCodSourceFin;
	private String intituleLongCodSourceFin;
	private String libelleLongMp;
	private String cod4;
}