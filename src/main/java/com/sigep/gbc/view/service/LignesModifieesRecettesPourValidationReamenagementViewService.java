package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.LignesModifieesRecettesPourValidationReamenagementViewDto;


@Service
public interface LignesModifieesRecettesPourValidationReamenagementViewService {
	public List<LignesModifieesRecettesPourValidationReamenagementViewDto> getLignesModifieesRecettesPourValidationReamenagement(Short gestion, Integer idBudget, Long codReam);
}
