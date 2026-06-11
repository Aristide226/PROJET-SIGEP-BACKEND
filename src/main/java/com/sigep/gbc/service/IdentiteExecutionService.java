package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sigep.gbc.dto.requestDto.IdentiteExecutionRequestDto;
import com.sigep.gbc.dto.responseDto.IdentiteExecutionResponseDto;
import com.sigep.gbc.entity.IdentiteExecution;


@Service
public interface IdentiteExecutionService {
	public IdentiteExecutionResponseDto add(IdentiteExecutionRequestDto identiteExecutionRequestDto);
	public List<IdentiteExecutionResponseDto> getAll();
	public IdentiteExecution get(String id);
	public IdentiteExecutionResponseDto getById(String id);
	public IdentiteExecutionResponseDto delete(String id);
	public IdentiteExecutionResponseDto edit(String id, IdentiteExecutionRequestDto identiteExecutionRequestDto);
}
