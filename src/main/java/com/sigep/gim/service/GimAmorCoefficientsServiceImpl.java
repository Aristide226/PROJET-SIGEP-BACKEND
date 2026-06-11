package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.AmorCoefficientsRequestDto;
import com.sigep.gim.dto.responseDto.AmorCoefficientsResponseDto;
import com.sigep.gim.entity.AmorCoefficients;
import com.sigep.gim.entity.AmorCoefficientsId;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimAmorCoefficientsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimAmorCoefficientsServiceImpl implements GimAmorCoefficientsService {
	
	private final GimAmorCoefficientsRepository repository;
	
	@Override
	@Transactional
	public AmorCoefficientsResponseDto add(AmorCoefficientsRequestDto amorCoefficientsRequestDto) {
		AmorCoefficients entity = new AmorCoefficients();
		entity.setDureeMax(amorCoefficientsRequestDto.getDureeMax());
		entity.setCoefficient(amorCoefficientsRequestDto.getCoefficient());
		
		entity.setId(new AmorCoefficientsId(
			amorCoefficientsRequestDto.getAmorType(),
			amorCoefficientsRequestDto.getDureeMin()
		));
		repository.save(entity);
		return GimMapper.AmorCoefficientsToAmorCoefficientsResponseDto(entity);
	}
	
	@Override
	public List<AmorCoefficientsResponseDto> getAll() {
		List<AmorCoefficients> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.AmorCoefficientsToAmorCoefficientsResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public AmorCoefficients get(char amortType, int dureeMin) {
		AmorCoefficientsId id = new AmorCoefficientsId();
		id.setAmorType(amortType);
		id.setDureeMin(dureeMin);
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("AmorCoefficients with id "+id+"could not be found")
		);
	}
	
	@Override
	public AmorCoefficientsResponseDto getById(char amortType, int dureeMin) {
		AmorCoefficients entity = get(amortType,dureeMin);
		return GimMapper.AmorCoefficientsToAmorCoefficientsResponseDto(entity);
	}
	
	@Override
	@Transactional
	public AmorCoefficientsResponseDto delete(char amortType, int dureeMin) {
		AmorCoefficients entity = get(amortType,dureeMin);
		repository.delete(entity);
		return GimMapper.AmorCoefficientsToAmorCoefficientsResponseDto(entity);
	}
	
	@Override
	@Transactional
	public AmorCoefficientsResponseDto edit(char amortType, int dureeMin,AmorCoefficientsRequestDto amorCoefficientsRequestDto) {
		AmorCoefficients entity = get(amortType,dureeMin);
		entity.setDureeMax(amorCoefficientsRequestDto.getDureeMax());
		entity.setCoefficient(amorCoefficientsRequestDto.getCoefficient());
		return GimMapper.AmorCoefficientsToAmorCoefficientsResponseDto(entity);
	}
}
