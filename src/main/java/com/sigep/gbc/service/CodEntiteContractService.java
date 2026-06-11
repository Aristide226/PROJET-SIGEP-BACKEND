package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.CodEntiteContractRequestDto;
import com.sigep.gbc.dto.responseDto.CodEntiteContractResponseDto;
import com.sigep.gbc.entity.CodEntiteContract;


@Service
public interface CodEntiteContractService {
	public CodEntiteContractResponseDto add(CodEntiteContractRequestDto codEntiteContractRequestDto);
	public List<CodEntiteContractResponseDto> getAll();
	public CodEntiteContract get(String id);
	public CodEntiteContractResponseDto getById(String id);
	public CodEntiteContractResponseDto delete(String id);
	public CodEntiteContractResponseDto edit(String id, CodEntiteContractRequestDto codEntiteContractRequestDto);
}
