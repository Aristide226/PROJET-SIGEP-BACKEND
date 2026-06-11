package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.NiveauPlanComptableRequestDto;
import com.sigep.gbc.dto.responseDto.NiveauPlanComptableResponseDto;
import com.sigep.gbc.entity.NiveauPlanComptable;


@Service
public interface NiveauPlanComptableService {
	public NiveauPlanComptableResponseDto add(NiveauPlanComptableRequestDto niveauPlanComptableRequestDto);
	public List<NiveauPlanComptableResponseDto> getAll();
	public NiveauPlanComptable get(Integer id);
	public NiveauPlanComptableResponseDto getById(Integer id);
	public NiveauPlanComptableResponseDto delete(Integer id);
	public NiveauPlanComptableResponseDto edit(Integer id, NiveauPlanComptableRequestDto niveauPlanComptableRequestDto);
}
