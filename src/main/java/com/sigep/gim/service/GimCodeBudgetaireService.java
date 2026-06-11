package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.CodeBudgetaireStatistiqueDto;
import com.sigep.gim.dto.requestDto.CodeBudgetaireRequestDto;
import com.sigep.gim.dto.responseDto.CodeBudgetaireResponseDto;
import com.sigep.gim.entity.CodeBudgetaire;

@Service
public interface GimCodeBudgetaireService {
	public CodeBudgetaireResponseDto add(CodeBudgetaireRequestDto codeBudgetaireRequestDto);
	public List<CodeBudgetaireResponseDto> getAll();
	public CodeBudgetaire get(int id);
	public CodeBudgetaireResponseDto getById(int id);
	public CodeBudgetaireResponseDto delete(int id);
	public CodeBudgetaireResponseDto edit(int id, CodeBudgetaireRequestDto codeBudgetaireRequestDto);
	public List<CodeBudgetaireStatistiqueDto> getCodeBudgetaireStatistiqueDto();
}