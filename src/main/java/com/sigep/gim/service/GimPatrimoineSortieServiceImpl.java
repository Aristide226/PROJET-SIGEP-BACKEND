package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PatrimoineSortieRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineSortieResponseDto;
import com.sigep.gim.entity.EtatBien;
import com.sigep.gim.entity.Fiches;
import com.sigep.gim.entity.Patrimoine;
import com.sigep.gim.entity.PatrimoineSortie;
import com.sigep.gim.entity.PatrimoineSortieId;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimPatrimoineSortieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimPatrimoineSortieServiceImpl implements GimPatrimoineSortieService {
	
	private final GimPatrimoineSortieRepository repository;
	private final GimEtatBienService gimEtatBienService;
	private final GimFichesService gimFichesService;
	private final GimPatrimoineService gimPatrimoineService;
	
	@Override
	@Transactional
	public PatrimoineSortieResponseDto add(PatrimoineSortieRequestDto patrimoineSortieRequestDto) {
		PatrimoineSortie entity = new PatrimoineSortie();

	    entity.setValeurAffectation(patrimoineSortieRequestDto.getValeurAffectation());
	    entity.setObserv(patrimoineSortieRequestDto.getObserv());
	    entity.setTemporaire(patrimoineSortieRequestDto.getTemporaire());
	    entity.setDateRetourPossible(patrimoineSortieRequestDto.getDateRetourPossible());
	    entity.setDateRetourEffective(patrimoineSortieRequestDto.getDateRetourEffective());
	    entity.setEtatRetour(patrimoineSortieRequestDto.getEtatRetour());
	    entity.setObservRetour(patrimoineSortieRequestDto.getObservRetour());
	    entity.setIdFicheH(patrimoineSortieRequestDto.getIdFicheH());
	    entity.setStatPatriH(patrimoineSortieRequestDto.getStatPatriH());
	    entity.setMleAffectH(patrimoineSortieRequestDto.getMleAffectH());
	    entity.setIdMagasinH(patrimoineSortieRequestDto.getIdMagasinH());
	    entity.setCodeSite(patrimoineSortieRequestDto.getCodeSite());
	    entity.setCodDirectH(patrimoineSortieRequestDto.getCodDirectH());
	    entity.setCodServiceH(patrimoineSortieRequestDto.getCodServiceH());
	    entity.setCodProvH(patrimoineSortieRequestDto.getCodProvH());
	    entity.setEtatActuelH(patrimoineSortieRequestDto.getEtatActuelH());
	    entity.setIdInventH(patrimoineSortieRequestDto.getIdInventH());
	    entity.setIdFicheRetour(patrimoineSortieRequestDto.getIdFicheRetour());

	    if (patrimoineSortieRequestDto.getEtatB() == null) {
	    	throw new IllegalArgumentException("PatrimoineSortie need a EtatBien");
	    }
	    EtatBien etatBien = gimEtatBienService.get(patrimoineSortieRequestDto.getEtatB());
	    entity.setEtatBien(etatBien);
	    
	    if (patrimoineSortieRequestDto.getIdFiche() == null) {
	    	throw new IllegalArgumentException("PatrimoineSortie need a Fiches");
	    }
	    Fiches fiches = gimFichesService.get(patrimoineSortieRequestDto.getIdFiche());
	    entity.setFiches(fiches);
	    
	    if (patrimoineSortieRequestDto.getMle() == null) {
	    	throw new IllegalArgumentException("PatrimoineSortie need a Patrimoine");
	    }
	    Patrimoine patrimoine = gimPatrimoineService.get(patrimoineSortieRequestDto.getMle());
	    entity.setPatrimoine(patrimoine);
	    
	    entity.setId(new PatrimoineSortieId(
	    	fiches.getIdFiche(),
	    	patrimoine.getMle()
	    ));
		repository.save(entity);
		return GimMapper.PatrimoineSortieToPatrimoineSortieResponseDto(entity);
	}
	
	@Override
	public List<PatrimoineSortieResponseDto> getAll() {
		List<PatrimoineSortie> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.PatrimoineSortieToPatrimoineSortieResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public PatrimoineSortie get(long idFiche, String mle) {
		PatrimoineSortieId id = new PatrimoineSortieId();
		id.setIdFiche(idFiche);
		id.setMle(mle);
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("PatrimoineSortie with id "+id+"could not be found")
		);
	}
	
	@Override
	public PatrimoineSortieResponseDto getById(long idFiche, String mle) {
		PatrimoineSortie entity = get(idFiche,mle);
		return GimMapper.PatrimoineSortieToPatrimoineSortieResponseDto(entity);
	}
	
	@Override
	@Transactional
	public PatrimoineSortieResponseDto delete(long idFiche, String mle) {
		PatrimoineSortie entity = get(idFiche,mle);
		repository.delete(entity);
		return GimMapper.PatrimoineSortieToPatrimoineSortieResponseDto(entity);
	}
	
	@Override
	@Transactional
	public PatrimoineSortieResponseDto edit(long idFiche, String mle,PatrimoineSortieRequestDto patrimoineSortieRequestDto) {
		PatrimoineSortie entity = get(idFiche,mle);
		entity.setValeurAffectation(patrimoineSortieRequestDto.getValeurAffectation());
	    entity.setObserv(patrimoineSortieRequestDto.getObserv());
	    entity.setTemporaire(patrimoineSortieRequestDto.getTemporaire());
	    entity.setDateRetourPossible(patrimoineSortieRequestDto.getDateRetourPossible());
	    entity.setDateRetourEffective(patrimoineSortieRequestDto.getDateRetourEffective());
	    entity.setEtatRetour(patrimoineSortieRequestDto.getEtatRetour());
	    entity.setObservRetour(patrimoineSortieRequestDto.getObservRetour());
	    entity.setIdFicheH(patrimoineSortieRequestDto.getIdFicheH());
	    entity.setStatPatriH(patrimoineSortieRequestDto.getStatPatriH());
	    entity.setMleAffectH(patrimoineSortieRequestDto.getMleAffectH());
	    entity.setIdMagasinH(patrimoineSortieRequestDto.getIdMagasinH());
	    entity.setCodeSite(patrimoineSortieRequestDto.getCodeSite());
	    entity.setCodDirectH(patrimoineSortieRequestDto.getCodDirectH());
	    entity.setCodServiceH(patrimoineSortieRequestDto.getCodServiceH());
	    entity.setCodProvH(patrimoineSortieRequestDto.getCodProvH());
	    entity.setEtatActuelH(patrimoineSortieRequestDto.getEtatActuelH());
	    entity.setIdInventH(patrimoineSortieRequestDto.getIdInventH());
	    entity.setIdFicheRetour(patrimoineSortieRequestDto.getIdFicheRetour());

	    if (patrimoineSortieRequestDto.getEtatB() != null) {
	    	 EtatBien etatBien = gimEtatBienService.get(patrimoineSortieRequestDto.getEtatB());
	 	    entity.setEtatBien(etatBien);
	    }
	   
		return GimMapper.PatrimoineSortieToPatrimoineSortieResponseDto(entity);
	}
}
