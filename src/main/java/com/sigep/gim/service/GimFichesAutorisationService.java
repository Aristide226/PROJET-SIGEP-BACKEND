package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.FichesAutorisationRequestDto;
import com.sigep.gim.dto.responseDto.FichesAutorisationResponseDto;
import com.sigep.gim.entity.FichesAutorisation;

@Service
public interface GimFichesAutorisationService {
	public FichesAutorisationResponseDto add(FichesAutorisationRequestDto fichesAutorisationRequestDto);
	public List<FichesAutorisationResponseDto> getAll();
	public FichesAutorisation get(long id);
	public FichesAutorisationResponseDto getById(long id);
	public FichesAutorisationResponseDto delete(long id);
	public FichesAutorisationResponseDto edit(long id, FichesAutorisationRequestDto fichesAutorisationRequestDto);
}