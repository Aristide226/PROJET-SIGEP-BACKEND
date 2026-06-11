package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.NumerotationMandatRequestDto;
import com.sigep.gbc.dto.responseDto.NumerotationMandatResponseDto;
import com.sigep.gbc.entity.NumerotationMandat;
import com.sigep.gbc.repository.NumerotationMandatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NumerotationMandatServiceImpl implements NumerotationMandatService {
	
	private final NumerotationMandatRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public NumerotationMandatResponseDto add(NumerotationMandatRequestDto numerotationMandatRequestDto) {
		NumerotationMandat numerotationMandat = new NumerotationMandat();
		numerotationMandat.setMandNumApresVisaCf(numerotationMandatRequestDto.getMandNumApresVisaCf());
		numerotationMandat.setDescriptions(numerotationMandatRequestDto.getDescriptions());
		repository.save(numerotationMandat);
		return GbcMapper.nmToNmResponseDto(numerotationMandat);
	}

	@Override
	public List<NumerotationMandatResponseDto> getAll() {
		List<NumerotationMandat> numerotationMandats = repository.findAll();
		return numerotationMandats
				.stream().map(element  -> GbcMapper.nmToNmResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public NumerotationMandat get(int id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("NumerotationMandat with id: " + id + " could not be found"));
	}

	@Override
	public NumerotationMandatResponseDto getById(int id) {
		NumerotationMandat numerotationMandat = get(id);
		return GbcMapper.nmToNmResponseDto(numerotationMandat);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public NumerotationMandatResponseDto delete(int id) {
		NumerotationMandat numerotationMandat = get(id);
		repository.delete(numerotationMandat);
		return GbcMapper.nmToNmResponseDto(numerotationMandat);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public NumerotationMandatResponseDto edit(int id, NumerotationMandatRequestDto numerotationMandatRequestDto) {
		NumerotationMandat numerotationMandat = get(id);
		numerotationMandat.setMandNumApresVisaCf(numerotationMandatRequestDto.getMandNumApresVisaCf());
		numerotationMandat.setDescriptions(numerotationMandatRequestDto.getDescriptions());
		return GbcMapper.nmToNmResponseDto(numerotationMandat);
	}
}


