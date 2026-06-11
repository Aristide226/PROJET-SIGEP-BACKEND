package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.BudgetModifBudgetDto;
import com.sigep.gbc.dto.requestDto.BudgetModifRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetModifResponseDto;
import com.sigep.gbc.entity.BudgetModif;


@Service
public interface BudgetModifService {
	public BudgetModifResponseDto add(BudgetModifRequestDto budgetModifRequestDto);
	public List<BudgetModifResponseDto> getAll();
	public BudgetModif get(Long codBma, String codBud);
	public BudgetModifResponseDto getById(Long codBma, String codBud);
	public BudgetModifResponseDto delete(Long codBma, String codBud);
	public BudgetModifResponseDto edit(Long codBma, String codBud, BudgetModifRequestDto budgetModifRequestDto);
	
	public List<BudgetModifResponseDto> getByCodBma(Long codBma);
	public List<BudgetModifBudgetDto> getLigneModifieesRecettesDepenses(Long codBma);
	public Boolean addLignesModifiees(List<BudgetModifRequestDto> budgetModifRequestDtos); // Ajout les lignes modifiées
	public Boolean deleteLignesModifiees(Long codBma); // Suppression des lignes modifiées
	public Boolean exists(Long codBma, String codBud);
	public Boolean editAllCAAjoutCAAnnul(Long codBma); // Calcul le CAAjout et CAAnnul pour chaque ligne de l'acte
}
