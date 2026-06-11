package com.sigep.gbc.dto.requestDto;



import lombok.Data;

@Data
public class FactureDetailRequestDto {
	private Integer numeroItem;
	private String designation;
	private String qtite;
	private Long prixUnitaire;
	private Long prixTotal;
	private Long idFact;
}
