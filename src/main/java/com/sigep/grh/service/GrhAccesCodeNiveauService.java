package com.sigep.grh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.grh.dto.requestDto.AccesCodeNiveauRequestDto;
import com.sigep.grh.dto.responseDto.AccesCodeNiveauResponseDto;
import com.sigep.grh.entity.AccesCodeNiveau;

@Service
public interface GrhAccesCodeNiveauService {
	public AccesCodeNiveauResponseDto add(AccesCodeNiveauRequestDto accesCodeNiveauRequestDto);
	public List<AccesCodeNiveauResponseDto> getAll();
	public AccesCodeNiveau get(String id);
	public AccesCodeNiveauResponseDto getById(String id);
	public AccesCodeNiveauResponseDto delete(String id);
	public AccesCodeNiveauResponseDto edit(String id, AccesCodeNiveauRequestDto accesCodeNiveauRequestDto);
}
