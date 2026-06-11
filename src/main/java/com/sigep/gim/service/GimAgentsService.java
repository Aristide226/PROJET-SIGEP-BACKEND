package com.sigep.gim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.AgentsRequestDto;
import com.sigep.gim.dto.responseDto.AgentsResponseDto;
import com.sigep.gim.entity.Agents;

@Service
public interface GimAgentsService {
	public AgentsResponseDto add(AgentsRequestDto agentsRequestDto);
	public List<AgentsResponseDto> getAll();
	public Agents get(String id);
	public AgentsResponseDto getById(String id);
	public AgentsResponseDto delete(String id);
	public AgentsResponseDto edit(String id , AgentsRequestDto agentsRequestDto);
}
