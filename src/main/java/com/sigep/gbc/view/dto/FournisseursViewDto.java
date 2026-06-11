package com.sigep.gbc.view.dto;

import lombok.Data;

@Data
public class FournisseursViewDto {
	private long idFourn;
	private String raisonSociale;
	private String bp;
	private String profession;
	private String telephone;
	private String ifumle;
	private String ftype;
	private String contactTel;
	private String contactEmail;
	private long nbreCompteDestinataire;
	private long occurenceFournisseurDansEngagement;
	private long cccurenceFournisseurDansPPM_EXEC;
}