package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.DecisionSAmpliationRequestDto;
import com.sigep.gbc.dto.responseDto.DecisionSAmpliationResponseDto;
import com.sigep.gbc.entity.DecisionSampliation;


@Service
public interface DecisionSAmpliationService {
	public DecisionSAmpliationResponseDto add(DecisionSAmpliationRequestDto decisionSAmpliationRequestDto);
	public List<DecisionSAmpliationResponseDto> getAll();
	public DecisionSampliation get(Integer id);
	public DecisionSAmpliationResponseDto getById(Integer id);
	public DecisionSAmpliationResponseDto delete(Integer id);
	public DecisionSAmpliationResponseDto edit(Integer id, DecisionSAmpliationRequestDto decisionSAmpliationRequestDto);
}
