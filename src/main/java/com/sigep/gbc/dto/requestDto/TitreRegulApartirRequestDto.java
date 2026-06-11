package com.sigep.gbc.dto.requestDto;



import lombok.Data;

@Data
public class TitreRegulApartirRequestDto {
	private Integer idApartir;
	private String libelleApartir;
	private Boolean regularisation;
}
