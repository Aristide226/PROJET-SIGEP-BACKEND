package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PpmProcedureRequestDto;
import com.sigep.gbc.dto.responseDto.PpmProcedureResponseDto;
import com.sigep.gbc.entity.PpmProcedure;


@Service
public interface PpmProcedureService {
	public PpmProcedureResponseDto add(PpmProcedureRequestDto ppmProcedureRequestDto);
	public List<PpmProcedureResponseDto> getAll();
	public PpmProcedure get(Integer id);
	public PpmProcedureResponseDto getById(Integer id);
	public PpmProcedureResponseDto delete(Integer id);
	public PpmProcedureResponseDto edit(Integer id, PpmProcedureRequestDto ppmProcedureRequestDto);
}
