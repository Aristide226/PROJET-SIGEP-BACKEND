package com.sigep.gim.dto.responseDto;

import java.util.Date;

import lombok.Data;

@Data
public class HistoEtatResponseDto {
	private String etat;
	private Long idFiche;
	private Date dateEtat;
}
