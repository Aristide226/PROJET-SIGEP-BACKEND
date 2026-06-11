package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.FichesRequestDto;
import com.sigep.gim.dto.responseDto.FichesResponseDto;
import com.sigep.gim.entity.CategorieBien;
import com.sigep.gim.entity.EtatFiche;
import com.sigep.gim.entity.Fiches;
import com.sigep.gim.entity.Fournisseurs;
import com.sigep.gim.entity.TypFiche;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimFichesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimFichesServiceImpl implements GimFichesService {
	
	private final GimFichesRepository repository;
	private final GimCategorieBienService gimCategorieBienService;
	private final GimEtatFicheService gimEtatFicheService;
	private final GimFournisseursService gimFournisseursService;
	private final GimTypFicheService gimTypFicheService;
	
	@Override
	@Transactional
	public FichesResponseDto add(FichesRequestDto fichesRequestDto) {
		long idFiche = findByMaxIdFiche() + 1;
	
		 Fiches entity = new Fiches();
		 entity.setIdFiche(idFiche);
		
		 entity.setNumFiche(fichesRequestDto.getNumFiche());
		 entity.setDateSaisie(fichesRequestDto.getDateSaisie());
		 entity.setDateEtat(fichesRequestDto.getDateEtat());
		 entity.setMontantFiche(fichesRequestDto.getMontantFiche());
		 entity.setIdTypeAcq(fichesRequestDto.getIdTypeAcq());
		 entity.setCodSourceFin(fichesRequestDto.getCodSourceFin());   
		 entity.setAffect(fichesRequestDto.getAffect());
		 entity.setIdMagasin(fichesRequestDto.getIdMagasin());
		 entity.setCodDirect(fichesRequestDto.getCodDirect());
		 entity.setIdService(fichesRequestDto.getIdService());
		 entity.setCodProv(fichesRequestDto.getCodProv());
		 entity.setMleAgent(fichesRequestDto.getMleAgent());
		 entity.setDateAffect(fichesRequestDto.getDateAffect());
		 entity.setCodDirectOrigi(fichesRequestDto.getCodDirectOrigi());
		 entity.setIdServiceOrigi(fichesRequestDto.getIdServiceOrigi());
		 entity.setCodProvOrigi(fichesRequestDto.getCodProvOrigi());
		 entity.setCodeSite(fichesRequestDto.getCodeSite());
		 entity.setDateRetourPossible(fichesRequestDto.getDateRetourPossible());
		 entity.setDateRetourEffective(fichesRequestDto.getDateRetourEffective());
		 entity.setTypSortie(fichesRequestDto.getTypSortie());
		 entity.setIdFicheH(fichesRequestDto.getIdFicheH());
		 entity.setIdSourceFin(fichesRequestDto.getIdSourceFin());
		 entity.setIdBudget(fichesRequestDto.getIdBudget());
		 entity.setFonctSigna1(fichesRequestDto.getFonctSigna1());
		 entity.setPrenomNomSigna1(fichesRequestDto.getPrenomNomSigna1());
		 entity.setTitreHonoSigna1(fichesRequestDto.getTitreHonoSigna1());
		 entity.setFonctSigna2(fichesRequestDto.getFonctSigna2());
		 entity.setPrenomNomSigna2(fichesRequestDto.getPrenomNomSigna2());
		 entity.setTitreHonoSigna2(fichesRequestDto.getTitreHonoSigna2());
		 entity.setFonctSigna3(fichesRequestDto.getFonctSigna3());
		 entity.setPrenomNomSigna3(fichesRequestDto.getPrenomNomSigna3());
		 entity.setTitreHonoSigna3(fichesRequestDto.getTitreHonoSigna3());
		 entity.setNumBe(fichesRequestDto.getNumBe());
		 entity.setBenum(fichesRequestDto.getBenum());
		 entity.setNbBiens(fichesRequestDto.getNbBiens());
		 entity.setDateEntreSortie(fichesRequestDto.getDateEntreSortie());
		 entity.setBienEnMagasin(fichesRequestDto.isBienEnMagasin());   
		 
		 if(fichesRequestDto.getCodCategorie() == null) {
			 throw new IllegalArgumentException("Fiches need a CategorieBien");
		 }
		 CategorieBien categorieBien = gimCategorieBienService.get(fichesRequestDto.getCodCategorie());
		 entity.setCategorieBien(categorieBien);
		 
		 if(fichesRequestDto.getEtat() == null) {
			 throw new IllegalArgumentException("Fiches need a EtatFiche");
		 }
		 EtatFiche etatFiche = gimEtatFicheService.get(fichesRequestDto.getEtat());
		 entity.setEtatFiche(etatFiche);
		 
		 if(fichesRequestDto.getIdFourn() == null) {
			 throw new IllegalArgumentException("Fiches need a Fournisseurs");
		 }
		 Fournisseurs fournisseurs = gimFournisseursService.get(fichesRequestDto.getIdFourn());
		 entity.setFournisseurs(fournisseurs);
		 
		 if(fichesRequestDto.getIdTypFiche() == null) {
			 throw new IllegalArgumentException("Fiches need a TypFiche");
		 }
		 TypFiche typFiche = gimTypFicheService.get(fichesRequestDto.getIdTypFiche());
		 entity.setTypFiche(typFiche);
		 
		repository.save(entity);
		return GimMapper.FichesToFichesResponseDto(entity);
	}
	
	@Override
	public List<FichesResponseDto> getAll() {
		List<Fiches> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.FichesToFichesResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Fiches get(long id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Fiches with id "+id+"could not be found")
		);
	}
	
	@Override
	public FichesResponseDto getById(long id) {
		Fiches entity = get(id);
		return GimMapper.FichesToFichesResponseDto(entity);
	}
	
	@Override
	@Transactional
	public FichesResponseDto delete(long id) {
		Fiches entity = get(id);
		repository.delete(entity);
		return GimMapper.FichesToFichesResponseDto(entity);
	}
	
	@Override
	@Transactional
	public FichesResponseDto edit(long id,FichesRequestDto fichesRequestDto) {
		Fiches entity = get(id);
		entity.setNumFiche(fichesRequestDto.getNumFiche());
		 entity.setDateSaisie(fichesRequestDto.getDateSaisie());
		 entity.setDateEtat(fichesRequestDto.getDateEtat());
		 entity.setMontantFiche(fichesRequestDto.getMontantFiche());
		 entity.setIdTypeAcq(fichesRequestDto.getIdTypeAcq());
		 entity.setCodSourceFin(fichesRequestDto.getCodSourceFin());   
		 entity.setAffect(fichesRequestDto.getAffect());
		 entity.setIdMagasin(fichesRequestDto.getIdMagasin());
		 entity.setCodDirect(fichesRequestDto.getCodDirect());
		 entity.setIdService(fichesRequestDto.getIdService());
		 entity.setCodProv(fichesRequestDto.getCodProv());
		 entity.setMleAgent(fichesRequestDto.getMleAgent());
		 entity.setDateAffect(fichesRequestDto.getDateAffect());
		 entity.setCodDirectOrigi(fichesRequestDto.getCodDirectOrigi());
		 entity.setIdServiceOrigi(fichesRequestDto.getIdServiceOrigi());
		 entity.setCodProvOrigi(fichesRequestDto.getCodProvOrigi());
		 entity.setCodeSite(fichesRequestDto.getCodeSite());
		 entity.setDateRetourPossible(fichesRequestDto.getDateRetourPossible());
		 entity.setDateRetourEffective(fichesRequestDto.getDateRetourEffective());
		 entity.setTypSortie(fichesRequestDto.getTypSortie());
		 entity.setIdFicheH(fichesRequestDto.getIdFicheH());
		 entity.setIdSourceFin(fichesRequestDto.getIdSourceFin());
		 entity.setIdBudget(fichesRequestDto.getIdBudget());
		 entity.setFonctSigna1(fichesRequestDto.getFonctSigna1());
		 entity.setPrenomNomSigna1(fichesRequestDto.getPrenomNomSigna1());
		 entity.setTitreHonoSigna1(fichesRequestDto.getTitreHonoSigna1());
		 entity.setFonctSigna2(fichesRequestDto.getFonctSigna2());
		 entity.setPrenomNomSigna2(fichesRequestDto.getPrenomNomSigna2());
		 entity.setTitreHonoSigna2(fichesRequestDto.getTitreHonoSigna2());
		 entity.setFonctSigna3(fichesRequestDto.getFonctSigna3());
		 entity.setPrenomNomSigna3(fichesRequestDto.getPrenomNomSigna3());
		 entity.setTitreHonoSigna3(fichesRequestDto.getTitreHonoSigna3());
		 entity.setNumBe(fichesRequestDto.getNumBe());
		 entity.setBenum(fichesRequestDto.getBenum());
		 entity.setNbBiens(fichesRequestDto.getNbBiens());
		 entity.setDateEntreSortie(fichesRequestDto.getDateEntreSortie());
		 entity.setBienEnMagasin(fichesRequestDto.isBienEnMagasin());   
		 
		 if(fichesRequestDto.getCodCategorie() != null) {
			 CategorieBien categorieBien = gimCategorieBienService.get(fichesRequestDto.getCodCategorie());
			 entity.setCategorieBien(categorieBien);
		 }
		 
		 if(fichesRequestDto.getEtat() != null) {
			 EtatFiche etatFiche = gimEtatFicheService.get(fichesRequestDto.getEtat());
			 entity.setEtatFiche(etatFiche);
		 }
		 
		 if(fichesRequestDto.getIdFourn() != null) {
			 Fournisseurs fournisseurs = gimFournisseursService.get(fichesRequestDto.getIdFourn());
			 entity.setFournisseurs(fournisseurs);
		 }
		 
		 if(fichesRequestDto.getIdTypFiche() != null) {
			 TypFiche typFiche = gimTypFicheService.get(fichesRequestDto.getIdTypFiche());
			 entity.setTypFiche(typFiche);
		 }
		 
		return GimMapper.FichesToFichesResponseDto(entity);
	}
	
	@Override
	@Transactional
	public Long findByMaxIdFiche() {
		return repository.findByMaxIdFiche();
	}
}
