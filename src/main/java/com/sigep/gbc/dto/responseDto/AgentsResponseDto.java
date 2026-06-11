package com.sigep.gbc.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class AgentsResponseDto {
	private Long mle;
	private String nom;
	private String prenom;
	private char sexe;
	private String signataire;
	private String titreHonoSign;
	private Boolean actif;
	private Integer idService;
	private List<String> userNames;
}
