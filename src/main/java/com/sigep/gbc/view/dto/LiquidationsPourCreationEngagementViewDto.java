package com.sigep.gbc.view.dto;

import java.util.Date;

import lombok.Data;

@Data
public class LiquidationsPourCreationEngagementViewDto {
	private long codLiq;
	private short gestion;
	private int numBl;
	private Date dateLiq;
	private String objet;
	private long montant;
	private long montEngage;
	private long montDjaLiq;
	private boolean modifiable;
	private String idUser;
	private String numeroDemande;
	private Date dateModif;
	private boolean actif;
	private int idBudget;
	private String compteFourn;
	private Long idContrat;
	private Long numBe;
	private long idFourn;
	private String ifumle;
	private String ftype;
	private String contactTel;
	private String contactEmail;
	private String nom;
}
