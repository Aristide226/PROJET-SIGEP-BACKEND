package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.TypeMarcheRequestDto;
import com.sigep.gbc.dto.responseDto.TypeMarcheResponseDto;
import com.sigep.gbc.entity.TypeMarche;
import com.sigep.gbc.repository.TypeMarcheRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeMarcheServiceImpl implements TypeMarcheService{
	
	private final TypeMarcheRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public TypeMarcheResponseDto add(TypeMarcheRequestDto typeMarcheRequestDto) {
		TypeMarche entity = new TypeMarche();
		entity.setCodTypeMarche(typeMarcheRequestDto.getCodTypeMarche());
		entity.setIntitule(typeMarcheRequestDto.getIntitule());
		
		repository.save(entity);
		return GbcMapper2.typeMarcheDtoToTypeMarcheResponseDto(entity);
	}

	@Override
	public List<TypeMarcheResponseDto> getAll() {
		List<TypeMarche> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.typeMarcheDtoToTypeMarcheResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public TypeMarche get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("TypeMarche with id: " + id + " could not be found"));
	}

	@Override
	public TypeMarcheResponseDto getById(String id) {
		TypeMarche entity = get(id);
		return GbcMapper2.typeMarcheDtoToTypeMarcheResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public TypeMarcheResponseDto delete(String id) {
		TypeMarche entity = get(id);
		repository.delete(entity);
		return GbcMapper2.typeMarcheDtoToTypeMarcheResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public TypeMarcheResponseDto edit(String id, TypeMarcheRequestDto typeMarcheRequestDto) {
		TypeMarche entity = get(id);
		entity.setIntitule(typeMarcheRequestDto.getIntitule());
		return GbcMapper2.typeMarcheDtoToTypeMarcheResponseDto(entity);
	}
}
