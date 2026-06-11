package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PpmDacRequestDto;
import com.sigep.gbc.dto.responseDto.PpmDacResponseDto;
import com.sigep.gbc.entity.PpmDac;


@Service
public interface PpmDacService {
	public PpmDacResponseDto add(PpmDacRequestDto ppmDacRequestDto);
	public List<PpmDacResponseDto> getAll();
	public PpmDac get(String id);
	public PpmDacResponseDto getById(String id);
	public PpmDacResponseDto delete(String id);
	public PpmDacResponseDto edit(String id, PpmDacRequestDto ppmDacRequestDto);
}
