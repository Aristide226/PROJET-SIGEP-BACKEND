package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.AgentsRequestDto;
import com.sigep.gbc.dto.responseDto.AgentsResponseDto;
import com.sigep.gbc.entity.Agents;


@Service
public interface AgentsService {
	public AgentsResponseDto add(AgentsRequestDto agentsRequestDto);
	public List<AgentsResponseDto> getAll();
	public Agents get(Long id);
	public AgentsResponseDto getById(Long id);
	public AgentsResponseDto delete(Long id);
	public AgentsResponseDto edit(Long id, AgentsRequestDto agentsRequestDto);
}
