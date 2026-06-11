package com.sigep.common.histoGbk.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.common.histoGbk.dto.requestDto.BudgetTypeRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.BudgetTypeResponseDto;
import com.sigep.common.histoGbk.entity.BudgetType;
import com.sigep.common.histoGbk.repository.HistoGbkBudgetTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoGbkBudgetTypeServiceImpl implements HistoGbkBudgetTypeService {
	
	private final HistoGbkBudgetTypeRepository repository;
	private final ModelMapper modelMapper;

	@Override
	@Transactional("histoGbkTransactionManager")
	public BudgetTypeResponseDto add(BudgetTypeRequestDto budgetTypeRequestDto) {
		BudgetType entity = new BudgetType();
		entity.setLibelleBudget(budgetTypeRequestDto.getLibelleBudget());
		entity.setLibelleDecision(budgetTypeRequestDto.getLibelleDecision());
		repository.save(entity);
		return modelMapper.map(entity, BudgetTypeResponseDto.class);
	}

	@Override
	public List<BudgetTypeResponseDto> getAll() {
		List<BudgetType> list = repository.findAll();
		return list
				.stream().map(element  -> modelMapper.map(element, BudgetTypeResponseDto.class))
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
		return modelMapper.map(entity, BudgetTypeResponseDto.class);
	}

	@Override
	@Transactional("histoGbkTransactionManager")
	public BudgetTypeResponseDto delete(Integer id) {
		BudgetType entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, BudgetTypeResponseDto.class);
	}

	@Override
	@Transactional("histoGbkTransactionManager")
	public BudgetTypeResponseDto edit(Integer id, BudgetTypeRequestDto budgetTypeRequestDto) {
		BudgetType entity = get(id);
		entity.setLibelleBudget(budgetTypeRequestDto.getLibelleBudget());
		entity.setLibelleDecision(budgetTypeRequestDto.getLibelleDecision());
		return modelMapper.map(entity, BudgetTypeResponseDto.class);
	}

	
}
