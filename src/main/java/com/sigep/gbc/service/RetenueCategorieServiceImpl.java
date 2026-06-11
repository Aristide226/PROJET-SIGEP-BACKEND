package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.RetenueCategorieRequestDto;
import com.sigep.gbc.dto.responseDto.RetenueCategorieResponseDto;
import com.sigep.gbc.entity.RetenueCategorie;
import com.sigep.gbc.repository.RetenueCategorieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RetenueCategorieServiceImpl implements RetenueCategorieService {
	
	private final RetenueCategorieRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public RetenueCategorieResponseDto add(RetenueCategorieRequestDto requestDto) {
		RetenueCategorie entity = new RetenueCategorie();
		entity.setIdCategorie(requestDto.getIdCategorie());
		entity.setLibelle(requestDto.getLibelle());
		repository.save(entity);
		return GbcMapper.RcToRcResponseDto(entity);
	}

	@Override
	public List<RetenueCategorieResponseDto> getAll() {
		List<RetenueCategorie> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.RcToRcResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public RetenueCategorie get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("RetenueCategorie with id: " + id + " could not be found"));
	}

	@Override
	public RetenueCategorieResponseDto getById(String id) {
		RetenueCategorie entity = get(id);
		return GbcMapper.RcToRcResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public RetenueCategorieResponseDto delete(String id) {
		RetenueCategorie entity = get(id);
		repository.delete(entity);
		return GbcMapper.RcToRcResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public RetenueCategorieResponseDto edit(String id, RetenueCategorieRequestDto requestDto) {
		RetenueCategorie entity = get(id);
		entity.setLibelle(requestDto.getLibelle());
		return GbcMapper.RcToRcResponseDto(entity);
	}	
}
