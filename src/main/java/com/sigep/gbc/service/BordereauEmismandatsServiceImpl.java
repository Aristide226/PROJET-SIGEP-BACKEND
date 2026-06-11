package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.BordereauEmismandatsRequestDto;
import com.sigep.gbc.dto.responseDto.BordereauEmismandatsResponseDto;
import com.sigep.gbc.entity.BordereauEmismandats;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.repository.BordereauEmismandatsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BordereauEmismandatsServiceImpl implements BordereauEmismandatsService{
	
	private final BordereauEmismandatsRepository repository;
	private final BudgetTypeService budgetTypeService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public BordereauEmismandatsResponseDto add(BordereauEmismandatsRequestDto bordereauEmismandatsRequestDto) {
		BordereauEmismandats entity = new BordereauEmismandats();
		entity.setGestion(bordereauEmismandatsRequestDto.getGestion());
		entity.setNum(repository.getNum(bordereauEmismandatsRequestDto.getGestion(), bordereauEmismandatsRequestDto.getIdBudget(), bordereauEmismandatsRequestDto.getDossier()));
		entity.setJournee(bordereauEmismandatsRequestDto.getJournee());
		entity.setTotal(bordereauEmismandatsRequestDto.getTotal());
		entity.setTotalAnterieur(repository.getTotalAnterieur(bordereauEmismandatsRequestDto.getGestion(), bordereauEmismandatsRequestDto.getIdBudget(), bordereauEmismandatsRequestDto.getDossier()));
		entity.setTotalCumul(
				bordereauEmismandatsRequestDto.getTotal() + 
				repository.getTotalAnterieur(bordereauEmismandatsRequestDto.getGestion(), bordereauEmismandatsRequestDto.getIdBudget(), bordereauEmismandatsRequestDto.getDossier()) +
				repository.getMontDeduitDuDernierBordereau(bordereauEmismandatsRequestDto.getGestion(), bordereauEmismandatsRequestDto.getIdBudget(), bordereauEmismandatsRequestDto.getDossier())
		);
		entity.setMontDeduit(0L); // CALCULE LORS DU REJET DE MANDAT
		entity.setIdLogin(bordereauEmismandatsRequestDto.getIdLogin());
		entity.setDossier(bordereauEmismandatsRequestDto.getDossier());
		entity.setActif(bordereauEmismandatsRequestDto.getActif());
		entity.setDateReception(bordereauEmismandatsRequestDto.getDateReception());
		entity.setUserReception(bordereauEmismandatsRequestDto.getUserReception());
		entity.setIdentiteRecept(bordereauEmismandatsRequestDto.getIdentiteRecept());
		
		if (bordereauEmismandatsRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("BordereauEmismandats need a BudgetType");
		}
		BudgetType budgetType = budgetTypeService.get(bordereauEmismandatsRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		repository.save(entity);
		
		return GbcMapper.BordereauEmismandatsToBordereauEmismandatsResponseDto(entity);
	}
	
	@Override
	public List<BordereauEmismandatsResponseDto> getAll() {
		List<BordereauEmismandats> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.BordereauEmismandatsToBordereauEmismandatsResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public BordereauEmismandats get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("BordereauEmismandats with id: " + id + " could not be found"));
	}
	
	@Override
	public BordereauEmismandatsResponseDto getById(String id) {
		BordereauEmismandats entity = get(id);
		return GbcMapper.BordereauEmismandatsToBordereauEmismandatsResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public BordereauEmismandatsResponseDto delete(String id) {
		BordereauEmismandats entity = get(id);
		repository.delete(entity);
		return GbcMapper.BordereauEmismandatsToBordereauEmismandatsResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public BordereauEmismandatsResponseDto edit(String id, BordereauEmismandatsRequestDto bordereauEmismandatsRequestDto) {
		BordereauEmismandats entity = get(id);
		entity.setGestion(bordereauEmismandatsRequestDto.getGestion());
		entity.setJournee(bordereauEmismandatsRequestDto.getJournee());
		entity.setIdLogin(bordereauEmismandatsRequestDto.getIdLogin());
		entity.setDossier(bordereauEmismandatsRequestDto.getDossier());
		entity.setActif(bordereauEmismandatsRequestDto.getActif());
		entity.setDateReception(bordereauEmismandatsRequestDto.getDateReception());
		entity.setUserReception(bordereauEmismandatsRequestDto.getUserReception());
		entity.setIdentiteRecept(bordereauEmismandatsRequestDto.getIdentiteRecept());
		
		if (bordereauEmismandatsRequestDto.getIdBudget() != null) {
			BudgetType budgetType = budgetTypeService.get(bordereauEmismandatsRequestDto.getIdBudget());
			entity.setBudgetType(budgetType);
		}
		
		return GbcMapper.BordereauEmismandatsToBordereauEmismandatsResponseDto(entity);
	}

	@Override
	public List<BordereauEmismandatsResponseDto> getByGestionAndIdBudgetAndDossier(Short gestion, Integer idBudget, String dossier) {
		List<BordereauEmismandats> list = repository.getByGestionAndIdBudgetAndDossier(gestion, idBudget, dossier);
		return list
				.stream().map(element  -> GbcMapper.BordereauEmismandatsToBordereauEmismandatsResponseDto(element))
				.collect(Collectors.toList());
	}	
}
