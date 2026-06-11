package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.BudgetTypeRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetTypeResponseDto;
import com.sigep.gbc.entity.BudgetType;


@Service
public interface BudgetTypeService {
	public BudgetTypeResponseDto add(BudgetTypeRequestDto budgetTypeRequestDto);
	public List<BudgetTypeResponseDto> getAll();
	public BudgetType get(Integer id);
	public BudgetTypeResponseDto getById(Integer id);
	public BudgetTypeResponseDto delete(Integer id);
	public BudgetTypeResponseDto edit(Integer id, BudgetTypeRequestDto budgetTypeRequestDto);
}
