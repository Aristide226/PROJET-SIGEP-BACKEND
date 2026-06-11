package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.ElementEauCouranteRequestDto;
import com.sigep.gim.dto.responseDto.ElementEauCouranteResponseDto;
import com.sigep.gim.entity.ElementEauCourante;

@Service
public interface GimElementEauCouranteService {
	public ElementEauCouranteResponseDto add(ElementEauCouranteRequestDto elementEauCouranteRequestDto);
	public List<ElementEauCouranteResponseDto> getAll();
	public ElementEauCourante get(int id);
	public ElementEauCouranteResponseDto getById(int id);
	public ElementEauCouranteResponseDto delete(int id);
	public ElementEauCouranteResponseDto edit(int id, ElementEauCouranteRequestDto elementEauCouranteRequestDto);
}