package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.BudgetModifActeRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetModifActeResponseDto;
import com.sigep.gbc.entity.BudgetModifActe;


@Service
public interface BudgetModifActeService {
	public BudgetModifActeResponseDto add(BudgetModifActeRequestDto budgetModifActeRequestDto);
	public List<BudgetModifActeResponseDto> getAll();
	public BudgetModifActe get(Long id);
	public BudgetModifActeResponseDto getById(Long id);
	public BudgetModifActeResponseDto delete(Long id);
	public BudgetModifActeResponseDto edit(Long id, BudgetModifActeRequestDto budgetModifActeRequestDto);
	public Long getCodReamCodBMA();
	public Boolean existsByGestionAndIdBudgetAndValide(Short gestion, Integer idBudget, Boolean valide);
	public List<BudgetModifActeResponseDto> getByGestionAndIdBudgetAndValide(Short gestion, Integer idBudget, Boolean valide);
}
