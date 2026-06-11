package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PpmModPassRequestDto;
import com.sigep.gbc.dto.responseDto.PpmModPassResponseDto;
import com.sigep.gbc.entity.PpmModePass;


@Service
public interface PpmModPassService {
	public PpmModPassResponseDto add(PpmModPassRequestDto ppmModPassRequestDto);
	public List<PpmModPassResponseDto> getAll();
	public PpmModePass get(String id);
	public PpmModPassResponseDto getById(String id);
	public PpmModPassResponseDto delete(String id);
	public PpmModPassResponseDto edit(String id, PpmModPassRequestDto ppmModPassRequestDto);
}
