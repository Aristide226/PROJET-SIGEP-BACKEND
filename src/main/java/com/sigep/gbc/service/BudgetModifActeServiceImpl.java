package com.sigep.gbc.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.BudgetModifActeRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetModifActeResponseDto;
import com.sigep.gbc.entity.BudgetModifActe;
import com.sigep.gbc.repository.BudgetModifActeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BudgetModifActeServiceImpl implements BudgetModifActeService{
	
	private final BudgetModifActeRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetModifActeResponseDto add(BudgetModifActeRequestDto budgetModifActeRequestDto) {
		BudgetModifActe entity = new BudgetModifActe();
		entity.setCodBma(getCodReamCodBMA());
		entity.setDateSaisie(new Date());
		entity.setValide(budgetModifActeRequestDto.getValide());
		entity.setActeBma(budgetModifActeRequestDto.getActeBma());
		entity.setNumActeBma(budgetModifActeRequestDto.getNumActeBma());
		entity.setDateActeBma(budgetModifActeRequestDto.getDateActeBma());
		entity.setIdLogin(budgetModifActeRequestDto.getIdLogin());
		entity.setGestion(budgetModifActeRequestDto.getGestion());
		entity.setDateValid(budgetModifActeRequestDto.getDateValid());
		entity.setIdValid(budgetModifActeRequestDto.getIdValid());
		entity.setIdBudget(budgetModifActeRequestDto.getIdBudget());
		
		repository.save(entity);
		return GbcMapper2.BudgetModifActeToBudgetModifActeResponseDto(entity);
	}

	@Override
	public List<BudgetModifActeResponseDto> getAll() {
		List<BudgetModifActe> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.BudgetModifActeToBudgetModifActeResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public BudgetModifActe get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("BudgetModifActe with id: " + id + " could not be found"));
	}

	@Override
	public BudgetModifActeResponseDto getById(Long id) {
		BudgetModifActe entity = get(id);
		return GbcMapper2.BudgetModifActeToBudgetModifActeResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetModifActeResponseDto delete(Long id) {
		BudgetModifActe entity = get(id);
		repository.delete(entity);
		return GbcMapper2.BudgetModifActeToBudgetModifActeResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetModifActeResponseDto edit(Long id, BudgetModifActeRequestDto budgetModifActeRequestDto) {
		BudgetModifActe entity = get(id);
		entity.setValide(budgetModifActeRequestDto.getValide());
		entity.setActeBma(budgetModifActeRequestDto.getActeBma());
		entity.setNumActeBma(budgetModifActeRequestDto.getNumActeBma());
		entity.setDateActeBma(budgetModifActeRequestDto.getDateActeBma());
		entity.setIdLogin(budgetModifActeRequestDto.getIdLogin());
		entity.setGestion(budgetModifActeRequestDto.getGestion());
		entity.setDateValid(budgetModifActeRequestDto.getDateValid());
		entity.setIdValid(budgetModifActeRequestDto.getIdValid());
		entity.setIdBudget(budgetModifActeRequestDto.getIdBudget());
		return GbcMapper2.BudgetModifActeToBudgetModifActeResponseDto(entity);
	}

	@Override
	public Long getCodReamCodBMA() {
		return (repository.getMaxCodReamCodBMA() == null)? 1 : repository.getMaxCodReamCodBMA() + 1;
	}

	@Override
	public Boolean existsByGestionAndIdBudgetAndValide(Short gestion, Integer idBudget, Boolean valide) {
		return repository.existsByGestionAndIdBudgetAndValide(gestion, idBudget, valide);
	}

	@Override
	public List<BudgetModifActeResponseDto> getByGestionAndIdBudgetAndValide(Short gestion, Integer idBudget, Boolean valide) {
		List<BudgetModifActe> list = repository.getByGestionAndIdBudgetAndValideOrderByDateSaisieDesc(gestion, idBudget, valide);
		return list
				.stream().map(element  -> GbcMapper2.BudgetModifActeToBudgetModifActeResponseDto(element))
				.collect(Collectors.toList());
	}
}
