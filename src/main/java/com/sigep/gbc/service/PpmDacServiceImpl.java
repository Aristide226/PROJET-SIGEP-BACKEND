package com.sigep.gbc.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.PpmDacRequestDto;
import com.sigep.gbc.dto.responseDto.PpmDacResponseDto;
import com.sigep.gbc.entity.Ppm;
import com.sigep.gbc.entity.PpmDac;
import com.sigep.gbc.repository.PpmDacRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PpmDacServiceImpl implements PpmDacService{
	
	private final PpmDacRepository repository;
	private final PpmService ppmService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmDacResponseDto add(PpmDacRequestDto ppmDacRequestDto) {
		PpmDac entity = new PpmDac();
		entity.setIdDac(UUID.randomUUID().toString().toUpperCase());
		entity.setRefPassation(ppmDacRequestDto.getRefPassation());
		entity.setDateCreation(ppmDacRequestDto.getDateCreation());
		entity.setDateDac(ppmDacRequestDto.getDateDac());
		entity.setDateLancement(ppmDacRequestDto.getDateLancement());
		
		if (ppmDacRequestDto.getIdPpm() == null) {
			entity.setPpm(null);
		} else {
			Ppm ppm = ppmService.get(ppmDacRequestDto.getIdPpm());
			entity.setPpm(ppm);
		}
		
		repository.save(entity);
		return GbcMapper2.ppmDacToPpmDacResponseDto(entity);
	}
	
	@Override
	public List<PpmDacResponseDto> getAll() {
		List<PpmDac> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.ppmDacToPpmDacResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public PpmDac get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("PpmDac with id: " + id + " could not be found"));
	}
	
	@Override
	public PpmDacResponseDto getById(String id) {
		PpmDac entity = get(id);
		return GbcMapper2.ppmDacToPpmDacResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmDacResponseDto delete(String id) {
		PpmDac entity = get(id);
		repository.delete(entity);
		return GbcMapper2.ppmDacToPpmDacResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmDacResponseDto edit(String id, PpmDacRequestDto ppmDacRequestDto) {
		PpmDac entity = get(id);
		entity.setRefPassation(ppmDacRequestDto.getRefPassation());
		//entity.setDateCreation(ppmDacRequestDto.getDateCreation());
		entity.setDateDac(ppmDacRequestDto.getDateDac());
		entity.setDateLancement(ppmDacRequestDto.getDateLancement());
		
		if (ppmDacRequestDto.getIdPpm() == null) {
			entity.setPpm(null);
		} else {
			Ppm ppm = ppmService.get(ppmDacRequestDto.getIdPpm());
			entity.setPpm(ppm);
		}
		return GbcMapper2.ppmDacToPpmDacResponseDto(entity);
	}
}
