package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.DepartementRequestDto;
import com.sigep.gim.dto.responseDto.DepartementResponseDto;
import com.sigep.gim.entity.Departement;
import com.sigep.gim.entity.Province;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimDepartementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimDepartementServiceImpl implements GimDepartementService {
	
	private final GimDepartementRepository repository;
	private final GimProvinceService gimProvinceService;
	
	@Override
	@Transactional
	public DepartementResponseDto add(DepartementRequestDto departementRequestDto) {
		Departement entity = new Departement();
		entity.setCodDepart(departementRequestDto.getCodDepart());
		entity.setDepartema(departementRequestDto.getDepartema());
		entity.setChefLieuDepart(departementRequestDto.getChefLieuDepart());
		
		if(departementRequestDto.getCodProv() == null) {
			throw new IllegalArgumentException("Departement need a Province");
		}
		Province province = gimProvinceService.get(departementRequestDto.getCodProv());
		entity.setProvince(province);
		
		repository.save(entity);
		return GimMapper.DepartementToDepartementResponseDto(entity);
	}
	
	@Override
	public List<DepartementResponseDto> getAll() {
		List<Departement> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.DepartementToDepartementResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Departement get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Departement with id "+id+"could not be found")
		);
	}
	
	@Override
	public DepartementResponseDto getById(int id) {
		Departement entity = get(id);
		return GimMapper.DepartementToDepartementResponseDto(entity);
	}
	
	@Override
	@Transactional
	public DepartementResponseDto delete(int id) {
		Departement entity = get(id);
		repository.delete(entity);
		return GimMapper.DepartementToDepartementResponseDto(entity);
	}
	
	@Override
	@Transactional
	public DepartementResponseDto edit(int id,DepartementRequestDto departementRequestDto) {
		Departement entity = get(id);
		entity.setCodDepart(departementRequestDto.getCodDepart());
		entity.setDepartema(departementRequestDto.getDepartema());
		entity.setChefLieuDepart(departementRequestDto.getChefLieuDepart());
		
		if(departementRequestDto.getCodProv() != null) {
			Province province = gimProvinceService.get(departementRequestDto.getCodProv());
			entity.setProvince(province);
		}
		return GimMapper.DepartementToDepartementResponseDto(entity);
	}
}
