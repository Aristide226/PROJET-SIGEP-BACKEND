package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.BudgetTypeGestionRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetTypeGestionResponseDto;
import com.sigep.gbc.entity.BudgetTypeGestion;


@Service
public interface BudgetTypeGestionService {
	public BudgetTypeGestionResponseDto add(BudgetTypeGestionRequestDto budgetTypeGestionRequestDto);
	public List<BudgetTypeGestionResponseDto> getAll();
	public BudgetTypeGestion get(Integer idBudget, Short annee);
	public BudgetTypeGestionResponseDto getById(Integer idBudget, Short annee);
	public BudgetTypeGestionResponseDto delete(Integer idBudget, Short annee);
	public BudgetTypeGestionResponseDto edit(Integer idBudget, Short annee, BudgetTypeGestionRequestDto budgetTypeGestionRequestDto);
}
