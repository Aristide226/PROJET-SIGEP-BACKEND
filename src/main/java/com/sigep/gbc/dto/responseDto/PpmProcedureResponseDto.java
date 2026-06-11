package com.sigep.gbc.dto.responseDto;


import java.util.List;


import lombok.Data;

@Data
public class PpmProcedureResponseDto {
	private Integer idProc;
	private String libProcedure;
	private List<String> idCodModPasss;
}
