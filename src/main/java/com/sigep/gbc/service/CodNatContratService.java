package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.CodNatContratRequestDto;
import com.sigep.gbc.dto.responseDto.CodNatContratResponseDto;
import com.sigep.gbc.entity.CodNatContrat;


@Service
public interface CodNatContratService {
	public CodNatContratResponseDto add(CodNatContratRequestDto codNatContratRequestDto);
	public List<CodNatContratResponseDto> getAll();
	public CodNatContrat get(String id);
	public CodNatContratResponseDto getById(String id);
	public CodNatContratResponseDto delete(String id);
	public CodNatContratResponseDto edit(String id, CodNatContratRequestDto codNatContratRequestDto);
}
