package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.DirectionServiceNiveauRequestDto;
import com.sigep.gbc.dto.responseDto.DirectionServiceNiveauResponseDto;
import com.sigep.gbc.entity.DirectionServiceNiveau;


@Service
public interface DirectionServiceNiveauService {
	public DirectionServiceNiveauResponseDto add(DirectionServiceNiveauRequestDto directionServiceNiveauRequestDto);
	public List<DirectionServiceNiveauResponseDto> getAll();
	public DirectionServiceNiveau get(Integer id);
	public DirectionServiceNiveauResponseDto getById(Integer id);
	public DirectionServiceNiveauResponseDto delete(Integer id);
	public DirectionServiceNiveauResponseDto edit(Integer id, DirectionServiceNiveauRequestDto directionServiceNiveauRequestDto);
}
