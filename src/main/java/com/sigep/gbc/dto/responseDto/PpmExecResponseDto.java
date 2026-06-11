//Aristide
package com.sigep.gbc.dto.responseDto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class PpmExecResponseDto {
	private int idPpmExec;
	private int idLot;
	private Integer idBudget;
	private short exercice;
	private int nbLot;
	private int num;
	private Long montantEstime;
	private Long montDepEngNonLiq;
	private Long creditDispo;
	private String natPrestation;
	private Date dateCreation; 
	private Date dateButoire;
	private boolean execution;
	private BigDecimal montantTtc;
	private BigDecimal montantHtva;
	private BigDecimal montantMaxTtc;
	private BigDecimal montantMaxHtva;
	private BigDecimal montantMinTtc;
	private BigDecimal montantMinHtva;
	private String abrevMp;
	private String idPpm;
	private Date dateRemiseEtOuvertureDesPlis;
	
	private String objetLot;
    private int idFourn;
    private Long montantAttrib;
    private Date dateNotificationProvisoire;
    private Date dateApprobContrat;
    private String niveauMiseEnOeuvreEtObservation;
    private Date dateReception;
    private Date dateLancementMarchePrevisionnel;
    private Date dateLanceEffect;
    private int nbJoursRetardLancement;
    
}