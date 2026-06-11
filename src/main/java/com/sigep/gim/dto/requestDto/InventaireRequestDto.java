package com.sigep.gim.dto.requestDto;

import java.util.Date;

import lombok.Data;

@Data
public class InventaireRequestDto {
	private Date dateInvent;
	private Date dateEtat;
	private boolean enStock;
	private String etat;
	private Short idTypeInvent;
}
