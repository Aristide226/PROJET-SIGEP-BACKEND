package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.LignesModifieesRecettesPourValidationModificationBudgetView;
import com.sigep.gbc.view.dto.LignesModifieesRecettesPourValidationModificationBudgetViewDto;
import com.sigep.gbc.view.repository.LignesModifieesRecettesPourValidationModificationBudgetViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class LignesModifieesRecettesPourValidationModificationBudgetViewServiceImpl implements LignesModifieesRecettesPourValidationModificationBudgetViewService{
	private final LignesModifieesRecettesPourValidationModificationBudgetViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<LignesModifieesRecettesPourValidationModificationBudgetViewDto> getLignesModifieesRecettesPourValidationModificationBudget(Short gestion, Integer idBudget, Long codBma) {
		List<LignesModifieesRecettesPourValidationModificationBudgetView> list = repository.findByGestionAndIdBudgetAndCodBma(gestion, idBudget, codBma);
		return list
				.stream().map(element  -> modelMapper.map(element, LignesModifieesRecettesPourValidationModificationBudgetViewDto.class))
				.collect(Collectors.toList());
	}
}
