package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.NiveauCodeBudgetaireRequestDto;
import com.sigep.gim.dto.responseDto.NiveauCodeBudgetaireResponseDto;
import com.sigep.gim.entity.NiveauCodeBudgetaire;

@Service
public interface GimNiveauCodeBudgetaireService {
	public NiveauCodeBudgetaireResponseDto add(NiveauCodeBudgetaireRequestDto niveauCodeBudgetaireRequestDto);
	public List<NiveauCodeBudgetaireResponseDto> getAll();
	public NiveauCodeBudgetaire get(int id);
	public NiveauCodeBudgetaireResponseDto getById(int id);
	public NiveauCodeBudgetaireResponseDto delete(int id);
	public NiveauCodeBudgetaireResponseDto edit(int id, NiveauCodeBudgetaireRequestDto niveauCodeBudgetaireRequestDto);
}