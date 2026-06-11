package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PatrimoineBatimentsRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineBatimentsResponseDto;
import com.sigep.gim.entity.PatrimoineBatiments;

@Service
public interface GimPatrimoineBatimentsService {
	public PatrimoineBatimentsResponseDto add(PatrimoineBatimentsRequestDto patrimoineBatimentsRequestDto);
	public List<PatrimoineBatimentsResponseDto> getAll();
	public PatrimoineBatiments get(String id);
	public PatrimoineBatimentsResponseDto getById(String id);
	public PatrimoineBatimentsResponseDto delete(String id);
	public PatrimoineBatimentsResponseDto edit(String id, PatrimoineBatimentsRequestDto patrimoineBatimentsRequestDto);
}