package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.EtatFicheRequestDto;
import com.sigep.gim.dto.responseDto.EtatFicheResponseDto;
import com.sigep.gim.entity.EtatFiche;

@Service
public interface GimEtatFicheService {
	public EtatFicheResponseDto add(EtatFicheRequestDto etatFicheRequestDto);
	public List<EtatFicheResponseDto> getAll();
	public EtatFiche get(String id);
	public EtatFicheResponseDto getById(String id);
	public EtatFicheResponseDto delete(String id);
	public EtatFicheResponseDto edit(String id, EtatFicheRequestDto etatFicheRequestDto);
}