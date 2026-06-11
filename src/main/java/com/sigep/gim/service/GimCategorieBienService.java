package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.CategorieBienRequestDto;
import com.sigep.gim.dto.responseDto.CategorieBienResponseDto;
import com.sigep.gim.entity.CategorieBien;

@Service
public interface GimCategorieBienService {
	public CategorieBienResponseDto add(CategorieBienRequestDto categorieBienRequestDto);
	public List<CategorieBienResponseDto> getAll();
	public CategorieBien get(int id);
	public CategorieBienResponseDto getById(int id);
	public CategorieBienResponseDto delete(int id);
	public CategorieBienResponseDto edit(int id, CategorieBienRequestDto categorieBienRequestDto);
	public Integer findMaxCodCategorie();
}