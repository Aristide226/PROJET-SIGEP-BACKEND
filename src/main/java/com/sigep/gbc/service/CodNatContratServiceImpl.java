package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.CodNatContratRequestDto;
import com.sigep.gbc.dto.responseDto.CodNatContratResponseDto;
import com.sigep.gbc.entity.CodNatContrat;
import com.sigep.gbc.repository.CodNatContratRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodNatContratServiceImpl implements CodNatContratService{
	
	private final CodNatContratRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public CodNatContratResponseDto add(CodNatContratRequestDto codNatContratRequestDto) {
		CodNatContrat entity = new CodNatContrat();
		entity.setCod3(codNatContratRequestDto.getCod3());
		entity.setIntitule(codNatContratRequestDto.getIntitule());
		
		repository.save(entity);
		return GbcMapper2.codNatContratToCodNatContratResponseDto(entity);
	}

	@Override
	public List<CodNatContratResponseDto> getAll() {
		List<CodNatContrat> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.codNatContratToCodNatContratResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public CodNatContrat get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("CodNatContrat with id: " + id + " could not be found"));
	}

	@Override
	public CodNatContratResponseDto getById(String id) {
		CodNatContrat entity = get(id);
		return GbcMapper2.codNatContratToCodNatContratResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public CodNatContratResponseDto delete(String id) {
		CodNatContrat entity = get(id);
		repository.delete(entity);
		return GbcMapper2.codNatContratToCodNatContratResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public CodNatContratResponseDto edit(String id, CodNatContratRequestDto codNatContratRequestDto) {
		CodNatContrat entity = get(id);
		entity.setIntitule(codNatContratRequestDto.getIntitule());
		return GbcMapper2.codNatContratToCodNatContratResponseDto(entity);
	}
}
