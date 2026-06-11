package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.LiquidationViewDto;


@Service
public interface LiquidationViewService {
	public List<LiquidationViewDto> getByGestionAndIdBudgetOrderByNumBlDesc(Short gestion, Integer idBudget);
	
	public List<LiquidationViewDto> getReçuModifiables(Short gestion, Integer idBudget);
	public List<LiquidationViewDto> getReçuSansMandats(Short gestion, Integer idBudget); 
	
	public List<LiquidationViewDto> getLiquidationModifiables(Short gestion, Integer idBudget);
	public List<LiquidationViewDto> getByGestionAndIdBudgetOrderByNumBeDesc(Short gestion, Integer idBudget);
	public List<LiquidationViewDto> getLiquidationValidables(Short gestion, Integer idBudget);
	public List<LiquidationViewDto> getLiquidationRetrogradables(Short gestion, Integer idBudget, String idUser);
}
