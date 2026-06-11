package com.sigep.gbc.dto.responseDto;



import java.util.List;

import lombok.Data;

@Data
public class CodModPassResponseDto {
	private String cod4;
	private String intitule;
	private String libelleCourt;
	private Integer idProc;
	private List<String> idPpmModePasss;
}
