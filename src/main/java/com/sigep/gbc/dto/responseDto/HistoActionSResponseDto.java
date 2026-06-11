package com.sigep.gbc.dto.responseDto;


import java.util.Date;

import lombok.Data;

@Data
public class HistoActionSResponseDto {
	private Date dateAct;
	private String codH;
	private String action;
}
