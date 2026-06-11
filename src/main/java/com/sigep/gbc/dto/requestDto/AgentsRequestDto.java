package com.sigep.gbc.dto.requestDto;


import lombok.Data;

@Data
public class AgentsRequestDto {
	private String nom;
	private String prenom;
	private char sexe;
	private String signataire;
	private String titreHonoSign;
	private Boolean actif;
	private Integer idService;
}
