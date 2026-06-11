package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.HistoConSRequestDto;
import com.sigep.gbc.dto.responseDto.HistoConSResponseDto;
import com.sigep.gbc.entity.HistoConS;


@Service
public interface HistoConSService {
	public HistoConSResponseDto add(HistoConSRequestDto histoConSRequestDto);
	public List<HistoConSResponseDto> getAll();
	public HistoConS get(String id);
	public HistoConSResponseDto getById(String id);
}
