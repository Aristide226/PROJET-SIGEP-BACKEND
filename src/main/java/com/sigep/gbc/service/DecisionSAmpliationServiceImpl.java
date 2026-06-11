package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.DecisionSAmpliationRequestDto;
import com.sigep.gbc.dto.responseDto.DecisionSAmpliationResponseDto;
import com.sigep.gbc.entity.DecisionSampliation;
import com.sigep.gbc.repository.DecisionSAmpliationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DecisionSAmpliationServiceImpl implements DecisionSAmpliationService {
	
	private final DecisionSAmpliationRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public DecisionSAmpliationResponseDto add(DecisionSAmpliationRequestDto decisionSAmpliationRequestDto) {
		DecisionSampliation entity = new DecisionSampliation();
		entity.setAmpliataire(decisionSAmpliationRequestDto.getAmpliataire());
		entity.setAmpliataireReam(decisionSAmpliationRequestDto.getAmpliataireReam());
		
		repository.save(entity);
		return GbcMapper.dsamToDsamDto(entity);
	}

	@Override
	public List<DecisionSAmpliationResponseDto> getAll() {
		List<DecisionSampliation> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.dsamToDsamDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public DecisionSampliation get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("DecisionSampliation with id: " + id + " could not be found"));
	}

	@Override
	public DecisionSAmpliationResponseDto getById(Integer id) {
		DecisionSampliation entity = get(id);
		return GbcMapper.dsamToDsamDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public DecisionSAmpliationResponseDto delete(Integer id) {
		DecisionSampliation entity = get(id);
		repository.delete(entity);
		return GbcMapper.dsamToDsamDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public DecisionSAmpliationResponseDto edit(Integer id, DecisionSAmpliationRequestDto decisionSAmpliationRequestDto) {
		DecisionSampliation entity = get(id);
		entity.setAmpliataire(decisionSAmpliationRequestDto.getAmpliataire());
		entity.setAmpliataireReam(decisionSAmpliationRequestDto.getAmpliataireReam());
		return GbcMapper.dsamToDsamDto(entity);
	}
}
