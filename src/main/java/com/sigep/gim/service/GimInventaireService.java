package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.InventaireRequestDto;
import com.sigep.gim.dto.responseDto.InventaireResponseDto;
import com.sigep.gim.entity.Inventaire;

@Service
public interface GimInventaireService {
	public InventaireResponseDto add(InventaireRequestDto inventaireRequestDto);
	public List<InventaireResponseDto> getAll();
	public Inventaire get(long id);
	public InventaireResponseDto getById(long id);
	public InventaireResponseDto delete(long id);
	public InventaireResponseDto edit(long id, InventaireRequestDto inventaireRequestDto);
	public long findMaxIdInvent();
}