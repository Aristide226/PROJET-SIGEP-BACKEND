package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.TitreRegulApartirRequestDto;
import com.sigep.gbc.dto.responseDto.TitreRegulApartirResponseDto;
import com.sigep.gbc.entity.TitreRegulApartir;


@Service
public interface TitreRegulApartirService {
	public TitreRegulApartirResponseDto add(TitreRegulApartirRequestDto titreRegulApartirRequestDto);
	public List<TitreRegulApartirResponseDto> getAll();
	public TitreRegulApartir get(Integer id);
	public TitreRegulApartirResponseDto getById(Integer id);
	public TitreRegulApartirResponseDto delete(Integer id);
	public TitreRegulApartirResponseDto edit(Integer id, TitreRegulApartirRequestDto titreRegulApartirRequestDto);
}
