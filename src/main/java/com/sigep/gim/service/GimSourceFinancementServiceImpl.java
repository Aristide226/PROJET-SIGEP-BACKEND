package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.FinancementStatistiqueDto;
import com.sigep.gim.dto.requestDto.SourceFinancementRequestDto;
import com.sigep.gim.dto.responseDto.SourceFinancementResponseDto;
import com.sigep.gim.entity.SourceFinancement;
import com.sigep.gim.repository.GimSourceFinancementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimSourceFinancementServiceImpl implements GimSourceFinancementService {
	
	private final GimSourceFinancementRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public SourceFinancementResponseDto add(SourceFinancementRequestDto sourceFinancementRequestDto) {
		SourceFinancement entity = new SourceFinancement();
		entity.setCodSourceFin(sourceFinancementRequestDto.getCodSourceFin());
		entity.setLibSourceFin(sourceFinancementRequestDto.getLibSourceFin());
		entity.setAbrevSourceFin(sourceFinancementRequestDto.getAbrevSourceFin());
		repository.save(entity);
		return modelMapper.map(entity, SourceFinancementResponseDto.class);
	}
	
	@Override
	public List<SourceFinancementResponseDto> getAll() {
		List<SourceFinancement> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, SourceFinancementResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public SourceFinancement get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("SourceFinancement with id "+id+"could not be found")
		);
	}
	
	@Override
	public SourceFinancementResponseDto getById(String id) {
		SourceFinancement entity = get(id);
		return modelMapper.map(entity, SourceFinancementResponseDto.class);
	}
	
	@Override
	@Transactional
	public SourceFinancementResponseDto delete(String id) {
		SourceFinancement entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, SourceFinancementResponseDto.class);
	}
	
	@Override
	@Transactional
	public SourceFinancementResponseDto edit(String id,SourceFinancementRequestDto sourceFinancementRequestDto) {
		SourceFinancement entity = get(id);
		entity.setLibSourceFin(sourceFinancementRequestDto.getLibSourceFin());
		entity.setAbrevSourceFin(sourceFinancementRequestDto.getAbrevSourceFin());
		return modelMapper.map(entity, SourceFinancementResponseDto.class);
	}
	
	@Override
	@Transactional
	public List<FinancementStatistiqueDto> getFinancementStatistiqueParCategorie() {
		return repository.getFinancementStatistiqueParCategorie();
	}
}
