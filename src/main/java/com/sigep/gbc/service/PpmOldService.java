package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PpmOldRequestDto;
import com.sigep.gbc.dto.responseDto.PpmOldResponseDto;
import com.sigep.gbc.entity.PpmOld;


@Service
public interface PpmOldService {
	public PpmOldResponseDto add(PpmOldRequestDto ppmOldRequestDto);
	public List<PpmOldResponseDto> getAll();
	public PpmOld get(String idPpmM, String idPpm);
	public PpmOldResponseDto getById(String idPpmM, String idPpm);
	public PpmOldResponseDto delete(String idPpmM, String idPpm);
	public PpmOldResponseDto edit(String idPpmM, String idPpm, PpmOldRequestDto ppmOldRequestDto);
}
