package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.T13RequestDto;
import com.sigep.gim.dto.responseDto.T13ResponseDto;
import com.sigep.gim.entity.T13;
import com.sigep.gim.repository.GimT13Repository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimT13ServiceImpl implements GimT13Service {
	
	private final GimT13Repository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public T13ResponseDto add(T13RequestDto t13RequestDto) {
		T13 entity = new T13();
		entity.setCodeMat(t13RequestDto.getCodeMat());
		entity.setAnneacq(t13RequestDto.getAnneacq());
		repository.save(entity);
		return modelMapper.map(entity, T13ResponseDto.class);
	}
	
	@Override
	public List<T13ResponseDto> getAll() {
		List<T13> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, T13ResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public T13 get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("T13 with id "+id+"could not be found")
		);
	}
	
	@Override
	public T13ResponseDto getById(String id) {
		T13 entity = get(id);
		return modelMapper.map(entity, T13ResponseDto.class);
	}
	
	@Override
	@Transactional
	public T13ResponseDto delete(String id) {
		T13 entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, T13ResponseDto.class);
	}
	
	@Override
	@Transactional
	public T13ResponseDto edit(String id,T13RequestDto t13RequestDto) {
		T13 entity = get(id);
		entity.setAnneacq(t13RequestDto.getAnneacq());
		return modelMapper.map(entity, T13ResponseDto.class);
	}
}
