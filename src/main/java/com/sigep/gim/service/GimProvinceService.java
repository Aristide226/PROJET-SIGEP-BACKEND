package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.ProvinceRequestDto;
import com.sigep.gim.dto.responseDto.ProvinceResponseDto;
import com.sigep.gim.entity.Province;

@Service
public interface GimProvinceService {
	public ProvinceResponseDto add(ProvinceRequestDto provinceRequestDto);
	public List<ProvinceResponseDto> getAll();
	public Province get(int id);
	public ProvinceResponseDto getById(int id);
	public ProvinceResponseDto delete(int id);
	public ProvinceResponseDto edit(int id, ProvinceRequestDto provinceRequestDto);
}