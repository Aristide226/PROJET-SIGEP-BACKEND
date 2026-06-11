package com.sigep.gbc.dto.requestDto;


import java.math.BigDecimal;
import java.util.Date;


import lombok.Data;

@Data
public class ContratsRequestDto {
	private String cod1;
	private String cod2;
	private String cod3;
	private String cod4;
	private String cod5;
	private Short annee;
	private String objet;
	private String reference;
	private Long delaiNbre;
	private String delaiText;
	private Date dateSaisie;
	private Date dateApprob;
	private String acteRef;
	private String refNotif;
	private Date dateNotif;
	private Date dateDemmar;
	private Boolean mleAuto;
	private String refPassation;
	private String refArt;
	private BigDecimal tauxappli;
	private Boolean suspens;
	private String idLogin;
	private String idcompte;
	private Long montantMaxHtva;
	private Long montantMinHtva;
	private Long montantMaxTtc;
	private Long montantMinTtc;
	private Boolean avecTva;
	private Boolean avecMiniMax;
	private Integer delaiAn;
	private Integer delaiMois;
	private Integer delaiSemaine;
	private Integer delaiJours;
	private Date dateCreate;
	private String userUpdate;
	private Date dateUpdate;
	private String idContratParent;
	private String abrevEpe;
	private Date dateAttribution;
	private String codTypeMarche;
	private String codIdentiteExecution;
	private Integer idPpmExe;
	private Integer idLot;
	private String codBud;
	private String idSrceFin;
	private Integer idBudget;
	private String type;
	private Long idFourn;
	private String idDac;
}
