package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.StElementsNomenclaDto;
import com.sigep.gbc.entity.Gestion;
import com.sigep.gbc.entity.StElements;
import com.sigep.gbc.entity.StElementsNomencla;
import com.sigep.gbc.entity.StElementsNomenclaId;
import com.sigep.gbc.repository.StElementsNomenclaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StElementsNomenclaServiceImpl implements StElementsNomenclaService {
	
	private final StElementsNomenclaRepository repository;
	private final GestionService gService;
	private final StElementsService steService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public StElementsNomenclaDto add(StElementsNomenclaDto stElementsNomenclaDto) {
		StElementsNomencla entity = new StElementsNomencla();
		
		if (stElementsNomenclaDto.getIdStElts() == null) {
			throw new IllegalArgumentException("StElementsNomencla need a StElements");
		}
		StElements stElements = steService.get(stElementsNomenclaDto.getIdStElts());
		entity.setStElements(stElements);
		
		if (stElementsNomenclaDto.getGestion() == null) {
			throw new IllegalArgumentException("StElementsNomencla need a Gestion");
		}
		Gestion gestion = gService.get(stElementsNomenclaDto.getGestion());
		entity.setGestion(gestion);
		
		if (stElementsNomenclaDto.getIdPlan() == null) {
			throw new IllegalArgumentException("StElementsNomencla need an attribute IdPlan");
		}
		
		entity.setId(new StElementsNomenclaId(
				stElementsNomenclaDto.getIdStElts(), 
				stElementsNomenclaDto.getGestion(),
				stElementsNomenclaDto.getIdPlan()
		));
		
		entity.setOp("B");
		
		repository.save(entity);
		return GbcMapper.stenToStenResponseDto(entity);
	}
	
	@Override
	public List<StElementsNomenclaDto> getAll() {
		List<StElementsNomencla> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.stenToStenResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public StElementsNomencla get(String idStElts, Short gestion, String idPlan) {
		StElementsNomenclaId id = new StElementsNomenclaId();
		id.setIdStElts(idStElts);
		id.setGestion(gestion);
		id.setIdPlan(idPlan);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("StElementsNomencla with id: " + id + " could not be found"));
	}
	
	@Override
	public StElementsNomenclaDto getById(String idStElts, Short gestion, String idPlan) {
		StElementsNomencla entity  = get(idStElts, gestion, idPlan);
		return GbcMapper.stenToStenResponseDto(entity);
	}
	
	@Transactional("gbcTransactionManager")
	@Override
	public StElementsNomenclaDto delete(String idStElts, Short gestion, String idPlan) {
		StElementsNomencla entity  = get(idStElts, gestion, idPlan);
		repository.delete(entity);
		return GbcMapper.stenToStenResponseDto(entity);
	}

	@Override
	public List<StElementsNomenclaDto> getByIdStEltsAndGestion(String idStElts, Short gestion) {
		StElements stElements = steService.get(idStElts);
		Gestion gestion2 = gService.get(gestion);
		List<StElementsNomencla> list = repository.findByStElementsAndGestion(stElements, gestion2);
		return list
				.stream().map(element  -> GbcMapper.stenToStenResponseDto(element))
				.collect(Collectors.toList());
	}
}
