package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.LignesModifieesRecettesPourValidationReamenagementView;
import com.sigep.gbc.view.dto.LignesModifieesRecettesPourValidationReamenagementViewDto;
import com.sigep.gbc.view.repository.LignesModifieesRecettesPourValidationReamenagementViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class LignesModifieesRecettesPourValidationReamenagementViewServiceImpl implements LignesModifieesRecettesPourValidationReamenagementViewService{
	private final LignesModifieesRecettesPourValidationReamenagementViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<LignesModifieesRecettesPourValidationReamenagementViewDto> getLignesModifieesRecettesPourValidationReamenagement(Short gestion, Integer idBudget, Long codReam) {
		List<LignesModifieesRecettesPourValidationReamenagementView> list = repository.findByGestionAndIdBudgetAndCodReam(gestion, idBudget, codReam);
		return list
				.stream().map(element  -> modelMapper.map(element, LignesModifieesRecettesPourValidationReamenagementViewDto.class))
				.collect(Collectors.toList());
	}
}
