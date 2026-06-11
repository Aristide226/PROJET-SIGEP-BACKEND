package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.BudgetModifBudgetDto;
import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.BudgetModifRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetModifResponseDto;
import com.sigep.gbc.entity.Budget;
import com.sigep.gbc.entity.BudgetModif;
import com.sigep.gbc.entity.BudgetModifActe;
import com.sigep.gbc.entity.BudgetModifId;
import com.sigep.gbc.repository.BudgetModifRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BudgetModifServiceImpl implements BudgetModifService{
	
	private final BudgetModifRepository repository;
	private final BudgetService budgetService;
	private final BudgetModifActeService budgetModifActeService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public BudgetModifResponseDto add(BudgetModifRequestDto budgetModifRequestDto) {
		BudgetModif entity = new BudgetModif();
		
		if (budgetModifRequestDto.getCodBma() == null) {
			throw new IllegalArgumentException("BudgetModif need a BudgetModifActe");
		}
		BudgetModifActe budgetModifActe = budgetModifActeService.get(budgetModifRequestDto.getCodBma());
		entity.setBudgetModifActe(budgetModifActe);
		
		if (budgetModifRequestDto.getCodBud() == null) {
			throw new IllegalArgumentException("BudgetModif need a Budget");
		}
		Budget budget = budgetService.get(budgetModifRequestDto.getCodBud());
		entity.setBudget(budget);
		
		entity.setId(new BudgetModifId(
				budgetModifRequestDto.getCodBma(), 
				budgetModifRequestDto.getCodBud()
		));
		
		entity.setAjoute(budgetModifRequestDto.getAjoute());
		entity.setAnnule(budgetModifRequestDto.getAnnule());
		entity.setNouvelle(budgetModifRequestDto.getNouvelle());
		
		repository.save(entity);
		return GbcMapper2.budgetModifToBudgetModifResponseDto(entity);
	}
	
	@Override
	public List<BudgetModifResponseDto> getAll() {
		List<BudgetModif> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.budgetModifToBudgetModifResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public BudgetModif get(Long codBma, String codBud) {
		BudgetModifId id = new BudgetModifId();
		id.setCodBma(codBma);
		id.setCodBud(codBud);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("BudgetModif with id: " + id + " could not be found"));
	}
	
	@Override
	public BudgetModifResponseDto getById(Long codBma, String codBud) {
		BudgetModif entity  = get(codBma, codBud);
		return GbcMapper2.budgetModifToBudgetModifResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public BudgetModifResponseDto delete(Long codBma, String codBud) {
		BudgetModif entity  = get(codBma, codBud);
		repository.delete(entity);
		return GbcMapper2.budgetModifToBudgetModifResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public BudgetModifResponseDto edit(Long codBma, String codBud, BudgetModifRequestDto budgetModifRequestDto) {
		BudgetModif entity  = get(codBma, codBud);
		entity.setAjoute(budgetModifRequestDto.getAjoute());
		entity.setAnnule(budgetModifRequestDto.getAnnule());
		entity.setNouvelle(budgetModifRequestDto.getNouvelle());
		return GbcMapper2.budgetModifToBudgetModifResponseDto(entity);
	}

	@Override
	public List<BudgetModifResponseDto> getByCodBma(Long codBma) {
		BudgetModifActe budgetModifActe = budgetModifActeService.get(codBma);
		List<BudgetModif> list = repository.findByBudgetModifActe(budgetModifActe);
		return list
				.stream().map(element  -> GbcMapper2.budgetModifToBudgetModifResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public List<BudgetModifBudgetDto> getLigneModifieesRecettesDepenses(Long codBma) {
		return repository.getLigneModifieesRecettesDepenses(codBma);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public Boolean addLignesModifiees(List<BudgetModifRequestDto> budgetModifRequestDtos) {
		try {
			for (BudgetModifRequestDto budgetModifRequestDto : budgetModifRequestDtos) {
				add(budgetModifRequestDto);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional("gbcTransactionManager")
	public Boolean deleteLignesModifiees(Long codBma) {
		try {
			BudgetModifActe budgetModifActe = budgetModifActeService.get(codBma);
			List<BudgetModif> budgetModifs = repository.deleteByBudgetModifActe(budgetModifActe);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean exists(Long codBma, String codBud) {
		return repository.existsById(new BudgetModifId(codBma, codBud));
	}

	@Override
	@Transactional("gbcTransactionManager")
	public Boolean editAllCAAjoutCAAnnul(Long codBma) {
		try {
			List<BudgetModifResponseDto> budgetModifResponseDtos = getByCodBma(codBma);
			for (BudgetModifResponseDto budgetModifResponseDto : budgetModifResponseDtos) {
				budgetService.editCAajoutCAannul(budgetModifResponseDto.getCodBud());
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
