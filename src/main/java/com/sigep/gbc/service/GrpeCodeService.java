package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.GrpeCodeRequestDto;
import com.sigep.gbc.dto.responseDto.GrpeCodeResponseDto;
import com.sigep.gbc.entity.GrpeCode;


@Service
public interface GrpeCodeService {
	public GrpeCodeResponseDto add(GrpeCodeRequestDto grpeCodeRequestDto);
	public List<GrpeCodeResponseDto> getAll();
	public GrpeCode get(String id);
	public GrpeCodeResponseDto getById(String id);
	public GrpeCodeResponseDto delete(String id);
	public GrpeCodeResponseDto edit(String id, GrpeCodeRequestDto grpeCodeRequestDto);
}
