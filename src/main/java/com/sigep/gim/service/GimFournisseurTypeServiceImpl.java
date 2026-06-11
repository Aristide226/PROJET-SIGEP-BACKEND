package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.FournisseurTypeRequestDto;
import com.sigep.gim.dto.responseDto.FournisseurTypeResponseDto;
import com.sigep.gim.entity.FournisseurType;
import com.sigep.gim.repository.GimFournisseurTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimFournisseurTypeServiceImpl implements GimFournisseurTypeService {
	
	private final GimFournisseurTypeRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public FournisseurTypeResponseDto add(FournisseurTypeRequestDto fournisseurTypeRequestDto) {
		FournisseurType entity = new FournisseurType();
		entity.setTypF(fournisseurTypeRequestDto.getTypF());
		entity.setLibelle(fournisseurTypeRequestDto.getLibelle());
		repository.save(entity);
		return modelMapper.map(entity, FournisseurTypeResponseDto.class);
	}
	
	@Override
	public List<FournisseurTypeResponseDto> getAll() {
		List<FournisseurType> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, FournisseurTypeResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public FournisseurType get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("FournisseurType with id "+id+"could not be found")
		);
	}
	
	@Override
	public FournisseurTypeResponseDto getById(String id) {
		FournisseurType entity = get(id);
		return modelMapper.map(entity, FournisseurTypeResponseDto.class);
	}
	
	@Override
	@Transactional
	public FournisseurTypeResponseDto delete(String id) {
		FournisseurType entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, FournisseurTypeResponseDto.class);
	}
	
	@Override
	@Transactional
	public FournisseurTypeResponseDto edit(String id,FournisseurTypeRequestDto fournisseurTypeRequestDto) {
		FournisseurType entity = get(id);
		entity.setLibelle(fournisseurTypeRequestDto.getLibelle());
		return modelMapper.map(entity, FournisseurTypeResponseDto.class);
	}
}
