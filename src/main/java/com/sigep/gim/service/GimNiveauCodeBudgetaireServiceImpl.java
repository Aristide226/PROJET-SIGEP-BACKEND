package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.NiveauCodeBudgetaireRequestDto;
import com.sigep.gim.dto.responseDto.NiveauCodeBudgetaireResponseDto;
import com.sigep.gim.entity.NiveauCodeBudgetaire;
import com.sigep.gim.repository.GimNiveauCodeBudgetaireRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimNiveauCodeBudgetaireServiceImpl implements GimNiveauCodeBudgetaireService {
	
	private final GimNiveauCodeBudgetaireRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public NiveauCodeBudgetaireResponseDto add(NiveauCodeBudgetaireRequestDto niveauCodeBudgetaireRequestDto) {
		NiveauCodeBudgetaire entity = new NiveauCodeBudgetaire();
		entity.setNiveau(niveauCodeBudgetaireRequestDto.getNiveau());
		entity.setIntituleNiveau(niveauCodeBudgetaireRequestDto.getIntituleNiveau());
		entity.setDescription(niveauCodeBudgetaireRequestDto.getDescription());
		repository.save(entity);
		return modelMapper.map(entity, NiveauCodeBudgetaireResponseDto.class);
	}
	
	@Override
	public List<NiveauCodeBudgetaireResponseDto> getAll() {
		List<NiveauCodeBudgetaire> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, NiveauCodeBudgetaireResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public NiveauCodeBudgetaire get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("NiveauCodeBudgetaire with id "+id+"could not be found")
		);
	}
	
	@Override
	public NiveauCodeBudgetaireResponseDto getById(int id) {
		NiveauCodeBudgetaire entity = get(id);
		return modelMapper.map(entity, NiveauCodeBudgetaireResponseDto.class);
	}
	
	@Override
	@Transactional
	public NiveauCodeBudgetaireResponseDto delete(int id) {
		NiveauCodeBudgetaire entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, NiveauCodeBudgetaireResponseDto.class);
	}
	
	@Override
	@Transactional
	public NiveauCodeBudgetaireResponseDto edit(int id,NiveauCodeBudgetaireRequestDto niveauCodeBudgetaireRequestDto) {
		NiveauCodeBudgetaire entity = get(id);
		entity.setIntituleNiveau(niveauCodeBudgetaireRequestDto.getIntituleNiveau());
		entity.setDescription(niveauCodeBudgetaireRequestDto.getDescription());
		return modelMapper.map(entity, NiveauCodeBudgetaireResponseDto.class);
	}
}
