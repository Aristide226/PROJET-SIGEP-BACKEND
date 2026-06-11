package com.sigep.gim.dto.responseDto;

import java.util.Date;

import lombok.Data;

@Data
public class CodeAccesHistoResponseDto {
	private int id;
	private Date dateChangement;
	private String motPasse;
}
