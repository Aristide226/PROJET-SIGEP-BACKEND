package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.LignesModifieesRecettesPourAnnulerValidationModificationBudgetView;
import com.sigep.gbc.view.dto.LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewDto;
import com.sigep.gbc.view.repository.LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewServiceImpl implements LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewService{
	private final LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewDto> getLignesModifieesRecettesPourAnnulerValidationModificationBudget(Short gestion, Integer idBudget, Long codBma) {
		List<LignesModifieesRecettesPourAnnulerValidationModificationBudgetView> list = repository.findByGestionAndIdBudgetAndCodBma(gestion, idBudget, codBma);
		return list
				.stream().map(element  -> modelMapper.map(element, LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewDto.class))
				.collect(Collectors.toList());
	}
}
