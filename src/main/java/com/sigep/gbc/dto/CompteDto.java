package com.sigep.gbc.dto;


import lombok.Data;

@Data
public class CompteDto {
	private String codCpte; 
	private String numCompte;
	private String intitule;
	private Boolean attente;
	private String abreviation;
	private String codeBanque;
	private String codeAgence;
	private String cleRib;
	private String caissePop;
	private String numCaissePop;
	private Long solde;
	private String libCompte;
}
