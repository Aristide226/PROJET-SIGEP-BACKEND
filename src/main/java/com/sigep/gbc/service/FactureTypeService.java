package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.FactureTypeRequestDto;
import com.sigep.gbc.dto.responseDto.FactureTypeResponseDto;
import com.sigep.gbc.entity.FactureType;


@Service
public interface FactureTypeService {
	public FactureTypeResponseDto add(FactureTypeRequestDto factureTypeRequestDto);
	public List<FactureTypeResponseDto> getAll();
	public FactureType get(String id);
	public FactureTypeResponseDto getById(String id);
	public FactureTypeResponseDto delete(String id);
	public FactureTypeResponseDto edit(String id, FactureTypeRequestDto factureTypeRequestDto);
}
