package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.TitreDetailRequestDto;
import com.sigep.gbc.dto.responseDto.TitreDetailResponseDto;
import com.sigep.gbc.entity.TitreDetail;


@Service
public interface TitreDetailService {
	public TitreDetailResponseDto add(TitreDetailRequestDto titreDetailRequestDto);
	public List<TitreDetailResponseDto> getAll();
	public TitreDetail get(Long id);
	public TitreDetailResponseDto getById(Long id);
	public TitreDetailResponseDto delete(Long id);
	public TitreDetailResponseDto edit(Long id, TitreDetailRequestDto titreDetailRequestDto);
}
