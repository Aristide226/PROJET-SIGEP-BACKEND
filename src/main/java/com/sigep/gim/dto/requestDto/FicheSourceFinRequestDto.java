package com.sigep.gim.dto.requestDto;

import lombok.Data;

@Data
public class FicheSourceFinRequestDto {
	private Long idFiche;
	private String idSourceFin;
	private long montantSourceFin;
}
