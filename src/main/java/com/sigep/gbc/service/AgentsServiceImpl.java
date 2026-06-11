package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.AgentsRequestDto;
import com.sigep.gbc.dto.requestDto.DestinatairesRequestDto;
import com.sigep.gbc.dto.responseDto.AgentsResponseDto;
import com.sigep.gbc.entity.Agents;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.DirectionService;

import com.sigep.gbc.repository.AgentsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgentsServiceImpl implements AgentsService{
	
	private final AgentsRepository repository;
	private final DestinatairesService dService;
	private final DirectionServiceService dsService;

	@Override
	@Transactional("gbcTransactionManager")
	public AgentsResponseDto add(AgentsRequestDto agentsRequestDto) {
		Agents agents = new Agents();
		agents.setNom(agentsRequestDto.getNom());
		agents.setPrenom(agentsRequestDto.getPrenom());
		agents.setSexe(agentsRequestDto.getSexe());
		agents.setSignataire(agentsRequestDto.getSignataire());
		agents.setTitreHonoSign(agentsRequestDto.getTitreHonoSign());
		agents.setActif(agentsRequestDto.getActif());
		
		if (agentsRequestDto.getIdService() == null) {
			throw new IllegalArgumentException("Agents need a DirectionService");
		}
		DirectionService directionService = dsService.get(agentsRequestDto.getIdService());
		agents.setDirectionService(directionService);
		
		DestinatairesRequestDto destinatairesRequestDto = new DestinatairesRequestDto();
		destinatairesRequestDto.setFtype("A");
		dService.add(destinatairesRequestDto);
		
		Destinataires destinataires = dService.findTopByOrderByIdDest();
		agents.setDestinataires(destinataires);
		
		repository.save(agents);
		return GbcMapper.aToAResponseDto(agents);
	}

	@Override
	public List<AgentsResponseDto> getAll() {
		List<Agents> agentss = repository.findAll();
		return agentss
				.stream().map(element  -> GbcMapper.aToAResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public Agents get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Agents with id: " + id + " could not be found"));
	}

	@Override
	public AgentsResponseDto getById(Long id) {
		Agents agents = get(id);
		return GbcMapper.aToAResponseDto(agents);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public AgentsResponseDto delete(Long id) {
		Agents agents = get(id);
		repository.delete(agents);
		return GbcMapper.aToAResponseDto(agents);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public AgentsResponseDto edit(Long id, AgentsRequestDto agentsRequestDto) {
		Agents agents = get(id);
		agents.setNom(agentsRequestDto.getNom());
		agents.setPrenom(agentsRequestDto.getPrenom());
		agents.setSexe(agentsRequestDto.getSexe());
		agents.setSignataire(agentsRequestDto.getSignataire());
		agents.setTitreHonoSign(agentsRequestDto.getTitreHonoSign());
		agents.setActif(agentsRequestDto.getActif());
		
		if (agentsRequestDto.getIdService() != null) {
			DirectionService directionService = dsService.get(agentsRequestDto.getIdService());
			agents.setDirectionService(directionService);
		}
		
		//Destinataires destinataires = dService.f
		//agents.setDestinataires(destinataires);
		
		return GbcMapper.aToAResponseDto(agents);
	}

}
