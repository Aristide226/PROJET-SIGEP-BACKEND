package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PatrimoineRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineResponseDto;
import com.sigep.gim.entity.CategorieBien;
import com.sigep.gim.entity.CodeMateriel;
import com.sigep.gim.entity.EtatBien;
import com.sigep.gim.entity.Fiches;
import com.sigep.gim.entity.Patrimoine;
import com.sigep.gim.entity.PatrimoineStatut;
import com.sigep.gim.entity.Sites;
import com.sigep.gim.entity.SourceFinancement;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimPatrimoineRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimPatrimoineServiceImpl implements GimPatrimoineService {
	
	private final GimPatrimoineRepository repository;
	private final GimCategorieBienService gimCategorieBienService;
	private final GimCodeMaterielService gimCodeMaterielService;
	private final GimEtatBienService gimEtatBienService;
	private final GimFichesService gimFichesService;
	private final GimPatrimoineStatutService gimPatrimoineStatutService;
	private final GimSitesService gimSitesService;
	private final GimSourceFinancementService gimSourceFinancementService;
	
	@Override
	@Transactional
	public PatrimoineResponseDto add(PatrimoineRequestDto patrimoineRequestDto) {
		Patrimoine entity = new Patrimoine();
		entity.setMle(patrimoineRequestDto.getMle());
	    entity.setCodStruct(patrimoineRequestDto.getCodStruct());
	    entity.setAnneAcq(patrimoineRequestDto.getAnneAcq());
	    entity.setDateEntre(patrimoineRequestDto.getDateEntre());
	    entity.setQuantieme(patrimoineRequestDto.getQuantieme());
	    entity.setValUnit(patrimoineRequestDto.getValUnit());
	    entity.setDureeVie(patrimoineRequestDto.getDureeVie());
	    entity.setAmrtisable(patrimoineRequestDto.isAmrtisable());
	    entity.setAmorType(patrimoineRequestDto.getAmorType());
	    entity.setFormat(patrimoineRequestDto.getFormat());
	    entity.setIdMagasin(patrimoineRequestDto.getIdMagasin());
	    entity.setMleAffect(patrimoineRequestDto.getMleAffect());
	    entity.setCodDirect(patrimoineRequestDto.getCodDirect());
	    entity.setCodeDir(patrimoineRequestDto.getCodeDir());
	    entity.setCodService(patrimoineRequestDto.getCodService());
	    entity.setCodReg(patrimoineRequestDto.getCodReg());
	    entity.setCodProv(patrimoineRequestDto.getCodProv());
	    entity.setEtatActuel(patrimoineRequestDto.getEtatActuel());
	    entity.setIdInvent(patrimoineRequestDto.getIdInvent());
	    entity.setIdFicheEntreProv(patrimoineRequestDto.getIdFicheEntreProv());
	    entity.setIdFicheEnCours(patrimoineRequestDto.getIdFicheEnCours());
	    entity.setNomAgentUtil(patrimoineRequestDto.getNomAgentUtil());
	    entity.setMleAgentUtil(patrimoineRequestDto.getMleAgentUtil());
	    entity.setDansInventaire(patrimoineRequestDto.isDansInventaire());
	    
	    if(patrimoineRequestDto.getCodCategorie() ==  null) {
	    	throw new IllegalArgumentException("Patrimoine need a CategorieBien");
	    }
	    CategorieBien categorieBien = gimCategorieBienService.get(patrimoineRequestDto.getCodCategorie());
	    entity.setCategorieBien(categorieBien);
	    
	    if(patrimoineRequestDto.getCodMat() ==  null) {
	    	throw new IllegalArgumentException("Patrimoine need a CodeMateriel");
	    }
	    CodeMateriel codeMateriel = gimCodeMaterielService.get(patrimoineRequestDto.getCodMat());
	    entity.setCodeMateriel(codeMateriel);
	    
	    if(patrimoineRequestDto.getEtatB() ==  null) {
	    	throw new IllegalArgumentException("Patrimoine need a EtatBien CodeMateriel");
	    }
	    EtatBien etatBien = gimEtatBienService.get(patrimoineRequestDto.getEtatB());
	    entity.setEtatBien(etatBien);
	    
	    if(patrimoineRequestDto.getFichesByIdFicheAffec() ==  null) {
	    	entity.setFichesByIdFicheAffec(null);
	    } else {
	    	Fiches fichesByIdFicheAffec = gimFichesService.get(patrimoineRequestDto.getFichesByIdFicheAffec());
		    entity.setFichesByIdFicheAffec(fichesByIdFicheAffec);
	    }
	    
	    if(patrimoineRequestDto.getFichesByIdFiche() ==  null) {
	    	throw new IllegalArgumentException("Patrimoine need a Fiches");
	    }
	    Fiches fichesByIdFiche = gimFichesService.get(patrimoineRequestDto.getFichesByIdFiche());
	    entity.setFichesByIdFiche(fichesByIdFiche);
	    
	    if(patrimoineRequestDto.getStatPatri() ==  null) {
	    	entity.setPatrimoineStatut(null);
	    } else {
	    	PatrimoineStatut patrimoineStatut = gimPatrimoineStatutService.get(patrimoineRequestDto.getStatPatri());
		    entity.setPatrimoineStatut(patrimoineStatut);
	    }
	    
	    if(patrimoineRequestDto.getCodeSite() ==  null) {
	    	entity.setSites(null);
	    } else {
	    	Sites sites = gimSitesService.get(patrimoineRequestDto.getCodeSite());
		    entity.setSites(sites);
	    }
	    
	    if(patrimoineRequestDto.getCodSourceFin() ==  null) {
	    	throw new IllegalArgumentException("Patrimoine need a SourceFinancement");
	    }
	    SourceFinancement sourceFinancement = gimSourceFinancementService.get(patrimoineRequestDto.getCodSourceFin());
	    entity.setSourceFinancement(sourceFinancement);
	    
		repository.save(entity);
		return GimMapper.PatrimoineToPatrimoineResponseDto(entity);
	}
	
	@Override
	public List<PatrimoineResponseDto> getAll() {
		List<Patrimoine> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.PatrimoineToPatrimoineResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Patrimoine get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Patrimoine with id "+id+"could not be found")
		);
	}
	
	@Override
	public PatrimoineResponseDto getById(String id) {
		Patrimoine entity = get(id);
		return GimMapper.PatrimoineToPatrimoineResponseDto(entity);
	}
	
	@Override
	@Transactional
	public PatrimoineResponseDto delete(String id) {
		Patrimoine entity = get(id);
		repository.delete(entity);
		return GimMapper.PatrimoineToPatrimoineResponseDto(entity);
	}
	
	@Override
	@Transactional
	public PatrimoineResponseDto edit(String id,PatrimoineRequestDto patrimoineRequestDto) {
		Patrimoine entity = get(id);entity.setCodStruct(patrimoineRequestDto.getCodStruct());
	    entity.setAnneAcq(patrimoineRequestDto.getAnneAcq());
	    entity.setDateEntre(patrimoineRequestDto.getDateEntre());
	    entity.setQuantieme(patrimoineRequestDto.getQuantieme());
	    entity.setValUnit(patrimoineRequestDto.getValUnit());
	    entity.setDureeVie(patrimoineRequestDto.getDureeVie());
	    entity.setAmrtisable(patrimoineRequestDto.isAmrtisable());
	    entity.setAmorType(patrimoineRequestDto.getAmorType());
	    entity.setFormat(patrimoineRequestDto.getFormat());
	    entity.setIdMagasin(patrimoineRequestDto.getIdMagasin());
	    entity.setMleAffect(patrimoineRequestDto.getMleAffect());
	    entity.setCodDirect(patrimoineRequestDto.getCodDirect());
	    entity.setCodeDir(patrimoineRequestDto.getCodeDir());
	    entity.setCodService(patrimoineRequestDto.getCodService());
	    entity.setCodReg(patrimoineRequestDto.getCodReg());
	    entity.setCodProv(patrimoineRequestDto.getCodProv());
	    entity.setEtatActuel(patrimoineRequestDto.getEtatActuel());
	    entity.setIdInvent(patrimoineRequestDto.getIdInvent());
	    entity.setIdFicheEntreProv(patrimoineRequestDto.getIdFicheEntreProv());
	    entity.setIdFicheEnCours(patrimoineRequestDto.getIdFicheEnCours());
	    entity.setNomAgentUtil(patrimoineRequestDto.getNomAgentUtil());
	    entity.setMleAgentUtil(patrimoineRequestDto.getMleAgentUtil());
	    entity.setDansInventaire(patrimoineRequestDto.isDansInventaire());
	    
	    if(patrimoineRequestDto.getCodCategorie() !=  null) {
	    	CategorieBien categorieBien = gimCategorieBienService.get(patrimoineRequestDto.getCodCategorie());
		    entity.setCategorieBien(categorieBien);
	    }
	    
	    if(patrimoineRequestDto.getCodMat() !=  null) {
	    	CodeMateriel codeMateriel = gimCodeMaterielService.get(patrimoineRequestDto.getCodMat());
		    entity.setCodeMateriel(codeMateriel);
	    }
	    
	    if(patrimoineRequestDto.getEtatB() !=  null) {
	    	EtatBien etatBien = gimEtatBienService.get(patrimoineRequestDto.getEtatB());
		    entity.setEtatBien(etatBien);
	    }
	    
	    if(patrimoineRequestDto.getFichesByIdFicheAffec() ==  null) {
	    	entity.setFichesByIdFicheAffec(null);
	    } else {
	    	Fiches fichesByIdFicheAffec = gimFichesService.get(patrimoineRequestDto.getFichesByIdFicheAffec());
		    entity.setFichesByIdFicheAffec(fichesByIdFicheAffec);
	    }
	    
	    if(patrimoineRequestDto.getFichesByIdFiche() !=  null) {
	    	Fiches fichesByIdFiche = gimFichesService.get(patrimoineRequestDto.getFichesByIdFiche());
		    entity.setFichesByIdFiche(fichesByIdFiche);
	    }
	    
	    if(patrimoineRequestDto.getStatPatri() ==  null) {
	    	entity.setPatrimoineStatut(null);
	    } else {
	    	PatrimoineStatut patrimoineStatut = gimPatrimoineStatutService.get(patrimoineRequestDto.getStatPatri());
		    entity.setPatrimoineStatut(patrimoineStatut);
	    }
	    
	    if(patrimoineRequestDto.getCodeSite() ==  null) {
	    	entity.setSites(null);
	    } else {
	    	Sites sites = gimSitesService.get(patrimoineRequestDto.getCodeSite());
		    entity.setSites(sites);
	    }
	    
	    if(patrimoineRequestDto.getCodSourceFin() !=  null) {
	    	SourceFinancement sourceFinancement = gimSourceFinancementService.get(patrimoineRequestDto.getCodSourceFin());
		    entity.setSourceFinancement(sourceFinancement);
	    }
	    
		return GimMapper.PatrimoineToPatrimoineResponseDto(entity);
	}
}
