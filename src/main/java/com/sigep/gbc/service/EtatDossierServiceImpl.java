package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.EtatDossierRequestDto;
import com.sigep.gbc.dto.responseDto.EtatDossierResponseDto;
import com.sigep.gbc.entity.EtatDossier;
import com.sigep.gbc.repository.EtatDossierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EtatDossierServiceImpl implements EtatDossierService{
	
	private final EtatDossierRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public EtatDossierResponseDto add(EtatDossierRequestDto etatDossierRequestDto) {
		EtatDossier entity = new EtatDossier();
		entity.setEtat(etatDossierRequestDto.getEtat());
		entity.setLibEtat(etatDossierRequestDto.getLibEtat());
		entity.setAvecMotifR(etatDossierRequestDto.getAvecMotifR());
		
		repository.save(entity);
		return GbcMapper.edToEdResponseDto(entity);
	}

	@Override
	public List<EtatDossierResponseDto> getAll() {
		List<EtatDossier> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.edToEdResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public EtatDossier get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("EtatDossier with id: " + id + " could not be found"));
	}

	@Override
	public EtatDossierResponseDto getById(String id) {
		EtatDossier entity = get(id);
		return GbcMapper.edToEdResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public EtatDossierResponseDto delete(String id) {
		EtatDossier entity = get(id);
		repository.delete(entity);
		return GbcMapper.edToEdResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public EtatDossierResponseDto edit(String id, EtatDossierRequestDto etatDossierRequestDto) {
		EtatDossier entity = get(id);
		entity.setLibEtat(etatDossierRequestDto.getLibEtat());
		entity.setAvecMotifR(etatDossierRequestDto.getAvecMotifR());
		return GbcMapper.edToEdResponseDto(entity);
	}
}
