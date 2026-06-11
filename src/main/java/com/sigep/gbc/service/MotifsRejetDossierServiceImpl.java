package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.MotifsRejetDossierRequestDto;
import com.sigep.gbc.dto.responseDto.MotifsRejetDossierResponseDto;
import com.sigep.gbc.entity.MotifsRejetDossier;
import com.sigep.gbc.repository.MotifsRejetDossierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MotifsRejetDossierServiceImpl implements MotifsRejetDossierService {
	
	private final MotifsRejetDossierRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public MotifsRejetDossierResponseDto add(MotifsRejetDossierRequestDto motifsRejetDossierRequestDto) {
		MotifsRejetDossier entity = new MotifsRejetDossier();
		entity.setMotifs(motifsRejetDossierRequestDto.getMotifs());
		entity.setDateSaisie(motifsRejetDossierRequestDto.getDateSaisie());
		entity.setNumBe(motifsRejetDossierRequestDto.getNumBe());
		entity.setNumMand(motifsRejetDossierRequestDto.getNumMand());
		entity.setCodLiq(motifsRejetDossierRequestDto.getCodLiq());
		entity.setIdTitre(motifsRejetDossierRequestDto.getIdTitre());
		entity.setUserName(motifsRejetDossierRequestDto.getUserName());
		entity.setDateEnreg(motifsRejetDossierRequestDto.getDateEnreg());
		entity.setActif(motifsRejetDossierRequestDto.isActif());
		repository.save(entity);
		return GbcMapper2.mrdToMrjResponseDto(entity);
	}

	@Override
	public List<MotifsRejetDossierResponseDto> getAll() {
		List<MotifsRejetDossier> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.mrdToMrjResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public MotifsRejetDossier get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("MotifsRejet with id: " + id + " could not be found"));
	}

	@Override
	public MotifsRejetDossierResponseDto getById(String id) {
		MotifsRejetDossier entity = get(id);
		return GbcMapper2.mrdToMrjResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public MotifsRejetDossierResponseDto delete(String id) {
		MotifsRejetDossier entity = get(id);
		repository.delete(entity);
		return GbcMapper2.mrdToMrjResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public MotifsRejetDossierResponseDto edit(String id, MotifsRejetDossierRequestDto motifsRejetDossierRequestDto) {
		MotifsRejetDossier entity = get(id);
		entity.setMotifs(motifsRejetDossierRequestDto.getMotifs());
		entity.setNumBe(motifsRejetDossierRequestDto.getNumBe());
		entity.setNumMand(motifsRejetDossierRequestDto.getNumMand());
		entity.setCodLiq(motifsRejetDossierRequestDto.getCodLiq());
		entity.setIdTitre(motifsRejetDossierRequestDto.getIdTitre());
		entity.setUserName(motifsRejetDossierRequestDto.getUserName());
		entity.setDateEnreg(motifsRejetDossierRequestDto.getDateEnreg());
		entity.setActif(motifsRejetDossierRequestDto.isActif());
		return GbcMapper2.mrdToMrjResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public void deleteLastRecord(Long numbe) {
		repository.deleteLastRecord(numbe);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public Boolean setActifToFalse(Long numBe) {
		try {
			repository.setActifToFalse(numBe);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
