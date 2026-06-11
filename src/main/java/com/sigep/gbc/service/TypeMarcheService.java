package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sigep.gbc.dto.requestDto.TypeMarcheRequestDto;
import com.sigep.gbc.dto.responseDto.TypeMarcheResponseDto;
import com.sigep.gbc.entity.TypeMarche;


@Service
public interface TypeMarcheService {
	public TypeMarcheResponseDto add(TypeMarcheRequestDto typeMarcheRequestDto);
	public List<TypeMarcheResponseDto> getAll();
	public TypeMarche get(String id);
	public TypeMarcheResponseDto getById(String id);
	public TypeMarcheResponseDto delete(String id);
	public TypeMarcheResponseDto edit(String id, TypeMarcheRequestDto typeMarcheRequestDto);
}
