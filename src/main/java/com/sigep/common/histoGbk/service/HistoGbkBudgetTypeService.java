package com.sigep.common.histoGbk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.common.histoGbk.dto.requestDto.BudgetTypeRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.BudgetTypeResponseDto;
import com.sigep.common.histoGbk.entity.BudgetType;



@Service
public interface HistoGbkBudgetTypeService {
	public BudgetTypeResponseDto add(BudgetTypeRequestDto budgetTypeRequestDto);
	public List<BudgetTypeResponseDto> getAll();
	public BudgetType get(Integer id);
	public BudgetTypeResponseDto getById(Integer id);
	public BudgetTypeResponseDto delete(Integer id);
	public BudgetTypeResponseDto edit(Integer id, BudgetTypeRequestDto budgetTypeRequestDto);
}
