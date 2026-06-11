package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.RecettesPourMajBudgetViewDto;


@Service
public interface RecettesPourMajBudgetViewService {
	public List<RecettesPourMajBudgetViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget);
}
