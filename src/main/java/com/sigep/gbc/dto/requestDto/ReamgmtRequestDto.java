package com.sigep.gbc.dto.requestDto;


import lombok.Data;

@Data
public class ReamgmtRequestDto {
	private Long codReam;
	private String codBug;
	private Long ouvert;
	private Long annule;
	private Boolean nouvelle;
}
