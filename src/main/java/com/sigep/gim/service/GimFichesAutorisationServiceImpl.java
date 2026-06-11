package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.FichesAutorisationRequestDto;
import com.sigep.gim.dto.responseDto.FichesAutorisationResponseDto;
import com.sigep.gim.entity.Fiches;
import com.sigep.gim.entity.FichesAutorisation;
import com.sigep.gim.repository.GimFichesAutorisationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimFichesAutorisationServiceImpl implements GimFichesAutorisationService {
	
	private final GimFichesAutorisationRepository repository;
	private final ModelMapper modelMapper;
	private final GimFichesService gimFichesService;
	
	@Override
	@Transactional
	public FichesAutorisationResponseDto add(FichesAutorisationRequestDto fichesAutorisationRequestDto) {
		FichesAutorisation entity = new FichesAutorisation();
		entity.setObjetDepense(fichesAutorisationRequestDto.getObjetDepense());
		entity.setMontantHtva(fichesAutorisationRequestDto.getMontantHtva());
		entity.setAvecTva(fichesAutorisationRequestDto.isAvecTva());
		entity.setMontantTtc(fichesAutorisationRequestDto.getMontantTtc());
		
		if(fichesAutorisationRequestDto.getIdFiche() == null) {
			throw new IllegalArgumentException("FichesAutorisation need a Fiches");
		}
		Fiches fiches = gimFichesService.get(fichesAutorisationRequestDto.getIdFiche());
		entity.setFiches(fiches);
		
		repository.save(entity);
		return modelMapper.map(entity, FichesAutorisationResponseDto.class);
	}
	
	@Override
	public List<FichesAutorisationResponseDto> getAll() {
		List<FichesAutorisation> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, FichesAutorisationResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public FichesAutorisation get(long id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("FichesAutorisation with id "+id+"could not be found")
		);
	}
	
	@Override
	public FichesAutorisationResponseDto getById(long id) {
		FichesAutorisation entity = get(id);
		return modelMapper.map(entity, FichesAutorisationResponseDto.class);
	}
	
	@Override
	@Transactional
	public FichesAutorisationResponseDto delete(long id) {
		FichesAutorisation entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, FichesAutorisationResponseDto.class);
	}
	
	@Override
	@Transactional
	public FichesAutorisationResponseDto edit(long id,FichesAutorisationRequestDto fichesAutorisationRequestDto) {
		FichesAutorisation entity = get(id);
		entity.setObjetDepense(fichesAutorisationRequestDto.getObjetDepense());
		entity.setMontantHtva(fichesAutorisationRequestDto.getMontantHtva());
		entity.setAvecTva(fichesAutorisationRequestDto.isAvecTva());
		entity.setMontantTtc(fichesAutorisationRequestDto.getMontantTtc());
		return modelMapper.map(entity, FichesAutorisationResponseDto.class);
	}
}
