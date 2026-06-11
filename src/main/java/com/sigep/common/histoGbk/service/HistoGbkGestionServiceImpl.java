package com.sigep.common.histoGbk.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.common.histoGbk.dto.requestDto.GestionRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.GestionResponsetDto;
import com.sigep.common.histoGbk.entity.Gestion;
import com.sigep.common.histoGbk.repository.HistoGbkGestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional("histoGbkTransactionManager")
public class HistoGbkGestionServiceImpl implements HistoGbkGestionService {
	
	private final HistoGbkGestionRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public GestionResponsetDto add(GestionRequestDto gestionRequestDto) {
		Gestion entity = new Gestion();
		entity.setCourante(gestionRequestDto.getCourante());
		entity.setLibelle(gestionRequestDto.getLibelle());
		entity.setEtat(gestionRequestDto.getEtat());
		entity.setUtilisation(gestionRequestDto.getUtilisation());
		repository.save(entity);
		return modelMapper.map(entity, GestionResponsetDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GestionResponsetDto> getAll() {
		List<Gestion> list = repository.findAll();
		return list
				.stream().map(element  -> modelMapper.map(element, GestionResponsetDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Gestion get(Short id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Gestion with id: " + id + " could not be found"));
	}

	@Override
	@Transactional(readOnly = true)
	public GestionResponsetDto getById(Short id) {
		Gestion entity = get(id);
		return modelMapper.map(entity, GestionResponsetDto.class);
	}

	@Override
	public GestionResponsetDto delete(Short id) {
		Gestion entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, GestionResponsetDto.class);
	}

	@Override
	public GestionResponsetDto edit(Short id, GestionRequestDto gestionRequestDto) {
		Gestion entity = get(id);
		entity.setLibelle(gestionRequestDto.getLibelle());
		entity.setEtat(gestionRequestDto.getEtat());
		entity.setUtilisation(gestionRequestDto.getUtilisation());
		return modelMapper.map(entity, GestionResponsetDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Boolean exists(Short id) {
		return repository.existsById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public GestionResponsetDto getLastByEtat(String etat) {
		Gestion entity = repository.findTopByEtatOrderByCouranteDesc(etat);
		return modelMapper.map(entity, GestionResponsetDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GestionResponsetDto> getAllByEtatOrderByCouranteDesc(String etat) {
		List<Gestion> list = repository.findByEtatOrderByCouranteDesc(etat);
		return list
				.stream().map(element  -> modelMapper.map(element, GestionResponsetDto.class))
				.collect(Collectors.toList());
	}

}
