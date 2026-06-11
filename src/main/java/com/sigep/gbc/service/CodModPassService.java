package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.CodModPassRequestDto;
import com.sigep.gbc.dto.responseDto.CodModPassResponseDto;
import com.sigep.gbc.entity.CodModPass;


@Service
public interface CodModPassService {
	public CodModPassResponseDto add(CodModPassRequestDto codModPassRequestDto);
	public List<CodModPassResponseDto> getAll();
	public CodModPass get(String id);
	public CodModPassResponseDto getById(String id);
	public CodModPassResponseDto delete(String id);
	public CodModPassResponseDto edit(String id, CodModPassRequestDto codModPassRequestDto);
}
