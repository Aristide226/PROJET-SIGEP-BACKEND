package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.TypeSortieRequestDto;
import com.sigep.gim.dto.responseDto.TypeSortieResponseDto;
import com.sigep.gim.entity.TypeSortie;

@Service
public interface GimTypeSortieService {
	public TypeSortieResponseDto add(TypeSortieRequestDto typeSortieRequestDto);
	public List<TypeSortieResponseDto> getAll();
	public TypeSortie get(short id);
	public TypeSortieResponseDto getById(short id);
	public TypeSortieResponseDto delete(short id);
	public TypeSortieResponseDto edit(short id, TypeSortieRequestDto typeSortieRequestDto);
	public short findByMaxTypSortie();
}