package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.TypeDecisionRequestDto;
import com.sigep.gbc.dto.responseDto.TypeDecisionResponseDto;
import com.sigep.gbc.entity.TypeDecision;


@Service
public interface TypeDecisionService {
	public TypeDecisionResponseDto add(TypeDecisionRequestDto typeDecisionRequestDto);
	public List<TypeDecisionResponseDto> getAll();
	public TypeDecision get(Integer id);
	public TypeDecisionResponseDto getById(Integer id);
	public TypeDecisionResponseDto delete(Integer id);
	public TypeDecisionResponseDto edit(Integer id, TypeDecisionRequestDto typeDecisionRequestDto);
}
