package com.sigep.gbc.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class DirectionServiceNiveauResponseDto {
	private Integer idNiveau;
	private String libelleNiveau;
	private List<Integer> idServices;
}
