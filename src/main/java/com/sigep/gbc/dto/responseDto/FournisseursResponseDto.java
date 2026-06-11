package com.sigep.gbc.dto.responseDto;

import lombok.Data;

@Data
public class FournisseursResponseDto {
	private Long idFourn;
	private String raisonSociale;
	private String bp;
	private String profession;
	private String telephone;
}
