package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.BatimentUsagesRequestDto;
import com.sigep.gim.dto.responseDto.BatimentUsagesResponseDto;
import com.sigep.gim.entity.BatimentUsages;

@Service
public interface GimBatimentUsagesService {
	public BatimentUsagesResponseDto add(BatimentUsagesRequestDto batimentUsagesRequestDto);
	public List<BatimentUsagesResponseDto> getAll();
	public BatimentUsages get(int id);
	public BatimentUsagesResponseDto getById(int id);
	public BatimentUsagesResponseDto delete(int id);
	public BatimentUsagesResponseDto edit(int id, BatimentUsagesRequestDto batimentUsagesRequestDto);
}