package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.MotifsRejetDossierRequestDto;
import com.sigep.gbc.dto.responseDto.MotifsRejetDossierResponseDto;
import com.sigep.gbc.entity.MotifsRejetDossier;


@Service
public interface MotifsRejetDossierService {
	public MotifsRejetDossierResponseDto add(MotifsRejetDossierRequestDto motifsRejetDossierRequestDto);
	public List<MotifsRejetDossierResponseDto> getAll();
	public MotifsRejetDossier get(String id);
	public MotifsRejetDossierResponseDto getById(String id);
	public MotifsRejetDossierResponseDto delete(String id);
	public MotifsRejetDossierResponseDto edit(String id, MotifsRejetDossierRequestDto motifsRejetDossierRequestDto);
	public void deleteLastRecord(Long numbe);
	public Boolean setActifToFalse(Long numBe);
}
