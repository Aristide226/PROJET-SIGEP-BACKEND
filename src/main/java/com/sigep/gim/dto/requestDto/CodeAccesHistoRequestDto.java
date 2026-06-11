package com.sigep.gim.dto.requestDto;

import java.util.Date;

import lombok.Data;

@Data
public class CodeAccesHistoRequestDto {
	private Date dateChangement;
	private String motPasse;
}
