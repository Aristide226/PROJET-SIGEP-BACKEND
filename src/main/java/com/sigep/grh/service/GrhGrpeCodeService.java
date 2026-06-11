package com.sigep.grh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.grh.dto.requestDto.GrpeCodeRequestDto;
import com.sigep.grh.dto.responseDto.GrpeCodeResponseDto;
import com.sigep.grh.entity.GrpeCode;

@Service
public interface GrhGrpeCodeService {
	public GrpeCodeResponseDto add(GrpeCodeRequestDto grpeCodeRequestDto);
	public List<GrpeCodeResponseDto> getAll();
	public GrpeCode get(String id);
	public GrpeCodeResponseDto getById(String id);
	public GrpeCodeResponseDto delete(String id);
	public GrpeCodeResponseDto edit(String id, GrpeCodeRequestDto grpeCodeRequestDto);
}
