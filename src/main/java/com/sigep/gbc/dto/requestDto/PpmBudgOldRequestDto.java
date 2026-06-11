package com.sigep.gbc.dto.requestDto;



import lombok.Data;

@Data
public class PpmBudgOldRequestDto {
	private String idPpmM;
	private String idPpm;
	private String codBud;
	private String idSrceFin;
	private Long montantEstime;
}
