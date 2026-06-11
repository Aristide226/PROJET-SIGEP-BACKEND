package com.sigep.grh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.grh.dto.requestDto.AccesCodeNiveauRequestDto;
import com.sigep.grh.dto.responseDto.AccesCodeNiveauResponseDto;
import com.sigep.grh.entity.AccesCodeNiveau;
import com.sigep.grh.entity.GrpeCode;
import com.sigep.grh.mapper.GrhMapper;
import com.sigep.grh.repository.GrhAccesCodeNiveauRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional("grhTransactionManager")
@RequiredArgsConstructor
public class GrhAccesCodeNiveauServiceImpl implements GrhAccesCodeNiveauService {
	private final GrhAccesCodeNiveauRepository repository;
	private final GrhGrpeCodeService gcService;

	@Override
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
		return GrhMapper.acnToAcnResponseDto(accesCodeNiveau);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccesCodeNiveauResponseDto> getAll() {
		List<AccesCodeNiveau> accesCodeNiveaus = repository.findAllWithGrpeCodes();
		return accesCodeNiveaus
				.stream().map(element  -> GrhMapper.acnToAcnResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public AccesCodeNiveau get(String id) {
		String id2;
		if (id.length() < 3) id = id + " ";
		id2 = id;
		
		AccesCodeNiveau accesCodeNiveau = repository.findByIdWithGrpeCodes(id);
		if (accesCodeNiveau == null) new IllegalArgumentException("AccesCodeNiveau with id: " + id2 + " could not be found");
		
		return accesCodeNiveau;
	}

	@Override
	@Transactional(readOnly = true)
	public AccesCodeNiveauResponseDto getById(String id) {
		AccesCodeNiveau accesCodeNiveau = get(id);
		return GrhMapper.acnToAcnResponseDto(accesCodeNiveau);
	}

	@Override
	public AccesCodeNiveauResponseDto delete(String id) {
		AccesCodeNiveau accesCodeNiveau = get(id);
		repository.delete(accesCodeNiveau);
		return GrhMapper.acnToAcnResponseDto(accesCodeNiveau);
	}

	@Override
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
		
		return GrhMapper.acnToAcnResponseDto(accesCodeNiveau);
	}
}
