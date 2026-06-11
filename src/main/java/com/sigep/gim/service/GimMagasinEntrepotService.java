package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.MagasinEntrepotRequestDto;
import com.sigep.gim.dto.responseDto.MagasinEntrepotResponseDto;
import com.sigep.gim.entity.MagasinEntrepot;

@Service
public interface GimMagasinEntrepotService {
	public MagasinEntrepotResponseDto add(MagasinEntrepotRequestDto magasinEntrepotRequestDto);
	public List<MagasinEntrepotResponseDto> getAll();
	public MagasinEntrepot get(int id);
	public MagasinEntrepotResponseDto getById(int id);
	public MagasinEntrepotResponseDto delete(int id);
	public MagasinEntrepotResponseDto edit(int id, MagasinEntrepotRequestDto magasinEntrepotRequestDto);
}