package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.GestionRequestDto;
import com.sigep.gbc.dto.responseDto.GestionResponsetDto;
import com.sigep.gbc.entity.Gestion;


@Service
public interface GestionService {
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
