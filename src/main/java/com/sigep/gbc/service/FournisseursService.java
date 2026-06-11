package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.FournisseursRequestDto;
import com.sigep.gbc.dto.responseDto.FournisseursResponseDto;
import com.sigep.gbc.entity.Fournisseurs;


@Service
public interface FournisseursService {
	public FournisseursResponseDto add(FournisseursRequestDto fournisseursRequestDto);
	public List<FournisseursResponseDto> getAll();
	public Fournisseurs get(Long id);
	public FournisseursResponseDto getById(Long id);
	public FournisseursResponseDto delete(Long id);
	public FournisseursResponseDto edit(Long id, FournisseursRequestDto fournisseursRequestDto);
}
