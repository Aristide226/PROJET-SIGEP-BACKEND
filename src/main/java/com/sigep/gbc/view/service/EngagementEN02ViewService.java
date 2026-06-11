package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sigep.gbc.view.dto.EngagementEN02ViewDto;


@Service
public interface EngagementEN02ViewService {
	public List<EngagementEN02ViewDto> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(Short gestion, Integer idBudget);
	public EngagementEN02ViewDto getByGestionAndIdBudgetAndBenum(Short gestion, Integer idBudget, Integer benum);
	
	public List<EngagementEN02ViewDto> getEngagementModifiables(Short gestion, Integer idBudget);
}
