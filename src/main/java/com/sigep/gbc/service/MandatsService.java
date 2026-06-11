package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.MandatsRequestDto;
import com.sigep.gbc.dto.responseDto.MandatsResponseDto;
import com.sigep.gbc.entity.Mandats;
import com.sigep.gbc.model.IdMandsIdBordEmis;
import com.sigep.gbc.model.InfosPourAbandonnerLiquidation;
import com.sigep.gbc.model.InfosPourRetrograderLiquidation;
import com.sigep.gbc.model.InfosPourValiderLiquidation;


@Service
public interface MandatsService {
	public MandatsResponseDto add(MandatsRequestDto mandatsRequestDto);
	public List<MandatsResponseDto> getAll();
	public Mandats get(Long id);
	public MandatsResponseDto getById(Long id);
	public MandatsResponseDto delete(Long id);
	public MandatsResponseDto edit(Long id, MandatsRequestDto mandatsRequestDto);
	public MandatsResponseDto getByEngagements(Long numbe);
	public Boolean abandonnerLiquidation(InfosPourAbandonnerLiquidation infosPourAbandonnerLiquidation);
	public Boolean validerLiquidation(InfosPourValiderLiquidation infosPourValiderLiquidation);
	public Boolean retrograderLiquidation(InfosPourRetrograderLiquidation retrograderLiquidation);
	public Boolean transmettre(IdMandsIdBordEmis idMandsIdBordEmis);
}
