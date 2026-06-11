package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.EtatFicheRequestDto;
import com.sigep.gim.dto.responseDto.EtatFicheResponseDto;
import com.sigep.gim.entity.EtatFiche;
import com.sigep.gim.repository.GimEtatFicheRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimEtatFicheServiceImpl implements GimEtatFicheService {
	
	private final GimEtatFicheRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public EtatFicheResponseDto add(EtatFicheRequestDto etatFicheRequestDto) {
		EtatFiche entity = new EtatFiche();
		entity.setEtat(etatFicheRequestDto.getEtat());
		entity.setLibEtat(etatFicheRequestDto.getLibEtat());
		repository.save(entity);
		return modelMapper.map(entity, EtatFicheResponseDto.class);
	}
	
	@Override
	public List<EtatFicheResponseDto> getAll() {
		List<EtatFiche> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, EtatFicheResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public EtatFiche get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("EtatFiche with id "+id+"could not be found")
		);
	}
	
	@Override
	public EtatFicheResponseDto getById(String id) {
		EtatFiche entity = get(id);
		return modelMapper.map(entity, EtatFicheResponseDto.class);
	}
	
	@Override
	@Transactional
	public EtatFicheResponseDto delete(String id) {
		EtatFiche entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, EtatFicheResponseDto.class);
	}
	
	@Override
	@Transactional
	public EtatFicheResponseDto edit(String id,EtatFicheRequestDto etatFicheRequestDto) {
		EtatFiche entity = get(id);
		entity.setLibEtat(etatFicheRequestDto.getLibEtat());
		return modelMapper.map(entity, EtatFicheResponseDto.class);
	}
}
