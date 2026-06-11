package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.PpmBudgRequestDto;
import com.sigep.gbc.dto.responseDto.PpmBudgResponseDto;
import com.sigep.gbc.entity.Budget;
import com.sigep.gbc.entity.CodSourceFin;
import com.sigep.gbc.entity.Ppm;
import com.sigep.gbc.entity.PpmBudg;
import com.sigep.gbc.entity.PpmBudgId;
import com.sigep.gbc.repository.PpmBudgRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public  class PpmBudgServiceImpl implements PpmBudgService {
	
	private final PpmBudgRepository repository;
	private final PpmService ppmService;
	private final BudgetService budgetService;
	private final CodSourceFinService codSourceFinService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmBudgResponseDto add(PpmBudgRequestDto ppmBudgRequestDto) {
		PpmBudg entity = new PpmBudg();
		
		if (ppmBudgRequestDto.getIdPpm() == null) {
			throw new IllegalArgumentException("PpmBudg need a Ppm");
		}
		Ppm ppm = ppmService.get(ppmBudgRequestDto.getIdPpm());
		entity.setPpm(ppm);
		
		if (ppmBudgRequestDto.getCodBud() == null) {
			throw new IllegalArgumentException("PpmBudg need a Budget");
		}
		Budget budget = budgetService.get(ppmBudgRequestDto.getCodBud());
		entity.setBudget(budget);
		
		if (ppmBudgRequestDto.getIdSrceFin() == null) {
			throw new IllegalArgumentException("PpmBudg need a CodSourceFin");
		}
		CodSourceFin codSourceFin = codSourceFinService.get(ppmBudgRequestDto.getIdSrceFin());
		entity.setCodSourceFin(codSourceFin);
		
		entity.setId(new PpmBudgId(
				ppmBudgRequestDto.getIdPpm(), 
				ppmBudgRequestDto.getCodBud(),
				ppmBudgRequestDto.getIdSrceFin()
		));
		
		entity.setMontantEstime(ppmBudgRequestDto.getMontantEstime());
		
		repository.save(entity);
		return GbcMapper2.ppmBudgToPpmBudgResponseDto(entity);
	}
	
	@Override
	public List<PpmBudgResponseDto> getAll() {
		List<PpmBudg> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.ppmBudgToPpmBudgResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public PpmBudg get(String idPpm, String codBud, String idSrceFin) {
		PpmBudgId id = new PpmBudgId();
		id.setIdPpm(idPpm);
		id.setCodBud(codBud);
		id.setIdSrceFin(idSrceFin);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("PpmBudg with id: " + id + " could not be found"));
	}
	
	@Override
	public PpmBudgResponseDto getById(String idPpm, String codBud, String idSrceFin) {
		PpmBudg entity  = get(idPpm, codBud, idSrceFin);
		return GbcMapper2.ppmBudgToPpmBudgResponseDto(entity);
	}
	
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmBudgResponseDto delete(String idPpm, String codBud, String idSrceFin) {
		PpmBudg entity  = get(idPpm, codBud, idSrceFin);
		repository.delete(entity);
		return GbcMapper2.ppmBudgToPpmBudgResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmBudgResponseDto edit(String idPpm, String codBud, String idSrceFin, PpmBudgRequestDto ppmBudgRequestDto) {
		PpmBudg entity  = get(idPpm, codBud, idSrceFin);
		entity.setMontantEstime(ppmBudgRequestDto.getMontantEstime());
		return GbcMapper2.ppmBudgToPpmBudgResponseDto(entity);
	}
	
	
	//Aristide
	@Override
	public List<PpmBudgResponseDto> getByIdPpm(String idPpm) {
	    List<PpmBudg> entity = repository.findById_IdPpm(idPpm);
	    return entity.stream()
	            .map(GbcMapper2::ppmBudgToPpmBudgResponseDto)
	            .collect(Collectors.toList());
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmBudgResponseDto addReam(PpmBudgRequestDto ppmBudgRequestDto) {
		PpmBudg entity = new PpmBudg();
		
		if (ppmBudgRequestDto.getIdPpm() == null) {
			throw new IllegalArgumentException("PpmBudg need a Ppm");
		}
		Ppm ppm = ppmService.get(ppmBudgRequestDto.getIdPpm());
		entity.setPpm(ppm);
		
		if (ppmBudgRequestDto.getCodBud() == null) {
			throw new IllegalArgumentException("PpmBudg need a Budget");
		}
		Budget budget = budgetService.get(ppmBudgRequestDto.getCodBud());
		entity.setBudget(budget);
		
		if (ppmBudgRequestDto.getIdSrceFin() == null) {
			throw new IllegalArgumentException("PpmBudg need a CodSourceFin");
		}
		CodSourceFin codSourceFin = codSourceFinService.get(ppmBudgRequestDto.getIdSrceFin());
		entity.setCodSourceFin(codSourceFin);
		
		entity.setId(new PpmBudgId(
				ppmBudgRequestDto.getIdPpm(), 
				ppmBudgRequestDto.getCodBud(),
				ppmBudgRequestDto.getIdSrceFin()
		));
		
		entity.setMontantEstime(ppmBudgRequestDto.getMontantEstime());
		entity.setReam(true);
		
		repository.save(entity);
		return GbcMapper2.ppmBudgToPpmBudgResponseDto(entity);
	}
	
}
