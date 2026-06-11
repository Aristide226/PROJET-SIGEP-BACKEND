package com.sigep.common.histoGbk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.common.histoGbk.dto.requestDto.EnteteRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.EnteteResponseDto;
import com.sigep.common.histoGbk.entity.Entete;




@Service
public interface HistoGbkEnteteService {
	public EnteteResponseDto add(EnteteRequestDto enteteRequestDto);
	public List<EnteteResponseDto> getAll();
	public Entete get(String id);
	public EnteteResponseDto getById(String id);
	public EnteteResponseDto delete(String id);
	public EnteteResponseDto edit(String id, EnteteRequestDto enteteRequestDto);
	public EnteteResponseDto addEsToE(String eId, String esId);
	public EnteteResponseDto removeEsFromE(String eId);
}
