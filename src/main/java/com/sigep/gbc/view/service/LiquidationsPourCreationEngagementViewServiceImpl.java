package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.LiquidationsPourCreationEngagementView;
import com.sigep.gbc.view.dto.LiquidationsPourCreationEngagementViewDto;
import com.sigep.gbc.view.repository.LiquidationsPourCreationEngagementViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class LiquidationsPourCreationEngagementViewServiceImpl implements LiquidationsPourCreationEngagementViewService {
	private final LiquidationsPourCreationEngagementViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<LiquidationsPourCreationEngagementViewDto> getByGestion(Short gestion) {
		List<LiquidationsPourCreationEngagementView> list = repository.findByGestion(gestion);
		return list
				.stream().map(element  -> modelMapper.map(element, LiquidationsPourCreationEngagementViewDto.class))
				.collect(Collectors.toList());
	}	
}
