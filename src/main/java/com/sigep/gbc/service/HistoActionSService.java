package com.sigep.gbc.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.HistoActionSHistoConSDto;
import com.sigep.gbc.dto.requestDto.HistoActionSRequestDto;
import com.sigep.gbc.dto.responseDto.HistoActionSResponseDto;
import com.sigep.gbc.entity.HistoActionS;


@Service
public interface HistoActionSService {
	public HistoActionSResponseDto add(HistoActionSRequestDto histoActionSRequestDto);
	public List<HistoActionSResponseDto> getAll();
	public HistoActionS get(Date dateAct, String codH);
	public HistoActionSResponseDto getById(Date dateAct, String codH);
	public List<HistoActionSHistoConSDto> getHistoActionSHistoConS();
}
