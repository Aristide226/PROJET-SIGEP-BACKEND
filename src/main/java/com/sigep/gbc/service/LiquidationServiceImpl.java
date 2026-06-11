package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.LiquidationRequestDto;
import com.sigep.gbc.dto.responseDto.LiquidationResponseDto;
import com.sigep.gbc.entity.CompteDestinataire;
import com.sigep.gbc.entity.Contrats;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.Engagements;
import com.sigep.gbc.entity.Liquidation;
import com.sigep.gbc.repository.LiquidationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LiquidationServiceImpl implements LiquidationService {
	
	private final LiquidationRepository repository;
	private final CompteDestinataireService compteDestinataireService;
	private final ContratsService contratsService;
	private final EngagementsService engagementsService;
	private final DestinatairesService destinatairesService;
	
	
	@Override
	@Transactional("gbcTransactionManager")
	public LiquidationResponseDto add(LiquidationRequestDto liquidationRequestDto) {
		Liquidation entity = new Liquidation();
		entity.setCodLiq(repository.getCodLiq());
		entity.setGestion(liquidationRequestDto.getGestion());
		entity.setNumBl(repository.getNumBl(liquidationRequestDto.getGestion()));
		entity.setDateLiq(liquidationRequestDto.getDateLiq());
		entity.setObjet(liquidationRequestDto.getObjet());
		entity.setMontant(liquidationRequestDto.getMontant());
		entity.setMontEngage(liquidationRequestDto.getMontEngage());
		entity.setMontDjaLiq(liquidationRequestDto.getMontDjaLiq());
		entity.setModifiable(liquidationRequestDto.getModifiable());
		entity.setIdUser(liquidationRequestDto.getIdUser());
		entity.setDateModif(liquidationRequestDto.getDateModif());
		entity.setActif(liquidationRequestDto.getActif());
		entity.setIdBudget(liquidationRequestDto.getIdBudget());
		
		if (liquidationRequestDto.getCompteFourn() == null) {
			entity.setCompteDestinataire(null);
		} else {
			CompteDestinataire compteDestinataire = compteDestinataireService.get(liquidationRequestDto.getCompteFourn());
			entity.setCompteDestinataire(compteDestinataire);
		}
		
		if (liquidationRequestDto.getIdContrat() == null) {
			entity.setContrats(null);
		} else {
			Contrats contrat = contratsService.get(liquidationRequestDto.getIdContrat());
			entity.setContrats(contrat);
		}
		
		if (liquidationRequestDto.getNumBe() == null) {
			entity.setEngagements(null);
		} else {
			Engagements engagement = engagementsService.get(liquidationRequestDto.getNumBe());
			entity.setEngagements(engagement);
		}
		
		if (liquidationRequestDto.getIdFourn() == null) {
			throw new IllegalArgumentException("Liquidation need a Destinataire");
		}
		Destinataires destinataires = destinatairesService.get(liquidationRequestDto.getIdFourn());
		entity.setDestinataires(destinataires);
		
		repository.save(entity);
		return GbcMapper2.liqToLiqResponseDto(entity);
	}
	
	@Override
	public List<LiquidationResponseDto> getAll() {
		List<Liquidation> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.liqToLiqResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public Liquidation get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Liquidation with id: " + id + " could not be found"));
	}
	
	@Override
	public LiquidationResponseDto getById(Long id) {
		Liquidation entity = get(id);
		return GbcMapper2.liqToLiqResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public LiquidationResponseDto delete(Long id) {
		Liquidation entity = get(id);
		repository.delete(entity);
		return GbcMapper2.liqToLiqResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public LiquidationResponseDto edit(Long id, LiquidationRequestDto liquidationRequestDto) {
		Liquidation entity = get(id);
		entity.setObjet(liquidationRequestDto.getObjet());
		entity.setMontant(liquidationRequestDto.getMontant());
		entity.setMontEngage(liquidationRequestDto.getMontEngage());
		entity.setMontDjaLiq(liquidationRequestDto.getMontDjaLiq());
		entity.setModifiable(liquidationRequestDto.getModifiable());
		entity.setIdUser(liquidationRequestDto.getIdUser());
		entity.setDateModif(liquidationRequestDto.getDateModif());
		entity.setActif(liquidationRequestDto.getActif());
		entity.setIdBudget(liquidationRequestDto.getIdBudget());
		
		if (liquidationRequestDto.getCompteFourn() == null) {
			entity.setCompteDestinataire(null);
		} else {
			CompteDestinataire compteDestinataire = compteDestinataireService.get(liquidationRequestDto.getCompteFourn());
			entity.setCompteDestinataire(compteDestinataire);
		}
		
		if (liquidationRequestDto.getIdContrat() == null) {
			entity.setContrats(null);
		} else {
			Contrats contrat = contratsService.get(liquidationRequestDto.getIdContrat());
			entity.setContrats(contrat);
		}
		
		if (liquidationRequestDto.getNumBe() == null) {
			entity.setEngagements(null);
		} else {
			Engagements engagement = engagementsService.get(liquidationRequestDto.getNumBe());
			entity.setEngagements(engagement);
		}
		
		if (liquidationRequestDto.getIdFourn() != null) {
			Destinataires destinataires = destinatairesService.get(liquidationRequestDto.getIdFourn());
			entity.setDestinataires(destinataires);
		}
		
		
		return GbcMapper2.liqToLiqResponseDto(entity);
	}
}
