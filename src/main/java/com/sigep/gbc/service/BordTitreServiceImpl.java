package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.BordTitreDto;
import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.entity.BordTitre;
import com.sigep.gbc.entity.BordTitreId;
import com.sigep.gbc.entity.BordereauEmismandats;
import com.sigep.gbc.entity.TitreDetail;
import com.sigep.gbc.repository.BordTitreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BordTitreServiceImpl implements BordTitreService {
	
	private final BordTitreRepository repository;
	private final BordereauEmismandatsService bordereauEmismandatsService;
	private final TitreDetailService titreDetailService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public BordTitreDto add(BordTitreDto bordTitreDto) {
		BordTitre entity = new BordTitre();
		
		if (bordTitreDto.getIdBord() == null) {
			throw new IllegalArgumentException("BordTitre need a BordereauEmisMandats");
		}
		BordereauEmismandats bordereauEmismandats = bordereauEmismandatsService.get(bordTitreDto.getIdBord());
		entity.setBordereauEmismandats(bordereauEmismandats);
		
		if (bordTitreDto.getIdDetailTitre() == null) {
			throw new IllegalArgumentException("BordTitre need a TitreDetail");
		}
		TitreDetail titreDetail = titreDetailService.get(bordTitreDto.getIdDetailTitre());
		entity.setTitreDetail(titreDetail);
		
		entity.setId(new BordTitreId(
				bordTitreDto.getIdBord(), 
				bordTitreDto.getIdDetailTitre()
		));
		
		entity.setDatePaieRecouv(bordTitreDto.getDatePaieRecouv());
		entity.setObservation(bordTitreDto.getObservation());
		entity.setActifSurBord(bordTitreDto.getActifSurBord());
		
		repository.save(entity);
		return GbcMapper.bordTitreToBordTitreResponseDto(entity);
	}
	
	@Override
	public List<BordTitreDto> getAll() {
		List<BordTitre> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.bordTitreToBordTitreResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public BordTitre get(String idBord, Long idDetailTitre) {
		BordTitreId id = new BordTitreId();
		id.setIdbord(idBord);
		id.setIdDetailTitre(idDetailTitre);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("BordTitre with id: " + id + " could not be found"));
	}
	
	@Override
	public BordTitreDto getById(String idBord, Long idDetailTitre) {
		BordTitre entity  = get(idBord, idDetailTitre);
		return GbcMapper.bordTitreToBordTitreResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public BordTitreDto delete(String idBord, Long idDetailTitre) {
		BordTitre entity  = get(idBord, idDetailTitre);
		repository.delete(entity);
		return GbcMapper.bordTitreToBordTitreResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public BordTitreDto edit(String idBord, Long idDetailTitre, BordTitreDto bordTitreDto) {
		BordTitre entity  = get(idBord, idDetailTitre);
		entity.setDatePaieRecouv(bordTitreDto.getDatePaieRecouv());
		entity.setObservation(bordTitreDto.getObservation());
		entity.setActifSurBord(bordTitreDto.getActifSurBord());
		return GbcMapper.bordTitreToBordTitreResponseDto(entity);
	}	
}
