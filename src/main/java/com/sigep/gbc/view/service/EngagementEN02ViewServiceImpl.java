package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.EngagementEN02View;
import com.sigep.gbc.view.dto.EngagementEN02ViewDto;
import com.sigep.gbc.view.repository.EngagementEN02ViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class EngagementEN02ViewServiceImpl implements EngagementEN02ViewService {
	private final EngagementEN02ViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<EngagementEN02ViewDto> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(Short gestion, Integer idBudget) {
		List<EngagementEN02View> list = repository.getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(gestion, idBudget, 0L);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementEN02ViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public EngagementEN02ViewDto getByGestionAndIdBudgetAndBenum(Short gestion, Integer idBudget, Integer benum) {
		EngagementEN02View entity  = repository.getByGestionAndIdBudgetAndBenum(gestion, idBudget, benum);
		return modelMapper.map(entity, EngagementEN02ViewDto.class);
	}
	
	@Override
	public List<EngagementEN02ViewDto> getEngagementModifiables(Short gestion, Integer idBudget) {
		List<EngagementEN02View> list = repository.getEngagementModifiables(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementEN02ViewDto.class))
				.collect(Collectors.toList());
	}
}
