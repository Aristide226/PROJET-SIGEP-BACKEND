package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PiecesRequestDto;
import com.sigep.gim.dto.responseDto.PiecesResponseDto;
import com.sigep.gim.entity.Pieces;
import com.sigep.gim.repository.GimPiecesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimPiecesServiceImpl implements GimPiecesService {
	
	private final GimPiecesRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public PiecesResponseDto add(PiecesRequestDto piecesRequestDto) {
		Pieces entity = new Pieces();
		entity.setNaturePiece(piecesRequestDto.getNaturePiece());
		repository.save(entity);
		return modelMapper.map(entity, PiecesResponseDto.class);
	}
	
	@Override
	public List<PiecesResponseDto> getAll() {
		List<Pieces> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, PiecesResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Pieces get(long id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Pieces with id "+id+"could not be found")
		);
	}
	
	@Override
	public PiecesResponseDto getById(long id) {
		Pieces entity = get(id);
		return modelMapper.map(entity, PiecesResponseDto.class);
	}
	
	@Override
	@Transactional
	public PiecesResponseDto delete(long id) {
		Pieces entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, PiecesResponseDto.class);
	}
	
	@Override
	@Transactional
	public PiecesResponseDto edit(long id,PiecesRequestDto piecesRequestDto) {
		Pieces entity = get(id);
		entity.setNaturePiece(piecesRequestDto.getNaturePiece());
		return modelMapper.map(entity, PiecesResponseDto.class);
	}
}
