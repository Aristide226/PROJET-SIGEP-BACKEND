package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.DecisionSVisaDto;
import com.sigep.gbc.entity.DecisionSvisa;
import com.sigep.gbc.entity.TypeDecision;
import com.sigep.gbc.repository.DecisionSVisaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DecisionSVisaServiceImpl implements DecisionSVisaService {
	
	private final DecisionSVisaRepository repository;
	private final TypeDecisionService tdService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public DecisionSVisaDto add(DecisionSVisaDto decisionSVisaRequestDto) {
		DecisionSvisa entity = new DecisionSvisa();
		entity.setRangVisa(decisionSVisaRequestDto.getRangVisa());
		entity.setLibelleVisa(decisionSVisaRequestDto.getLibelleVisa());
		
		if (decisionSVisaRequestDto.getIdType() == null) {
			throw new IllegalArgumentException("DecisionSVisa need a TypeDecision");
		}
		TypeDecision typeDecision = tdService.get(decisionSVisaRequestDto.getIdType());
		entity.setTypeDecision(typeDecision);
		
		repository.save(entity);
		return GbcMapper.dsvToDsvDto(entity);
	}
	
	@Override
	public List<DecisionSVisaDto> getAll() {
		List<DecisionSvisa> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.dsvToDsvDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public DecisionSvisa get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("DecisionSvisa with id: " + id + " could not be found"));
	}
	
	@Override
	public DecisionSVisaDto getById(Integer id) {
		DecisionSvisa entity = get(id);
		return GbcMapper.dsvToDsvDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public DecisionSVisaDto delete(Integer id) {
		DecisionSvisa entity = get(id);
		repository.delete(entity);
		return GbcMapper.dsvToDsvDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public DecisionSVisaDto edit(Integer newId, Integer oldId, DecisionSVisaDto decisionSVisaRequestDto) {
		repository.update(
				newId,
				oldId, 
				decisionSVisaRequestDto.getLibelleVisa(), 
				decisionSVisaRequestDto.getIdType()
			);
		
		DecisionSvisa entity = get(newId);
		return GbcMapper.dsvToDsvDto(entity);
	}

	@Override
	public Boolean existsById(Integer id) {
		return repository.existsById(id);
	}
}
