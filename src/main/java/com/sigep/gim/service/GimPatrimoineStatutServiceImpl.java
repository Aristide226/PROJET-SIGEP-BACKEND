package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PatrimoineStatutRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineStatutResponseDto;
import com.sigep.gim.entity.PatrimoineStatut;
import com.sigep.gim.repository.GimPatrimoineStatutRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimPatrimoineStatutServiceImpl implements GimPatrimoineStatutService {
	
	private final GimPatrimoineStatutRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public PatrimoineStatutResponseDto add(PatrimoineStatutRequestDto patrimoineStatutRequestDto) {
		PatrimoineStatut entity = new PatrimoineStatut();
		entity.setStatPatri(patrimoineStatutRequestDto.getStatPatri());
		entity.setLibelStatPatri(patrimoineStatutRequestDto.getLibelStatPatri());
		repository.save(entity);
		return modelMapper.map(entity, PatrimoineStatutResponseDto.class);
	}
	
	@Override
	public List<PatrimoineStatutResponseDto> getAll() {
		List<PatrimoineStatut> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, PatrimoineStatutResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public PatrimoineStatut get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("PatrimoineStatut with id "+id+"could not be found")
		);
	}
	
	@Override
	public PatrimoineStatutResponseDto getById(String id) {
		PatrimoineStatut entity = get(id);
		return modelMapper.map(entity, PatrimoineStatutResponseDto.class);
	}
	
	@Override
	@Transactional
	public PatrimoineStatutResponseDto delete(String id) {
		PatrimoineStatut entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, PatrimoineStatutResponseDto.class);
	}
	
	@Override
	@Transactional
	public PatrimoineStatutResponseDto edit(String id,PatrimoineStatutRequestDto patrimoineStatutRequestDto) {
		PatrimoineStatut entity = get(id);
		entity.setLibelStatPatri(patrimoineStatutRequestDto.getLibelStatPatri());
		return modelMapper.map(entity, PatrimoineStatutResponseDto.class);
	}
}
