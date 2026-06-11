package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.MandatsView;
import com.sigep.gbc.view.dto.MandatsViewDto;
import com.sigep.gbc.view.repository.MandatsViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class MandatsViewServiceImpl implements MandatsViewService {
	private final MandatsViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<MandatsViewDto> getMandatValideAE2EtSansBordereaus(Short gestion, Integer idBudget) {
		List<MandatsView> list = repository.getMandatValideAE2EtSansBordereaus(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, MandatsViewDto.class))
				.collect(Collectors.toList());
	}
}
