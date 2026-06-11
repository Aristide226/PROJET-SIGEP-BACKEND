package com.sigep.gbc.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class DirectionServiceResponseDto {
	private Integer idService;
	private String libelle;
	private String abrev;
	private String idHerachique;
	private Integer idNiveau;
	private String codStruct;
	private Integer idParent;
	private List<Integer> idServices;
	private List<Long> mles;
}
