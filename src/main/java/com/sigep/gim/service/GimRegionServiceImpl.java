package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.RegionRequestDto;
import com.sigep.gim.dto.responseDto.RegionResponseDto;
import com.sigep.gim.entity.Region;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimRegionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimRegionServiceImpl implements GimRegionService {
	
	private final GimRegionRepository repository;
	
	@Override
	@Transactional
	public RegionResponseDto add(RegionRequestDto regionRequestDto) {
		Region entity = new Region();
		int codReg = findByMaxCodeReg()+1;
		entity.setCodReg(codReg);
		entity.setRgion(regionRequestDto.getRgion());
		entity.setChefLieu(regionRequestDto.getChefLieu());
		entity.setArticleRegion(regionRequestDto.getArticleRegion());
		repository.save(entity);
		return GimMapper.RegionToRegionResponseDto(entity);
	}
	
	@Override
	public List<RegionResponseDto> getAll() {
		List<Region> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.RegionToRegionResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Region get(int id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException(" with id "+id+"could not be found")
				);
	}
	
	@Override
	public RegionResponseDto getById(int id) {
		Region entity = get(id);
		return GimMapper.RegionToRegionResponseDto(entity);
	}
	
	@Override
	@Transactional
	public RegionResponseDto delete(int id) {
		Region entity = get(id);
		repository.delete(entity);
		return GimMapper.RegionToRegionResponseDto(entity);
	}
	
	@Override
	@Transactional
	public RegionResponseDto edit(int id,RegionRequestDto regionRequestDto) {
		Region entity = get(id);
		entity.setRgion(regionRequestDto.getRgion());
		entity.setChefLieu(regionRequestDto.getChefLieu());
		entity.setArticleRegion(regionRequestDto.getArticleRegion());
		return GimMapper.RegionToRegionResponseDto(entity);
	}
	
	@Override
	@Transactional
	public Integer findByMaxCodeReg() {
		return repository.findByMaxCodeReg();
	}
}
