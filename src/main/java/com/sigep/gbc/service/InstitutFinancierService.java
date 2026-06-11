package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.InstitutFinancierRequestDto;
import com.sigep.gbc.dto.responseDto.InstitutFinancierResponseDto;
import com.sigep.gbc.entity.InstitutFinancier;


@Service
public interface InstitutFinancierService {
	public InstitutFinancierResponseDto add(InstitutFinancierRequestDto institutFinancierRequestDto);
	public List<InstitutFinancierResponseDto> getAll();
	public InstitutFinancier get(String id);
	public InstitutFinancierResponseDto getById(String id);
	public InstitutFinancierResponseDto delete(String id);
	public InstitutFinancierResponseDto edit(String id, InstitutFinancierRequestDto institutFinancierRequestDto);
}
