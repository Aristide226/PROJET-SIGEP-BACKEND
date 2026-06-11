package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.CoupureMonnaieDto;
import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.entity.CoupureMonnaie;
import com.sigep.gbc.entity.CoupureMonnaieId;
import com.sigep.gbc.repository.CoupureMonnaieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoupureMonnaieServiceImpl implements CoupureMonnaieService{
	
	private final CoupureMonnaieRepository repository;

	@Transactional("gbcTransactionManager")
	@Override
	public CoupureMonnaieDto add(CoupureMonnaieDto coupureMonnaieDto) {
		CoupureMonnaie entity = new CoupureMonnaie();
		entity.setId(new CoupureMonnaieId(
				coupureMonnaieDto.getDesigna(),
				coupureMonnaieDto.getIdCoupure()
		));
		repository.save(entity);
		return GbcMapper.cMToCmResponseDto(entity);
	}

	@Override
	public List<CoupureMonnaieDto> getAll() {
		List<CoupureMonnaie> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.cMToCmResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public CoupureMonnaie get(String designa, Long idCoupure) {
		CoupureMonnaieId id = new CoupureMonnaieId(
				designa,
				idCoupure
		);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("CoupureMonnaie with id: " + id + " could not be found"));
	}

	@Override
	public CoupureMonnaieDto getById(String designa, Long idCoupure) {
		CoupureMonnaie entity = get(designa, idCoupure);
		return GbcMapper.cMToCmResponseDto(entity);
	}

	@Transactional("gbcTransactionManager")
	@Override
	public CoupureMonnaieDto delete(String designa, Long idCoupure) {
		CoupureMonnaie entity = get(designa, idCoupure);
		repository.delete(entity);
		return GbcMapper.cMToCmResponseDto(entity);
	}

	@Transactional("gbcTransactionManager")
	@Override
	public void edit(String designa, Long idCoupure, CoupureMonnaieDto coupureMonnaieDto) {
		repository.update(
				coupureMonnaieDto.getDesigna(),
				coupureMonnaieDto.getIdCoupure(), 
				designa,
				idCoupure
		);
	}
	
}
