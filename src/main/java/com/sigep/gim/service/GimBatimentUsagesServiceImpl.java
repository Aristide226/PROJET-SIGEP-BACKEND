package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.BatimentUsagesRequestDto;
import com.sigep.gim.dto.responseDto.BatimentUsagesResponseDto;
import com.sigep.gim.entity.BatimentUsages;
import com.sigep.gim.repository.GimBatimentUsagesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimBatimentUsagesServiceImpl implements GimBatimentUsagesService {
	
	private final GimBatimentUsagesRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public BatimentUsagesResponseDto add(BatimentUsagesRequestDto batimentUsagesRequestDto) {
		BatimentUsages entity = new BatimentUsages();
		entity.setLibelleUsage(batimentUsagesRequestDto.getLibelleUsage());
		repository.save(entity);
		return modelMapper.map(entity, BatimentUsagesResponseDto.class);
	}
	
	@Override
	public List<BatimentUsagesResponseDto> getAll() {
		List<BatimentUsages> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, BatimentUsagesResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public BatimentUsages get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("BatimentUsages with id "+id+"could not be found")
		);
	}
	
	@Override
	public BatimentUsagesResponseDto getById(int id) {
		BatimentUsages entity = get(id);
		return modelMapper.map(entity, BatimentUsagesResponseDto.class);
	}
	
	@Override
	@Transactional
	public BatimentUsagesResponseDto delete(int id) {
		BatimentUsages entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, BatimentUsagesResponseDto.class);
	}
	
	@Override
	@Transactional
	public BatimentUsagesResponseDto edit(int id,BatimentUsagesRequestDto batimentUsagesRequestDto) {
		BatimentUsages entity = get(id);
		entity.setLibelleUsage(batimentUsagesRequestDto.getLibelleUsage());
		return modelMapper.map(entity, BatimentUsagesResponseDto.class);
	}
}
