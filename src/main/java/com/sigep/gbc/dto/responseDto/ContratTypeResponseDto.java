package com.sigep.gbc.dto.responseDto;


import java.util.List;


import lombok.Data;

@Data
public class ContratTypeResponseDto {
	private String typeContrat;
	private String libelle;
	private Boolean avecMiniMax;
	private List<Long> idContrats;
}
