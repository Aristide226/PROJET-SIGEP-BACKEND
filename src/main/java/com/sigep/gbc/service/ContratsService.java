package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.ContratsRequestDto;
import com.sigep.gbc.dto.responseDto.ContratsResponseDto;
import com.sigep.gbc.entity.Contrats;


@Service
public interface ContratsService {
	public ContratsResponseDto add(ContratsRequestDto contratsRequestDto);
	public List<ContratsResponseDto> getAll();
	public Contrats get(Long id);
	public ContratsResponseDto getById(Long id);
	public ContratsResponseDto delete(Long id);
	public ContratsResponseDto edit(Long id, ContratsRequestDto contratsRequestDto);
}
