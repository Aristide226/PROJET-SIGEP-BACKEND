package com.sigep.gbc.dto.responseDto;



import lombok.Data;

@Data
public class PpmBudgResponseDto {
	private String idPpm;
	private String codBud;
	private String idSrceFin;
	private Long montantEstime;
	private Boolean ream; 
}
