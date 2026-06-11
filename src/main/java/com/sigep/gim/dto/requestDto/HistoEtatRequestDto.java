package com.sigep.gim.dto.requestDto;

import java.util.Date;

import lombok.Data;

@Data
public class HistoEtatRequestDto {
	private String etat;
	private Long idFiche;
	private Date dateEtat;
}
