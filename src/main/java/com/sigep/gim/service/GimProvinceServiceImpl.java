package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.ProvinceRequestDto;
import com.sigep.gim.dto.responseDto.ProvinceResponseDto;
import com.sigep.gim.entity.Province;
import com.sigep.gim.entity.Region;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimProvinceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimProvinceServiceImpl implements GimProvinceService {
	
	private final GimProvinceRepository repository;
	private final GimRegionService gimRegionService;
	
	@Override
	@Transactional
	public ProvinceResponseDto add(ProvinceRequestDto provinceRequestDto) {
		Province entity = new Province();
		entity.setProvinc(provinceRequestDto.getProvinc());
		entity.setChefLieu(provinceRequestDto.getChefLieu());
		entity.setArticleProv(provinceRequestDto.getArticleProv());
		if(provinceRequestDto.getCodReg() == null) {
			throw new IllegalArgumentException("Province need a Region ");
		}
		Region region = gimRegionService.get(provinceRequestDto.getCodReg());
		entity.setRegion(region);
		repository.save(entity);
		return GimMapper.ProvinceToProvinceResponseDto(entity);
	}
	
	@Override
	public List<ProvinceResponseDto> getAll() {
		List<Province> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.ProvinceToProvinceResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Province get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Province with id "+id+"could not be found")
		);
	}
	
	@Override
	public ProvinceResponseDto getById(int id) {
		Province entity = get(id);
		return GimMapper.ProvinceToProvinceResponseDto(entity);
	}
	
	@Override
	@Transactional
	public ProvinceResponseDto delete(int id) {
		Province entity = get(id);
		repository.delete(entity);
		return GimMapper.ProvinceToProvinceResponseDto(entity);
	}
	
	@Override
	@Transactional
	public ProvinceResponseDto edit(int id,ProvinceRequestDto provinceRequestDto) {
		Province entity = get(id);
		entity.setProvinc(provinceRequestDto.getProvinc());
		entity.setChefLieu(provinceRequestDto.getChefLieu());
		entity.setArticleProv(provinceRequestDto.getArticleProv());
		if(provinceRequestDto.getCodReg() != null) {
			Region region = gimRegionService.get(provinceRequestDto.getCodReg());
			entity.setRegion(region);
		}
		
		return GimMapper.ProvinceToProvinceResponseDto(entity);
	}
}
