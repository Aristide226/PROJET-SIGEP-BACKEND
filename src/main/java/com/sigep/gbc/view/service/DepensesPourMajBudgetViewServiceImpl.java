package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.DepensesPourMajBudgetView;
import com.sigep.gbc.view.dto.DepensesPourMajBudgetViewDto;
import com.sigep.gbc.view.repository.DepensesPourMajBudgetViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class DepensesPourMajBudgetViewServiceImpl implements DepensesPourMajBudgetViewService{
	private final DepensesPourMajBudgetViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<DepensesPourMajBudgetViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget) {
		List<DepensesPourMajBudgetView> list = repository.findByGestionAndIdBudget(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, DepensesPourMajBudgetViewDto.class))
				.collect(Collectors.toList());
	}	
}
