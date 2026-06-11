package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.LignesModifieesDepensesPourAnnulerValidationModificationBudgetView;
import com.sigep.gbc.view.dto.LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewDto;
import com.sigep.gbc.view.repository.LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewServiceImpl implements LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewService{
	private final LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewDto> getLignesModifieesDepensesPourAnnulerValidationModificationBudget(Short gestion, Integer idBudget, Long codBma) {
		List<LignesModifieesDepensesPourAnnulerValidationModificationBudgetView> list = repository.findByGestionAndIdBudgetAndCodBma(gestion, idBudget, codBma);
		return list
				.stream().map(element  -> modelMapper.map(element, LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewDto.class))
				.collect(Collectors.toList());
	}
}
