package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.FinancementStatistiqueDto;
import com.sigep.gim.dto.requestDto.SourceFinancementRequestDto;
import com.sigep.gim.dto.responseDto.SourceFinancementResponseDto;
import com.sigep.gim.entity.SourceFinancement;

@Service
public interface GimSourceFinancementService {
	public SourceFinancementResponseDto add(SourceFinancementRequestDto sourceFinancementRequestDto);
	public List<SourceFinancementResponseDto> getAll();
	public SourceFinancement get(String id);
	public SourceFinancementResponseDto getById(String id);
	public SourceFinancementResponseDto delete(String id);
	public SourceFinancementResponseDto edit(String id, SourceFinancementRequestDto sourceFinancementRequestDto);
	public List<FinancementStatistiqueDto> getFinancementStatistiqueParCategorie();
}