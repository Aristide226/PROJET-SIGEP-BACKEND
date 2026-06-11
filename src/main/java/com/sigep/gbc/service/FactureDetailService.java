package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.FactureDetailRequestDto;
import com.sigep.gbc.dto.responseDto.FactureDetailResponseDto;
import com.sigep.gbc.entity.FactureDetail;


@Service
public interface FactureDetailService {
	public FactureDetailResponseDto add(FactureDetailRequestDto factureDetailRequestDto);
	public List<FactureDetailResponseDto> getAll();
	public FactureDetail get(String id);
	public FactureDetailResponseDto getById(String id);
	public FactureDetailResponseDto delete(String id);
	public FactureDetailResponseDto edit(String id, FactureDetailRequestDto factureDetailRequestDto);
}
