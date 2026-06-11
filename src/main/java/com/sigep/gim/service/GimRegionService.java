package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.RegionRequestDto;
import com.sigep.gim.dto.responseDto.RegionResponseDto;
import com.sigep.gim.entity.Region;

@Service
public interface GimRegionService {
	public RegionResponseDto add(RegionRequestDto regionRequestDto);
	public List<RegionResponseDto> getAll();
	public Region get(int id);
	public RegionResponseDto getById(int id);
	public RegionResponseDto delete(int id);
	public RegionResponseDto edit(int id, RegionRequestDto regionRequestDto);
	public Integer findByMaxCodeReg();
}