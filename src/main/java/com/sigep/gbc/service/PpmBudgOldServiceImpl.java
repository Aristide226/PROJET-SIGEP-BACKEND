package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.PpmBudgOldRequestDto;
import com.sigep.gbc.dto.responseDto.PpmBudgOldResponseDto;
import com.sigep.gbc.entity.PpmActe;
import com.sigep.gbc.entity.PpmBudgOld;
import com.sigep.gbc.entity.PpmBudgOldId;
import com.sigep.gbc.repository.PpmBudgOldRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PpmBudgOldServiceImpl implements PpmBudgOldService {
	
	private final PpmBudgOldRepository repository;
	private final PpmActeService ppmActeService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmBudgOldResponseDto add(PpmBudgOldRequestDto ppmBudgOldRequestDto) {
		PpmBudgOld entity = new PpmBudgOld();
		
		if (ppmBudgOldRequestDto.getIdPpmM() == null) {
			throw new IllegalArgumentException("PpmBudgOld need a PpmActe");
		}
		PpmActe ppmActe = ppmActeService.get(ppmBudgOldRequestDto.getIdPpmM());
		entity.setPpmActe(ppmActe);
		
		entity.setId(new PpmBudgOldId(
				ppmBudgOldRequestDto.getIdPpmM(),
				ppmBudgOldRequestDto.getIdPpm(), 
				ppmBudgOldRequestDto.getCodBud(),
				ppmBudgOldRequestDto.getIdSrceFin()
		));
		
		entity.setMontantEstime(ppmBudgOldRequestDto.getMontantEstime());
		
		repository.save(entity);
		return GbcMapper2.ppmBudgOldToPpmBudgOldResponseDto(entity);
	}
	
	@Override
	public List<PpmBudgOldResponseDto> getAll() {
		List<PpmBudgOld> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.ppmBudgOldToPpmBudgOldResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public PpmBudgOld get(String idPpmM, String idPpm, String codBud, String idSrceFin) {
		PpmBudgOldId id = new PpmBudgOldId();
		id.setIdPpmM(idPpmM);
		id.setIdPpm(idPpm);
		id.setCodBud(codBud);
		id.setIdSrceFin(idSrceFin);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("PpmBudgOld with id: " + id + " could not be found"));
	}
	
	@Override
	public PpmBudgOldResponseDto getById(String idPpmM, String idPpm, String codBud, String idSrceFin) {
		PpmBudgOld entity  = get(idPpmM, idPpm, codBud, idSrceFin);
		return GbcMapper2.ppmBudgOldToPpmBudgOldResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmBudgOldResponseDto delete(String idPpmM, String idPpm, String codBud, String idSrceFin) {
		PpmBudgOld entity  = get(idPpmM, idPpm, codBud, idSrceFin);
		repository.delete(entity);
		return GbcMapper2.ppmBudgOldToPpmBudgOldResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmBudgOldResponseDto edit(String idPpmM, String idPpm, String codBud, String idSrceFin, PpmBudgOldRequestDto ppmBudgOldRequestDto) {
		PpmBudgOld entity  = get(idPpmM, idPpm, codBud, idSrceFin);
		entity.setMontantEstime(ppmBudgOldRequestDto.getMontantEstime());
		return GbcMapper2.ppmBudgOldToPpmBudgOldResponseDto(entity);
	}
}
