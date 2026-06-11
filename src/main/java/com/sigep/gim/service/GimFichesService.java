package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.FichesRequestDto;
import com.sigep.gim.dto.responseDto.FichesResponseDto;
import com.sigep.gim.entity.Fiches;

@Service
public interface GimFichesService {
	public FichesResponseDto add(FichesRequestDto fichesRequestDto);
	public List<FichesResponseDto> getAll();
	public Fiches get(long id);
	public FichesResponseDto getById(long id);
	public FichesResponseDto delete(long id);
	public FichesResponseDto edit(long id, FichesRequestDto fichesRequestDto);
	public Long findByMaxIdFiche();
}