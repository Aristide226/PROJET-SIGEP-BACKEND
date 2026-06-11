package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.FactureDetailRequestDto;
import com.sigep.gbc.dto.responseDto.FactureDetailResponseDto;
import com.sigep.gbc.entity.FactureDetail;
import com.sigep.gbc.entity.Factures;
import com.sigep.gbc.repository.FactureDetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FactureDetailServiceImpl implements FactureDetailService{
	
	private final FactureDetailRepository repository;
	private final FacturesService facturesService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public FactureDetailResponseDto add(FactureDetailRequestDto factureDetailRequestDto) {
		FactureDetail entity = new FactureDetail();
		entity.setNumeroItem(factureDetailRequestDto.getNumeroItem());
		entity.setDesignation(factureDetailRequestDto.getDesignation());
		entity.setQtite(factureDetailRequestDto.getQtite());
		entity.setPrixUnitaire(factureDetailRequestDto.getPrixUnitaire());
		entity.setPrixTotal(factureDetailRequestDto.getPrixTotal());
		
		if (factureDetailRequestDto.getIdFact() == null) {
			throw new IllegalArgumentException("FactureDetail need a Factures");
		}
		Factures factures = facturesService.get(factureDetailRequestDto.getIdFact());
		entity.setFactures(factures);
		
		repository.save(entity);
		return GbcMapper2.factureDetailToFactureDetailResponseDto(entity);
	}
	
	@Override
	public List<FactureDetailResponseDto> getAll() {
		List<FactureDetail> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.factureDetailToFactureDetailResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public FactureDetail get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("FactureDetail with id: " + id + " could not be found"));
	}
	
	@Override
	public FactureDetailResponseDto getById(String id) {
		FactureDetail entity = get(id);
		return GbcMapper2.factureDetailToFactureDetailResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public FactureDetailResponseDto delete(String id) {
		FactureDetail entity = get(id);
		repository.delete(entity);
		return GbcMapper2.factureDetailToFactureDetailResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public FactureDetailResponseDto edit(String id, FactureDetailRequestDto factureDetailRequestDto) {
		FactureDetail entity = get(id);
		entity.setNumeroItem(factureDetailRequestDto.getNumeroItem());
		entity.setDesignation(factureDetailRequestDto.getDesignation());
		entity.setQtite(factureDetailRequestDto.getQtite());
		entity.setPrixUnitaire(factureDetailRequestDto.getPrixUnitaire());
		entity.setPrixTotal(factureDetailRequestDto.getPrixTotal());
		
		if (factureDetailRequestDto.getIdFact() != null) {
			Factures factures = facturesService.get(factureDetailRequestDto.getIdFact());
			entity.setFactures(factures);
		}
	
		return GbcMapper2.factureDetailToFactureDetailResponseDto(entity);
	}
}
