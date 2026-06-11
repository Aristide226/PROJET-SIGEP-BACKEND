package com.sigep.gbc.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.HistoActionSHistoConSDto;
import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.HistoActionSRequestDto;
import com.sigep.gbc.dto.responseDto.HistoActionSResponseDto;
import com.sigep.gbc.entity.HistoActionS;
import com.sigep.gbc.entity.HistoActionSId;
import com.sigep.gbc.entity.HistoConS;
import com.sigep.gbc.repository.HistoActionSRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoActionSServiceImpl implements HistoActionSService {
	
	private final HistoActionSRepository repository;
	private final HistoConSService histoConSService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public HistoActionSResponseDto add(HistoActionSRequestDto histoActionSRequestDto) {
		HistoActionS entity = new HistoActionS();
		
		if (histoActionSRequestDto.getCodH() == null) {
			throw new IllegalArgumentException("HistoActionS need a HistoConS");
		}
		HistoConS histoConS = histoConSService.get(histoActionSRequestDto.getCodH());
		entity.setHistoConS(histoConS);
		
		entity.setId(new HistoActionSId(
				new Date(),
				histoActionSRequestDto.getCodH()
		));
		
		entity.setAction(histoActionSRequestDto.getAction());
		
		repository.save(entity);
		return GbcMapper2.histoActionSToHistoActionSResponseDto(entity);
	}
	
	@Override
	public List<HistoActionSResponseDto> getAll() {
		List<HistoActionS> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.histoActionSToHistoActionSResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public HistoActionS get(Date dateAct, String codH) {
		HistoActionSId id = new HistoActionSId(
				dateAct,
				codH
		);
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("HistoActionS with id: " + id + " could not be found"));
	}
	
	@Override
	public HistoActionSResponseDto getById(Date dateAct, String codH) {
		HistoActionS entity  = get(dateAct, codH);
		return GbcMapper2.histoActionSToHistoActionSResponseDto(entity);
	}

	@Override
	public List<HistoActionSHistoConSDto> getHistoActionSHistoConS() {
		return repository.getHistoActionSHistoConS();
	}
}
