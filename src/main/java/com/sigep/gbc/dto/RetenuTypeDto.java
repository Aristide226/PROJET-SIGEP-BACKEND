package com.sigep.gbc.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RetenuTypeDto {
	private Integer idTypRetenu;
	private String libelle;
	private BigDecimal taux;
	private String libelleCpte;
	private String codCpte;
	private String idCategorie;
}
