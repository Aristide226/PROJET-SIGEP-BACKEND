package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.BatimentMateriauxConstructCaractRequestDto;
import com.sigep.gim.dto.responseDto.BatimentMateriauxConstructCaractResponseDto;
import com.sigep.gim.entity.BatimentMateriauxConstructCaract;
import com.sigep.gim.entity.BatimentMateriauxConstrut;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimBatimentMateriauxConstructCaractRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimBatimentMateriauxConstructCaractServiceImpl implements GimBatimentMateriauxConstructCaractService {
	
	private final GimBatimentMateriauxConstructCaractRepository repository;
	private final GimBatimentMateriauxConstrutService gimBatimentMateriauxConstrutService;
	
	@Override
	@Transactional
	public BatimentMateriauxConstructCaractResponseDto add(BatimentMateriauxConstructCaractRequestDto batimentMateriauxConstructCaractRequestDto) {
		BatimentMateriauxConstructCaract entity = new BatimentMateriauxConstructCaract();
		entity.setLibelleMateriauxCaract(batimentMateriauxConstructCaractRequestDto.getLibelleMateriauxCaract());
		
		if(batimentMateriauxConstructCaractRequestDto.getCodMatereiaux() == null) {
			throw new IllegalArgumentException("BatimentMateriauxConstructCaract need a BatimentMateriauxConstrut");
		}
		BatimentMateriauxConstrut batimentMateriauxConstrut = gimBatimentMateriauxConstrutService.get(batimentMateriauxConstructCaractRequestDto.getCodMatereiaux());
		entity.setBatimentMateriauxConstrut(batimentMateriauxConstrut);
		
		repository.save(entity);
		return GimMapper.BatimentMateriauxConstructCaractToBatimentMateriauxConstructCaractResponseDto(entity);
	}
	
	@Override
	public List<BatimentMateriauxConstructCaractResponseDto> getAll() {
		List<BatimentMateriauxConstructCaract> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.BatimentMateriauxConstructCaractToBatimentMateriauxConstructCaractResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public BatimentMateriauxConstructCaract get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("BatimentMateriauxConstructCaract with id "+id+"could not be found")
		);
	}
	
	@Override
	public BatimentMateriauxConstructCaractResponseDto getById(int id) {
		BatimentMateriauxConstructCaract entity = get(id);
		return GimMapper.BatimentMateriauxConstructCaractToBatimentMateriauxConstructCaractResponseDto(entity);
	}
	
	@Override
	@Transactional
	public BatimentMateriauxConstructCaractResponseDto delete(int id) {
		BatimentMateriauxConstructCaract entity = get(id);
		repository.delete(entity);
		return GimMapper.BatimentMateriauxConstructCaractToBatimentMateriauxConstructCaractResponseDto(entity);
	}
	
	@Override
	@Transactional
	public BatimentMateriauxConstructCaractResponseDto edit(int id,BatimentMateriauxConstructCaractRequestDto batimentMateriauxConstructCaractRequestDto) {
		BatimentMateriauxConstructCaract entity = get(id);
		entity.setLibelleMateriauxCaract(batimentMateriauxConstructCaractRequestDto.getLibelleMateriauxCaract());
		
		if(batimentMateriauxConstructCaractRequestDto.getCodMatereiaux() != null) {
			BatimentMateriauxConstrut batimentMateriauxConstrut = gimBatimentMateriauxConstrutService.get(batimentMateriauxConstructCaractRequestDto.getCodMatereiaux());
			entity.setBatimentMateriauxConstrut(batimentMateriauxConstrut);
		}
		
		return GimMapper.BatimentMateriauxConstructCaractToBatimentMateriauxConstructCaractResponseDto(entity);
	}
}
