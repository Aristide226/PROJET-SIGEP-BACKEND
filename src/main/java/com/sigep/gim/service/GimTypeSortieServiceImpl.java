package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.TypeSortieRequestDto;
import com.sigep.gim.dto.responseDto.TypeSortieResponseDto;
import com.sigep.gim.entity.TypeSortie;
import com.sigep.gim.repository.GimTypeSortieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimTypeSortieServiceImpl implements GimTypeSortieService {
	
	private final GimTypeSortieRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public TypeSortieResponseDto add(TypeSortieRequestDto typeSortieRequestDto) {
		TypeSortie entity = new TypeSortie();
		short typSortie = (short) (findByMaxTypSortie() +1);
		entity.setTypSortie(typSortie);
		entity.setLibSortie(typeSortieRequestDto.getLibSortie());
		entity.setSorti(typeSortieRequestDto.getSorti());
		repository.save(entity);
		return modelMapper.map(entity, TypeSortieResponseDto.class);
	}
	
	@Override
	public List<TypeSortieResponseDto> getAll() {
		List<TypeSortie> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, TypeSortieResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public TypeSortie get(short id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("TypeSortie with id "+id+"could not be found")
		);
	}
	
	@Override
	public TypeSortieResponseDto getById(short id) {
		TypeSortie entity = get(id);
		return modelMapper.map(entity, TypeSortieResponseDto.class);
	}
	
	@Override
	@Transactional
	public TypeSortieResponseDto delete(short id) {
		TypeSortie entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, TypeSortieResponseDto.class);
	}
	
	@Override
	@Transactional
	public TypeSortieResponseDto edit(short id,TypeSortieRequestDto typeSortieRequestDto) {
		TypeSortie entity = get(id);
		entity.setLibSortie(typeSortieRequestDto.getLibSortie());
		entity.setSorti(typeSortieRequestDto.getSorti());
		return modelMapper.map(entity, TypeSortieResponseDto.class);
	}
	
	@Override
	@Transactional
	public short findByMaxTypSortie() {
		return repository.findByMaxTypSortie();
	}
}
