package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PatrimoineMaterielsRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineMaterielsResponseDto;
import com.sigep.gim.entity.Patrimoine;
import com.sigep.gim.entity.PatrimoineMateriels;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimPatrimoineMaterielsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimPatrimoineMaterielsServiceImpl implements GimPatrimoineMaterielsService {
	
	private final GimPatrimoineMaterielsRepository repository;
	private final GimPatrimoineService gimPatrimoineService;
	
	@Override
	@Transactional
	public PatrimoineMaterielsResponseDto add(PatrimoineMaterielsRequestDto patrimoineMaterielsRequestDto) {
		PatrimoineMateriels entity = new PatrimoineMateriels();
		entity.setMarqRace(patrimoineMaterielsRequestDto.getMarqRace());
		entity.setImmatriculation(patrimoineMaterielsRequestDto.getImmatriculation());
		entity.setIdMagasin(patrimoineMaterielsRequestDto.getIdMagasin());
		entity.setFormat(patrimoineMaterielsRequestDto.getFormat());
		
		if(patrimoineMaterielsRequestDto.getMle() == null) {
			throw new IllegalArgumentException("PatrimoineMateriels need a Patrimoine");
		}
		Patrimoine patrimoine = gimPatrimoineService.get(patrimoineMaterielsRequestDto.getMle());
		entity.setPatrimoine(patrimoine);
		repository.save(entity);
		return GimMapper.PatrimoineMaterielsToPatrimoineMaterielsResponseDto(entity);
	}
	
	@Override
	public List<PatrimoineMaterielsResponseDto> getAll() {
		List<PatrimoineMateriels> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.PatrimoineMaterielsToPatrimoineMaterielsResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public PatrimoineMateriels get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("PatrimoineMateriels with id "+id+"could not be found")
		);
	}
	
	@Override
	public PatrimoineMaterielsResponseDto getById(String id) {
		PatrimoineMateriels entity = get(id);
		return GimMapper.PatrimoineMaterielsToPatrimoineMaterielsResponseDto(entity);
	}
	
	@Override
	@Transactional
	public PatrimoineMaterielsResponseDto delete(String id) {
		PatrimoineMateriels entity = get(id);
		repository.delete(entity);
		return GimMapper.PatrimoineMaterielsToPatrimoineMaterielsResponseDto(entity);
	}
	
	@Override
	@Transactional
	public PatrimoineMaterielsResponseDto edit(String id,PatrimoineMaterielsRequestDto patrimoineMaterielsRequestDto) {
		PatrimoineMateriels entity = get(id);
		entity.setMarqRace(patrimoineMaterielsRequestDto.getMarqRace());
		entity.setImmatriculation(patrimoineMaterielsRequestDto.getImmatriculation());
		entity.setIdMagasin(patrimoineMaterielsRequestDto.getIdMagasin());
		entity.setFormat(patrimoineMaterielsRequestDto.getFormat());
		return GimMapper.PatrimoineMaterielsToPatrimoineMaterielsResponseDto(entity);
	}
}
