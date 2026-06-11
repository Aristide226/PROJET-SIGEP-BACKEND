package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.CodSourceFinRequestDto;
import com.sigep.gbc.dto.responseDto.CodSourceFinResponseDto;
import com.sigep.gbc.entity.CodSourceFin;
import com.sigep.gbc.repository.CodSourceFinRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodSourceFinServiceImpl implements CodSourceFinService{
	
	private final CodSourceFinRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public CodSourceFinResponseDto add(CodSourceFinRequestDto codSourceFinRequestDto) {
		CodSourceFin entity = new CodSourceFin();
		entity.setCod5(codSourceFinRequestDto.getCod5());
		entity.setIntituleCourt(codSourceFinRequestDto.getIntituleCourt());
		entity.setAbrev(codSourceFinRequestDto.getAbrev());
		entity.setIntituleLong(codSourceFinRequestDto.getIntituleLong());
		
		repository.save(entity);
		return GbcMapper2.codSourceFinToCodSourceFinResponseDto(entity);
	}

	@Override
	public List<CodSourceFinResponseDto> getAll() {
		List<CodSourceFin> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.codSourceFinToCodSourceFinResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public CodSourceFin get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("CodSourceFin with id: " + id + " could not be found"));
	}

	@Override
	public CodSourceFinResponseDto getById(String id) {
		CodSourceFin entity = get(id);
		return GbcMapper2.codSourceFinToCodSourceFinResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public CodSourceFinResponseDto delete(String id) {
		CodSourceFin entity = get(id);
		repository.delete(entity);
		return GbcMapper2.codSourceFinToCodSourceFinResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public CodSourceFinResponseDto edit(String id, CodSourceFinRequestDto codSourceFinRequestDto) {
		CodSourceFin entity = get(id);
		entity.setIntituleCourt(codSourceFinRequestDto.getIntituleCourt());
		entity.setAbrev(codSourceFinRequestDto.getAbrev());
		entity.setIntituleLong(codSourceFinRequestDto.getIntituleLong());
		return GbcMapper2.codSourceFinToCodSourceFinResponseDto(entity);
	}
}
