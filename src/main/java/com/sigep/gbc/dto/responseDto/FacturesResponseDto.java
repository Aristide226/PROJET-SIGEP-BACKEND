package com.sigep.gbc.dto.responseDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class FacturesResponseDto {
	private Long idFact;
	private String objetFact;
	private Date dateFact;
	private String numeroFact;
	private Long montant;
	private Long remise;
	private BigDecimal tauxTva;
	private Boolean avecTva;
	private Long montantHt;
	private Long montantTva;
	private Long montantTtc;
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
	private List<String> codTitrs;
	private List<String> idFactDetails;
}
