package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.ElementEauCouranteRequestDto;
import com.sigep.gim.dto.responseDto.ElementEauCouranteResponseDto;
import com.sigep.gim.entity.ElementEauCourante;
import com.sigep.gim.repository.GimElementEauCouranteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimElementEauCouranteServiceImpl implements GimElementEauCouranteService {
	
	private final GimElementEauCouranteRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public ElementEauCouranteResponseDto add(ElementEauCouranteRequestDto elementEauCouranteRequestDto) {
		ElementEauCourante entity = new ElementEauCourante();
		entity.setBranchement(elementEauCouranteRequestDto.getBranchement());
		repository.save(entity);
		return modelMapper.map(entity, ElementEauCouranteResponseDto.class);
	}
	
	@Override
	public List<ElementEauCouranteResponseDto> getAll() {
		List<ElementEauCourante> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, ElementEauCouranteResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public ElementEauCourante get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("ElementEauCourante with id "+id+"could not be found")
		);
	}
	
	@Override
	public ElementEauCouranteResponseDto getById(int id) {
		ElementEauCourante entity = get(id);
		return modelMapper.map(entity, ElementEauCouranteResponseDto.class);
	}
	
	@Override
	@Transactional
	public ElementEauCouranteResponseDto delete(int id) {
		ElementEauCourante entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, ElementEauCouranteResponseDto.class);
	}
	
	@Override
	@Transactional
	public ElementEauCouranteResponseDto edit(int id,ElementEauCouranteRequestDto elementEauCouranteRequestDto) {
		ElementEauCourante entity = get(id);
		entity.setBranchement(elementEauCouranteRequestDto.getBranchement());
		return modelMapper.map(entity, ElementEauCouranteResponseDto.class);
	}
}
