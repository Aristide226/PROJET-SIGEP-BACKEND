package com.sigep.gim.dto.responseDto;

import java.util.Date;

import lombok.Data;

@Data
public class InventaireResponseDto {
	private long idInvent;
	private Date dateInvent;
	private Date dateEtat;
	private boolean enStock;
	private String etat;
	private Short idTypeInvent;
}
