package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.FacturesRequestDto;
import com.sigep.gbc.dto.responseDto.FacturesResponseDto;
import com.sigep.gbc.entity.Compte;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.FactureType;
import com.sigep.gbc.entity.Factures;
import com.sigep.gbc.repository.FacturesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacturesServiceImpl implements FacturesService{
	
	private final FacturesRepository repository;
	private final CompteService compteService;
	private final DestinatairesService destinatairesService;
	private final FactureTypeService factureTypeService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public FacturesResponseDto add(FacturesRequestDto facturesRequestDto) {
		Factures entity = new Factures();
		entity.setIdFact(facturesRequestDto.getIdFact());
		entity.setObjetFact(facturesRequestDto.getObjetFact());
		entity.setDateFact(facturesRequestDto.getDateFact());
		entity.setMontant(facturesRequestDto.getMontant());
		entity.setRemise(facturesRequestDto.getRemise());
		entity.setTauxTva(facturesRequestDto.getTauxTva());
		entity.setAvecTva(facturesRequestDto.getAvecTva());
		entity.setIdSignataire(facturesRequestDto.getIdSignataire());
		entity.setSignataire(facturesRequestDto.getSignataire());
		entity.setNomSign(facturesRequestDto.getNomSign());
		entity.setTitreHonoSign(facturesRequestDto.getTitreHonoSign());
		entity.setNumChrono(facturesRequestDto.getNumChrono());
		entity.setComplemaNum(facturesRequestDto.getComplemaNum());
		entity.setIdFactParent(facturesRequestDto.getIdFactParent());
		entity.setValide(facturesRequestDto.getValide());
		entity.setNumeroContate(facturesRequestDto.getNumeroContate());
		entity.setActif(facturesRequestDto.getActif());
		
		if (facturesRequestDto.getIdTypFact() == null) {
			throw new IllegalArgumentException("Factures need a FacturesType");
		}
		FactureType factureType = factureTypeService.get(facturesRequestDto.getIdTypFact());
		entity.setFactureType(factureType);
		
		if (facturesRequestDto.getIdCpte() == null) {
			throw new IllegalArgumentException("Factures need a Compte");
		}
		Compte compte = compteService.get(facturesRequestDto.getIdCpte());
		entity.setCompte(compte);
		
		if (facturesRequestDto.getIdDebiteur() == null) {
			throw new IllegalArgumentException("Factures need a Destinaires");
		}
		Destinataires destinataires = destinatairesService.get(facturesRequestDto.getIdDebiteur());
		entity.setDestinataires(destinataires);
		
		repository.save(entity);
		return GbcMapper.facturesToFacturesResponseDto(entity);
	}
	
	@Override
	public List<FacturesResponseDto> getAll() {
		List<Factures> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.facturesToFacturesResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public Factures get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Factures with id: " + id + " could not be found"));
	}
	
	@Override
	public FacturesResponseDto getById(Long id) {
		Factures entity = get(id);
		return GbcMapper.facturesToFacturesResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public FacturesResponseDto delete(Long id) {
		Factures entity = get(id);
		repository.delete(entity);
		return GbcMapper.facturesToFacturesResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public FacturesResponseDto edit(Long id, FacturesRequestDto facturesRequestDto) {
		Factures entity = get(id);
		entity.setObjetFact(facturesRequestDto.getObjetFact());
		entity.setDateFact(facturesRequestDto.getDateFact());
		entity.setMontant(facturesRequestDto.getMontant());
		entity.setRemise(facturesRequestDto.getRemise());
		entity.setTauxTva(facturesRequestDto.getTauxTva());
		entity.setAvecTva(facturesRequestDto.getAvecTva());
		entity.setIdSignataire(facturesRequestDto.getIdSignataire());
		entity.setSignataire(facturesRequestDto.getSignataire());
		entity.setNomSign(facturesRequestDto.getNomSign());
		entity.setTitreHonoSign(facturesRequestDto.getTitreHonoSign());
		entity.setNumChrono(facturesRequestDto.getNumChrono());
		entity.setComplemaNum(facturesRequestDto.getComplemaNum());
		entity.setIdFactParent(facturesRequestDto.getIdFactParent());
		entity.setValide(facturesRequestDto.getValide());
		entity.setNumeroContate(facturesRequestDto.getNumeroContate());
		entity.setActif(facturesRequestDto.getActif());
		
		if (facturesRequestDto.getIdTypFact() != null) {
			FactureType factureType = factureTypeService.get(facturesRequestDto.getIdTypFact());
			entity.setFactureType(factureType);
		}
		
		if (facturesRequestDto.getIdCpte() != null) {
			Compte compte = compteService.get(facturesRequestDto.getIdCpte());
			entity.setCompte(compte);
		}
		
		if (facturesRequestDto.getIdDebiteur() != null) {
			Destinataires destinataires = destinatairesService.get(facturesRequestDto.getIdDebiteur());
			entity.setDestinataires(destinataires);
		}
		
		return GbcMapper.facturesToFacturesResponseDto(entity);
	}
}
