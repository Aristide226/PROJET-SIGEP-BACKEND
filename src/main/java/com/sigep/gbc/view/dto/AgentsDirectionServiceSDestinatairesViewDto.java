package com.sigep.gbc.view.dto;

import lombok.Data;

@Data
public class AgentsDirectionServiceSDestinatairesViewDto {
	private long mle;
	private String nom;
	private String prenom;
	private char sexe;
	private String signataire;
	private String titreHonoSign;
	private boolean actif;
	private Integer idService;
	private String libelle;
	private String abrev;
	private String idHerachique;
	private Integer idNiveau;
	private String codStruct;
	private Integer idParent;
	private String ifumle;
	private String ftype;
	private String contactTel;
	private String contactEmail;
}
