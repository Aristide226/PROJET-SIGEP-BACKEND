package com.sigep.common.histoGbk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.common.histoGbk.dto.requestDto.NumerotationMandatRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.NumerotationMandatResponseDto;
import com.sigep.common.histoGbk.entity.NumerotationMandat;



@Service
public interface HistoGbkNumerotationMandatService {
	public NumerotationMandatResponseDto add(NumerotationMandatRequestDto numerotationMandatRequestDto);
	public List<NumerotationMandatResponseDto> getAll();
	public NumerotationMandat get(int id);
	public NumerotationMandatResponseDto getById(int id);
	public NumerotationMandatResponseDto delete(int id);
	public NumerotationMandatResponseDto edit(int id, NumerotationMandatRequestDto numerotationMandatRequestDto);
}
