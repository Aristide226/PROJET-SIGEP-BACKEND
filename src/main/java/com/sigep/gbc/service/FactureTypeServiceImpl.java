package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.FactureTypeRequestDto;
import com.sigep.gbc.dto.responseDto.FactureTypeResponseDto;
import com.sigep.gbc.entity.FactureType;
import com.sigep.gbc.repository.FactureTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FactureTypeServiceImpl implements FactureTypeService{
	
	private final FactureTypeRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public FactureTypeResponseDto add(FactureTypeRequestDto factureTypeRequestDto) {
		FactureType entity = new FactureType();
		entity.setIdTypFact(factureTypeRequestDto.getIdTypFact());
		entity.setLibelleTypFact(factureTypeRequestDto.getLibelleTypFact());
		
		repository.save(entity);
		return GbcMapper.factureTypeToFactureTypeResponseDto(entity);
	}

	@Override
	public List<FactureTypeResponseDto> getAll() {
		List<FactureType> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.factureTypeToFactureTypeResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public FactureType get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("FactureType with id: " + id + " could not be found"));
	}

	@Override
	public FactureTypeResponseDto getById(String id) {
		FactureType entity = get(id);
		return GbcMapper.factureTypeToFactureTypeResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public FactureTypeResponseDto delete(String id) {
		FactureType entity = get(id);
		repository.delete(entity);
		return GbcMapper.factureTypeToFactureTypeResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public FactureTypeResponseDto edit(String id, FactureTypeRequestDto factureTypeRequestDto) {
		FactureType entity = get(id);
		entity.setLibelleTypFact(factureTypeRequestDto.getLibelleTypFact());
		return GbcMapper.factureTypeToFactureTypeResponseDto(entity);
	}
}
