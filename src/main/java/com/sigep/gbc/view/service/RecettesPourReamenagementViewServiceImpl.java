package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.RecettesPourReamenagementView;
import com.sigep.gbc.view.dto.RecettesPourReamenagementViewDto;
import com.sigep.gbc.view.repository.RecettesPourReamenagementViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class RecettesPourReamenagementViewServiceImpl implements RecettesPourReamenagementViewService {
	private final RecettesPourReamenagementViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<RecettesPourReamenagementViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget) {
		List<RecettesPourReamenagementView> list = repository.findByGestionAndIdBudget(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, RecettesPourReamenagementViewDto.class))
				.collect(Collectors.toList());
	}
}
