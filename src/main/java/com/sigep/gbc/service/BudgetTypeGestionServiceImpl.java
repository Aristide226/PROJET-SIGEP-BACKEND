package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.BudgetTypeGestionRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetTypeGestionResponseDto;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.BudgetTypeGestion;
import com.sigep.gbc.entity.BudgetTypeGestionId;
import com.sigep.gbc.entity.Gestion;
import com.sigep.gbc.repository.BudgetTypeGestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BudgetTypeGestionServiceImpl implements BudgetTypeGestionService{
	
	private final BudgetTypeGestionRepository repository;
	private final BudgetTypeService btService;
	private final GestionService gService;

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetTypeGestionResponseDto add(BudgetTypeGestionRequestDto budgetTypeGestionRequestDto) {
		BudgetTypeGestion entity = new BudgetTypeGestion();
		entity.setId(new BudgetTypeGestionId(budgetTypeGestionRequestDto.getIdBudget(), budgetTypeGestionRequestDto.getAnnee()));
		entity.setDateMiseEnPlace(budgetTypeGestionRequestDto.getDateMiseEnPlace());
		entity.setDateCloture(budgetTypeGestionRequestDto.getDateCloture());
		entity.setFermer(budgetTypeGestionRequestDto.getFermer());
		entity.setPageCommencantA(budgetTypeGestionRequestDto.getPageCommencantA());
		entity.setEteteD(budgetTypeGestionRequestDto.getEteteD());
		entity.setEteteM(budgetTypeGestionRequestDto.getEteteM());
		entity.setPiedD(budgetTypeGestionRequestDto.getPiedD());
		entity.setPiedM(budgetTypeGestionRequestDto.getPiedM());
		entity.setSignataireBud(budgetTypeGestionRequestDto.getSignataireBud());
		entity.setNomSignataire(budgetTypeGestionRequestDto.getNomSignataire());
		entity.setHonoSignataire(budgetTypeGestionRequestDto.getHonoSignataire());
		
		if (budgetTypeGestionRequestDto.getAnnee() == null) {
			throw new IllegalArgumentException("BudgetTypeGestion need a Gestion");
		}
		Gestion gestion = gService.get(budgetTypeGestionRequestDto.getAnnee());
		entity.setGestion(gestion);
		
		if (budgetTypeGestionRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("BudgetTypeGestion need a BudgetType");
		}
		BudgetType budgetType = btService.get(budgetTypeGestionRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		repository.save(entity);
		return GbcMapper.btgToBtgResponseDto(entity);
	}

	@Override
	public List<BudgetTypeGestionResponseDto> getAll() {
		List<BudgetTypeGestion> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.btgToBtgResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public BudgetTypeGestion get(Integer idBudget, Short annee) {
		BudgetTypeGestionId id = new BudgetTypeGestionId(idBudget, annee);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("BudgetTypeGestion with id: " + id + " could not be found"));
	}

	@Override
	public BudgetTypeGestionResponseDto getById(Integer idBudget, Short annee) {
		BudgetTypeGestion entity = get(idBudget, annee);
		return GbcMapper.btgToBtgResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetTypeGestionResponseDto delete(Integer idBudget, Short annee) {
		BudgetTypeGestion entity = get(idBudget, annee);
		repository.delete(entity);
		return GbcMapper.btgToBtgResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetTypeGestionResponseDto edit(Integer idBudget, Short annee, BudgetTypeGestionRequestDto budgetTypeGestionRequestDto) {
		BudgetTypeGestion entity = get(idBudget, annee);
		entity.setDateMiseEnPlace(budgetTypeGestionRequestDto.getDateMiseEnPlace());
		entity.setDateCloture(budgetTypeGestionRequestDto.getDateCloture());
		entity.setFermer(budgetTypeGestionRequestDto.getFermer());
		entity.setPageCommencantA(budgetTypeGestionRequestDto.getPageCommencantA());
		entity.setEteteD(budgetTypeGestionRequestDto.getEteteD());
		entity.setEteteM(budgetTypeGestionRequestDto.getEteteM());
		entity.setPiedD(budgetTypeGestionRequestDto.getPiedD());
		entity.setPiedM(budgetTypeGestionRequestDto.getPiedM());
		entity.setSignataireBud(budgetTypeGestionRequestDto.getSignataireBud());
		entity.setNomSignataire(budgetTypeGestionRequestDto.getNomSignataire());
		entity.setHonoSignataire(budgetTypeGestionRequestDto.getHonoSignataire());
		
		if (budgetTypeGestionRequestDto.getAnnee() != null) {
			Gestion gestion = gService.get(budgetTypeGestionRequestDto.getAnnee());
			entity.setGestion(gestion);
		}
		
		if (budgetTypeGestionRequestDto.getIdBudget() == null) {
			BudgetType budgetType = btService.get(budgetTypeGestionRequestDto.getIdBudget());
			entity.setBudgetType(budgetType);
		}
		
		return GbcMapper.btgToBtgResponseDto(entity);
	}
}
