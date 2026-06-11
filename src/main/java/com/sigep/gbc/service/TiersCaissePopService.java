package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.TiersCaissePopRequestDto;
import com.sigep.gbc.dto.responseDto.TiersCaissePopResponseDto;
import com.sigep.gbc.entity.TiersCaissePop;


@Service
public interface TiersCaissePopService {
	public TiersCaissePopResponseDto add(TiersCaissePopRequestDto tiersCaissePopRequestDto);
	public List<TiersCaissePopResponseDto> getAll();
	public TiersCaissePop get(Long id);
	public TiersCaissePopResponseDto getById(Long id);
	public TiersCaissePopResponseDto delete(Long id);
	public TiersCaissePopResponseDto edit(Long id, TiersCaissePopRequestDto tiersCaissePopRequestDto);
}
