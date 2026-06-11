package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.ReamHvisaResquestDto;
import com.sigep.gbc.dto.responseDto.ReamHvisaResponseDto;
import com.sigep.gbc.entity.ReamHvisa;


@Service
public interface ReamHvisaService {
	public ReamHvisaResponseDto add(ReamHvisaResquestDto reamHvisaResquestDto);
	public List<ReamHvisaResponseDto> getAll();
	public ReamHvisa get(Long codReam, Integer rangVisa);
	public ReamHvisaResponseDto getById(Long codReam, Integer rangVisa);
	public ReamHvisaResponseDto delete(Long codReam, Integer rangVisa);
	public ReamHvisaResponseDto edit(Long codReam, Integer rangVisa, ReamHvisaResquestDto reamHvisaResquestDto);
}
