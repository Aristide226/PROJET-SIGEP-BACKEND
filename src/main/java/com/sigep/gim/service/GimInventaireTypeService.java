package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.InventaireTypeRequestDto;
import com.sigep.gim.dto.responseDto.InventaireTypeResponseDto;
import com.sigep.gim.entity.InventaireType;

@Service
public interface GimInventaireTypeService {
	public InventaireTypeResponseDto add(InventaireTypeRequestDto inventaireTypeRequestDto);
	public List<InventaireTypeResponseDto> getAll();
	public InventaireType get(short id);
	public InventaireTypeResponseDto getById(short id);
	public InventaireTypeResponseDto delete(short id);
	public InventaireTypeResponseDto edit(short id, InventaireTypeRequestDto inventaireTypeRequestDto);
}