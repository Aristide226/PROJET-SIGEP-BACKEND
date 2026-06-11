package com.sigep.gbc.dto.requestDto;


import lombok.Data;

@Data
public class TiersCaissePopRequestDto {
	private String caissePop;
	private String folio;
	private Long idDest;
}
