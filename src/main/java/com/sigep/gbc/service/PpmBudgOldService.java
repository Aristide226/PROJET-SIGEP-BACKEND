package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PpmBudgOldRequestDto;
import com.sigep.gbc.dto.responseDto.PpmBudgOldResponseDto;
import com.sigep.gbc.entity.PpmBudgOld;


@Service
public interface PpmBudgOldService {
	public PpmBudgOldResponseDto add(PpmBudgOldRequestDto ppmBudgOldRequestDto);
	public List<PpmBudgOldResponseDto> getAll();
	public PpmBudgOld get(String idPpmM, String idPpm, String codBud, String idSrceFin);
	public PpmBudgOldResponseDto getById(String idPpmM, String idPpm, String codBud, String idSrceFin);
	public PpmBudgOldResponseDto delete(String idPpmM, String idPpm, String codBud, String idSrceFin);
	public PpmBudgOldResponseDto edit(String idPpmM, String idPpm, String codBud, String idSrceFin, PpmBudgOldRequestDto ppmBudgOldRequestDto);
}
