package com.sigep.gbc.dto.requestDto;

import java.util.Date;

import lombok.Data;

@Data
public class MandatsRequestDto {
	private Date dateMand;
	private Long montant;
	private Date dateEtat;
	private Date datePaie;
	private Long montantPaie;
	private String idCompte;
	private String idUser;
	private Date datePosition;
	private Integer benum;
	private String objet;
	private Long montEngage;
	private Long montDjaLiq;
	private Date dateEtatBl;
	private Date datePec;
	private Boolean receptionne;
	private Boolean genererOv;
	private Boolean avecReversement;
	private Long precompte;
	private Date datePrecompte;
	private String userPrecompte;
	private Date dateValid;
	private Long idFiche;
	private Long montantTotalPec;
	private Date dateCreat;
	private Boolean estOrdre;
	private Integer mandNumApresVisaCf;
	private Integer idEtatTransL;
	private Integer idEtatTransM;
	private String idBordEmis;
	private Long idBord;
	private String codBud;
	private Integer idBudget;
	private String compteFourn;
	private Long idContrat;
	private Long idFourn;
	private Short gestion;
	private Long codLiq;
	private String idLettrage;
	private String idModePaie;
	private Long numBe;
	private String etat;
	private String etatBl;
	private Long numMandParent;
}
