package com.sigep.gbc.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sigep.common.dto.AccesCodeDtoForGrh;
import com.sigep.gbc.dto.AccesCodeDto;
import com.sigep.gbc.service.AccesCodeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GbcAccesCodeFacadeImpl implements GbcAccesCodeFacade {
	
	private final AccesCodeService accesCodeService;
	private final ModelMapper modelMapper;

	@Override
	public List<AccesCodeDtoForGrh> getAll() {
		List<AccesCodeDto> list = accesCodeService.getAll();
		return list
				.stream()
				.map(element  -> modelMapper.map(element, AccesCodeDtoForGrh.class))
				.collect(Collectors.toList());
	}

}
