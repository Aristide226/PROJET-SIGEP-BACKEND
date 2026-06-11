package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.InventaireTypeRequestDto;
import com.sigep.gim.dto.responseDto.InventaireTypeResponseDto;
import com.sigep.gim.entity.InventaireType;
import com.sigep.gim.repository.GimInventaireTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimInventaireTypeServiceImpl implements GimInventaireTypeService {
	
	private final GimInventaireTypeRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public InventaireTypeResponseDto add(InventaireTypeRequestDto inventaireTypeRequestDto) {
		InventaireType entity = new InventaireType();
		entity.setLibTypeInvent(inventaireTypeRequestDto.getLibTypeInvent());
		repository.save(entity);
		return modelMapper.map(entity, InventaireTypeResponseDto.class);
	}
	
	@Override
	public List<InventaireTypeResponseDto> getAll() {
		List<InventaireType> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, InventaireTypeResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public InventaireType get(short id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("InventaireType with id "+id+"could not be found")
		);
	}
	
	@Override
	public InventaireTypeResponseDto getById(short id) {
		InventaireType entity = get(id);
		return modelMapper.map(entity, InventaireTypeResponseDto.class);
	}
	
	@Override
	@Transactional
	public InventaireTypeResponseDto delete(short id) {
		InventaireType entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, InventaireTypeResponseDto.class);
	}
	
	@Override
	@Transactional
	public InventaireTypeResponseDto edit(short id,InventaireTypeRequestDto inventaireTypeRequestDto) {
		InventaireType entity = get(id);
		entity.setLibTypeInvent(inventaireTypeRequestDto.getLibTypeInvent());
		return modelMapper.map(entity, InventaireTypeResponseDto.class);
	}
}
