package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.PlanComptableRequestDto;
import com.sigep.gbc.dto.responseDto.PlanComptableResponseDto;

import com.sigep.gbc.entity.NiveauPlanComptable;
import com.sigep.gbc.entity.PlanComptable;
import com.sigep.gbc.repository.PlanComptableRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanComptableServiceImpl implements PlanComptableService {
	
	private final PlanComptableRepository repository;
	private final NiveauPlanComptableService npcService;

	@Override
	@Transactional("gbcTransactionManager")
	public PlanComptableResponseDto add(PlanComptableRequestDto planComptableRequestDto) {
		PlanComptable entity = new PlanComptable();
		entity.setIdPlan(planComptableRequestDto.getIdPlan());
		entity.setIntitulePlan(planComptableRequestDto.getIntitulePlan());
		
		if (planComptableRequestDto.getNiveau() == null) {
			throw new IllegalArgumentException("PlanComptable need a NiveauPlanComptable");
		}
		NiveauPlanComptable niveauPlanComptable = npcService.get(planComptableRequestDto.getNiveau());
		entity.setNiveauPlanComptable(niveauPlanComptable);
		
		repository.save(entity);
		return GbcMapper.pcToPcResponseDto(entity);
	}

	@Override
	public List<PlanComptableResponseDto> getAll() {
		List<PlanComptable> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.pcToPcResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public PlanComptable get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("PlanComptable with id: " + id + " could not be found"));
	}

	@Override
	public PlanComptableResponseDto getById(String id) {
		PlanComptable entity = get(id);
		return GbcMapper.pcToPcResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public PlanComptableResponseDto delete(String id) {
		PlanComptable entity = get(id);
		repository.delete(entity);
		return GbcMapper.pcToPcResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public PlanComptableResponseDto edit(String id, PlanComptableRequestDto planComptableRequestDto) {
		PlanComptable entity = get(id);
		entity.setIntitulePlan(planComptableRequestDto.getIntitulePlan());
		
		if (planComptableRequestDto.getNiveau() != null) {
			NiveauPlanComptable niveauPlanComptable = npcService.get(planComptableRequestDto.getNiveau());
			entity.setNiveauPlanComptable(niveauPlanComptable);
		}
		
		return GbcMapper.pcToPcResponseDto(entity);
	}

	@Override
	public List<PlanComptableResponseDto> getCompteTiers() {
		List<PlanComptable> list = repository.getCompteTiers();
		return list
				.stream().map(element  -> GbcMapper.pcToPcResponseDto(element))
				.collect(Collectors.toList());
	}
}
