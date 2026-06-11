package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.RecettesPourMajBudgetView;
import com.sigep.gbc.view.dto.RecettesPourMajBudgetViewDto;
import com.sigep.gbc.view.repository.RecettesPourMajBudgetViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class RecettesPourMajBudgetViewServiceImpl implements RecettesPourMajBudgetViewService{
	private final RecettesPourMajBudgetViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<RecettesPourMajBudgetViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget) {
		List<RecettesPourMajBudgetView> list = repository.findByGestionAndIdBudget(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, RecettesPourMajBudgetViewDto.class))
				.collect(Collectors.toList());
	}
}
