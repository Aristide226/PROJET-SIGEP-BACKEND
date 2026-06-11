package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.BatimentMateriauxConstructCaractRequestDto;
import com.sigep.gim.dto.responseDto.BatimentMateriauxConstructCaractResponseDto;
import com.sigep.gim.entity.BatimentMateriauxConstructCaract;

@Service
public interface GimBatimentMateriauxConstructCaractService {
	public BatimentMateriauxConstructCaractResponseDto add(BatimentMateriauxConstructCaractRequestDto batimentMateriauxConstructCaractRequestDto);
	public List<BatimentMateriauxConstructCaractResponseDto> getAll();
	public BatimentMateriauxConstructCaract get(int id);
	public BatimentMateriauxConstructCaractResponseDto getById(int id);
	public BatimentMateriauxConstructCaractResponseDto delete(int id);
	public BatimentMateriauxConstructCaractResponseDto edit(int id, BatimentMateriauxConstructCaractRequestDto batimentMateriauxConstructCaractRequestDto);
}