package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.ReamgmtBudgetDto;
import com.sigep.gbc.dto.requestDto.ReamgmtRequestDto;
import com.sigep.gbc.dto.responseDto.ReamgmtResponseDto;
import com.sigep.gbc.entity.Budget;
import com.sigep.gbc.entity.Reamgmt;
import com.sigep.gbc.entity.ReamgmtActe;
import com.sigep.gbc.entity.ReamgmtId;
import com.sigep.gbc.repository.ReamgmtRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReamgmtServiceImpl implements ReamgmtService{
	
	private final ReamgmtRepository repository;
	private final BudgetService budgetService;
	private final ReamgmtActeService reamgmtActeService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public ReamgmtResponseDto add(ReamgmtRequestDto reamgmtRequestDto) {
		Reamgmt entity = new Reamgmt();
		
		if (reamgmtRequestDto.getCodReam() == null) {
			throw new IllegalArgumentException("Reamgmt need a ReamgmtActe");
		}
		ReamgmtActe reamgmtActe = reamgmtActeService.get(reamgmtRequestDto.getCodReam());
		entity.setReamgmtActe(reamgmtActe);
		
		if (reamgmtRequestDto.getCodBug() == null) {
			throw new IllegalArgumentException("Reamgmt need a Budget");
		}
		Budget budget = budgetService.get(reamgmtRequestDto.getCodBug());
		entity.setBudget(budget);
		
		entity.setId(new ReamgmtId(
				reamgmtRequestDto.getCodReam(), 
				reamgmtRequestDto.getCodBug()
		));
		
		entity.setOuvert(reamgmtRequestDto.getOuvert());
		entity.setAnnule(reamgmtRequestDto.getAnnule());
		entity.setNouvelle(reamgmtRequestDto.getNouvelle());
		
		repository.save(entity);
		return GbcMapper2.reamgmtToReamgmtResponseDto(entity);
	}
	
	@Override
	public List<ReamgmtResponseDto> getAll() {
		List<Reamgmt> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.reamgmtToReamgmtResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public Reamgmt get(Long codReam, String codBud) {
		ReamgmtId id = new ReamgmtId(codReam, codBud);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Reamgmt with id: " + id + " could not be found"));
	}
	
	@Override
	public ReamgmtResponseDto getById(Long codReam, String codBud) {
		Reamgmt entity  = get(codReam, codBud);
		return GbcMapper2.reamgmtToReamgmtResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public ReamgmtResponseDto delete(Long codReam, String codBud) {
		Reamgmt entity  = get(codReam, codBud);
		repository.delete(entity);
		return GbcMapper2.reamgmtToReamgmtResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public ReamgmtResponseDto edit(Long codReam, String codBud, ReamgmtRequestDto reamgmtRequestDto) {
		Reamgmt entity  = get(codReam, codBud);
		entity.setOuvert(reamgmtRequestDto.getOuvert());
		entity.setAnnule(reamgmtRequestDto.getAnnule());
		entity.setNouvelle(reamgmtRequestDto.getNouvelle());
		return GbcMapper2.reamgmtToReamgmtResponseDto(entity);
	}

	@Override
	public List<ReamgmtResponseDto> getByCodReam(Long codReam) {
		ReamgmtActe reamgmtActe = reamgmtActeService.get(codReam);
		List<Reamgmt> list = repository.findByReamgmtActe(reamgmtActe);
		return list
				.stream().map(element  -> GbcMapper2.reamgmtToReamgmtResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public List<ReamgmtBudgetDto> getLigneModifieesRecettesDepenses(Long codReam) {
		return repository.getLigneModifieesRecettesDepenses(codReam);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public Boolean addLignesModifiees(List<ReamgmtRequestDto> reamgmtRequestDtos) {
		try {
			for (ReamgmtRequestDto reamgmtRequestDto : reamgmtRequestDtos) {
				add(reamgmtRequestDto);
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
	public Boolean deleteLignesModifiees(Long codReam) {
		try {
			ReamgmtActe reamgmtActe = reamgmtActeService.get(codReam);
			List<Reamgmt> reamgmts = repository.deleteByReamgmtActe(reamgmtActe);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean exists(Long codReam, String codBud) {
		return repository.existsById(new ReamgmtId(codReam, codBud));
	}

	@Override
	@Transactional("gbcTransactionManager")
	public Boolean editAllReam(Long codReam) {
		try {
			List<ReamgmtResponseDto> reamgmtResponseDtos = getByCodReam(codReam);
			for (ReamgmtResponseDto reamgmtResponseDto : reamgmtResponseDtos) {
				budgetService.editReam(reamgmtResponseDto.getCodBug());
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
}
