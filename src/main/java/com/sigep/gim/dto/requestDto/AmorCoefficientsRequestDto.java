package com.sigep.gim.dto.requestDto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AmorCoefficientsRequestDto {
	private char amorType;
	private int dureeMin;
	private int dureeMax;
	private BigDecimal coefficient;
}
