package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.NumerotationMandatRequestDto;
import com.sigep.gbc.dto.responseDto.NumerotationMandatResponseDto;
import com.sigep.gbc.entity.NumerotationMandat;


@Service
public interface NumerotationMandatService {
	public NumerotationMandatResponseDto add(NumerotationMandatRequestDto numerotationMandatRequestDto);
	public List<NumerotationMandatResponseDto> getAll();
	public NumerotationMandat get(int id);
	public NumerotationMandatResponseDto getById(int id);
	public NumerotationMandatResponseDto delete(int id);
	public NumerotationMandatResponseDto edit(int id, NumerotationMandatRequestDto numerotationMandatRequestDto);
}
