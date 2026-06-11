package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.ProcedureRequestDto;
import com.sigep.gbc.dto.responseDto.ProcedureResponseDto;
import com.sigep.gbc.entity.Procedures;
import com.sigep.gbc.repository.ProcedureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProcedureServiceImpl implements ProcedureService{
	
	private final ProcedureRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public ProcedureResponseDto add(ProcedureRequestDto procedureRequestDto) {
		Procedures entity = new Procedures();
		entity.setProced(procedureRequestDto.getProced());
		entity.setLibProced(procedureRequestDto.getLibProced());
		
		repository.save(entity);
		return GbcMapper.proToProResponseDto(entity);
	}

	@Override
	public List<ProcedureResponseDto> getAll() {
		List<Procedures> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.proToProResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public Procedures get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Procedure with id: " + id + " could not be found"));
	}

	@Override
	public ProcedureResponseDto getById(String id) {
		Procedures entity = get(id);
		return GbcMapper.proToProResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public ProcedureResponseDto delete(String id) {
		Procedures entity = get(id);
		repository.delete(entity);
		return GbcMapper.proToProResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public ProcedureResponseDto edit(String id, ProcedureRequestDto procedureRequestDto) {
		Procedures entity = get(id);
		entity.setLibProced(procedureRequestDto.getLibProced());
		return GbcMapper.proToProResponseDto(entity);
	}
}
