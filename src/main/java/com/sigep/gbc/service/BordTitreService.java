package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.BordTitreDto;
import com.sigep.gbc.entity.BordTitre;


@Service
public interface BordTitreService {
	public BordTitreDto add(BordTitreDto bordTitreDto);
	public List<BordTitreDto> getAll();
	public BordTitre get(String idBord, Long idDetailTitre);
	public BordTitreDto getById(String idBord, Long idDetailTitre);
	public BordTitreDto delete(String idBord, Long idDetailTitre);
	public BordTitreDto edit(String idBord, Long idDetailTitre, BordTitreDto bordTitreDto);
}
