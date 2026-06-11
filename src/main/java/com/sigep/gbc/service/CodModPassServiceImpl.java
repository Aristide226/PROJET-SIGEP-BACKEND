package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.CodModPassRequestDto;
import com.sigep.gbc.dto.responseDto.CodModPassResponseDto;
import com.sigep.gbc.entity.CodModPass;
import com.sigep.gbc.entity.PpmProcedure;
import com.sigep.gbc.repository.CodModPassRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodModPassServiceImpl implements CodModPassService{
	
	private final CodModPassRepository repository;
	private final PpmProcedureService ppmProcedureService;

	@Override
	@Transactional("gbcTransactionManager")
	public CodModPassResponseDto add(CodModPassRequestDto codModPassRequestDto) {
		CodModPass entity = new CodModPass();
		entity.setCod4(codModPassRequestDto.getCod4());
		entity.setIntitule(codModPassRequestDto.getIntitule());
		entity.setLibelleCourt(codModPassRequestDto.getLibelleCourt());
		
		if (codModPassRequestDto.getIdProc() == null) {
			throw new IllegalArgumentException("CodModPass need a PpmProcedure");
		}
		PpmProcedure ppmProcedure = ppmProcedureService.get(codModPassRequestDto.getIdProc());
		entity.setPpmProcedure(ppmProcedure);
		
		repository.save(entity);
		return GbcMapper2.codModPassToCodModPassResponseDto(entity);
	}

	@Override
	public List<CodModPassResponseDto> getAll() {
		List<CodModPass> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.codModPassToCodModPassResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public CodModPass get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("CodModPass with id: " + id + " could not be found"));
	}

	@Override
	public CodModPassResponseDto getById(String id) {
		CodModPass entity = get(id);
		return GbcMapper2.codModPassToCodModPassResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public CodModPassResponseDto delete(String id) {
		CodModPass entity = get(id);
		repository.delete(entity);
		return GbcMapper2.codModPassToCodModPassResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public CodModPassResponseDto edit(String id, CodModPassRequestDto codModPassRequestDto) {
		CodModPass entity = get(id);
		entity.setIntitule(codModPassRequestDto.getIntitule());
		entity.setLibelleCourt(codModPassRequestDto.getLibelleCourt());
		
		if (codModPassRequestDto.getIdProc() != null) {
			PpmProcedure ppmProcedure = ppmProcedureService.get(codModPassRequestDto.getIdProc());
			entity.setPpmProcedure(ppmProcedure);
		}
		
		return GbcMapper2.codModPassToCodModPassResponseDto(entity);
	}
}
