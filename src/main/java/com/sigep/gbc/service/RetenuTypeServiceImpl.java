package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.RetenuTypeDto;
import com.sigep.gbc.entity.RetenuType;
import com.sigep.gbc.repository.RetenuTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RetenuTypeServiceImpl implements RetenuTypeService {
	
	private final RetenuTypeRepository repository;
	private final RetenueCategorieService rcService;
	private final CompteService cService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public RetenuTypeDto add(RetenuTypeDto retenuTypeDto) {
		RetenuType entity = new RetenuType();
		entity.setLibelle(retenuTypeDto.getLibelle());
		entity.setTaux(retenuTypeDto.getTaux());
		entity.setCompte(cService.get(retenuTypeDto.getCodCpte()));
		entity.setRetenueCategorie(rcService.get(retenuTypeDto.getIdCategorie()));
		
		repository.insert(
				retenuTypeDto.getLibelle(),
				retenuTypeDto.getTaux(),
				retenuTypeDto.getCodCpte(),
				retenuTypeDto.getIdCategorie());
		return GbcMapper.RtToRtResponseDto(entity);
	}
	
	@Override
	public List<RetenuTypeDto> getAll() {
		List<RetenuType> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.RtToRtResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public RetenuType get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("RetenuType with id: " + id + " could not be found"));
	}
	
	@Override
	public RetenuTypeDto getById(Integer id) {
		RetenuType entity = get(id);
		return GbcMapper.RtToRtResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public RetenuTypeDto delete(Integer id) {
		RetenuType entity = get(id);
		repository.delete(entity);
		return GbcMapper.RtToRtResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public RetenuTypeDto edit(Integer id, RetenuTypeDto retenuTypeDto) {
		repository.update(
				retenuTypeDto.getLibelle(),
				retenuTypeDto.getTaux(),
				retenuTypeDto.getCodCpte(),
				retenuTypeDto.getIdCategorie(),
				id);
		RetenuType entity = get(id);
		return GbcMapper.RtToRtResponseDto(entity);
	}
	
}
