package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sigep.gbc.dto.requestDto.FacturesRequestDto;
import com.sigep.gbc.dto.responseDto.FacturesResponseDto;
import com.sigep.gbc.entity.Factures;


@Service
public interface FacturesService {
	public FacturesResponseDto add(FacturesRequestDto facturesRequestDto);
	public List<FacturesResponseDto> getAll();
	public Factures get(Long id);
	public FacturesResponseDto getById(Long id);
	public FacturesResponseDto delete(Long id);
	public FacturesResponseDto edit(Long id, FacturesRequestDto facturesRequestDto);
}
