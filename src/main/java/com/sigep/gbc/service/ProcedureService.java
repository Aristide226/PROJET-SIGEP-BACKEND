package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.ProcedureRequestDto;
import com.sigep.gbc.dto.responseDto.ProcedureResponseDto;
import com.sigep.gbc.entity.Procedures;


@Service
public interface ProcedureService {
	public ProcedureResponseDto add(ProcedureRequestDto procedureRequestDto);
	public List<ProcedureResponseDto> getAll();
	public Procedures get(String id);
	public ProcedureResponseDto getById(String id);
	public ProcedureResponseDto delete(String id);
	public ProcedureResponseDto edit(String id, ProcedureRequestDto procedureRequestDto);
}
