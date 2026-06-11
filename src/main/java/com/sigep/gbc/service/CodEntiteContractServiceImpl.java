package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.CodEntiteContractRequestDto;
import com.sigep.gbc.dto.responseDto.CodEntiteContractResponseDto;
import com.sigep.gbc.entity.CodEntiteContract;
import com.sigep.gbc.repository.CodEntiteContractRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodEntiteContractServiceImpl implements CodEntiteContractService{
	
	private final CodEntiteContractRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public CodEntiteContractResponseDto add(CodEntiteContractRequestDto codEntiteContractRequestDto) {
		CodEntiteContract entity = new CodEntiteContract();
		entity.setCod2(codEntiteContractRequestDto.getCod2());
		entity.setIntitule(codEntiteContractRequestDto.getIntitule());
		
		repository.save(entity);
		return GbcMapper2.codEntiteContractToCodEntiteContractResponseDto(entity);
	}

	@Override
	public List<CodEntiteContractResponseDto> getAll() {
		List<CodEntiteContract> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.codEntiteContractToCodEntiteContractResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public CodEntiteContract get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("CodEntiteContract with id: " + id + " could not be found"));
	}

	@Override
	public CodEntiteContractResponseDto getById(String id) {
		CodEntiteContract entity = get(id);
		return GbcMapper2.codEntiteContractToCodEntiteContractResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public CodEntiteContractResponseDto delete(String id) {
		CodEntiteContract entity = get(id);
		repository.delete(entity);
		return GbcMapper2.codEntiteContractToCodEntiteContractResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public CodEntiteContractResponseDto edit(String id, CodEntiteContractRequestDto codEntiteContractRequestDto) {
		CodEntiteContract entity = get(id);
		entity.setIntitule(codEntiteContractRequestDto.getIntitule());
		return GbcMapper2.codEntiteContractToCodEntiteContractResponseDto(entity);
	}
}
