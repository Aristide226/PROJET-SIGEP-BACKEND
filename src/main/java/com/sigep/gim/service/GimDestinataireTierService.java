package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.DestinataireTierRequestDto;
import com.sigep.gim.dto.responseDto.DestinataireTierResponseDto;
import com.sigep.gim.entity.DestinataireTier;

@Service
public interface GimDestinataireTierService {
	public DestinataireTierResponseDto add(DestinataireTierRequestDto destinataireTierRequestDto);
	public List<DestinataireTierResponseDto> getAll();
	public DestinataireTier get(int id);
	public DestinataireTierResponseDto getById(int id);
	public DestinataireTierResponseDto delete(int id);
	public DestinataireTierResponseDto edit(int id, DestinataireTierRequestDto destinataireTierRequestDto);
}