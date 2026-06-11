package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.TypFicheRequestDto;
import com.sigep.gim.dto.responseDto.TypFicheResponseDto;
import com.sigep.gim.entity.TypFiche;

@Service
public interface GimTypFicheService {
	public TypFicheResponseDto add(TypFicheRequestDto typFicheRequestDto);
	public List<TypFicheResponseDto> getAll();
	public TypFiche get(String id);
	public TypFicheResponseDto getById(String id);
	public TypFicheResponseDto delete(String id);
	public TypFicheResponseDto edit(String id, TypFicheRequestDto typFicheRequestDto);
}