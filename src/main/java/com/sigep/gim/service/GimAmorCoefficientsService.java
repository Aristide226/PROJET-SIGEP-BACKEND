package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.AmorCoefficientsRequestDto;
import com.sigep.gim.dto.responseDto.AmorCoefficientsResponseDto;
import com.sigep.gim.entity.AmorCoefficients;

@Service
public interface GimAmorCoefficientsService {
	public AmorCoefficientsResponseDto add(AmorCoefficientsRequestDto amorCoefficientsRequestDto);
	public List<AmorCoefficientsResponseDto> getAll();
	public AmorCoefficients get(char amorType, int dureeMin);
	public AmorCoefficientsResponseDto getById(char amorType, int dureeMin);
	public AmorCoefficientsResponseDto delete(char amorType, int dureeMin);
	public AmorCoefficientsResponseDto edit(char amorType, int dureeMin, AmorCoefficientsRequestDto amorCoefficientsRequestDto);
}