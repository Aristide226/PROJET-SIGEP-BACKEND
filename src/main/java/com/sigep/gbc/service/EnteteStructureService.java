package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sigep.gbc.dto.requestDto.EnteteStructureRequestDto;
import com.sigep.gbc.dto.responseDto.EnteteStructureResponseDto;
import com.sigep.gbc.entity.EnteteStructure;


@Service
public interface EnteteStructureService {
	public EnteteStructureResponseDto add(EnteteStructureRequestDto enteteStructureRequestDto);
	public List<EnteteStructureResponseDto> getAll();
	public EnteteStructure get(String id);
	public EnteteStructureResponseDto getById(String id);
	public EnteteStructureResponseDto delete(String id);
	public EnteteStructureResponseDto edit(String newId, String oldId, EnteteStructureRequestDto enteteStructureRequestDto);
	public EnteteStructureResponseDto addNmToEs(String esId, int nmId);
	public EnteteStructureResponseDto removeNmFromEs(String esId);
}
