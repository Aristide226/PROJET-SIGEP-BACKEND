package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.SignataireParDefautRequestDto;
import com.sigep.gim.dto.responseDto.SignataireParDefautResponseDto;
import com.sigep.gim.entity.SignataireParDefaut;

@Service
public interface GimSignataireParDefautService {
	public SignataireParDefautResponseDto add(SignataireParDefautRequestDto signataireParDefautRequestDto);
	public List<SignataireParDefautResponseDto> getAll();
	public SignataireParDefaut get(String id);
	public SignataireParDefautResponseDto getById(String id);
	public SignataireParDefautResponseDto delete(String id);
	public SignataireParDefautResponseDto edit(String id, SignataireParDefautRequestDto signataireParDefautRequestDto);
}