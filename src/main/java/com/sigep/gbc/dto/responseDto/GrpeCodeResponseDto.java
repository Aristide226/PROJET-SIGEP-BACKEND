package com.sigep.gbc.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class GrpeCodeResponseDto {
	private String grpe;
	private String libelleGrpe;
	private List<String> userNames;
	private List<String> codes;
}
