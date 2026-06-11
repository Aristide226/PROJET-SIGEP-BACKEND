package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.DirectionServiceRequestDto;
import com.sigep.gbc.dto.responseDto.DirectionServiceResponseDto;
import com.sigep.gbc.entity.DirectionService;
import com.sigep.gbc.entity.DirectionServiceNiveau;
import com.sigep.gbc.entity.EnteteStructure;
import com.sigep.gbc.repository.DirectionServiceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DirectionServiceServiceImpl implements DirectionServiceService{

	private final DirectionServiceRepository repository;
	private final EnteteStructureService esService;
	private final DirectionServiceNiveauService dsnService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public DirectionServiceResponseDto add(DirectionServiceRequestDto directionServiceRequestDto) {
		DirectionService directionService = new DirectionService();
		directionService.setLibelle(directionServiceRequestDto.getLibelle());
		directionService.setAbrev(directionServiceRequestDto.getAbrev());
		directionService.setIdHerachique("-");
		
		if (directionServiceRequestDto.getIdNiveau() == null) {
			throw new IllegalArgumentException("DirectionService need a DirectionServiceNiveau");
		}
		DirectionServiceNiveau directionServiceNiveau = dsnService.get(directionServiceRequestDto.getIdNiveau());
		directionService.setDirectionServiceNiveau(directionServiceNiveau);
		
		if (directionServiceRequestDto.getCodStruct() == null) {
			throw new IllegalArgumentException("DirectionService need a EnteteStruture");
		}
		EnteteStructure enteteStructure = esService.get(directionServiceRequestDto.getCodStruct());
		directionService.setEnteteStructure(enteteStructure);
		
		if (directionServiceRequestDto.getIdParent() != null) {
			DirectionService directionServiceParent = get(directionServiceRequestDto.getIdParent());
			directionService.setDirectionService(directionServiceParent);
		}
		
		directionService = repository.save(directionService);
		
		int idService = directionService.getIdService();
		Integer idParent = (directionServiceRequestDto.getIdParent() == null)?null:directionService.getDirectionService().getIdService();
		String idHerachique = ((idParent == null)? "": idParent) + "" + idService;
		
		directionService.setIdHerachique(idHerachique);
		repository.save(directionService);
		return GbcMapper.dsToDsResponseDto(directionService);
	}

	@Override
	public List<DirectionServiceResponseDto> getAll() {
		List<DirectionService> directionServices = repository.findAll();
		return directionServices
				.stream().map(element  -> GbcMapper.dsToDsResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public DirectionService get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("DirectionService with id: " + id + " could not be found"));
	}

	@Override
	public DirectionServiceResponseDto getById(Integer id) {
		DirectionService directionService  = get(id);
		return GbcMapper.dsToDsResponseDto(directionService);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public DirectionServiceResponseDto delete(Integer id) {
		DirectionService directionService  = get(id);
		repository.delete(directionService);
		return GbcMapper.dsToDsResponseDto(directionService);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public DirectionServiceResponseDto edit(Integer id, DirectionServiceRequestDto directionServiceRequestDto) {
		DirectionService directionService = get(id);
		directionService.setLibelle(directionServiceRequestDto.getLibelle());
		directionService.setAbrev(directionServiceRequestDto.getAbrev());
		
		if (directionServiceRequestDto.getIdNiveau() != null) {
			DirectionServiceNiveau directionServiceNiveau = dsnService.get(directionServiceRequestDto.getIdNiveau());
			directionService.setDirectionServiceNiveau(directionServiceNiveau);
		}
		
		
		if (directionServiceRequestDto.getCodStruct() != null) {
			EnteteStructure enteteStructure = esService.get(directionServiceRequestDto.getCodStruct());
			directionService.setEnteteStructure(enteteStructure);
		}
		
		if (directionServiceRequestDto.getIdParent() != null) {
			DirectionService directionServiceParent = get(directionServiceRequestDto.getIdParent());
			directionService.setDirectionService(directionServiceParent);
		} else {
			repository.updateIdParent(directionServiceRequestDto.getIdParent(), id);
		}
		
		Integer idParent = directionServiceRequestDto.getIdParent();
		String idHerachique = ((idParent == null)? "": idParent) + "" + id;
		
		directionService.setIdHerachique(idHerachique);
		
		return GbcMapper.dsToDsResponseDto(directionService);
	}

}
