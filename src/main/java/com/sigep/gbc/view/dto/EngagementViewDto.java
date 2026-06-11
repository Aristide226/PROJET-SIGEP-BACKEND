package com.sigep.gbc.view.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EngagementViewDto {
	private long numBe;
	private String codBud;
	private short gestion;
	private int benum;
	private String proced;
	private Date dateCreation;
	private String natDepense;
	private String auProfit;
	private long montant;
	private Long dot_Initiale;
	private Long dispoAvant;
	private String etat;
	private Date dateEtat;
	private Long idBord;
	private Long idFourn;
	private Long idContrat;
	private Long idEng;
	private String idUser;
	private Integer idEtatTrans;
	private Integer idBudget;
	private boolean avecDecision;
	private Long codLiq;
	private boolean apartirDemandLiq;
	private boolean grh;
	private boolean receptionne;
	private Date dateValid;
	private Date dateCreat;
	private String intitule;
	private long dotInitiale;
	private long totalEngag;
	private Long dotationCorrigee;
	private Long dotationDefinitive;
	private Long disponible;
	private long nbreEngag;
	private String ifumle;
	private String ftype;
	private String nom;
	private String titre;
	private String section;
	private String chap;
	private String art;
	private String parag;
	private String rub;
	private String id_motif;
	private String motifs;
	private Date dateSaisieMotif;
	private Long idTitreMotif;
	private String userNameMotif;
	private Date dateEnregMotif;
	private boolean actifMotif;
	private Integer numeroBordTransmis;
}