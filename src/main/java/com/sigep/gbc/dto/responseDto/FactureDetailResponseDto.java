package com.sigep.gbc.dto.responseDto;



import lombok.Data;

@Data
public class FactureDetailResponseDto {
	private String idFactDetail;
	private Integer numeroItem;
	private String designation;
	private String qtite;
	private Long prixUnitaire;
	private Long prixTotal;
	private Long idFact;
}
