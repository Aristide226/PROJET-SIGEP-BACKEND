package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.FournisseurTypeRequestDto;
import com.sigep.gim.dto.responseDto.FournisseurTypeResponseDto;
import com.sigep.gim.entity.FournisseurType;

@Service
public interface GimFournisseurTypeService {
	public FournisseurTypeResponseDto add(FournisseurTypeRequestDto fournisseurTypeRequestDto);
	public List<FournisseurTypeResponseDto> getAll();
	public FournisseurType get(String id);
	public FournisseurTypeResponseDto getById(String id);
	public FournisseurTypeResponseDto delete(String id);
	public FournisseurTypeResponseDto edit(String id, FournisseurTypeRequestDto fournisseurTypeRequestDto);
}