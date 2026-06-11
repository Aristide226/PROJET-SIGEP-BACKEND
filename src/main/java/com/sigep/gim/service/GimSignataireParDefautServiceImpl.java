package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.SignataireParDefautRequestDto;
import com.sigep.gim.dto.responseDto.SignataireParDefautResponseDto;
import com.sigep.gim.entity.SignataireParDefaut;
import com.sigep.gim.repository.GimSignataireParDefautRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimSignataireParDefautServiceImpl implements GimSignataireParDefautService {
	
	private final GimSignataireParDefautRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	@Transactional
	public SignataireParDefautResponseDto add(SignataireParDefautRequestDto signataireParDefautRequestDto) {
		SignataireParDefaut entity = new SignataireParDefaut();
		entity.setCodSignataire(signataireParDefautRequestDto.getCodSignataire());
		entity.setFonctSigna1(signataireParDefautRequestDto.getFonctSigna1());
		entity.setPrenomNomSigna1(signataireParDefautRequestDto.getPrenomNomSigna1());
		entity.setTitreHonoSigna1(signataireParDefautRequestDto.getTitreHonoSigna1());
		entity.setFonctSigna2(signataireParDefautRequestDto.getFonctSigna2());
		entity.setPrenomNomSigna2(signataireParDefautRequestDto.getPrenomNomSigna2());
		entity.setTitreHonoSigna2(signataireParDefautRequestDto.getTitreHonoSigna2());
		entity.setFonctSigna3(signataireParDefautRequestDto.getFonctSigna3());
		entity.setPrenomNomSigna3(signataireParDefautRequestDto.getPrenomNomSigna3());
		entity.setTitreHonoSigna3(signataireParDefautRequestDto.getTitreHonoSigna3());
		repository.save(entity);
		return modelMapper.map(entity, SignataireParDefautResponseDto.class);
	}
	
	@Override
	public List<SignataireParDefautResponseDto> getAll() {
		List<SignataireParDefaut> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, SignataireParDefautResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public SignataireParDefaut get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("SignataireParDefaut with id "+id+"could not be found")
		);
	}
	
	@Override
	public SignataireParDefautResponseDto getById(String id) {
		SignataireParDefaut entity = get(id);
		return modelMapper.map(entity, SignataireParDefautResponseDto.class);
	}
	
	@Override
	@Transactional
	public SignataireParDefautResponseDto delete(String id) {
		SignataireParDefaut entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, SignataireParDefautResponseDto.class);
	}
	
	@Override
	@Transactional
	public SignataireParDefautResponseDto edit(String id,SignataireParDefautRequestDto signataireParDefautRequestDto) {
		SignataireParDefaut entity = get(id);
		entity.setFonctSigna1(signataireParDefautRequestDto.getFonctSigna1());
		entity.setPrenomNomSigna1(signataireParDefautRequestDto.getPrenomNomSigna1());
		entity.setTitreHonoSigna1(signataireParDefautRequestDto.getTitreHonoSigna1());
		entity.setFonctSigna2(signataireParDefautRequestDto.getFonctSigna2());
		entity.setPrenomNomSigna2(signataireParDefautRequestDto.getPrenomNomSigna2());
		entity.setTitreHonoSigna2(signataireParDefautRequestDto.getTitreHonoSigna2());
		entity.setFonctSigna3(signataireParDefautRequestDto.getFonctSigna3());
		entity.setPrenomNomSigna3(signataireParDefautRequestDto.getPrenomNomSigna3());
		entity.setTitreHonoSigna3(signataireParDefautRequestDto.getTitreHonoSigna3());
		return modelMapper.map(entity, SignataireParDefautResponseDto.class);
	}
}
