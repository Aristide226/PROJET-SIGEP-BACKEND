package com.sigep.gbc.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class TiersCaissePopResponseDto {
	private Long idCaissePop;
	private String caissePop;
	private String folio;
	private List<String> compteDestinatairesIds;
}
