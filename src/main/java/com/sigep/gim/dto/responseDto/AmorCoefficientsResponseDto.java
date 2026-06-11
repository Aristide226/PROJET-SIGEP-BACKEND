package com.sigep.gim.dto.responseDto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AmorCoefficientsResponseDto {
	private char amorType;
	private int dureeMin;
	private int dureeMax;
	private BigDecimal coefficient;
}
