package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.AccesLigneBudgetaireNomenclatureDBudgetViewDto;


@Service
public interface AccesLigneBudgetaireNomenclatureDBudgetViewService {
	public List<AccesLigneBudgetaireNomenclatureDBudgetViewDto> findByUserNameAndGestionAndIdBudget(String userName, Short gestion, Integer idBudget);
}
