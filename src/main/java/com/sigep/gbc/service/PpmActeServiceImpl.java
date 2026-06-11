package com.sigep.gbc.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.PpmActeRequestDto;
import com.sigep.gbc.dto.responseDto.PpmActeResponseDto;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.PpmActe;
import com.sigep.gbc.repository.PpmActeRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PpmActeServiceImpl implements PpmActeService{
	
	private final PpmActeRepository repository;
	private final BudgetTypeService budgetTypeService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmActeResponseDto add(PpmActeRequestDto ppmActeRequestDto) {
		PpmActe entity = new PpmActe();
		entity.setIdPpmM(UUID.randomUUID().toString().toUpperCase());
		entity.setGestion(ppmActeRequestDto.getGestion());
		entity.setQuantieme(ppmActeRequestDto.getQuantieme());
		entity.setDateModif(ppmActeRequestDto.getDateModif());
		entity.setMotifModif(ppmActeRequestDto.getMotifModif());
		entity.setActeAutorisation(ppmActeRequestDto.getActeAutorisation());
		entity.setDateCreate(ppmActeRequestDto.getDateCreate());
		entity.setUserCreate(ppmActeRequestDto.getUserCreate());
		entity.setDateUpdate(ppmActeRequestDto.getDateUpdate());
		entity.setUserUpdate(ppmActeRequestDto.getUserUpdate());
		entity.setValide(ppmActeRequestDto.getValide());
		entity.setUserValide(ppmActeRequestDto.getUserValide());
		entity.setDateValide(ppmActeRequestDto.getDateValide());
		
		if (ppmActeRequestDto.getIdPpmMMP() == null) {
			entity.setPpmActe(entity);
		} else {
			PpmActe ppmActe = get(ppmActeRequestDto.getIdPpmMMP());
			entity.setPpmActe(ppmActe);
		}
		
		if (ppmActeRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("BudgetType need a BudgetType");
		}
		BudgetType budgetType = budgetTypeService.get(ppmActeRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		repository.save(entity);
		return GbcMapper2.ppmActeToPpmActeResponseDto(entity);
	}
	
	@Override
	public List<PpmActeResponseDto> getAll() {
		List<PpmActe> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.ppmActeToPpmActeResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public PpmActe get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("PpmActe with id: " + id + " could not be found"));
	}
	
	@Override
	public PpmActeResponseDto getById(String id) {
		PpmActe entity = get(id);
		return GbcMapper2.ppmActeToPpmActeResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmActeResponseDto delete(String id) {
		PpmActe entity = get(id);
		repository.delete(entity);
		return GbcMapper2.ppmActeToPpmActeResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmActeResponseDto edit(String id, PpmActeRequestDto ppmActeRequestDto) {
		PpmActe entity = get(id);
		entity.setGestion(ppmActeRequestDto.getGestion());
		entity.setQuantieme(ppmActeRequestDto.getQuantieme());
		entity.setDateModif(ppmActeRequestDto.getDateModif());
		entity.setMotifModif(ppmActeRequestDto.getMotifModif());
		entity.setActeAutorisation(ppmActeRequestDto.getActeAutorisation());
		//Sentity.setDateCreate(ppmActeRequestDto.getDateCreate());
		entity.setUserCreate(ppmActeRequestDto.getUserCreate());
		entity.setDateUpdate(ppmActeRequestDto.getDateUpdate());
		entity.setUserUpdate(ppmActeRequestDto.getUserUpdate());
		entity.setValide(ppmActeRequestDto.getValide());
		entity.setUserValide(ppmActeRequestDto.getUserValide());
		entity.setDateValide(ppmActeRequestDto.getDateValide());
		
		
		if (ppmActeRequestDto.getIdPpmMMP() == null) {
			entity.setPpmActe(entity);
		} else {
			PpmActe ppmActe = get(ppmActeRequestDto.getIdPpmMMP());
			entity.setPpmActe(ppmActe);
		}
		
		if (ppmActeRequestDto.getIdBudget() != null) {
			BudgetType budgetType = budgetTypeService.get(ppmActeRequestDto.getIdBudget());
			entity.setBudgetType(budgetType);
		}
		
		return GbcMapper2.ppmActeToPpmActeResponseDto(entity);
	}
	
	//Aristide 
	@Override
	public List<PpmActeResponseDto> getByGestion(Short gestion){
		List<PpmActe> list = repository.findByGestion(gestion);
		return list.stream()
				.map(element  -> GbcMapper2.ppmActeToPpmActeResponseDto(element))
				.collect(Collectors.toList());
	}
	@Override
	public List<PpmActeResponseDto> getByGestionAndIdBudget (Short gestion,Integer idBudget){
		List<PpmActe> list = repository.findByGestionAndBudgetTypeIdBudget(gestion, idBudget);
		return list.stream()
				.map(element -> GbcMapper2.ppmActeToPpmActeResponseDto(element))
				.collect(Collectors.toList());
	}
}



