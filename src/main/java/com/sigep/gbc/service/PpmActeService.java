package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PpmActeRequestDto;
import com.sigep.gbc.dto.responseDto.PpmActeResponseDto;
import com.sigep.gbc.entity.PpmActe;


@Service
public interface PpmActeService {
	public PpmActeResponseDto add(PpmActeRequestDto ppmActeRequestDto);
	public List<PpmActeResponseDto> getAll();
	public PpmActe get(String id);
	public PpmActeResponseDto getById(String id);
	public PpmActeResponseDto delete(String id);
	public PpmActeResponseDto edit(String id, PpmActeRequestDto ppmActeRequestDto);
	
	//Aristide
	public List <PpmActeResponseDto> getByGestion(Short gestion);
	public List<PpmActeResponseDto> getByGestionAndIdBudget(Short gestion, Integer idBudget);
}
