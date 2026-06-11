package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.LignesModifieesDepensesPourValidationModificationBudgetViewDto;


@Service
public interface LignesModifieesDepensesPourValidationModificationBudgetViewService {
	public List<LignesModifieesDepensesPourValidationModificationBudgetViewDto> getLignesModifieesDepensesPourValidationModificationBudget(Short gestion, Integer idBudget, Long codBma);
}
