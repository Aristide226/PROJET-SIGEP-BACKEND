package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewDto;


@Service
public interface LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewService {
	public List<LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewDto> getLignesModifieesDepensesPourAnnulerValidationModificationBudget(Short gestion, Integer idBudget, Long codBma);
}
