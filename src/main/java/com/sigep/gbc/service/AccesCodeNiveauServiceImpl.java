package com.sigep.gbc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.requestDto.AccesCodeNiveauRequestDto;
import com.sigep.gbc.dto.responseDto.AccesCodeNiveauResponseDto;
import com.sigep.gbc.entity.AccesCodeNiveau;
import com.sigep.gbc.entity.GrpeCode;
import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.repository.AccesCodeNiveauRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccesCodeNiveauServiceImpl implements AccesCodeNiveauService{
	
	private final AccesCodeNiveauRepository repository;
	private final GrpeCodeService gcService;

	@Override
	@Transactional("gbcTransactionManager")
	public AccesCodeNiveauResponseDto add(AccesCodeNiveauRequestDto accesCodeNiveauRequestDto) {
		AccesCodeNiveau accesCodeNiveau = new AccesCodeNiveau();
		accesCodeNiveau.setCode(accesCodeNiveauRequestDto.getCode());
		accesCodeNiveau.setIntituleCode(accesCodeNiveauRequestDto.getIntituleCode());
		accesCodeNiveau.setNomStruct(accesCodeNiveauRequestDto.getNomStruct());
		
		if (accesCodeNiveauRequestDto.getGrpes().isEmpty()) {
			throw new IllegalArgumentException("AccesCodeNiveau need atleast one GrpeCode");
		} else {
			List<GrpeCode> grpeCodes = new ArrayList<>();
			for (String grpe: accesCodeNiveauRequestDto.getGrpes()) {
				GrpeCode grpeCode = gcService.get(grpe);
				grpeCodes.add(grpeCode);
			}
			accesCodeNiveau.setGrpeCodes(grpeCodes);
		}
		
		repository.save(accesCodeNiveau);
		return GbcMapper.acnToAcnResponseDto(accesCodeNiveau);
	}

	@Override
	public List<AccesCodeNiveauResponseDto> getAll() {
		List<AccesCodeNiveau> accesCodeNiveaus = repository.findAll();
		return accesCodeNiveaus
				.stream().map(element  -> GbcMapper.acnToAcnResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public AccesCodeNiveau get(String id) {
		String id2;
		if (id.length() < 3) id = id + " ";
		id2 = id;
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("AccesCodeNiveau with id: " + id2 + " could not be found"));
	}

	@Override
	public AccesCodeNiveauResponseDto getById(String id) {
		AccesCodeNiveau accesCodeNiveau = get(id);
		return GbcMapper.acnToAcnResponseDto(accesCodeNiveau);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public AccesCodeNiveauResponseDto delete(String id) {
		AccesCodeNiveau accesCodeNiveau = get(id);
		repository.delete(accesCodeNiveau);
		return GbcMapper.acnToAcnResponseDto(accesCodeNiveau);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public AccesCodeNiveauResponseDto edit(String id, AccesCodeNiveauRequestDto accesCodeNiveauRequestDto) {
		AccesCodeNiveau accesCodeNiveau = get(id);
		accesCodeNiveau.setIntituleCode(accesCodeNiveauRequestDto.getIntituleCode());
		accesCodeNiveau.setNomStruct(accesCodeNiveauRequestDto.getNomStruct());
		
		if (!accesCodeNiveauRequestDto.getGrpes().isEmpty()) {
			List<GrpeCode> grpeCodes = new ArrayList<>();
			for (String grpe: accesCodeNiveauRequestDto.getGrpes()) {
				GrpeCode grpeCode = gcService.get(grpe);
				grpeCodes.add(grpeCode);
			}
			accesCodeNiveau.setGrpeCodes(grpeCodes);
		} 
		
		return GbcMapper.acnToAcnResponseDto(accesCodeNiveau);
	}

}
