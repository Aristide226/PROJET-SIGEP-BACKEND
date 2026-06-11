package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.DirectionServiceNiveauRequestDto;
import com.sigep.gbc.dto.responseDto.DirectionServiceNiveauResponseDto;
import com.sigep.gbc.entity.DirectionServiceNiveau;
import com.sigep.gbc.repository.DirectionServiceNiveauRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DirectionServiceNiveauServiceImpl implements DirectionServiceNiveauService{

	private final DirectionServiceNiveauRepository repository;
	
	@Override
	@Transactional("gbcTransactionManager")
	public DirectionServiceNiveauResponseDto add(DirectionServiceNiveauRequestDto directionServiceNiveauRequestDto) {
		DirectionServiceNiveau directionServiceNiveau = new DirectionServiceNiveau();
		directionServiceNiveau.setIdNiveau(directionServiceNiveauRequestDto.getIdNiveau());
		directionServiceNiveau.setLibelleNiveau(directionServiceNiveauRequestDto.getLibelleNiveau());
		repository.save(directionServiceNiveau);
		return GbcMapper.dsnToDsnResponseDto(directionServiceNiveau);
	}

	@Override
	public List<DirectionServiceNiveauResponseDto> getAll() {
		List<DirectionServiceNiveau> directionServiceNiveaus = repository.findAll();
		return directionServiceNiveaus
				.stream().map(element  -> GbcMapper.dsnToDsnResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public DirectionServiceNiveau get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("DirectionServiceNiveau with id: " + id + " could not be found"));
	}

	@Override
	public DirectionServiceNiveauResponseDto getById(Integer id) {
		DirectionServiceNiveau directionServiceNiveau = get(id);
		return GbcMapper.dsnToDsnResponseDto(directionServiceNiveau);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public DirectionServiceNiveauResponseDto delete(Integer id) {
		DirectionServiceNiveau directionServiceNiveau = get(id);
		repository.delete(directionServiceNiveau);
		return GbcMapper.dsnToDsnResponseDto(directionServiceNiveau);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public DirectionServiceNiveauResponseDto edit(Integer id, DirectionServiceNiveauRequestDto directionServiceNiveauRequestDto) {
		DirectionServiceNiveau directionServiceNiveau = get(id);
		directionServiceNiveau.setLibelleNiveau(directionServiceNiveauRequestDto.getLibelleNiveau());
		return GbcMapper.dsnToDsnResponseDto(directionServiceNiveau);
	}

}
