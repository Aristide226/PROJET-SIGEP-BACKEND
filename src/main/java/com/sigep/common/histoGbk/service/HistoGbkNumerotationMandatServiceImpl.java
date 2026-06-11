package com.sigep.common.histoGbk.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.common.histoGbk.dto.requestDto.NumerotationMandatRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.NumerotationMandatResponseDto;
import com.sigep.common.histoGbk.entity.NumerotationMandat;
import com.sigep.common.histoGbk.repository.HistoGbkNumerotationMandatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional("gbcTransactionManager")
public class HistoGbkNumerotationMandatServiceImpl implements HistoGbkNumerotationMandatService {
	
	private final HistoGbkNumerotationMandatRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public NumerotationMandatResponseDto add(NumerotationMandatRequestDto numerotationMandatRequestDto) {
		NumerotationMandat entity = new NumerotationMandat();
		entity.setMandNumApresVisaCf(numerotationMandatRequestDto.getMandNumApresVisaCf());
		entity.setDescriptions(numerotationMandatRequestDto.getDescriptions());
		repository.save(entity);
		return modelMapper.map(entity, NumerotationMandatResponseDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<NumerotationMandatResponseDto> getAll() {
		List<NumerotationMandat> list = repository.findAll();
		return list
				.stream().map(element  -> modelMapper.map(element, NumerotationMandatResponseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public NumerotationMandat get(int id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("NumerotationMandat with id: " + id + " could not be found"));
	}

	@Override
	@Transactional(readOnly = true)
	public NumerotationMandatResponseDto getById(int id) {
		NumerotationMandat entity = get(id);
		return modelMapper.map(entity, NumerotationMandatResponseDto.class);
	}

	@Override
	public NumerotationMandatResponseDto delete(int id) {
		NumerotationMandat entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, NumerotationMandatResponseDto.class);
	}

	@Override
	public NumerotationMandatResponseDto edit(int id, NumerotationMandatRequestDto numerotationMandatRequestDto) {
		NumerotationMandat entity = get(id);
		entity.setMandNumApresVisaCf(numerotationMandatRequestDto.getMandNumApresVisaCf());
		entity.setDescriptions(numerotationMandatRequestDto.getDescriptions());
		return modelMapper.map(entity, NumerotationMandatResponseDto.class);
	}
}


