package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.IdentiteExecutionRequestDto;
import com.sigep.gbc.dto.responseDto.IdentiteExecutionResponseDto;
import com.sigep.gbc.entity.IdentiteExecution;
import com.sigep.gbc.repository.IdentiteExecutionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdentiteExecutionServiceImpl implements IdentiteExecutionService{
	
	private final IdentiteExecutionRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public IdentiteExecutionResponseDto add(IdentiteExecutionRequestDto identiteExecutionRequestDto) {
		IdentiteExecution entity = new IdentiteExecution();
		entity.setCodIdentiteExecution(identiteExecutionRequestDto.getCodIdentiteExecution());
		entity.setIntitule(identiteExecutionRequestDto.getIntitule());
		
		repository.save(entity);
		return GbcMapper2.identiteExecutionToIdentiteExecutionResponseDto(entity);
	}

	@Override
	public List<IdentiteExecutionResponseDto> getAll() {
		List<IdentiteExecution> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.identiteExecutionToIdentiteExecutionResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public IdentiteExecution get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("IdentiteExecution with id: " + id + " could not be found"));
	}

	@Override
	public IdentiteExecutionResponseDto getById(String id) {
		IdentiteExecution entity = get(id);
		return GbcMapper2.identiteExecutionToIdentiteExecutionResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public IdentiteExecutionResponseDto delete(String id) {
		IdentiteExecution entity = get(id);
		repository.delete(entity);
		return GbcMapper2.identiteExecutionToIdentiteExecutionResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public IdentiteExecutionResponseDto edit(String id, IdentiteExecutionRequestDto identiteExecutionRequestDto) {
		IdentiteExecution entity = get(id);
		entity.setIntitule(identiteExecutionRequestDto.getIntitule());
		return GbcMapper2.identiteExecutionToIdentiteExecutionResponseDto(entity);
	}
}
