package com.sigep.gbc.dto.requestDto;


import lombok.Data;

@Data
public class GestionRequestDto {
	private Short courante;
	private String libelle;
	private String etat;
	private String utilisation;
}
