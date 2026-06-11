package com.sigep.gbc.dto.responseDto;



import lombok.Data;

@Data
public class PpmBudgOldResponseDto {
	private String idPpmM;
	private String idPpm;
	private String codBud;
	private String idSrceFin;
	private Long montantEstime;
}
