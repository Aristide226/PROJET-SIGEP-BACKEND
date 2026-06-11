package com.sigep.gbc.dto.requestDto;



import lombok.Data;

@Data
public class PpmBudgRequestDto {
	private String idPpm;
	private String codBud;
	private String idSrceFin;
	private Long montantEstime;
	private Boolean ream; 
}
