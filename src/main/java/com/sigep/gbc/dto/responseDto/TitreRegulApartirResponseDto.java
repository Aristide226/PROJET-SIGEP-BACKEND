package com.sigep.gbc.dto.responseDto;


import java.util.List;


import lombok.Data;

@Data
public class TitreRegulApartirResponseDto {
	private Integer idApartir;
	private String libelleApartir;
	private Boolean regularisation;
	private List<Long> idDetailTitres;
}
