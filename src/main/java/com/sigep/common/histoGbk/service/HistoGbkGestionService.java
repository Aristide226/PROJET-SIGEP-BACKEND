package com.sigep.common.histoGbk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.common.histoGbk.dto.requestDto.GestionRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.GestionResponsetDto;
import com.sigep.common.histoGbk.entity.Gestion;



@Service
public interface HistoGbkGestionService {
	public GestionResponsetDto add(GestionRequestDto gestionRequestDto);
	public List<GestionResponsetDto> getAll();
	public Gestion get(Short id);
	public GestionResponsetDto getById(Short id);
	public GestionResponsetDto delete(Short id);
	public GestionResponsetDto edit(Short id, GestionRequestDto gestionRequestDto);
	public Boolean exists(Short id);
	public GestionResponsetDto getLastByEtat(String etat);
	public List<GestionResponsetDto> getAllByEtatOrderByCouranteDesc(String etat);
}
