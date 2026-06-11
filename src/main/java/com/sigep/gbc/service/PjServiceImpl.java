package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.PjRequestDto;
import com.sigep.gbc.dto.responseDto.PjResponseDto;
import com.sigep.gbc.entity.Pj;
import com.sigep.gbc.repository.PjRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PjServiceImpl implements PjService {
	
	private final PjRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public PjResponseDto add(PjRequestDto pjRequestDto) {
		Pj entity = new Pj();
		entity.setPj(pjRequestDto.getPj());
		entity.setAvecMontant(pjRequestDto.getAvecMontant());
		repository.save(entity);
		return GbcMapper.PjToPjResponseDto(entity);
	}

	@Override
	public List<PjResponseDto> getAll() {
		List<Pj> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.PjToPjResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public Pj get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Pj with id: " + id + " could not be found"));
	}

	@Override
	public PjResponseDto getById(Integer id) {
		Pj entity = get(id);
		return GbcMapper.PjToPjResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public PjResponseDto delete(Integer id) {
		Pj entity = get(id);
		repository.delete(entity);
		return GbcMapper.PjToPjResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public PjResponseDto edit(Integer id, PjRequestDto pjRequestDto) {
		Pj entity = get(id);
		entity.setPj(pjRequestDto.getPj());
		entity.setAvecMontant(pjRequestDto.getAvecMontant());
		return GbcMapper.PjToPjResponseDto(entity);
	}
}
