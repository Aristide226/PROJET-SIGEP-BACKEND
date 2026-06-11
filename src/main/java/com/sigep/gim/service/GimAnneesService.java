package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.AnneesRequestDto;
import com.sigep.gim.dto.responseDto.AnneesResponseDto;
import com.sigep.gim.entity.Annees;

@Service
public interface GimAnneesService {
	public AnneesResponseDto add(AnneesRequestDto anneesRequestDto);
	public List<AnneesResponseDto> getAll();
	public Annees get(short id);
	public AnneesResponseDto getById(short id);
	public AnneesResponseDto delete(short id);
}