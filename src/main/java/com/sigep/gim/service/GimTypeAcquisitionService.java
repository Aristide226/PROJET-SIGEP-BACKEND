package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.TypeAcquisitionRequestDto;
import com.sigep.gim.dto.responseDto.TypeAcquisitionResponseDto;
import com.sigep.gim.entity.TypeAcquisition;

@Service
public interface GimTypeAcquisitionService {
	public TypeAcquisitionResponseDto add(TypeAcquisitionRequestDto typeAcquisitionRequestDto);
	public List<TypeAcquisitionResponseDto> getAll();
	public TypeAcquisition get(int id);
	public TypeAcquisitionResponseDto getById(int id);
	public TypeAcquisitionResponseDto delete(int id);
	public TypeAcquisitionResponseDto edit(int id, TypeAcquisitionRequestDto typeAcquisitionRequestDto);
}