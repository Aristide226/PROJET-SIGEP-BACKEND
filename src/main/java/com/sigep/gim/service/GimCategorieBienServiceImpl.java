package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.CategorieBienRequestDto;
import com.sigep.gim.dto.responseDto.CategorieBienResponseDto;
import com.sigep.gim.entity.CategorieBien;
import com.sigep.gim.repository.GimCategorieBienRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimCategorieBienServiceImpl implements GimCategorieBienService {
	
	private final GimCategorieBienRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public CategorieBienResponseDto add(CategorieBienRequestDto categorieBienRequestDto) {
		
		int maxCodCategorie = findMaxCodCategorie() + 1;
		CategorieBien entity = new CategorieBien();
		entity.setCodCategorie(maxCodCategorie);
		entity.setLibCategorieBien(categorieBienRequestDto.getLibCategorieBien());
		repository.save(entity);
		return modelMapper.map(entity, CategorieBienResponseDto.class);
	}
	
	@Override
	public List<CategorieBienResponseDto> getAll() {
		List<CategorieBien> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, CategorieBienResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public CategorieBien get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("CategorieBien with id "+id+"could not be found")
		);
	}
	
	@Override
	public CategorieBienResponseDto getById(int id) {
		CategorieBien entity = get(id);
		return modelMapper.map(entity, CategorieBienResponseDto.class);
	}
	
	@Override
	@Transactional
	public CategorieBienResponseDto delete(int id) {
		CategorieBien entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, CategorieBienResponseDto.class);
	}
	
	@Override
	@Transactional
	public CategorieBienResponseDto edit(int id,CategorieBienRequestDto categorieBienRequestDto) {
		CategorieBien entity = get(id);
		return modelMapper.map(entity, CategorieBienResponseDto.class);
	}
	
	@Override
	@Transactional
	public Integer findMaxCodCategorie() {
		return repository.findMaxCodCategorie();
	}
}
