package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gim.dto.requestDto.DirectionsRequestDto;
import com.sigep.gim.dto.responseDto.DirectionsResponseDto;
import com.sigep.gim.entity.Directions;
import com.sigep.gim.repository.GimDirectionsRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional("gimTransactionManager")
@RequiredArgsConstructor
public class GimDirectionsServiceImpl implements GimDirectionsService {
	
	private final GimDirectionsRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public DirectionsResponseDto add(DirectionsRequestDto directionsRequestDto) {
		Directions entity = new Directions();
		entity.setNomDirection(directionsRequestDto.getNomDirection());
		entity.setAbrev(directionsRequestDto.getAbrev());
		entity.setCodeDir(directionsRequestDto.getCodeDir());
		repository.save(entity);
		return modelMapper.map(entity, DirectionsResponseDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DirectionsResponseDto> getAll() {
		List<Directions> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, DirectionsResponseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Directions get(int id) {
		return repository.findById(id).orElseThrow(() -> (
				new IllegalArgumentException("Directions with id "+id+" could not be found")
		));
	}

	@Override
	@Transactional(readOnly = true)
	public DirectionsResponseDto getById(int id) {
		Directions entity = get(id);
		return modelMapper.map(entity, DirectionsResponseDto.class);
	}

	@Override
	public DirectionsResponseDto delete(int id) {
		Directions entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, DirectionsResponseDto.class);
	}

	@Override
	public DirectionsResponseDto edit(int id, DirectionsRequestDto directionsRequestDto) {
		Directions entity = get(id);
		entity.setNomDirection(directionsRequestDto.getNomDirection());
		entity.setAbrev(directionsRequestDto.getAbrev());
		entity.setCodeDir(directionsRequestDto.getCodeDir());
		return modelMapper.map(entity, DirectionsResponseDto.class);
	}
}
