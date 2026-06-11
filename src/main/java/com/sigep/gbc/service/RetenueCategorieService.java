package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.RetenueCategorieRequestDto;
import com.sigep.gbc.dto.responseDto.RetenueCategorieResponseDto;
import com.sigep.gbc.entity.RetenueCategorie;


@Service
public interface RetenueCategorieService {
	public RetenueCategorieResponseDto add(RetenueCategorieRequestDto requestDto);
	public List<RetenueCategorieResponseDto> getAll();
	public RetenueCategorie get(String id);
	public RetenueCategorieResponseDto getById(String id);
	public RetenueCategorieResponseDto delete(String id);
	public RetenueCategorieResponseDto edit(String id, RetenueCategorieRequestDto requestDto);
}
