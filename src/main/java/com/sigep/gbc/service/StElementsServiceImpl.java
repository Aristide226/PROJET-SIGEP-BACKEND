package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.StElementsRequestDto;
import com.sigep.gbc.dto.responseDto.StElementsResponseDto;
import com.sigep.gbc.entity.StElements;
import com.sigep.gbc.repository.StElementsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StElementsServiceImpl implements StElementsService {
	
	private final StElementsRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public StElementsResponseDto add(StElementsRequestDto stElementsRequestDto) {
		StElements entity = new StElements();
		entity.setPartie(stElementsRequestDto.getPartie());
		entity.setRangStElts(stElementsRequestDto.getRangStElts());
		entity.setLibelleStElts(stElementsRequestDto.getLibelleStElts());
		entity.setCompletLib(stElementsRequestDto.getCompletLib());
		repository.save(entity);
		return GbcMapper.steToSteResponseDto(entity);
	}

	@Override
	public List<StElementsResponseDto> getAll() {
		List<StElements> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.steToSteResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public StElements get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("StElements with id: " + id + " could not be found"));
	}

	@Override
	public StElementsResponseDto getById(String id) {
		StElements entity = get(id);
		return GbcMapper.steToSteResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public StElementsResponseDto delete(String id) {
		StElements entity = get(id);
		repository.delete(entity);
		return GbcMapper.steToSteResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public StElementsResponseDto edit(String id, StElementsRequestDto stElementsRequestDto) {
		StElements entity = get(id);
		entity.setPartie(stElementsRequestDto.getPartie());
		entity.setRangStElts(stElementsRequestDto.getRangStElts());
		entity.setLibelleStElts(stElementsRequestDto.getLibelleStElts());
		entity.setCompletLib(stElementsRequestDto.getCompletLib());
		return GbcMapper.steToSteResponseDto(entity);
	}
	
}
