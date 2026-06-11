package com.sigep.gbc.dto.requestDto;



import lombok.Data;

@Data
public class ContratTypeRequestDto {
	private String typeContrat;
	private String libelle;
	private Boolean avecMiniMax;
}
