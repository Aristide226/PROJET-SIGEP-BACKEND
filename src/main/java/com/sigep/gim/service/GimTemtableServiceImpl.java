package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.TemtableRequestDto;
import com.sigep.gim.dto.responseDto.TemtableResponseDto;
import com.sigep.gim.entity.Temtable;
import com.sigep.gim.repository.GimTemtableRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimTemtableServiceImpl implements GimTemtableService {
	
	private final GimTemtableRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public TemtableResponseDto add(TemtableRequestDto temtableRequestDto) {
		Temtable entity = new Temtable();
		entity.setMle(temtableRequestDto.getMle());
		entity.setNumAffect(temtableRequestDto.getNumAffect());
		entity.setDesignation(temtableRequestDto.getDesignation());
		entity.setType(temtableRequestDto.getType());
		entity.setEtat(temtableRequestDto.getEtat());
		entity.setFormat(temtableRequestDto.getFormat());
		entity.setDateAcq(temtableRequestDto.getDateAcq());
		entity.setService(temtableRequestDto.getService());
		entity.setNomUtil(temtableRequestDto.getNomUtil());
		repository.save(entity);
		return modelMapper.map(entity, TemtableResponseDto.class);
	}
	
	@Override
	public List<TemtableResponseDto> getAll() {
		List<Temtable> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, TemtableResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Temtable get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Temtable with id "+id+"could not be found")
		);
	}
	
	@Override
	public TemtableResponseDto getById(String id) {
		Temtable entity = get(id);
		return modelMapper.map(entity, TemtableResponseDto.class);
	}
	
	@Override
	@Transactional
	public TemtableResponseDto delete(String id) {
		Temtable entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, TemtableResponseDto.class);
	}
	
	@Override
	@Transactional
	public TemtableResponseDto edit(String id,TemtableRequestDto temtableRequestDto) {
		Temtable entity = get(id);
		entity.setMle(temtableRequestDto.getMle());
		entity.setNumAffect(temtableRequestDto.getNumAffect());
		entity.setDesignation(temtableRequestDto.getDesignation());
		entity.setType(temtableRequestDto.getType());
		entity.setEtat(temtableRequestDto.getEtat());
		entity.setFormat(temtableRequestDto.getFormat());
		entity.setDateAcq(temtableRequestDto.getDateAcq());
		entity.setService(temtableRequestDto.getService());
		entity.setNomUtil(temtableRequestDto.getNomUtil());
		return modelMapper.map(entity, TemtableResponseDto.class);
	}
}
