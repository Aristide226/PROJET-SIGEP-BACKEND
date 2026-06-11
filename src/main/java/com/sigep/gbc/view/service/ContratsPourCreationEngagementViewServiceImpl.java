package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.ContratsPourCreationEngagementView;
import com.sigep.gbc.view.dto.ContratsPourCreationEngagementViewDto;
import com.sigep.gbc.view.repository.ContratsPourCreationEngagementViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class ContratsPourCreationEngagementViewServiceImpl implements ContratsPourCreationEngagementViewService{
	private final ContratsPourCreationEngagementViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<ContratsPourCreationEngagementViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget) {
		List<ContratsPourCreationEngagementView> list = repository.findByAnneeAndIdBudget(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, ContratsPourCreationEngagementViewDto.class))
				.collect(Collectors.toList());
	}	
}
