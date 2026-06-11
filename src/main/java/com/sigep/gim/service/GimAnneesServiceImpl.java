package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.AnneesRequestDto;
import com.sigep.gim.dto.responseDto.AnneesResponseDto;
import com.sigep.gim.entity.Annees;
import com.sigep.gim.repository.GimAnneesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimAnneesServiceImpl implements GimAnneesService {
	
	private final GimAnneesRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public AnneesResponseDto add(AnneesRequestDto anneesRequestDto) {
		Annees entity = new Annees();
		entity.setAnnee(anneesRequestDto.getAnnee());
		repository.save(entity);
		return modelMapper.map(entity, AnneesResponseDto.class);
	}
	
	@Override
	public List<AnneesResponseDto> getAll() {
		List<Annees> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, AnneesResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Annees get(short id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Annees with id "+id+"could not be found")
		);
	}
	
	@Override
	public AnneesResponseDto getById(short id) {
		Annees entity = get(id);
		return modelMapper.map(entity, AnneesResponseDto.class);
	}
	
	@Override
	@Transactional
	public AnneesResponseDto delete(short id) {
		Annees entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, AnneesResponseDto.class);
	}
}
