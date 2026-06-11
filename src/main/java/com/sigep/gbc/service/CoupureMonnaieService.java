package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.CoupureMonnaieDto;
import com.sigep.gbc.entity.CoupureMonnaie;


@Service
public interface CoupureMonnaieService {
	public CoupureMonnaieDto add(CoupureMonnaieDto coupureMonnaieDto);
	public List<CoupureMonnaieDto> getAll();
	public CoupureMonnaie get(String designa, Long idCoupure);
	public CoupureMonnaieDto getById(String designa, Long idCoupure);
	public CoupureMonnaieDto delete(String designa, Long idCoupure);
	public void edit(String designa, Long idCoupure, CoupureMonnaieDto coupureMonnaieDto);
}
