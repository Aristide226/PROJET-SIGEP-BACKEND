package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.CodSourceFinRequestDto;
import com.sigep.gbc.dto.responseDto.CodSourceFinResponseDto;
import com.sigep.gbc.entity.CodSourceFin;


@Service
public interface CodSourceFinService {
	public CodSourceFinResponseDto add(CodSourceFinRequestDto codSourceFinRequestDto);
	public List<CodSourceFinResponseDto> getAll();
	public CodSourceFin get(String id);
	public CodSourceFinResponseDto getById(String id);
	public CodSourceFinResponseDto delete(String id);
	public CodSourceFinResponseDto edit(String id, CodSourceFinRequestDto codSourceFinRequestDto);
}
