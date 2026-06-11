package com.sigep.gbc.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteDestinataireInstitutFinAgenceDto {
	private String id;
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
	private String libelleAgence;
	private String domicilieA;
	private Boolean supprimable;
}
