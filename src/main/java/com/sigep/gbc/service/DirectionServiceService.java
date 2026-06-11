package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.DirectionServiceRequestDto;
import com.sigep.gbc.dto.responseDto.DirectionServiceResponseDto;
import com.sigep.gbc.entity.DirectionService;


@Service
public interface DirectionServiceService {
	public DirectionServiceResponseDto add(DirectionServiceRequestDto directionServiceRequestDto);
	public List<DirectionServiceResponseDto> getAll();
	public DirectionService get(Integer id);
	public DirectionServiceResponseDto getById(Integer id);
	public DirectionServiceResponseDto delete(Integer id);
	public DirectionServiceResponseDto edit(Integer id, DirectionServiceRequestDto directionServiceRequestDto);
}
