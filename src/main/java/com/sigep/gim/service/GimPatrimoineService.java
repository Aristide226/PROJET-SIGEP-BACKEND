package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PatrimoineRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineResponseDto;
import com.sigep.gim.entity.Patrimoine;

@Service
public interface GimPatrimoineService {
	public PatrimoineResponseDto add(PatrimoineRequestDto patrimoineRequestDto);
	public List<PatrimoineResponseDto> getAll();
	public Patrimoine get(String id);
	public PatrimoineResponseDto getById(String id);
	public PatrimoineResponseDto delete(String id);
	public PatrimoineResponseDto edit(String id, PatrimoineRequestDto patrimoineRequestDto);
}