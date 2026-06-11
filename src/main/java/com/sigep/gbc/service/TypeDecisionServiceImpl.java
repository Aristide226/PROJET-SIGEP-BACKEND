package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.TypeDecisionRequestDto;
import com.sigep.gbc.dto.responseDto.TypeDecisionResponseDto;
import com.sigep.gbc.entity.TypeDecision;
import com.sigep.gbc.repository.TypeDecisionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeDecisionServiceImpl implements TypeDecisionService {
	
	private final TypeDecisionRepository repository;
	
	@Override
	@Transactional("gbcTransactionManager")
	public TypeDecisionResponseDto add(TypeDecisionRequestDto typeDecisionRequestDto) {
		TypeDecision entity = new TypeDecision();
		entity.setLibelle(typeDecisionRequestDto.getLibelle());
		repository.save(entity);
		return GbcMapper.tdToTdResponseDto(entity);
	}
	
	@Override
	public List<TypeDecisionResponseDto> getAll() {
		List<TypeDecision> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.tdToTdResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public TypeDecision get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("TypeDecision with id: " + id + " could not be found"));
	}
	
	@Override
	public TypeDecisionResponseDto getById(Integer id) {
		TypeDecision entity = get(id);
		return GbcMapper.tdToTdResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public TypeDecisionResponseDto delete(Integer id) {
		TypeDecision entity = get(id);
		repository.delete(entity);
		return GbcMapper.tdToTdResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public TypeDecisionResponseDto edit(Integer id, TypeDecisionRequestDto typeDecisionRequestDto) {
		TypeDecision entity = get(id);
		entity.setLibelle(typeDecisionRequestDto.getLibelle());
		return GbcMapper.tdToTdResponseDto(entity);
	}
}
