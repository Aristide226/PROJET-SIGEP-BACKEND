package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.PpmOldRequestDto;
import com.sigep.gbc.dto.responseDto.PpmOldResponseDto;
import com.sigep.gbc.entity.Ppm;
import com.sigep.gbc.entity.PpmActe;
import com.sigep.gbc.entity.PpmOld;
import com.sigep.gbc.entity.PpmOldId;
import com.sigep.gbc.repository.PpmOldRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PpmOldServiceImpl implements PpmOldService {
	
	private final PpmOldRepository repository;
	private final PpmActeService ppmActeService;
	private final PpmService ppmService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmOldResponseDto add(PpmOldRequestDto ppmOldRequestDto) {
		PpmOld entity = new PpmOld();
		
		if (ppmOldRequestDto.getIdPpmM() == null) {
			throw new IllegalArgumentException("PpmOld need a PpmActe");
		}
		PpmActe ppmActe = ppmActeService.get(ppmOldRequestDto.getIdPpmM());
		entity.setPpmActe(ppmActe);
		
		if (ppmOldRequestDto.getIdPpm() == null) {
			throw new IllegalArgumentException("PpmOld need a Ppm");
		}
		Ppm ppm = ppmService.get(ppmOldRequestDto.getIdPpm());
		entity.setPpm(ppm);
		
		entity.setId(new PpmOldId(
				ppmOldRequestDto.getIdPpmM(),
				ppmOldRequestDto.getIdPpm() 
		));
		
		entity.setMontantEstime(ppmOldRequestDto.getMontantEstime());
		entity.setMontDepEngNonLiq(ppmOldRequestDto.getMontDepEngNonLiq());
		entity.setCreditDispo(ppmOldRequestDto.getCreditDispo());
		entity.setNatPrestation(ppmOldRequestDto.getNatPrestation());
		entity.setNbLot(ppmOldRequestDto.getNbLot());
		entity.setIdModPassation(ppmOldRequestDto.getIdModPassation());
		entity.setDateLancement(ppmOldRequestDto.getDateLancement());
		entity.setDateRemiseOffre(ppmOldRequestDto.getDateRemiseOffre());
		entity.setNbJrsEvaluation(ppmOldRequestDto.getNbJrsEvaluation());
		entity.setDateProbDemar(ppmOldRequestDto.getDateProbDemar());
		entity.setDelaiExecJrs(ppmOldRequestDto.getDelaiExecJrs());
		entity.setDateButoire(ppmOldRequestDto.getDateButoire());
		entity.setDateEffectLance(ppmOldRequestDto.getDateEffectLance());
		
		repository.save(entity);
		return GbcMapper2.ppmOldToPpmOldResponseDto(entity);
	}
	
	@Override
	public List<PpmOldResponseDto> getAll() {
		List<PpmOld> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.ppmOldToPpmOldResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public PpmOld get(String idPpmM, String idPpm) {
		PpmOldId id = new PpmOldId();
		id.setIdPpmM(idPpmM);
		id.setIdPpm(idPpm);;
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("PpmOld with id: " + id + " could not be found"));
	}
	
	@Override
	public PpmOldResponseDto getById(String idPpmM, String idPpm) {
		PpmOld entity  = get(idPpmM, idPpm);
		return GbcMapper2.ppmOldToPpmOldResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmOldResponseDto delete(String idPpmM, String idPpm) {
		PpmOld entity  = get(idPpmM, idPpm);
		repository.delete(entity);
		return GbcMapper2.ppmOldToPpmOldResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmOldResponseDto edit(String idPpmM, String idPpm, PpmOldRequestDto ppmOldRequestDto) {
		PpmOld entity  = get(idPpmM, idPpm);
		entity.setMontantEstime(ppmOldRequestDto.getMontantEstime());
		entity.setMontDepEngNonLiq(ppmOldRequestDto.getMontDepEngNonLiq());
		entity.setCreditDispo(ppmOldRequestDto.getCreditDispo());
		entity.setNatPrestation(ppmOldRequestDto.getNatPrestation());
		entity.setNbLot(ppmOldRequestDto.getNbLot());
		entity.setIdModPassation(ppmOldRequestDto.getIdModPassation());
		entity.setDateLancement(ppmOldRequestDto.getDateLancement());
		entity.setDateRemiseOffre(ppmOldRequestDto.getDateRemiseOffre());
		entity.setNbJrsEvaluation(ppmOldRequestDto.getNbJrsEvaluation());
		entity.setDateProbDemar(ppmOldRequestDto.getDateProbDemar());
		entity.setDelaiExecJrs(ppmOldRequestDto.getDelaiExecJrs());
		entity.setDateButoire(ppmOldRequestDto.getDateButoire());
		entity.setDateEffectLance(ppmOldRequestDto.getDateEffectLance());
		return GbcMapper2.ppmOldToPpmOldResponseDto(entity);
	}	
}
