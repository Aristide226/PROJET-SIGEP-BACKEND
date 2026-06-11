package com.sigep.gbc.view.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MandatsViewDto {
	private long numMand;
	private String codBud;
	private long numBe;
	private short gestion;
	private int mandNumb;
	private Date dateMand;
	private long montant;
	private String etat;
	private Date dateEtat;
	private Long idFourn;
	private Long idContrat;
	private String compteFourn;
	private Date datePaie;
	private Long montantPaie;
	private String idModePaie;
	private String idCompte;
	private String idUser;
	private Date datePosition;
	private int benum;
	private int numBl;
	private String objet;
	private long montEngage;
	private long montDjaLiq;
	private String etatBl;
	private Date dateEtatBl;
	private Long numMandParent;
	private String idBordEmis;
	private Long idbord;
	private Integer idEtatTransM;
	private Integer idEtatTransL;
	private Integer idBudget;
	private Long codLiq;
	private String idLettrage;
	private Date datePec;
	private boolean receptionne;
	private boolean genererOv;
	private boolean avecReversement;
	private long precompte;
	private Date datePrecompte;
	private String userPrecompte;
	private Date dateValid;
	private long idFiche;
	private long montantTotalPec;
	private Date dateCreat;
	private boolean estOrdre;
	private int mandNumApresVisaCf;
	private String ifumle;// DESTINATAIRES
	private String nom;
	private String titre;// NUMNO
	private String section;
	private String chap;
	private String art;
	private String parag;
	private String rub;
	private String intitule;
}