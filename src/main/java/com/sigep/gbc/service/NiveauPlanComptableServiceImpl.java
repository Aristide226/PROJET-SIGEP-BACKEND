package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.NiveauPlanComptableRequestDto;
import com.sigep.gbc.dto.responseDto.NiveauPlanComptableResponseDto;
import com.sigep.gbc.entity.NiveauPlanComptable;
import com.sigep.gbc.repository.NiveauPlanComptableRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NiveauPlanComptableServiceImpl implements NiveauPlanComptableService {
	
	private final NiveauPlanComptableRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public NiveauPlanComptableResponseDto add(NiveauPlanComptableRequestDto niveauPlanComptableRequestDto) {
		NiveauPlanComptable niveauPlanComptable = new NiveauPlanComptable();
		niveauPlanComptable.setNiveau(niveauPlanComptableRequestDto.getNiveau());
		niveauPlanComptable.setIntituleNiveau(niveauPlanComptableRequestDto.getIntituleNiveau());
		niveauPlanComptable.setDescription(niveauPlanComptableRequestDto.getDescription());
		repository.save(niveauPlanComptable);
		return GbcMapper.npcToNpcResponseDto(niveauPlanComptable);
	}

	@Override
	public List<NiveauPlanComptableResponseDto> getAll() {
		List<NiveauPlanComptable> niveauPlanComptables = repository.findAll();
		return niveauPlanComptables
				.stream().map(element  -> GbcMapper.npcToNpcResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public NiveauPlanComptable get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("NiveauPlanComptable with id: " + id + " could not be found"));
	}

	@Override
	public NiveauPlanComptableResponseDto getById(Integer id) {
		NiveauPlanComptable niveauPlanComptable = get(id);
		return GbcMapper.npcToNpcResponseDto(niveauPlanComptable);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public NiveauPlanComptableResponseDto delete(Integer id) {
		NiveauPlanComptable niveauPlanComptable = get(id);
		repository.delete(niveauPlanComptable);
		return GbcMapper.npcToNpcResponseDto(niveauPlanComptable);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public NiveauPlanComptableResponseDto edit(Integer id, NiveauPlanComptableRequestDto niveauPlanComptableRequestDto) {
		NiveauPlanComptable niveauPlanComptable = get(id);
		niveauPlanComptable.setIntituleNiveau(niveauPlanComptableRequestDto.getIntituleNiveau());
		niveauPlanComptable.setDescription(niveauPlanComptableRequestDto.getDescription());
		return GbcMapper.npcToNpcResponseDto(niveauPlanComptable);
	}

}
