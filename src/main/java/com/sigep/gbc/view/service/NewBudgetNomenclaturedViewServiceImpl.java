package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.NewBudgetNomenclaturedView;
import com.sigep.gbc.view.dto.NewBudgetNomenclaturedViewDto;
import com.sigep.gbc.view.repository.NewBudgetNomenclaturedViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class NewBudgetNomenclaturedViewServiceImpl implements NewBudgetNomenclaturedViewService{
	private final NewBudgetNomenclaturedViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<NewBudgetNomenclaturedViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget) {
		List<NewBudgetNomenclaturedView> list = repository.findByGestionAndIdBudget(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, NewBudgetNomenclaturedViewDto.class))
				.collect(Collectors.toList());
	}

}
