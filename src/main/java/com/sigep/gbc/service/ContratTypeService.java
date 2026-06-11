package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.responseDto.ContratTypeResponseDto;
import com.sigep.gbc.entity.ContratType;


@Service
public interface ContratTypeService {
	public ContratTypeResponseDto add(ContratTypeResponseDto contratTypeResponseDto);
	public List<ContratTypeResponseDto> getAll();
	public ContratType get(String id);
	public ContratTypeResponseDto getById(String id);
	public ContratTypeResponseDto delete(String id);
	public ContratTypeResponseDto edit(String id, ContratTypeResponseDto contratTypeResponseDto);
}
