package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.BordMandDto;
import com.sigep.gbc.entity.BordMand;
import com.sigep.gbc.entity.BordMandId;
import com.sigep.gbc.entity.BordereauEmismandats;
import com.sigep.gbc.entity.Mandats;
import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.model.IdMandsIdBordEmis;
import com.sigep.gbc.repository.BordMandRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BordMandServiceImpl implements BordMandService {
	
	private final BordMandRepository repository;
	private final BordereauEmismandatsService bordereauEmismandatsService;
	private final MandatsService mandatsService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public BordMandDto add(BordMandDto bordMandDto) {
		BordMand entity = new BordMand();
		
		if (bordMandDto.getIdBord() == null) {
			throw new IllegalArgumentException("BordMand need a BordereauEmisMandats");
		}
		BordereauEmismandats bordereauEmismandats = bordereauEmismandatsService.get(bordMandDto.getIdBord());
		entity.setBordereauEmismandats(bordereauEmismandats);
		
		if (bordMandDto.getNumMand() == null) {
			throw new IllegalArgumentException("BordMand need a Mandat");
		}
		Mandats mandat = mandatsService.get(bordMandDto.getNumMand());
		entity.setMandats(mandat);
		
		entity.setId(new BordMandId(
				bordMandDto.getIdBord(), 
				bordMandDto.getNumMand()
		));
		
		entity.setDatePaieRecouv(bordMandDto.getDatePaieRecouv());
		entity.setObservation(bordMandDto.getObservation());
		entity.setActifSurBord(bordMandDto.getActifSurBord());
		
		repository.save(entity);
		return GbcMapper.bordMandToBordMandResponseDto(entity);
	}
	
	@Override
	public List<BordMandDto> getAll() {
		List<BordMand> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.bordMandToBordMandResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public BordMand get(String idBord, Long numMand) {
		BordMandId id = new BordMandId();
		id.setIdbord(idBord);
		id.setNumMand(numMand);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("BordMand with id: " + id + " could not be found"));
	}
	
	@Override
	public BordMandDto getById(String idBord, Long numMand) {
		BordMand entity  = get(idBord, numMand);
		return GbcMapper.bordMandToBordMandResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public BordMandDto delete(String idBord, Long numMand) {
		BordMand entity  = get(idBord, numMand);
		repository.delete(entity);
		return GbcMapper.bordMandToBordMandResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public BordMandDto edit(String idBord, Long numMand, BordMandDto bordMandDto) {
		BordMand entity  = get(idBord, numMand);
		entity.setDatePaieRecouv(bordMandDto.getDatePaieRecouv());
		entity.setObservation(bordMandDto.getObservation());
		entity.setActifSurBord(bordMandDto.getActifSurBord());
		return GbcMapper.bordMandToBordMandResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public Boolean adds(IdMandsIdBordEmis idMandsIdBordEmis) {
		try {
			for (Long id : idMandsIdBordEmis.getIds()) {
				BordMandDto bordMandRequestDto = new BordMandDto();
				bordMandRequestDto.setIdBord(idMandsIdBordEmis.getIdBordEmis());
				bordMandRequestDto.setNumMand(id);
				bordMandRequestDto.setDatePaieRecouv(null);
				bordMandRequestDto.setObservation(null);
				bordMandRequestDto.setActifSurBord(true); 
				add(bordMandRequestDto);	
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
	public Boolean deleteBordereauEmismandats(String idBord) {
		try {
			List<BordMand> list = repository.getByIdBord(idBord);
			boolean isSupprimable = true;
			for (BordMand bordMand : list) {
				Mandats mandat = mandatsService.get(bordMand.getMandats().getNumMand());
				if (!mandat.getEtatDossierByEtat().getEtat().equals("M2")) {
					isSupprimable = false;
				}
			}
			if (isSupprimable) {
				bordereauEmismandatsService.delete(idBord);
			}
			return isSupprimable;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}	
}
