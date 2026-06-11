package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.BatimentMateriauxConstrutRequestDto;
import com.sigep.gim.dto.responseDto.BatimentMateriauxConstrutResponseDto;
import com.sigep.gim.entity.BatimentMateriauxConstrut;

@Service
public interface GimBatimentMateriauxConstrutService {
	public BatimentMateriauxConstrutResponseDto add(BatimentMateriauxConstrutRequestDto batimentMateriauxConstrutRequestDto);
	public List<BatimentMateriauxConstrutResponseDto> getAll();
	public BatimentMateriauxConstrut get(int id);
	public BatimentMateriauxConstrutResponseDto getById(int id);
	public BatimentMateriauxConstrutResponseDto delete(int id);
	public BatimentMateriauxConstrutResponseDto edit(int id, BatimentMateriauxConstrutRequestDto batimentMateriauxConstrutRequestDto);
}