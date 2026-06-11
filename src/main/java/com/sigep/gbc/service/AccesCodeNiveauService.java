package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.AccesCodeNiveauRequestDto;
import com.sigep.gbc.dto.responseDto.AccesCodeNiveauResponseDto;
import com.sigep.gbc.entity.AccesCodeNiveau;


@Service
public interface AccesCodeNiveauService {
	public AccesCodeNiveauResponseDto add(AccesCodeNiveauRequestDto accesCodeNiveauRequestDto);
	public List<AccesCodeNiveauResponseDto> getAll();
	public AccesCodeNiveau get(String id);
	public AccesCodeNiveauResponseDto getById(String id);
	public AccesCodeNiveauResponseDto delete(String id);
	public AccesCodeNiveauResponseDto edit(String id, AccesCodeNiveauRequestDto accesCodeNiveauRequestDto);
}
