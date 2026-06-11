package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gim.dto.requestDto.AgentsRequestDto;
import com.sigep.gim.dto.responseDto.AgentsResponseDto;
import com.sigep.gim.entity.Agents;
import com.sigep.gim.entity.Directions;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimAgentsRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional("gimTransactionManager")
@RequiredArgsConstructor
public class GimAgentsServiceImpl implements GimAgentsService {
	
	private final GimAgentsRepository repository;
	private final GimDirectionsService gimDirectionsService;
	
	@Override
	public AgentsResponseDto add(AgentsRequestDto agentsRequestDto) {
		Agents entity = new Agents();
		entity.setNom(agentsRequestDto.getNom());
		entity.setPrenom(agentsRequestDto.getPrenom());
		entity.setSexe(agentsRequestDto.getSexe());
		entity.setFonctActuelle(agentsRequestDto.getFonctActuelle());
		entity.setTitreHono(agentsRequestDto.getTitreHono());
		
		if (agentsRequestDto.getCodDirect() == null) {
			throw new IllegalArgumentException("Agents need a directions");
		}
		Directions directions = gimDirectionsService.get(agentsRequestDto.getCodDirect());
		entity.setDirections(directions);
		
		//mle agents provient de destinataire  
		repository.save(entity);
		return GimMapper.AgentsToAgentsResponseDto(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AgentsResponseDto> getAll() {
		List<Agents> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.AgentsToAgentsResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Agents get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Agents with id "+id+" could not be found")
		);
	}

	@Override
	@Transactional(readOnly = true)
	public AgentsResponseDto getById(String id) {
		Agents entity = get(id);
		return GimMapper.AgentsToAgentsResponseDto(entity);
	}

	@Override
	public AgentsResponseDto delete(String id) {
		Agents entity = get(id);
		repository.delete(entity);
		return GimMapper.AgentsToAgentsResponseDto(entity);
	}

	@Override
	public AgentsResponseDto edit(String id, AgentsRequestDto agentsRequestDto) {
		Agents entity = get(id);
		entity.setNom(agentsRequestDto.getNom());
		entity.setPrenom(agentsRequestDto.getPrenom());
		entity.setSexe(agentsRequestDto.getSexe());
		entity.setFonctActuelle(agentsRequestDto.getFonctActuelle());
		entity.setTitreHono(agentsRequestDto.getTitreHono());
		
		if(agentsRequestDto.getCodDirect() != null) {
			Directions directions = gimDirectionsService.get(agentsRequestDto.getCodDirect());
			entity.setDirections(directions);
		}
		return GimMapper.AgentsToAgentsResponseDto(entity);
	}

}
