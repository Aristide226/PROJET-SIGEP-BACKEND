package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.responseDto.ContratTypeResponseDto;
import com.sigep.gbc.entity.ContratType;
import com.sigep.gbc.repository.ContratTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContratTypeServiceImpl implements ContratTypeService{
	
	private final ContratTypeRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public ContratTypeResponseDto add(ContratTypeResponseDto contratTypeResponseDto) {
		ContratType entity = new ContratType();
		entity.setTypeContrat(contratTypeResponseDto.getTypeContrat());
		entity.setLibelle(contratTypeResponseDto.getLibelle());
		entity.setAvecMiniMax(contratTypeResponseDto.getAvecMiniMax());
		
		repository.save(entity);
		return GbcMapper2.contratTypeToContratTypeResponseDto(entity);
	}

	@Override
	public List<ContratTypeResponseDto> getAll() {
		List<ContratType> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.contratTypeToContratTypeResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public ContratType get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("ContratType with id: " + id + " could not be found"));
	}

	@Override
	public ContratTypeResponseDto getById(String id) {
		ContratType entity = get(id);
		return GbcMapper2.contratTypeToContratTypeResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public ContratTypeResponseDto delete(String id) {
		ContratType entity = get(id);
		repository.delete(entity);
		return GbcMapper2.contratTypeToContratTypeResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public ContratTypeResponseDto edit(String id, ContratTypeResponseDto contratTypeResponseDto) {
		ContratType entity = get(id);
		entity.setLibelle(contratTypeResponseDto.getLibelle());
		entity.setAvecMiniMax(contratTypeResponseDto.getAvecMiniMax());
		return GbcMapper2.contratTypeToContratTypeResponseDto(entity);
	}
}
