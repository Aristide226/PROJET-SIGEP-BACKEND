package com.sigep.gim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.CodeAccesTypeRequestDto;
import com.sigep.gim.dto.responseDto.CodeAccesTypeResponseDto;
import com.sigep.gim.entity.CodeAccesType;

@Service
public interface GimCodeAccesTypeService {
	public CodeAccesTypeResponseDto add(CodeAccesTypeRequestDto codeAccesTypeRequestDto);
	public List<CodeAccesTypeResponseDto> getAll();
	public CodeAccesType get(char id);
	public CodeAccesTypeResponseDto getById(char id);
	public CodeAccesTypeResponseDto delete(char id);
	public CodeAccesTypeResponseDto edit(char id , CodeAccesTypeRequestDto codeAccesTypeRequestDto);
}
