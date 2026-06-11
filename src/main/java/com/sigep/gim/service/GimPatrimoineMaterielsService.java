package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PatrimoineMaterielsRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineMaterielsResponseDto;
import com.sigep.gim.entity.PatrimoineMateriels;

@Service
public interface GimPatrimoineMaterielsService {
	public PatrimoineMaterielsResponseDto add(PatrimoineMaterielsRequestDto patrimoineMaterielsRequestDto);
	public List<PatrimoineMaterielsResponseDto> getAll();
	public PatrimoineMateriels get(String id);
	public PatrimoineMaterielsResponseDto getById(String id);
	public PatrimoineMaterielsResponseDto delete(String id);
	public PatrimoineMaterielsResponseDto edit(String id, PatrimoineMaterielsRequestDto patrimoineMaterielsRequestDto);
}