package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.MagasinEntrepotRequestDto;
import com.sigep.gim.dto.responseDto.MagasinEntrepotResponseDto;
import com.sigep.gim.entity.MagasinEntrepot;
import com.sigep.gim.repository.GimMagasinEntrepotRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimMagasinEntrepotServiceImpl implements GimMagasinEntrepotService {
	
	private final GimMagasinEntrepotRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public MagasinEntrepotResponseDto add(MagasinEntrepotRequestDto magasinEntrepotRequestDto) {
		MagasinEntrepot entity = new MagasinEntrepot();
		entity.setLibelleMagasin(magasinEntrepotRequestDto.getLibelleMagasin());
		repository.save(entity);
		return modelMapper.map(entity, MagasinEntrepotResponseDto.class);
	}
	
	@Override
	public List<MagasinEntrepotResponseDto> getAll() {
		List<MagasinEntrepot> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, MagasinEntrepotResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public MagasinEntrepot get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("MagasinEntrepot with id "+id+"could not be found")
		);
	}
	
	@Override
	public MagasinEntrepotResponseDto getById(int id) {
		MagasinEntrepot entity = get(id);
		return modelMapper.map(entity, MagasinEntrepotResponseDto.class);
	}
	
	@Override
	@Transactional
	public MagasinEntrepotResponseDto delete(int id) {
		MagasinEntrepot entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, MagasinEntrepotResponseDto.class);
	}
	
	@Override
	@Transactional
	public MagasinEntrepotResponseDto edit(int id,MagasinEntrepotRequestDto magasinEntrepotRequestDto) {
		MagasinEntrepot entity = get(id);
		entity.setLibelleMagasin(magasinEntrepotRequestDto.getLibelleMagasin());
		repository.save(entity);
		return modelMapper.map(entity, MagasinEntrepotResponseDto.class);
	}
}
