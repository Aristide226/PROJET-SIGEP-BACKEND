package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.ActeNatureRequestDto;
import com.sigep.gbc.dto.responseDto.ActeNatureResponseDto;
import com.sigep.gbc.entity.ActeNature;


@Service
public interface ActeNatureService {
	public ActeNatureResponseDto add(ActeNatureRequestDto acteNatureRequestDto);
	public List<ActeNatureResponseDto> getAll();
	public ActeNature get(Integer id);
	public ActeNatureResponseDto getById(Integer id);
	public ActeNatureResponseDto delete(Integer id);
	public ActeNatureResponseDto edit(Integer id, ActeNatureRequestDto acteNatureRequestDto);
}
