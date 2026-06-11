package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.BudgetRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetResponseDto;
import com.sigep.gbc.entity.Budget;


@Service
public interface BudgetService {
	public BudgetResponseDto add(BudgetRequestDto budgetRequestDto);
	public List<BudgetResponseDto> getAll();
	public Budget get(String id);
	public BudgetResponseDto getById(String id);
	public BudgetResponseDto delete(String id);
	public BudgetResponseDto edit(String id, BudgetRequestDto budgetRequestDto);
	public List<BudgetResponseDto> getByGestionAndIdBudget(Short gestion, Integer idBudget);
	public List<BudgetResponseDto> getByNumNo(String numNo);
	public Boolean exits(Short gestion, Integer idBudget);
	public List<BudgetResponseDto> creerBudgetSuivantAPartirDuBudgetPrecent(Short gestion, Integer idBudget);
	public List<BudgetResponseDto> creerBudgetSuivantAPartirDesRecettesEtDepenses(Short gestion, Integer idBudget);
	public List<BudgetResponseDto> getRecettes(Short gestion, Integer idBudget);
	public List<BudgetResponseDto> getDepenses(Short gestion, Integer idBudget);
	public BudgetResponseDto editCAajoutCAannul(String codBud);
	public BudgetResponseDto editReam(String codBud);	
}
