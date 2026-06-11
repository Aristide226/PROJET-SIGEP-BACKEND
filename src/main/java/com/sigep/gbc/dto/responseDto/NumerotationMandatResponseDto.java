package com.sigep.gbc.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class NumerotationMandatResponseDto {
	private int mandNumApresVisaCf;
	private String descriptions;
	private List<String> enteteStructureAbrevEpes;
}
