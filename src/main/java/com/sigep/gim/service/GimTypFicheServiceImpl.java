package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.TypFicheRequestDto;
import com.sigep.gim.dto.responseDto.TypFicheResponseDto;
import com.sigep.gim.entity.TypFiche;
import com.sigep.gim.repository.GimTypFicheRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimTypFicheServiceImpl implements GimTypFicheService {
	
	private final GimTypFicheRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public TypFicheResponseDto add(TypFicheRequestDto typFicheRequestDto) {
		TypFiche entity = new TypFiche();
		entity.setIdTypFiche(typFicheRequestDto.getIdTypFiche());
		entity.setLibTypFiche(typFicheRequestDto.getLibTypFiche());
		repository.save(entity);
		return modelMapper.map(entity, TypFicheResponseDto.class);
	}
	
	@Override
	public List<TypFicheResponseDto> getAll() {
		List<TypFiche> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, TypFicheResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public TypFiche get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("TypFiche with id "+id+"could not be found")
		);
	}
	
	@Override
	public TypFicheResponseDto getById(String id) {
		TypFiche entity = get(id);
		return modelMapper.map(entity, TypFicheResponseDto.class);
	}
	
	@Override
	@Transactional
	public TypFicheResponseDto delete(String id) {
		TypFiche entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, TypFicheResponseDto.class);
	}
	
	@Override
	@Transactional
	public TypFicheResponseDto edit(String id,TypFicheRequestDto typFicheRequestDto) {
		TypFiche entity = get(id);
		entity.setLibTypFiche(typFicheRequestDto.getLibTypFiche());
		return modelMapper.map(entity, TypFicheResponseDto.class);
	}
}
