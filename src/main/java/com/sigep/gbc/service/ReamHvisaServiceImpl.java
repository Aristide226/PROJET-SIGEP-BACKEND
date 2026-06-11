package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.ReamHvisaResquestDto;
import com.sigep.gbc.dto.responseDto.ReamHvisaResponseDto;
import com.sigep.gbc.entity.ReamHvisa;
import com.sigep.gbc.entity.ReamHvisaId;
import com.sigep.gbc.entity.ReamgmtActe;
import com.sigep.gbc.repository.ReamHvisaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReamHvisaServiceImpl implements ReamHvisaService {
	
	private final ReamHvisaRepository repository;
	private final ReamgmtActeService reamgmtActeService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public ReamHvisaResponseDto add(ReamHvisaResquestDto reamHvisaResquestDto) {
		ReamHvisa entity = new ReamHvisa();
		
		if (reamHvisaResquestDto.getCodReam() == null) {
			throw new IllegalArgumentException("ReamHvisa need a ReamgmtActe");
		}
		ReamgmtActe reamgmtActe = reamgmtActeService.get(reamHvisaResquestDto.getCodReam());
		entity.setReamgmtActe(reamgmtActe);
		
		entity.setId(new ReamHvisaId(
				reamHvisaResquestDto.getCodReam(), 
				reamHvisaResquestDto.getRangVisa()
		));
		
		entity.setLibelleVisa(reamHvisaResquestDto.getLibelleVisa());
		
		repository.save(entity);
		return GbcMapper2.reamHvisaToReamHvisaResponseDto(entity);
	}
	
	@Override
	public List<ReamHvisaResponseDto> getAll() {
		List<ReamHvisa> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.reamHvisaToReamHvisaResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public ReamHvisa get(Long codReam, Integer rangVisa) {
		ReamHvisaId id = new ReamHvisaId(codReam, rangVisa);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("ReamHvisa with id: " + id + " could not be found"));
	}
	
	@Override
	public ReamHvisaResponseDto getById(Long codReam, Integer rangVisa) {
		ReamHvisa entity  = get(codReam, rangVisa);
		return GbcMapper2.reamHvisaToReamHvisaResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public ReamHvisaResponseDto delete(Long codReam, Integer rangVisa) {
		ReamHvisa entity  = get(codReam, rangVisa);
		repository.delete(entity);
		return GbcMapper2.reamHvisaToReamHvisaResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public ReamHvisaResponseDto edit(Long codReam, Integer rangVisa, ReamHvisaResquestDto reamHvisaResquestDto) {
		ReamHvisa entity  = get(codReam, rangVisa);
		entity.setLibelleVisa(reamHvisaResquestDto.getLibelleVisa());
		return GbcMapper2.reamHvisaToReamHvisaResponseDto(entity);
	}
}
