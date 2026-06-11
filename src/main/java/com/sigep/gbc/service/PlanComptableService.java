package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PlanComptableRequestDto;
import com.sigep.gbc.dto.responseDto.PlanComptableResponseDto;
import com.sigep.gbc.entity.PlanComptable;


@Service
public interface PlanComptableService {
	public PlanComptableResponseDto add(PlanComptableRequestDto planComptableRequestDto);
	public List<PlanComptableResponseDto> getAll();
	public PlanComptable get(String id);
	public PlanComptableResponseDto getById(String id);
	public PlanComptableResponseDto delete(String id);
	public PlanComptableResponseDto edit(String id, PlanComptableRequestDto planComptableRequestDto);
	public List<PlanComptableResponseDto> getCompteTiers();
	
}
