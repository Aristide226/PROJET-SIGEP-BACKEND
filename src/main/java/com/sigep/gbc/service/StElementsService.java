package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.StElementsRequestDto;
import com.sigep.gbc.dto.responseDto.StElementsResponseDto;
import com.sigep.gbc.entity.StElements;


@Service
public interface StElementsService {
	public StElementsResponseDto add(StElementsRequestDto stElementsRequestDto);
	public List<StElementsResponseDto> getAll();
	public StElements get(String id);
	public StElementsResponseDto getById(String id);
	public StElementsResponseDto delete(String id);
	public StElementsResponseDto edit(String id, StElementsRequestDto stElementsRequestDto);
}
