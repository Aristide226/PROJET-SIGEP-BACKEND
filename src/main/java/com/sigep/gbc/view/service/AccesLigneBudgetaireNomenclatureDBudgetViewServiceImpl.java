package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.AccesLigneBudgetaireNomenclatureDBudgetView;
import com.sigep.gbc.view.dto.AccesLigneBudgetaireNomenclatureDBudgetViewDto;
import com.sigep.gbc.view.repository.AccesLigneBudgetaireNomenclatureDBudgetViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class AccesLigneBudgetaireNomenclatureDBudgetViewServiceImpl implements AccesLigneBudgetaireNomenclatureDBudgetViewService{
	private final AccesLigneBudgetaireNomenclatureDBudgetViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<AccesLigneBudgetaireNomenclatureDBudgetViewDto> findByUserNameAndGestionAndIdBudget(String userName, Short gestion, Integer idBudget) {
		List<AccesLigneBudgetaireNomenclatureDBudgetView> list = repository.findByUserNameAndGestionAndIdBudget(userName, gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, AccesLigneBudgetaireNomenclatureDBudgetViewDto.class))
				.collect(Collectors.toList());
	}

}
