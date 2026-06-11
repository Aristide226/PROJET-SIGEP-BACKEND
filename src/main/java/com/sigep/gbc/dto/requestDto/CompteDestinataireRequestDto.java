package com.sigep.gbc.dto.requestDto;


import lombok.Data;

@Data
public class CompteDestinataireRequestDto {
	private String codeBanque;
	private String codeAgence;
	private String numCompte;
	private String cleRib;
	private String caissePop;
	private String numCaissePop;
	private String codeBic;
	private String iban;
	private Long idCaissePop;
	private Long idDest;
	private String abreviation;
	private String idAgence; 
}
