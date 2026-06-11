package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.EtatTransmissionRequestDto;
import com.sigep.gbc.dto.responseDto.EtatTransmissionResponseDto;
import com.sigep.gbc.entity.EtatTransmission;
import com.sigep.gbc.repository.EtatTransmissionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EtatTransmissionServiceImpl implements EtatTransmissionService{
	
	private final EtatTransmissionRepository repository;
	
	@Override
	@Transactional("gbcTransactionManager")
	public EtatTransmissionResponseDto add(EtatTransmissionRequestDto etatTransmissionRequestDto) {
		EtatTransmission entity = new EtatTransmission();
		entity.setIdEtatTrans(etatTransmissionRequestDto.getIdEtatTrans());
		entity.setLibEtatTrans(etatTransmissionRequestDto.getLibEtatTrans());
		
		repository.save(entity);
		return GbcMapper.etToEtResponseDto(entity);
	}
	
	@Override
	public List<EtatTransmissionResponseDto> getAll() {
		List<EtatTransmission> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.etToEtResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public EtatTransmission get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("EtatTransmission with id: " + id + " could not be found"));
	}
	
	@Override
	public EtatTransmissionResponseDto getById(Integer id) {
		EtatTransmission entity = get(id);
		return GbcMapper.etToEtResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public EtatTransmissionResponseDto delete(Integer id) {
		EtatTransmission entity = get(id);
		repository.delete(entity);
		return GbcMapper.etToEtResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public EtatTransmissionResponseDto edit(Integer id, EtatTransmissionRequestDto etatTransmissionRequestDto) {
		EtatTransmission entity = get(id);
		entity.setLibEtatTrans(etatTransmissionRequestDto.getLibEtatTrans());
		return GbcMapper.etToEtResponseDto(entity);
	}	
}
