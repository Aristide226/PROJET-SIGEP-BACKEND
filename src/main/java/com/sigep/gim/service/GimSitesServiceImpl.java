package com.sigep.gim.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.SiteStatistiqueDto;
import com.sigep.gim.dto.requestDto.SitesRequestDto;
import com.sigep.gim.dto.responseDto.SitesResponseDto;
import com.sigep.gim.entity.Departement;
import com.sigep.gim.entity.Sites;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimSitesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimSitesServiceImpl implements GimSitesService {
	
	private final GimSitesRepository repository;
	private final GimDepartementService gimDepartementService;
	
	@Override
	@Transactional
	public SitesResponseDto add(SitesRequestDto sitesRequestDto) {
		Sites entity = new Sites();
		entity.setNomSite(sitesRequestDto.getNomSite());
	    entity.setSecteurCadastre(sitesRequestDto.getSecteurCadastre());
	    entity.setSectionCadastre(sitesRequestDto.getSectionCadastre());
	    entity.setLotCadastre(sitesRequestDto.getLotCadastre());
	    entity.setParcelleCadastre(sitesRequestDto.getParcelleCadastre());
	    entity.setAutresPrecision(sitesRequestDto.getAutresPrecision());
	    entity.setDateCreation( sitesRequestDto.getDateCreation() == null ? new Date() : sitesRequestDto.getDateCreation());
	    entity.setSuperficie(sitesRequestDto.getSuperficie());
	    entity.setCoutTerrain(sitesRequestDto.getCoutTerrain());
	    entity.setIdTypeAcq(sitesRequestDto.getIdTypeAcq());
	    entity.setNombreMaterielH(sitesRequestDto.getNombreMaterielH());
	    entity.setNbreBatimentH(sitesRequestDto.getNbreBatimentH());
	    entity.setNbreUe(sitesRequestDto.getNbreUe());
	    entity.setNbreAutreInfras(sitesRequestDto.getNbreAutreInfras());
	    entity.setArticleSite(sitesRequestDto.getArticleSite());
	    if (sitesRequestDto.getIdDepart() == null) {
	    	throw new IllegalArgumentException("Sites need a Departement");
	        
	    }
	    Departement departement = gimDepartementService.get(sitesRequestDto.getIdDepart());
	    entity.setDepartement(departement);

		repository.save(entity);
		return GimMapper.SitesToSitesResponseDto(entity);
	}
	
	@Override
	public List<SitesResponseDto> getAll() {
		List<Sites> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.SitesToSitesResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Sites get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Sites with id "+id+"could not be found")
		);
	}
	
	@Override
	public SitesResponseDto getById(int id) {
		Sites entity = get(id);
		return GimMapper.SitesToSitesResponseDto(entity);
	}
	
	@Override
	@Transactional
	public SitesResponseDto delete(int id) {
		Sites entity = get(id);
		repository.delete(entity);
		return GimMapper.SitesToSitesResponseDto(entity);
	}
	
	@Override
	@Transactional
	public SitesResponseDto edit(int id,SitesRequestDto sitesRequestDto) {
		Sites entity = get(id);
		entity.setNomSite(sitesRequestDto.getNomSite());
	    entity.setSecteurCadastre(sitesRequestDto.getSecteurCadastre());
	    entity.setSectionCadastre(sitesRequestDto.getSectionCadastre());
	    entity.setLotCadastre(sitesRequestDto.getLotCadastre());
	    entity.setParcelleCadastre(sitesRequestDto.getParcelleCadastre());
	    entity.setAutresPrecision(sitesRequestDto.getAutresPrecision());
	    entity.setSuperficie(sitesRequestDto.getSuperficie());
	    entity.setCoutTerrain(sitesRequestDto.getCoutTerrain());
	    entity.setIdTypeAcq(sitesRequestDto.getIdTypeAcq());
	    entity.setNombreMaterielH(sitesRequestDto.getNombreMaterielH());
	    entity.setNbreBatimentH(sitesRequestDto.getNbreBatimentH());
	    entity.setNbreUe(sitesRequestDto.getNbreUe());
	    entity.setNbreAutreInfras(sitesRequestDto.getNbreAutreInfras());
	    entity.setArticleSite(sitesRequestDto.getArticleSite());
	    if (sitesRequestDto.getIdDepart() != null) {
	    	Departement departement = gimDepartementService.get(sitesRequestDto.getIdDepart());
		    entity.setDepartement(departement);
	    }
	    
		return GimMapper.SitesToSitesResponseDto(entity);
	}
	
	@Override
	@Transactional
	public List<SiteStatistiqueDto> getStatistiquesPatrimoineParCategorie(){
		return repository.getStatistiquesPatrimoineParCategorie();
	}
}
