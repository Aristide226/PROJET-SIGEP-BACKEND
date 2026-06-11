package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.DepartementRequestDto;
import com.sigep.gim.dto.responseDto.DepartementResponseDto;
import com.sigep.gim.entity.Departement;

@Service
public interface GimDepartementService {
	public DepartementResponseDto add(DepartementRequestDto departementRequestDto);
	public List<DepartementResponseDto> getAll();
	public Departement get(int id);
	public DepartementResponseDto getById(int id);
	public DepartementResponseDto delete(int id);
	public DepartementResponseDto edit(int id, DepartementRequestDto departementRequestDto);
}