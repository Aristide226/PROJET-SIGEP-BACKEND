package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.TitreRegulApartirRequestDto;
import com.sigep.gbc.dto.responseDto.TitreRegulApartirResponseDto;
import com.sigep.gbc.entity.TitreRegulApartir;
import com.sigep.gbc.repository.TitreRegulApartirRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TitreRegulApartirServiceImpl implements TitreRegulApartirService{
	
	private final TitreRegulApartirRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public TitreRegulApartirResponseDto add(TitreRegulApartirRequestDto titreRegulApartirRequestDto) {
		TitreRegulApartir entity = new TitreRegulApartir();
		entity.setIdApartir(titreRegulApartirRequestDto.getIdApartir());
		entity.setLibelleApartir(titreRegulApartirRequestDto.getLibelleApartir());
		entity.setRegularisation(titreRegulApartirRequestDto.getRegularisation());
		
		repository.save(entity);
		return GbcMapper.traToTraResponseDto(entity);
	}

	@Override
	public List<TitreRegulApartirResponseDto> getAll() {
		List<TitreRegulApartir> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.traToTraResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public TitreRegulApartir get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("TitreRegulApartir with id: " + id + " could not be found"));
	}

	@Override
	public TitreRegulApartirResponseDto getById(Integer id) {
		TitreRegulApartir entity = get(id);
		return GbcMapper.traToTraResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public TitreRegulApartirResponseDto delete(Integer id) {
		TitreRegulApartir entity = get(id);
		repository.delete(entity);
		return GbcMapper.traToTraResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public TitreRegulApartirResponseDto edit(Integer id, TitreRegulApartirRequestDto titreRegulApartirRequestDto) {
		TitreRegulApartir entity = get(id);
		entity.setLibelleApartir(titreRegulApartirRequestDto.getLibelleApartir());
		entity.setRegularisation(titreRegulApartirRequestDto.getRegularisation());
		return GbcMapper.traToTraResponseDto(entity);
	}	
}
