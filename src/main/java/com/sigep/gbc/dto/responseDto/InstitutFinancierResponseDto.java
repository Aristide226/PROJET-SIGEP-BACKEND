package com.sigep.gbc.dto.responseDto;


import java.util.List;

import lombok.Data;

@Data
public class InstitutFinancierResponseDto {
	private String abreviation;
	private String libelle;
	private String addresseA;
	private String transiArct;
	private String codeBanque;
	private String libCourtMinus;
	private String libCourtMajus;
	private Long idDest;
	private List<String> idAgences;
}
