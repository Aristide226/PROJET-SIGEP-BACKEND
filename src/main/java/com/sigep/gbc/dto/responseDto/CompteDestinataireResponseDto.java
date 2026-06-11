package com.sigep.gbc.dto.responseDto;


import java.util.List;

import lombok.Data;

@Data
public class CompteDestinataireResponseDto {
	private String id;
	private String codeBanque;
	private String codeAgence;
	private String numCompte;
	private String cleRib;
	private String caissePop;
	private String numCaissePop;
	private String codeBic;
	private String iban;
	private Long idCaissePop;
	private Long idDest;
	private String abreviation;
	private String idAgence; 
	private List<Long> codLiqs;
	private List<Long> numMands;
	private Boolean isUsed;
}
