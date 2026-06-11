package com.sigep.gbc.dto.requestDto;


import lombok.Data;

@Data
public class InstitutFinancierRequestDto {
	private String abreviation;
	private String libelle;
	private String addresseA;
	private String transiArct;
	private String codeBanque;
	private String libCourtMinus;
	private String libCourtMajus;
}
