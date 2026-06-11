package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.BordereauEmismandatsRequestDto;
import com.sigep.gbc.dto.responseDto.BordereauEmismandatsResponseDto;
import com.sigep.gbc.entity.BordereauEmismandats;


@Service
public interface BordereauEmismandatsService {
	public BordereauEmismandatsResponseDto add(BordereauEmismandatsRequestDto bordereauEmismandatsRequestDto);
	public List<BordereauEmismandatsResponseDto> getAll();
	public BordereauEmismandats get(String id);
	public BordereauEmismandatsResponseDto getById(String id);
	public BordereauEmismandatsResponseDto delete(String id);
	public BordereauEmismandatsResponseDto edit(String id, BordereauEmismandatsRequestDto bordereauEmismandatsRequestDto);
	public List<BordereauEmismandatsResponseDto> getByGestionAndIdBudgetAndDossier(Short gestion, Integer idBudget, String dossier);
}
