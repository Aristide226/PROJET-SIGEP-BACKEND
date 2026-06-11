package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.GrpeCodeRequestDto;
import com.sigep.gbc.dto.responseDto.GrpeCodeResponseDto;
import com.sigep.gbc.entity.GrpeCode;
import com.sigep.gbc.repository.GrpeCodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrpeCodeServiceImpl implements GrpeCodeService{
	
	private final GrpeCodeRepository repository;
	

	@Override
	@Transactional("gbcTransactionManager")
	public GrpeCodeResponseDto add(GrpeCodeRequestDto grpeCodeRequestDto) {
		GrpeCode grpeCode = new GrpeCode();
		grpeCode.setGrpe(grpeCodeRequestDto.getGrpe());
		grpeCode.setLibelleGrpe(grpeCodeRequestDto.getLibelleGrpe());
		repository.save(grpeCode);
		return GbcMapper.gcToGcResponse(grpeCode);
	}

	@Override
	public List<GrpeCodeResponseDto> getAll() {
		List<GrpeCode> grpeCodes = repository.findAll();
		return grpeCodes
				.stream().map(element  -> GbcMapper.gcToGcResponse(element))
				.collect(Collectors.toList());
	}

	@Override
	public GrpeCode get(String id) {
		String id2;
		if (id.length() == 3) id = id + "  ";
		if (id.length() == 4) id = id + " ";
		id2 = id;
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("GrpeCode with id: " + id2 + " could not be found"));
	}

	@Override
	public GrpeCodeResponseDto getById(String id) {
		GrpeCode grpeCode = get(id);
		return GbcMapper.gcToGcResponse(grpeCode);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public GrpeCodeResponseDto delete(String id) {
		GrpeCode grpeCode = get(id);
		repository.delete(grpeCode);
		return GbcMapper.gcToGcResponse(grpeCode);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public GrpeCodeResponseDto edit(String id, GrpeCodeRequestDto grpeCodeRequestDto) {
		GrpeCode grpeCode = get(id);
		grpeCode.setLibelleGrpe(grpeCodeRequestDto.getLibelleGrpe());
		return GbcMapper.gcToGcResponse(grpeCode);
	}

	

}
