package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.LignesModifieesDepensesPourAnnulerValidationReamenagementView;
import com.sigep.gbc.view.dto.LignesModifieesDepensesPourAnnulerValidationReamenagementViewDto;
import com.sigep.gbc.view.repository.LignesModifieesDepensesPourAnnulerValidationReamenagementViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class LignesModifieesDepensesPourAnnulerValidationReamenagementViewServiceImpl implements LignesModifieesDepensesPourAnnulerValidationReamenagementViewService{
	private final LignesModifieesDepensesPourAnnulerValidationReamenagementViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<LignesModifieesDepensesPourAnnulerValidationReamenagementViewDto> getLignesModifieesDepensesPourAnnulerValidationReamenagement(Short gestion, Integer idBudget, Long codReam) {
		List<LignesModifieesDepensesPourAnnulerValidationReamenagementView> list = repository.findByGestionAndIdBudgetAndCodReam(gestion, idBudget, codReam);
		return list
				.stream().map(element  -> modelMapper.map(element, LignesModifieesDepensesPourAnnulerValidationReamenagementViewDto.class))
				.collect(Collectors.toList());
	}
}
