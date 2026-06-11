package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.EtatTransmissionRequestDto;
import com.sigep.gbc.dto.responseDto.EtatTransmissionResponseDto;
import com.sigep.gbc.entity.EtatTransmission;


@Service
public interface EtatTransmissionService {
	public EtatTransmissionResponseDto add(EtatTransmissionRequestDto etatTransmissionRequestDto);
	public List<EtatTransmissionResponseDto> getAll();
	public EtatTransmission get(Integer id);
	public EtatTransmissionResponseDto getById(Integer id);
	public EtatTransmissionResponseDto delete(Integer id);
	public EtatTransmissionResponseDto edit(Integer id, EtatTransmissionRequestDto etatTransmissionRequestDto);
}
