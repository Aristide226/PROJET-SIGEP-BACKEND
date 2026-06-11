package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.GestionRequestDto;
import com.sigep.gbc.dto.responseDto.GestionResponsetDto;
import com.sigep.gbc.entity.Gestion;
import com.sigep.gbc.repository.GestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestionServiceImpl implements GestionService {
	
	private final GestionRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public GestionResponsetDto add(GestionRequestDto gestionRequestDto) {
		Gestion gestion = new Gestion();
		gestion.setCourante(gestionRequestDto.getCourante());
		gestion.setLibelle(gestionRequestDto.getLibelle());
		gestion.setEtat(gestionRequestDto.getEtat());
		gestion.setUtilisation(gestionRequestDto.getUtilisation());
		repository.save(gestion);
		return GbcMapper.gToGResponseDto(gestion);
	}

	@Override
	public List<GestionResponsetDto> getAll() {
		List<Gestion> gestions = repository.findAll();
		return gestions
				.stream().map(element  -> GbcMapper.gToGResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public Gestion get(Short id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Gestion with id: " + id + " could not be found"));
	}

	@Override
	public GestionResponsetDto getById(Short id) {
		Gestion gestion = get(id);
		return GbcMapper.gToGResponseDto(gestion);
	}

	@Transactional("gbcTransactionManager")
	@Override
	public GestionResponsetDto delete(Short id) {
		Gestion gestion = get(id);
		repository.delete(gestion);
		return GbcMapper.gToGResponseDto(gestion);
	}

	@Transactional("gbcTransactionManager")
	@Override
	public GestionResponsetDto edit(Short id, GestionRequestDto gestionRequestDto) {
		Gestion gestion = get(id);
		gestion.setLibelle(gestionRequestDto.getLibelle());
		gestion.setEtat(gestionRequestDto.getEtat());
		gestion.setUtilisation(gestionRequestDto.getUtilisation());
		return GbcMapper.gToGResponseDto(gestion);
	}

	@Override
	public Boolean exists(Short id) {
		return repository.existsById(id);
	}

	@Override
	public GestionResponsetDto getLastByEtat(String etat) {
		Gestion gestion = repository.findTopByEtatOrderByCouranteDesc(etat);
		return GbcMapper.gToGResponseDto(gestion);
	}

	@Override
	public List<GestionResponsetDto> getAllByEtatOrderByCouranteDesc(String etat) {
		List<Gestion> gestions = repository.findByEtatOrderByCouranteDesc(etat);
		return gestions
				.stream().map(element  -> GbcMapper.gToGResponseDto(element))
				.collect(Collectors.toList());
	}

}
