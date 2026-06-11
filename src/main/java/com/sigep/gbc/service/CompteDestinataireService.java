package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.CompteDestinataireInstitutFinAgenceDto;
import com.sigep.gbc.dto.requestDto.CompteDestinataireRequestDto;
import com.sigep.gbc.dto.responseDto.CompteDestinataireResponseDto;
import com.sigep.gbc.entity.CompteDestinataire;


@Service
public interface CompteDestinataireService {
	public CompteDestinataireResponseDto add(CompteDestinataireRequestDto compteDestinataireRequestDto);
	public List<CompteDestinataireResponseDto> getAll();
	public CompteDestinataire get(String id);
	public CompteDestinataireResponseDto getById(String id);
	public CompteDestinataireResponseDto delete(String id);
	public CompteDestinataireResponseDto edit(String id, CompteDestinataireRequestDto compteDestinataireRequestDto);
	
	public List<CompteDestinataireInstitutFinAgenceDto> getByDestinataires(Long idDest);
	public boolean isUsed(String id);
}
