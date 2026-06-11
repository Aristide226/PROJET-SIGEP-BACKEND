package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.BatimentMateriauxConstrutRequestDto;
import com.sigep.gim.dto.responseDto.BatimentMateriauxConstrutResponseDto;
import com.sigep.gim.entity.BatimentMateriauxConstrut;
import com.sigep.gim.repository.GimBatimentMateriauxConstrutRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimBatimentMateriauxConstrutServiceImpl implements GimBatimentMateriauxConstrutService {
	
	private final GimBatimentMateriauxConstrutRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public BatimentMateriauxConstrutResponseDto add(BatimentMateriauxConstrutRequestDto batimentMateriauxConstrutRequestDto) {
		BatimentMateriauxConstrut entity = new BatimentMateriauxConstrut();
		entity.setLibelleMateriaux(batimentMateriauxConstrutRequestDto.getLibelleMateriaux());
		repository.save(entity);
		return modelMapper.map(entity, BatimentMateriauxConstrutResponseDto.class);
	}
	
	@Override
	public List<BatimentMateriauxConstrutResponseDto> getAll() {
		List<BatimentMateriauxConstrut> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, BatimentMateriauxConstrutResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public BatimentMateriauxConstrut get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("BatimentMateriauxConstrut with id "+id+"could not be found")
		);
	}
	
	@Override
	public BatimentMateriauxConstrutResponseDto getById(int id) {
		BatimentMateriauxConstrut entity = get(id);
		return modelMapper.map(entity, BatimentMateriauxConstrutResponseDto.class);
	}
	
	@Override
	@Transactional
	public BatimentMateriauxConstrutResponseDto delete(int id) {
		BatimentMateriauxConstrut entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, BatimentMateriauxConstrutResponseDto.class);
	}
	
	@Override
	@Transactional
	public BatimentMateriauxConstrutResponseDto edit(int id,BatimentMateriauxConstrutRequestDto batimentMateriauxConstrutRequestDto) {
		BatimentMateriauxConstrut entity = get(id);
		entity.setLibelleMateriaux(batimentMateriauxConstrutRequestDto.getLibelleMateriaux());
		return modelMapper.map(entity, BatimentMateriauxConstrutResponseDto.class);
	}
}
