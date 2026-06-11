package com.sigep.gbc.dto.requestDto;



import lombok.Data;

@Data
public class EtatDossierRequestDto {
	private String etat;
	private String libEtat;
	private Boolean avecMotifR;
}
