package com.sigep.gbc.dto.requestDto;



import lombok.Data;

@Data
public class CodModPassRequestDto {
	private String cod4;
	private String intitule;
	private String libelleCourt;
	private Integer idProc;
}
