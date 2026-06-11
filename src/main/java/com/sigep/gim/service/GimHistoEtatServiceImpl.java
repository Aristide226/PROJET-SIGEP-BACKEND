package com.sigep.gim.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.HistoEtatRequestDto;
import com.sigep.gim.dto.responseDto.HistoEtatResponseDto;
import com.sigep.gim.entity.EtatFiche;
import com.sigep.gim.entity.Fiches;
import com.sigep.gim.entity.HistoEtat;
import com.sigep.gim.entity.HistoEtatId;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimHistoEtatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimHistoEtatServiceImpl implements GimHistoEtatService {
	
	private final GimHistoEtatRepository repository;
	private final GimEtatFicheService gimEtatFicheService;
	private final GimFichesService gimFichesService;
	
	@Override
	@Transactional
	public HistoEtatResponseDto add(HistoEtatRequestDto histoEtatRequestDto) {
		HistoEtat entity = new HistoEtat();
		if(histoEtatRequestDto.getEtat() == null) {
			throw new IllegalArgumentException("HistoEtat need a EtatFiche");
		}
		EtatFiche etatFiche = gimEtatFicheService.get(histoEtatRequestDto.getEtat());
		
		if(histoEtatRequestDto.getIdFiche() == null) {
			throw new IllegalArgumentException("HistoEtat need a Fiches");
		}
		Fiches fiches = gimFichesService.get(histoEtatRequestDto.getIdFiche());
		
		entity.setId(new HistoEtatId(
			etatFiche.getEtat(),
			fiches.getIdFiche(),
			histoEtatRequestDto.getDateEtat()
		));
		repository.save(entity);
		return GimMapper.HistoEtatToHistoEtatResponseDto(entity);
	}
	
	@Override
	public List<HistoEtatResponseDto> getAll() {
		List<HistoEtat> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.HistoEtatToHistoEtatResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public HistoEtat get(String etat, long idFiche, Date dateEtat) {
		HistoEtatId id = new HistoEtatId();
		id.setEtat(etat);
		id.setIdFiche(idFiche);
		id.setDateEtat(dateEtat);
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("HistoEtat with id "+id+"could not be found")
		);
	}
	
	@Override
	public HistoEtatResponseDto getById(String etat, long idFiche, Date dateEtat) {
		HistoEtat entity = get(etat,idFiche,dateEtat);
		return GimMapper.HistoEtatToHistoEtatResponseDto(entity);
	}
	
	@Override
	@Transactional
	public HistoEtatResponseDto delete(String etat, long idFiche, Date dateEtat) {
		HistoEtat entity = get(etat,idFiche,dateEtat);
		repository.delete(entity);
		return GimMapper.HistoEtatToHistoEtatResponseDto(entity);
	}
	
	@Override
	@Transactional
	public HistoEtatResponseDto edit(String etat, long idFiche, Date dateEtat,HistoEtatRequestDto histoEtatRequestDto) {
		HistoEtat entity = get(etat,idFiche,dateEtat);
		return GimMapper.HistoEtatToHistoEtatResponseDto(entity);
	}
}
