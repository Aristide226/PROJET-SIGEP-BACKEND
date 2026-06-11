package com.sigep.gbc.dto.responseDto;


import lombok.Data;

@Data
public class ReamgmtResponseDto {
	private Long codReam;
	private String codBug;
	private Long ouvert;
	private Long annule;
	private Boolean nouvelle;
}
