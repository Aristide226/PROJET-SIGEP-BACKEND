package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.EtatDossierRequestDto;
import com.sigep.gbc.dto.responseDto.EtatDossierResponseDto;
import com.sigep.gbc.entity.EtatDossier;


@Service
public interface EtatDossierService {
	public EtatDossierResponseDto add(EtatDossierRequestDto etatDossierRequestDto);
	public List<EtatDossierResponseDto> getAll();
	public EtatDossier get(String id);
	public EtatDossierResponseDto getById(String id);
	public EtatDossierResponseDto delete(String id);
	public EtatDossierResponseDto edit(String id, EtatDossierRequestDto etatDossierRequestDto);
}
