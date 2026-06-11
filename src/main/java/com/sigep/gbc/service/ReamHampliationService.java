package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.ReamHampliationRequestDto;
import com.sigep.gbc.dto.responseDto.ReamHampliationResponseDto;
import com.sigep.gbc.entity.ReamHampliation;


@Service
public interface ReamHampliationService {
	public ReamHampliationResponseDto add(ReamHampliationRequestDto reamHampliationRequestDto);
	public List<ReamHampliationResponseDto> getAll();
	public ReamHampliation get(Long codReam, String ampliataireReam);
	public ReamHampliationResponseDto getById(Long codReam, String ampliataireReam);
	public ReamHampliationResponseDto delete(Long codReam, String ampliataireReam);
}
