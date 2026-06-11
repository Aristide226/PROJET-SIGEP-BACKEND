package com.sigep.gbc.dto.requestDto;

import lombok.Data;

@Data
public class DirectionServiceRequestDto {
	private String libelle;
	private String abrev;
	private Integer idNiveau;
	private String codStruct;
	private Integer idParent;
}
