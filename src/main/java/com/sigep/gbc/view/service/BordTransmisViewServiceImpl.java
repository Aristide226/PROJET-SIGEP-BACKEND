package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.BordTransmisView;
import com.sigep.gbc.view.dto.BordTransmisViewDto;
import com.sigep.gbc.view.repository.BordTransmisViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class BordTransmisViewServiceImpl implements BordTransmisViewService {
	
	private final BordTransmisViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<BordTransmisViewDto> getBordTransmisEtNonReceptionne(Short gestion, Integer idBudget) {
		List<BordTransmisView> list = repository.getBordTransmisEtNonReceptionne(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, BordTransmisViewDto.class))
				.collect(Collectors.toList());
	}
}
