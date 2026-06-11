package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.AccesLigneBudgetaireRequestDto;
import com.sigep.gbc.dto.responseDto.AccesLigneBudgetaireResponseDto;
import com.sigep.gbc.entity.AccesLigneBudgetaire;


@Service
public interface AccesLigneBudgetaireService {
	public AccesLigneBudgetaireResponseDto add(AccesLigneBudgetaireRequestDto accesLigneBudgetaireRequestDto);
	public List<AccesLigneBudgetaireResponseDto> getAll();
	public AccesLigneBudgetaire get(String userName, Short gestion, String numNo);
	public AccesLigneBudgetaireResponseDto getById(String userName, Short gestion, String numNo);
	public AccesLigneBudgetaireResponseDto delete(String userName, Short gestion, String numNo);
	public void deleteByUserNameAndGestionAndIdBuget(String userName, Short gestion, Integer idBudget);
}
