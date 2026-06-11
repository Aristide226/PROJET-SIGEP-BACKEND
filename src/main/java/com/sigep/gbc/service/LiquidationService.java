package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.LiquidationRequestDto;
import com.sigep.gbc.dto.responseDto.LiquidationResponseDto;
import com.sigep.gbc.entity.Liquidation;


@Service
public interface LiquidationService {
	public LiquidationResponseDto add(LiquidationRequestDto liquidationRequestDto);
	public List<LiquidationResponseDto> getAll();
	public Liquidation get(Long id);
	public LiquidationResponseDto getById(Long id);
	public LiquidationResponseDto delete(Long id);
	public LiquidationResponseDto edit(Long id, LiquidationRequestDto liquidationRequestDto);
}
