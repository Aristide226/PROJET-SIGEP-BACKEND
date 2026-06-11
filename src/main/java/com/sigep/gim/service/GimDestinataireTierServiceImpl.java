package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.DestinataireTierRequestDto;
import com.sigep.gim.dto.responseDto.DestinataireTierResponseDto;
import com.sigep.gim.entity.DestinataireTier;
import com.sigep.gim.repository.GimDestinataireTierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimDestinataireTierServiceImpl implements GimDestinataireTierService {
	
	private final GimDestinataireTierRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public DestinataireTierResponseDto add(DestinataireTierRequestDto destinataireTierRequestDto) {
		DestinataireTier entity = new DestinataireTier();
		entity.setLidDest(destinataireTierRequestDto.getLidDest());
		repository.save(entity);
		return modelMapper.map(entity, DestinataireTierResponseDto.class);
	}
	
	@Override
	public List<DestinataireTierResponseDto> getAll() {
		List<DestinataireTier> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, DestinataireTierResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public DestinataireTier get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("DestinataireTier with id "+id+"could not be found")
		);
	}
	
	@Override
	public DestinataireTierResponseDto getById(int id) {
		DestinataireTier entity = get(id);
		return modelMapper.map(entity, DestinataireTierResponseDto.class);
	}
	
	@Override
	@Transactional
	public DestinataireTierResponseDto delete(int id) {
		DestinataireTier entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, DestinataireTierResponseDto.class);
	}
	
	@Override
	@Transactional
	public DestinataireTierResponseDto edit(int id,DestinataireTierRequestDto destinataireTierRequestDto) {
		DestinataireTier entity = get(id);
		entity.setLidDest(destinataireTierRequestDto.getLidDest());
		return modelMapper.map(entity, DestinataireTierResponseDto.class);
	}
}
