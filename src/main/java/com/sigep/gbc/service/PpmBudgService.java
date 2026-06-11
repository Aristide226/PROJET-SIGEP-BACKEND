package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PpmBudgRequestDto;
import com.sigep.gbc.dto.responseDto.PpmBudgResponseDto;
import com.sigep.gbc.entity.PpmBudg;


@Service
public interface PpmBudgService {
	public PpmBudgResponseDto add(PpmBudgRequestDto ppmBudgRequestDto);
	public List<PpmBudgResponseDto> getAll();
	public PpmBudg get(String idPpm, String codBud, String idSrceFin);
	public PpmBudgResponseDto getById(String idPpm, String codBud, String idSrceFin);
	public PpmBudgResponseDto delete(String idPpm, String codBud, String idSrceFin);
	public PpmBudgResponseDto edit(String idPpm, String codBud, String idSrceFin, PpmBudgRequestDto ppmBudgRequestDto);
	
	//Aristide
	List<PpmBudgResponseDto> getByIdPpm(String idPpm);
	public PpmBudgResponseDto addReam(PpmBudgRequestDto ppmBudgRequestDto);
}
