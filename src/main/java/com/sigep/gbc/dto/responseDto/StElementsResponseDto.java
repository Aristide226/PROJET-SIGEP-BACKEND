package com.sigep.gbc.dto.responseDto;

import java.util.List;

import com.sigep.gbc.entity.StElementsNomenclaId;

import lombok.Data;

@Data
public class StElementsResponseDto {
	private String idStElts;
	private Integer partie;
	private Integer rangStElts;
	private String libelleStElts;
	private String completLib;
	private List<StElementsNomenclaId> stElementsNomenclaIds;
}
