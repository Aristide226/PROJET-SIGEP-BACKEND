package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.AccesLigneBudgetaireRequestDto;
import com.sigep.gbc.dto.responseDto.AccesLigneBudgetaireResponseDto;
import com.sigep.gbc.entity.AccesLigneBudgetaire;
import com.sigep.gbc.entity.AccesLigneBudgetaireId;
import com.sigep.gbc.entity.Gestion;
import com.sigep.gbc.entity.NomenclatureD;
import com.sigep.gbc.repository.AccesLigneBudgetaireRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccesLigneBudgetaireServiceImpl implements AccesLigneBudgetaireService {
	
	private final AccesLigneBudgetaireRepository repository;
	private final GestionService gService;
	private final NomenclatureDService nService;

	@Transactional("gbcTransactionManager")
	@Override
	public AccesLigneBudgetaireResponseDto add(AccesLigneBudgetaireRequestDto accesLigneBudgetaireRequestDto) {
		AccesLigneBudgetaire accesLigneBudgetaire = new AccesLigneBudgetaire();
		
		if (accesLigneBudgetaireRequestDto.getUserName() == null) {
			throw new IllegalArgumentException("AccesLigneBudgetaire need a AccesCode");
		}
		
		accesLigneBudgetaire.setId(new AccesLigneBudgetaireId(
				accesLigneBudgetaireRequestDto.getUserName(), 
				accesLigneBudgetaireRequestDto.getNumNo(),
				accesLigneBudgetaireRequestDto.getCourante()
		));
		
		if (accesLigneBudgetaireRequestDto.getIdBudgett() == null) {
			throw new IllegalArgumentException("AccesLigneBudgetaire need a IdBudget");
		}
		accesLigneBudgetaire.setIdBudgett(accesLigneBudgetaireRequestDto.getIdBudgett());
		
		if (accesLigneBudgetaireRequestDto.getCourante() == null) {
			throw new IllegalArgumentException("AccesLigneBudgetaire need a Gestion");
		}
		Gestion gestion = gService.get(accesLigneBudgetaireRequestDto.getCourante());
		accesLigneBudgetaire.setGestion(gestion);
		
		if (accesLigneBudgetaireRequestDto.getNumNo() == null) {
			throw new IllegalArgumentException("AccesLigneBudgetaire need a NomenclatureD");
		}
		NomenclatureD nomenclatureD = nService.get(accesLigneBudgetaireRequestDto.getNumNo());
		accesLigneBudgetaire.setNomenclatureD(nomenclatureD);
		
		repository.save(accesLigneBudgetaire);
		return GbcMapper.aLbToAlBResponseDto(accesLigneBudgetaire);
	}

	@Override
	public List<AccesLigneBudgetaireResponseDto> getAll() {
		List<AccesLigneBudgetaire> accesLigneBudgetaires = repository.findAll();
		return accesLigneBudgetaires
				.stream().map(element  -> GbcMapper.aLbToAlBResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public AccesLigneBudgetaire get(String userName, Short gestion, String numNo) {
		AccesLigneBudgetaireId id = new AccesLigneBudgetaireId();
		id.setUserName(userName);
		id.setGestion(gestion);
		id.setNumNo(numNo);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("AccesLigneBudgetaire with id: " + id + " could not be found"));
	}

	@Override
	public AccesLigneBudgetaireResponseDto getById(String userName, Short gestion, String numNo) {
		AccesLigneBudgetaire accesLigneBudgetaire  = get(userName, gestion, numNo);
		return GbcMapper.aLbToAlBResponseDto(accesLigneBudgetaire);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public AccesLigneBudgetaireResponseDto delete(String userName, Short gestion, String numNo) {
		AccesLigneBudgetaire accesLigneBudgetaire  = get(userName, gestion, numNo);
		repository.delete(accesLigneBudgetaire);
		return GbcMapper.aLbToAlBResponseDto(accesLigneBudgetaire);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public void deleteByUserNameAndGestionAndIdBuget(String userName, Short gestion, Integer idBudget) {
		repository.deleteByUserNameAndGestionAndIdBudget(userName, gestion, idBudget);
	}
}
