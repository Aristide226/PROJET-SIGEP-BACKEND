package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.DepensesPourMajBudgetViewDto;


@Service
public interface DepensesPourMajBudgetViewService {
	public List<DepensesPourMajBudgetViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget);
}
