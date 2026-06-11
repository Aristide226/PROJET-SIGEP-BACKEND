package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.BudgetTypeRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetTypeResponseDto;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.repository.BudgetTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BudgetTypeServiceImpl implements BudgetTypeService{
	
	private final BudgetTypeRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetTypeResponseDto add(BudgetTypeRequestDto budgetTypeRequestDto) {
		BudgetType entity = new BudgetType();
		entity.setLibelleBudget(budgetTypeRequestDto.getLibelleBudget());
		entity.setLibelleDecision(budgetTypeRequestDto.getLibelleDecision());
		repository.save(entity);
		return GbcMapper.btToBtResponseDto(entity);
	}

	@Override
	public List<BudgetTypeResponseDto> getAll() {
		List<BudgetType> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.btToBtResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public BudgetType get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("BudgetType with id: " + id + " could not be found"));
	}

	@Override
	public BudgetTypeResponseDto getById(Integer id) {
		BudgetType entity = get(id);
		return GbcMapper.btToBtResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetTypeResponseDto delete(Integer id) {
		BudgetType entity = get(id);
		repository.delete(entity);
		return GbcMapper.btToBtResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetTypeResponseDto edit(Integer id, BudgetTypeRequestDto budgetTypeRequestDto) {
		BudgetType entity = get(id);
		entity.setLibelleBudget(budgetTypeRequestDto.getLibelleBudget());
		entity.setLibelleDecision(budgetTypeRequestDto.getLibelleDecision());
		return GbcMapper.btToBtResponseDto(entity);
	}

	
}
