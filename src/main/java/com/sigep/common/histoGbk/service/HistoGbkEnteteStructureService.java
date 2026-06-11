package com.sigep.common.histoGbk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.common.histoGbk.dto.requestDto.EnteteStructureRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.EnteteStructureResponseDto;
import com.sigep.common.histoGbk.entity.EnteteStructure;


@Service
public interface HistoGbkEnteteStructureService {
	public EnteteStructureResponseDto add(EnteteStructureRequestDto enteteStructureRequestDto);
	public List<EnteteStructureResponseDto> getAll();
	public EnteteStructure get(String id);
	public EnteteStructureResponseDto getById(String id);
	public EnteteStructureResponseDto delete(String id);
	public EnteteStructureResponseDto edit(String newId, String oldId, EnteteStructureRequestDto enteteStructureRequestDto);
}
