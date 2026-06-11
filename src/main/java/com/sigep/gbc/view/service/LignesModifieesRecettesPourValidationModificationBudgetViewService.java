package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.LignesModifieesRecettesPourValidationModificationBudgetViewDto;


@Service
public interface LignesModifieesRecettesPourValidationModificationBudgetViewService {
	public List<LignesModifieesRecettesPourValidationModificationBudgetViewDto> getLignesModifieesRecettesPourValidationModificationBudget(Short gestion, Integer idBudget, Long codBma);
}
