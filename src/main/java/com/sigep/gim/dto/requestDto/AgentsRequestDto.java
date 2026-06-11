package com.sigep.gim.dto.requestDto;

import lombok.Data;

@Data
public class AgentsRequestDto {
	private String nom;
	private String prenom;
	private String sexe;
	private String fonctActuelle;
	private String titreHono;
	private Integer codDirect;
}
