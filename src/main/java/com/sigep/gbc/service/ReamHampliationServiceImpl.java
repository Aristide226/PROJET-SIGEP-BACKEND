package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.ReamHampliationRequestDto;
import com.sigep.gbc.dto.responseDto.ReamHampliationResponseDto;
import com.sigep.gbc.entity.ReamHampliation;
import com.sigep.gbc.entity.ReamHampliationId;
import com.sigep.gbc.entity.ReamgmtActe;
import com.sigep.gbc.repository.ReamHampliationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReamHampliationServiceImpl implements ReamHampliationService {
	
	private final ReamHampliationRepository repository;
	private final ReamgmtActeService reamgmtActeService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public ReamHampliationResponseDto add(ReamHampliationRequestDto reamHampliationRequestDto) {
		ReamHampliation entity = new ReamHampliation();
		
		if (reamHampliationRequestDto.getCodReam() == null) {
			throw new IllegalArgumentException("ReamHampliation need a ReamgmtActe");
		}
		ReamgmtActe reamgmtActe = reamgmtActeService.get(reamHampliationRequestDto.getCodReam());
		entity.setReamgmtActe(reamgmtActe);
		
		entity.setId(new ReamHampliationId(
				reamHampliationRequestDto.getCodReam(), 
				reamHampliationRequestDto.getAmpliataireReam()
		));
		
		repository.save(entity);
		return GbcMapper2.reamHampliationToReamHampliationResponseDto(entity);
	}
	
	@Override
	public List<ReamHampliationResponseDto> getAll() {
		List<ReamHampliation> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.reamHampliationToReamHampliationResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public ReamHampliation get(Long codReam, String ampliataireReam) {
		ReamHampliationId id = new ReamHampliationId(codReam, ampliataireReam);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("ReamHampliation with id: " + id + " could not be found"));
	}
	
	@Override
	public ReamHampliationResponseDto getById(Long codReam, String ampliataireReam) {
		ReamHampliation entity  = get(codReam, ampliataireReam);
		return GbcMapper2.reamHampliationToReamHampliationResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public ReamHampliationResponseDto delete(Long codReam, String ampliataireReam) {
		ReamHampliation entity  = get(codReam, ampliataireReam);
		repository.delete(entity);
		return GbcMapper2.reamHampliationToReamHampliationResponseDto(entity);
	}
}
