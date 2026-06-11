package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.ActeNatureRequestDto;
import com.sigep.gbc.dto.responseDto.ActeNatureResponseDto;
import com.sigep.gbc.entity.ActeNature;
import com.sigep.gbc.repository.ActeNatureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActeNatureServiceImpl implements ActeNatureService {
	
	private final ActeNatureRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public ActeNatureResponseDto add(ActeNatureRequestDto acteNatureRequestDto) {
		ActeNature entity = new ActeNature();
		entity.setActe(acteNatureRequestDto.getActe());
		entity.setActeTitre(acteNatureRequestDto.getActeTitre());
		entity.setActeNumComplema(acteNatureRequestDto.getActeNumComplema());
		entity.setDernierArticleDebloc(acteNatureRequestDto.getDernierArticleDebloc());
		entity.setDernierArticleReam(acteNatureRequestDto.getDernierArticleReam());
		repository.save(entity);
		return GbcMapper2.acteNatureToActeNatureResponseDto(entity);
	}

	@Override
	public List<ActeNatureResponseDto> getAll() {
		List<ActeNature> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.acteNatureToActeNatureResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public ActeNature get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("ActeNature with id: " + id + " could not be found"));
	}

	@Override
	public ActeNatureResponseDto getById(Integer id) {
		ActeNature entity = get(id);
		return GbcMapper2.acteNatureToActeNatureResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public ActeNatureResponseDto delete(Integer id) {
		ActeNature entity = get(id);
		repository.delete(entity);
		return GbcMapper2.acteNatureToActeNatureResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public ActeNatureResponseDto edit(Integer id, ActeNatureRequestDto acteNatureRequestDto) {
		ActeNature entity = get(id);
		entity.setActe(acteNatureRequestDto.getActe());
		entity.setActeTitre(acteNatureRequestDto.getActeTitre());
		entity.setActeNumComplema(acteNatureRequestDto.getActeNumComplema());
		entity.setDernierArticleDebloc(acteNatureRequestDto.getDernierArticleDebloc());
		entity.setDernierArticleReam(acteNatureRequestDto.getDernierArticleReam());
		return GbcMapper2.acteNatureToActeNatureResponseDto(entity);
	}
}
