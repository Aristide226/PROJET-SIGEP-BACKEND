package com.sigep.gbc.dto.responseDto;


import java.util.List;


import lombok.Data;

@Data
public class FactureTypeResponseDto {
	private String idTypFact;
	private String libelleTypFact;
	private List<Long> idFacts;
}
