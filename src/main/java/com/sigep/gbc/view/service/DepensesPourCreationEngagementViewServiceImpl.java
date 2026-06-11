package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.DepensesPourCreationEngagementView;
import com.sigep.gbc.view.dto.DepensesPourCreationEngagementViewDto;
import com.sigep.gbc.view.repository.DepensesPourCreationEngagementViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class DepensesPourCreationEngagementViewServiceImpl implements DepensesPourCreationEngagementViewService{
	private final DepensesPourCreationEngagementViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<DepensesPourCreationEngagementViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget) {
		List<DepensesPourCreationEngagementView> list = repository.findByGestionAndIdBudget(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, DepensesPourCreationEngagementViewDto.class))
				.collect(Collectors.toList());
	}	
}
