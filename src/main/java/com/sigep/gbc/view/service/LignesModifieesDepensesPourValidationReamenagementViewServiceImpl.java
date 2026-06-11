package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.LignesModifieesDepensesPourValidationReamenagementView;
import com.sigep.gbc.view.dto.LignesModifieesDepensesPourValidationReamenagementViewDto;
import com.sigep.gbc.view.repository.LignesModifieesDepensesPourValidationReamenagementViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class LignesModifieesDepensesPourValidationReamenagementViewServiceImpl implements LignesModifieesDepensesPourValidationReamenagementViewService{
	private final LignesModifieesDepensesPourValidationReamenagementViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<LignesModifieesDepensesPourValidationReamenagementViewDto> getLignesModifieesDepensesPourValidationReamenagement(Short gestion, Integer idBudget, Long codReam) {
		List<LignesModifieesDepensesPourValidationReamenagementView> list = repository.findByGestionAndIdBudgetAndCodReam(gestion, idBudget, codReam);
		return list
				.stream().map(element  -> modelMapper.map(element, LignesModifieesDepensesPourValidationReamenagementViewDto.class))
				.collect(Collectors.toList());
	}
}
