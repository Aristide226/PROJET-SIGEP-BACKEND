package com.sigep.gbc.dto.responseDto;

import java.util.List;

import com.sigep.gbc.model.Grpe;

import lombok.Data;

@Data
public class AccesCodeNiveauResponseDto {
	private String code;
	private String intituleCode;
	private String nomStruct;
	private List<String> userNames;
	private List<Grpe> grpes;
}
