package com.sigep.gim.dto.requestDto;

import lombok.Data;

@Data
public class PatrimoineMaterielsRequestDto {
	private String mle;
	private String marqRace;
	private String immatriculation;
	private Integer idMagasin;
	private String format;
}
