package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.DestinatairesRequestDto;
import com.sigep.gbc.dto.responseDto.DestinatairesResponseDto;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.repository.DestinatairesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DestinatairesServiceImpl implements DestinatairesService{

	private final DestinatairesRepository repository;
	
	@Override
	@Transactional("gbcTransactionManager")
	public void add(DestinatairesRequestDto destinatairesRequestDto) {
		long idDest = ((getMaxIDest() == null) ? 0 : getMaxIDest()) + 1;
		repository.insert(
				idDest, 
				(destinatairesRequestDto.getIfumle() == null || destinatairesRequestDto.getIfumle() =="")? "-" : destinatairesRequestDto.getIfumle(), 
				destinatairesRequestDto.getFtype(), 
				destinatairesRequestDto.getContactTel(), 
				destinatairesRequestDto.getContactEmail());	
	}

	@Override
	public List<DestinatairesResponseDto> getAll() {
		List<Destinataires> destinataires = repository.findAll();
		return destinataires
				.stream().map(element  -> GbcMapper.dToDResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public Destinataires get(long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Destinataires with id: " + id + " could not be found"));
	}

	@Override
	public DestinatairesResponseDto getById(long id) {
		Destinataires destinataires = get(id);
		return GbcMapper.dToDResponseDto(destinataires);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public DestinatairesResponseDto delete(long id) {
		Destinataires destinataires = get(id);
		repository.delete(destinataires);
		return GbcMapper.dToDResponseDto(destinataires);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public void edit(long id, DestinatairesRequestDto destinatairesRequestDto) {
		repository.update(
				(destinatairesRequestDto.getIfumle() == null || destinatairesRequestDto.getIfumle() =="")? "-" : destinatairesRequestDto.getIfumle(), 
				destinatairesRequestDto.getFtype(), 
				destinatairesRequestDto.getContactTel(), 
				destinatairesRequestDto.getContactEmail(),
				id);	
	}

	@Override
	public Long getMaxIDest() {
		return repository.getMaxIDest();
	}
	
	@Override
	public Boolean existsByIfumleAndIfumleNot(String ifumle, String excludedValue) {
		return repository.existsByIfumleAndIfumleNot(ifumle, excludedValue);
	}
	
	@Override
	public Boolean existsByIfumleAndIfumleNotOrNom(String ifumle, String excludedValue, String nom) {
		return repository.existsByIfumleAndIfumleNotOrNom(ifumle, excludedValue, nom);
	}
	
	@Override
	public Boolean existsByIfumleAndIfumleNotAndIdDestNotOrNomAndIdDestNot(String ifumle, String excludedValue, Long idDest1, String nom, Long idDest2) {
		return repository.existsByIfumleAndIfumleNotAndIdDestNotOrNomAndIdDestNot(ifumle, excludedValue, idDest1, nom, idDest2);
	}

	@Override
	public Destinataires findTopByOrderByIdDest() {
		return repository.findTopByOrderByIdDestDesc();
	}

	@Override
	public List<DestinatairesResponseDto> getDestinataireSansAgents() {
		List<Destinataires> destinataires = repository.getDestinataireSansAgents();
		return destinataires
				.stream().map(element  -> GbcMapper.dToDResponseDto(element))
				.collect(Collectors.toList());
	}
	
	//Aristide
	@Override
	public List<DestinatairesResponseDto> getAllFournisseurs() {
		List<Destinataires> fournisseurs = repository.findFournisseurs();
		    return fournisseurs
		         .stream()
		         .map(element -> GbcMapper.dToDResponseDto(element))
		         .collect(Collectors.toList());
	}

}
