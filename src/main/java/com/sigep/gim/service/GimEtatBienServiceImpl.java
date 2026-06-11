package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.EtatBienRequestDto;
import com.sigep.gim.dto.responseDto.EtatBienResponseDto;
import com.sigep.gim.entity.EtatBien;
import com.sigep.gim.repository.GimEtatBienRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimEtatBienServiceImpl implements GimEtatBienService {
	
	private final GimEtatBienRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public EtatBienResponseDto add(EtatBienRequestDto etatBienRequestDto) {
		EtatBien entity = new EtatBien();
		
		repository.save(entity);
		return modelMapper.map(entity, EtatBienResponseDto.class);
	}
	
	@Override
	public List<EtatBienResponseDto> getAll() {
		List<EtatBien> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, EtatBienResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public EtatBien get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("EtatBien with id "+id+"could not be found")
		);
	}
	
	@Override
	public EtatBienResponseDto getById(String id) {
		EtatBien entity = get(id);
		return modelMapper.map(entity, EtatBienResponseDto.class);
	}
	
	@Override
	@Transactional
	public EtatBienResponseDto delete(String id) {
		EtatBien entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, EtatBienResponseDto.class);
	}
}
