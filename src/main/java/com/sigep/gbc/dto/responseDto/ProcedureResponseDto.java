package com.sigep.gbc.dto.responseDto;


import java.util.List;


import lombok.Data;

@Data
public class ProcedureResponseDto {
	private String proced;
	private String libProced;
	private List<Long> numBes;
}
