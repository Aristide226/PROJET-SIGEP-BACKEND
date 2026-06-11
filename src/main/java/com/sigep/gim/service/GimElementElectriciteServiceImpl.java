package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.ElementElectriciteRequestDto;
import com.sigep.gim.dto.responseDto.ElementElectriciteResponseDto;
import com.sigep.gim.entity.ElementElectricite;
import com.sigep.gim.repository.GimElementElectriciteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimElementElectriciteServiceImpl implements GimElementElectriciteService {
	
	private final GimElementElectriciteRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public ElementElectriciteResponseDto add(ElementElectriciteRequestDto elementElectriciteRequestDto) {
		ElementElectricite entity = new ElementElectricite();
		entity.setValeurs(elementElectriciteRequestDto.getValeurs());
		repository.save(entity);
		return modelMapper.map(entity, ElementElectriciteResponseDto.class);
	}
	
	@Override
	public List<ElementElectriciteResponseDto> getAll() {
		List<ElementElectricite> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, ElementElectriciteResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public ElementElectricite get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("ElementElectricite with id "+id+"could not be found")
		);
	}
	
	@Override
	public ElementElectriciteResponseDto getById(int id) {
		ElementElectricite entity = get(id);
		return modelMapper.map(entity, ElementElectriciteResponseDto.class);
	}
	
	@Override
	@Transactional
	public ElementElectriciteResponseDto delete(int id) {
		ElementElectricite entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, ElementElectriciteResponseDto.class);
	}
	
	@Override
	@Transactional
	public ElementElectriciteResponseDto edit(int id,ElementElectriciteRequestDto elementElectriciteRequestDto) {
		ElementElectricite entity = get(id);
		entity.setValeurs(elementElectriciteRequestDto.getValeurs());
		return modelMapper.map(entity, ElementElectriciteResponseDto.class);
	}
}
