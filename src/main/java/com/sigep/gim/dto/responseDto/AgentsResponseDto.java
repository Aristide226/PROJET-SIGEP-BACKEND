package com.sigep.gim.dto.responseDto;

import lombok.Data;

@Data
public class AgentsResponseDto {
	private String mleAgent;
	private String nom;
	private String prenom;
	private String sexe;
	private String fonctActuelle;
	private String titreHono;
	private Integer codDirect;
}
