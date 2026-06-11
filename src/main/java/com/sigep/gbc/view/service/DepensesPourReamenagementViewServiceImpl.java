package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.DepensesPourReamenagementView;
import com.sigep.gbc.view.dto.DepensesPourReamenagementViewDto;
import com.sigep.gbc.view.repository.DepensesPourReamenagementViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class DepensesPourReamenagementViewServiceImpl implements DepensesPourReamenagementViewService {
	private final DepensesPourReamenagementViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<DepensesPourReamenagementViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget) {
		List<DepensesPourReamenagementView> list = repository.findByGestionAndIdBudget(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, DepensesPourReamenagementViewDto.class))
				.collect(Collectors.toList());
	}
}
