package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.ElementElectriciteRequestDto;
import com.sigep.gim.dto.responseDto.ElementElectriciteResponseDto;
import com.sigep.gim.entity.ElementElectricite;

@Service
public interface GimElementElectriciteService {
	public ElementElectriciteResponseDto add(ElementElectriciteRequestDto elementElectriciteRequestDto);
	public List<ElementElectriciteResponseDto> getAll();
	public ElementElectricite get(int id);
	public ElementElectriciteResponseDto getById(int id);
	public ElementElectriciteResponseDto delete(int id);
	public ElementElectriciteResponseDto edit(int id, ElementElectriciteRequestDto elementElectriciteRequestDto);
}