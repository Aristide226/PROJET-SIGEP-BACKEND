package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PjRequestDto;
import com.sigep.gbc.dto.responseDto.PjResponseDto;
import com.sigep.gbc.entity.Pj;


@Service
public interface PjService {
	public PjResponseDto add(PjRequestDto pjRequestDto);
	public List<PjResponseDto> getAll();
	public Pj get(Integer id);
	public PjResponseDto getById(Integer id);
	public PjResponseDto delete(Integer id);
	public PjResponseDto edit(Integer id, PjRequestDto pjRequestDto);
}
