package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewDto;


@Service
public interface LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewService {
	public List<LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewDto> getLignesModifieesRecettesPourAnnulerValidationModificationBudget(Short gestion, Integer idBudget, Long codBma);
}
