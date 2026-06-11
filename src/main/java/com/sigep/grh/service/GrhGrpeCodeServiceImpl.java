package com.sigep.grh.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.grh.dto.requestDto.GrpeCodeRequestDto;
import com.sigep.grh.dto.responseDto.GrpeCodeResponseDto;
import com.sigep.grh.entity.GrpeCode;
import com.sigep.grh.mapper.GrhMapper;
import com.sigep.grh.repository.GrhGrpeCodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional("grhTransactionManager")
public class GrhGrpeCodeServiceImpl implements GrhGrpeCodeService {
	
	private final GrhGrpeCodeRepository repository;
	

	@Override
	public GrpeCodeResponseDto add(GrpeCodeRequestDto grpeCodeRequestDto) {
		GrpeCode grpeCode = new GrpeCode();
		grpeCode.setGrpe(grpeCodeRequestDto.getGrpe());
		grpeCode.setLibelleGrpe(grpeCodeRequestDto.getLibelleGrpe());
		repository.save(grpeCode);
		return GrhMapper.gcToGcResponse(grpeCode);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GrpeCodeResponseDto> getAll() {
		List<GrpeCode> grpeCodes = repository.findAll();
		return grpeCodes
				.stream().map(element  -> GrhMapper.gcToGcResponse(element))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public GrpeCode get(String id) {
		String id2;
		if (id.length() == 3) id = id + "  ";
		if (id.length() == 4) id = id + " ";
		id2 = id;
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("GrpeCode with id: " + id2 + " could not be found"));
	}

	@Override
	@Transactional(readOnly = true)
	public GrpeCodeResponseDto getById(String id) {
		GrpeCode grpeCode = get(id);
		return GrhMapper.gcToGcResponse(grpeCode);
	}

	@Override
	public GrpeCodeResponseDto delete(String id) {
		GrpeCode grpeCode = get(id);
		repository.delete(grpeCode);
		return GrhMapper.gcToGcResponse(grpeCode);
	}

	@Override
	public GrpeCodeResponseDto edit(String id, GrpeCodeRequestDto grpeCodeRequestDto) {
		GrpeCode grpeCode = get(id);
		grpeCode.setLibelleGrpe(grpeCodeRequestDto.getLibelleGrpe());
		return GrhMapper.gcToGcResponse(grpeCode);
	}
}
