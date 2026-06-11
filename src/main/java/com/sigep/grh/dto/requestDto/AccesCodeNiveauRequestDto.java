package com.sigep.grh.dto.requestDto;

import java.util.List;

import lombok.Data;

@Data
public class AccesCodeNiveauRequestDto {
	private String code;
	private String intituleCode;
	private String nomStruct;
	private List<String> grpes;
}
