package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.TypeAcquisitionRequestDto;
import com.sigep.gim.dto.responseDto.TypeAcquisitionResponseDto;
import com.sigep.gim.entity.TypeAcquisition;
import com.sigep.gim.repository.GimTypeAcquisitionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimTypeAcquisitionServiceImpl implements GimTypeAcquisitionService {
	
	private final GimTypeAcquisitionRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public TypeAcquisitionResponseDto add(TypeAcquisitionRequestDto typeAcquisitionRequestDto) {
		TypeAcquisition entity = new TypeAcquisition();
		entity.setLibTypeAcq(typeAcquisitionRequestDto.getLibTypeAcq());
		entity.setExigerEngagement(typeAcquisitionRequestDto.isExigerEngagement());
		repository.save(entity);
		return modelMapper.map(entity, TypeAcquisitionResponseDto.class);
	}
	
	@Override
	public List<TypeAcquisitionResponseDto> getAll() {
		List<TypeAcquisition> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, TypeAcquisitionResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public TypeAcquisition get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("TypeAcquisition with id "+id+"could not be found")
		);
	}
	
	@Override
	public TypeAcquisitionResponseDto getById(int id) {
		TypeAcquisition entity = get(id);
		return modelMapper.map(entity, TypeAcquisitionResponseDto.class);
	}
	
	@Override
	@Transactional
	public TypeAcquisitionResponseDto delete(int id) {
		TypeAcquisition entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, TypeAcquisitionResponseDto.class);
	}
	
	@Override
	@Transactional
	public TypeAcquisitionResponseDto edit(int id,TypeAcquisitionRequestDto typeAcquisitionRequestDto) {
		TypeAcquisition entity = get(id);
		entity.setLibTypeAcq(typeAcquisitionRequestDto.getLibTypeAcq());
		entity.setExigerEngagement(typeAcquisitionRequestDto.isExigerEngagement());
		return modelMapper.map(entity, TypeAcquisitionResponseDto.class);
	}
}
