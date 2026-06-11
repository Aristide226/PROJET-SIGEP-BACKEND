package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.EtatBienRequestDto;
import com.sigep.gim.dto.responseDto.EtatBienResponseDto;
import com.sigep.gim.entity.EtatBien;

@Service
public interface GimEtatBienService {
	public EtatBienResponseDto add(EtatBienRequestDto etatBienRequestDto);
	public List<EtatBienResponseDto> getAll();
	public EtatBien get(String id);
	public EtatBienResponseDto getById(String id);
	public EtatBienResponseDto delete(String id);
}