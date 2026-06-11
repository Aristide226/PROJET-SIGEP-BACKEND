package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.NewBudgetNomenclaturedViewDto;


@Service
public interface NewBudgetNomenclaturedViewService {
	public List<NewBudgetNomenclaturedViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget);
}
