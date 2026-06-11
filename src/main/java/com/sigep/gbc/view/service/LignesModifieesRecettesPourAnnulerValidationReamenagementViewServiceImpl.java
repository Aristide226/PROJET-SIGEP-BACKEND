package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.LignesModifieesRecettesPourAnnulerValidationReamenagementView;
import com.sigep.gbc.view.dto.LignesModifieesRecettesPourAnnulerValidationReamenagementViewDto;
import com.sigep.gbc.view.repository.LignesModifieesRecettesPourAnnulerValidationReamenagementViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class LignesModifieesRecettesPourAnnulerValidationReamenagementViewServiceImpl implements LignesModifieesRecettesPourAnnulerValidationReamenagementViewService{
	private final LignesModifieesRecettesPourAnnulerValidationReamenagementViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<LignesModifieesRecettesPourAnnulerValidationReamenagementViewDto> getLignesModifieesRecettesPourAnnulerValidationReamenagement(Short gestion, Integer idBudget, Long codReam) {
		List<LignesModifieesRecettesPourAnnulerValidationReamenagementView> list = repository.findByGestionAndIdBudgetAndCodReam(gestion, idBudget, codReam);
		return list
				.stream().map(element  -> modelMapper.map(element, LignesModifieesRecettesPourAnnulerValidationReamenagementViewDto.class))
				.collect(Collectors.toList());
	}
}
