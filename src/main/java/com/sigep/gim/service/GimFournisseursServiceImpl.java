package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.FournisseursRequestDto;
import com.sigep.gim.dto.responseDto.FournisseursResponseDto;
import com.sigep.gim.entity.FournisseurType;
import com.sigep.gim.entity.Fournisseurs;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimFournisseursRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimFournisseursServiceImpl implements GimFournisseursService {
	
	private final GimFournisseursRepository repository;
	private final GimFournisseurTypeService gimFournisseurTypeService;
	
	@Override
	@Transactional
	public FournisseursResponseDto add(FournisseursRequestDto fournisseursRequestDto) {
		long idFourn = findByMaxIdFourn() + 1;
		
		Fournisseurs entity = new Fournisseurs();
		entity.setIdFourn(idFourn);
		entity.setFournisseur(fournisseursRequestDto.getFournisseur());
		entity.setNumIfu(fournisseursRequestDto.getNumIfu());
		entity.setTelFourn(fournisseursRequestDto.getTelFourn());
		entity.setBpfourn(fournisseursRequestDto.getBpfourn());
		
		if(fournisseursRequestDto.getTypF() == null) {
			throw new IllegalArgumentException("Fournisseurs need a FournisseurType");
		}
		FournisseurType fournisseurType = gimFournisseurTypeService.get(fournisseursRequestDto.getTypF());
		entity.setFournisseurType(fournisseurType);
		
		repository.save(entity);
		return GimMapper.FournisseursToFournisseursResponseDto(entity);
	}
	
	@Override
	public List<FournisseursResponseDto> getAll() {
		List<Fournisseurs> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.FournisseursToFournisseursResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Fournisseurs get(long id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Fournisseurs with id "+id+"could not be found")
		);
	}
	
	@Override
	public FournisseursResponseDto getById(long id) {
		Fournisseurs entity = get(id);
		return GimMapper.FournisseursToFournisseursResponseDto(entity);
	}
	
	@Override
	@Transactional
	public FournisseursResponseDto delete(long id) {
		Fournisseurs entity = get(id);
		repository.delete(entity);
		return GimMapper.FournisseursToFournisseursResponseDto(entity);
	}
	
	@Override
	@Transactional
	public FournisseursResponseDto edit(long id,FournisseursRequestDto fournisseursRequestDto) {
		Fournisseurs entity = get(id);
		entity.setFournisseur(fournisseursRequestDto.getFournisseur());
		entity.setNumIfu(fournisseursRequestDto.getNumIfu());
		entity.setTelFourn(fournisseursRequestDto.getTelFourn());
		entity.setBpfourn(fournisseursRequestDto.getBpfourn());
		
		if(fournisseursRequestDto.getTypF() != null) {
			FournisseurType fournisseurType = gimFournisseurTypeService.get(fournisseursRequestDto.getTypF());
			entity.setFournisseurType(fournisseurType);
		}
		
		return GimMapper.FournisseursToFournisseursResponseDto(entity);
	}
	
	@Override
	@Transactional
	public Long findByMaxIdFourn() {
		return repository.findByMaxIdFourn();
	}
}
