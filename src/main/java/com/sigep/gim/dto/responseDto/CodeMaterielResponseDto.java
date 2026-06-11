package com.sigep.gim.dto.responseDto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CodeMaterielResponseDto {
	private String codMat;
	private Integer num;
	private String intituleMateriel;
	private int dureeVieAn;
	private BigDecimal tauxAmortAn;
	private String art;
	private Integer codBud;
}
