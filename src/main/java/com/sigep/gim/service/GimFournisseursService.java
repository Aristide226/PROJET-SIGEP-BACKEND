package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.FournisseursRequestDto;
import com.sigep.gim.dto.responseDto.FournisseursResponseDto;
import com.sigep.gim.entity.Fournisseurs;

@Service
public interface GimFournisseursService {
	public FournisseursResponseDto add(FournisseursRequestDto fournisseursRequestDto);
	public List<FournisseursResponseDto> getAll();
	public Fournisseurs get(long id);
	public FournisseursResponseDto getById(long id);
	public FournisseursResponseDto delete(long id);
	public FournisseursResponseDto edit(long id, FournisseursRequestDto fournisseursRequestDto);
	public Long findByMaxIdFourn(); 
}