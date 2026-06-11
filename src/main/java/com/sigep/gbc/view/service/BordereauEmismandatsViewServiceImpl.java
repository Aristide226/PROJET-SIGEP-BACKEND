package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.BordereauEmismandatsView;
import com.sigep.gbc.view.dto.BordereauEmismandatsViewDto;
import com.sigep.gbc.view.repository.BordereauEmismandatsViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class BordereauEmismandatsViewServiceImpl implements BordereauEmismandatsViewService {
	
	private final BordereauEmismandatsViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<BordereauEmismandatsViewDto> getByGestionAndIdBudgetAndDossier(Short gestion, Integer idBudget, String dossier) {
		List<BordereauEmismandatsView> list = repository.getByGestionAndIdBudgetAndDossier(gestion, idBudget, dossier);
		return list
				.stream().map(element  -> modelMapper.map(element, BordereauEmismandatsViewDto.class))
				.collect(Collectors.toList());
	}
}
