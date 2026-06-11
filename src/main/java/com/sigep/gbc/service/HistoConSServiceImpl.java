package com.sigep.gbc.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.HistoConSRequestDto;
import com.sigep.gbc.dto.responseDto.HistoConSResponseDto;
import com.sigep.gbc.entity.HistoConS;
import com.sigep.gbc.repository.HistoConSRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoConSServiceImpl implements HistoConSService{
	
	private final HistoConSRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public HistoConSResponseDto add(HistoConSRequestDto histoConSRequestDto) {
		HistoConS entity = new HistoConS();
		entity.setIdl(histoConSRequestDto.getIdl());
		entity.setDateConnexion(new Date());
		entity.setPc(histoConSRequestDto.getPc());
		entity.setAdressMac(histoConSRequestDto.getAdressMac());
		repository.save(entity);
		return GbcMapper2.histoConSToHistoConSResponseDto(entity);
	}

	@Override
	public List<HistoConSResponseDto> getAll() {
		List<HistoConS> list = repository.findAll();
		return list
				.stream().map(element -> GbcMapper2.histoConSToHistoConSResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public HistoConS get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("HistoConS with id: " + id + " could not be found"));
	}

	@Override
	public HistoConSResponseDto getById(String id) {
		HistoConS entity = get(id);
		return GbcMapper2.histoConSToHistoConSResponseDto(entity);
	}	
}
