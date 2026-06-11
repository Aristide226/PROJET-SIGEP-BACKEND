package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.FicheSourceFinRequestDto;
import com.sigep.gim.dto.responseDto.FicheSourceFinResponseDto;
import com.sigep.gim.entity.FicheSourceFin;
import com.sigep.gim.entity.FicheSourceFinId;
import com.sigep.gim.entity.Fiches;
import com.sigep.gim.entity.SourceFinancement;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimFicheSourceFinRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimFicheSourceFinServiceImpl implements GimFicheSourceFinService {
	
	private final GimFicheSourceFinRepository repository;
	private final GimFichesService gimFichesService;
	private final GimSourceFinancementService gimSourceFinancementService;
	
	@Override
	@Transactional
	public FicheSourceFinResponseDto add(FicheSourceFinRequestDto ficheSourceFinRequestDto) {
		FicheSourceFin entity = new FicheSourceFin();
		entity.setMontantSourceFin(ficheSourceFinRequestDto.getMontantSourceFin());
		
		if(ficheSourceFinRequestDto.getIdFiche() == null) {
			throw new IllegalArgumentException("FicheSourceFin need a Fiches");
		}
		Fiches fiches = gimFichesService.get(ficheSourceFinRequestDto.getIdFiche());
		
		if(ficheSourceFinRequestDto.getIdSourceFin() == null) {
			throw new IllegalArgumentException("FicheSourceFin need a SourceFinancement");
		}
		SourceFinancement sourceFinancement = gimSourceFinancementService.get(ficheSourceFinRequestDto.getIdSourceFin());
		
		entity.setId(new FicheSourceFinId(
			fiches.getIdFiche(),
			sourceFinancement.getCodSourceFin()
		));
		
		repository.save(entity);
		return GimMapper.FicheSourceFinToFicheSourceFinResponseDto(entity);
	}
	
	@Override
	public List<FicheSourceFinResponseDto> getAll() {
		List<FicheSourceFin> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.FicheSourceFinToFicheSourceFinResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public FicheSourceFin get(long idFiche, String idSourceFin) {
		FicheSourceFinId id = new FicheSourceFinId();
		id.setIdFiche(idFiche);
		id.setIdSourceFin(idSourceFin);
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("FicheSourceFin with id "+id+"could not be found")
		);
	}
	
	@Override
	public FicheSourceFinResponseDto getById(long idFiche, String idSourceFin) {
		FicheSourceFin entity = get(idFiche,idSourceFin);
		return GimMapper.FicheSourceFinToFicheSourceFinResponseDto(entity);
	}
	
	@Override
	@Transactional
	public FicheSourceFinResponseDto delete(long idFiche, String idSourceFin) {
		FicheSourceFin entity = get(idFiche,idSourceFin);
		repository.delete(entity);
		return GimMapper.FicheSourceFinToFicheSourceFinResponseDto(entity);
	}
	
	@Override
	@Transactional
	public FicheSourceFinResponseDto edit(long idFiche, String idSourceFin,FicheSourceFinRequestDto ficheSourceFinRequestDto) {
		FicheSourceFin entity = get(idFiche,idSourceFin);
		entity.setMontantSourceFin(ficheSourceFinRequestDto.getMontantSourceFin());
		return GimMapper.FicheSourceFinToFicheSourceFinResponseDto(entity);
	}
}
