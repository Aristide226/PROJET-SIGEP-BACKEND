package com.sigep.gbc.dto.requestDto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class FacturesRequestDto {
	private Long idFact;
	private String objetFact;
	private Date dateFact;
	private Long montant;
	private Long remise;
	private BigDecimal tauxTva;
	private Boolean avecTva;
	private Integer idSignataire;
	private String signataire;
	private String nomSign;
	private String titreHonoSign;
	private Integer numChrono;
	private String complemaNum;
	private Long idFactParent;
	private Boolean valide;
	private String numeroContate;
	private Boolean actif;
	private String idTypFact;
	private Long idDebiteur;
	private String idCpte;
}
