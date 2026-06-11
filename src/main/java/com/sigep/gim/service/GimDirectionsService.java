package com.sigep.gim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.DirectionsRequestDto;
import com.sigep.gim.dto.responseDto.DirectionsResponseDto;
import com.sigep.gim.entity.Directions;

@Service
public interface GimDirectionsService {
	public DirectionsResponseDto add(DirectionsRequestDto directionsRequestDto);
	public List<DirectionsResponseDto> getAll();
	public Directions get(int id);
	public DirectionsResponseDto getById(int id);
	public DirectionsResponseDto delete(int id);
	public DirectionsResponseDto edit(int id, DirectionsRequestDto directionsRequestDto);
}
