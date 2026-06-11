package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.PpmProcedureRequestDto;
import com.sigep.gbc.dto.responseDto.PpmProcedureResponseDto;
import com.sigep.gbc.entity.PpmProcedure;
import com.sigep.gbc.repository.PpmProcedureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PpmProcedureServiceImpl implements PpmProcedureService{
	
	private final PpmProcedureRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public PpmProcedureResponseDto add(PpmProcedureRequestDto ppmProcedureRequestDto) {
		PpmProcedure entity = new PpmProcedure();
		entity.setIdProc(ppmProcedureRequestDto.getIdProc());
		entity.setLibProcedure(ppmProcedureRequestDto.getLibProcedure());
		
		repository.save(entity);
		return GbcMapper2.ppmProcedureToPpmProcedureResponseDto(entity);
	}

	@Override
	public List<PpmProcedureResponseDto> getAll() {
		List<PpmProcedure> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.ppmProcedureToPpmProcedureResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public PpmProcedure get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("PpmProcedure with id: " + id + " could not be found"));
	}

	@Override
	public PpmProcedureResponseDto getById(Integer id) {
		PpmProcedure entity = get(id);
		return GbcMapper2.ppmProcedureToPpmProcedureResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public PpmProcedureResponseDto delete(Integer id) {
		PpmProcedure entity = get(id);
		repository.delete(entity);
		return GbcMapper2.ppmProcedureToPpmProcedureResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public PpmProcedureResponseDto edit(Integer id, PpmProcedureRequestDto ppmProcedureRequestDto) {
		PpmProcedure entity = get(id);
		entity.setLibProcedure(ppmProcedureRequestDto.getLibProcedure());
		return GbcMapper2.ppmProcedureToPpmProcedureResponseDto(entity);
	}
}
