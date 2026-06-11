package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.ReamgmtActeRequestDto;
import com.sigep.gbc.dto.responseDto.ReamgmtActeResponseDto;
import com.sigep.gbc.entity.ReamgmtActe;


@Service
public interface ReamgmtActeService {
	public ReamgmtActeResponseDto add(ReamgmtActeRequestDto reamgmtActeRequestDto);
	public List<ReamgmtActeResponseDto> getAll();
	public ReamgmtActe get(Long id);
	public ReamgmtActeResponseDto getById(Long id);
	public ReamgmtActeResponseDto delete(Long id);
	public ReamgmtActeResponseDto edit(Long id, ReamgmtActeRequestDto reamgmtActeRequestDto);
	public Boolean existsByGestionAndIdBudgetAndValide(Short gestion, Integer idBudget, Boolean valide);
	public List<ReamgmtActeResponseDto> getByGestionAndIdBudgetAndValide(Short gestion, Integer idBudget, Boolean valide);
}
