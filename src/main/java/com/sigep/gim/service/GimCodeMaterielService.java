package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.CodeMaterielRequestDto;
import com.sigep.gim.dto.responseDto.CodeMaterielResponseDto;
import com.sigep.gim.entity.CodeMateriel;

@Service
public interface GimCodeMaterielService {
	public CodeMaterielResponseDto add(CodeMaterielRequestDto codeMaterielRequestDto);
	public List<CodeMaterielResponseDto> getAll();
	public CodeMateriel get(String id);
	public CodeMaterielResponseDto getById(String id);
	public CodeMaterielResponseDto delete(String id);
	public CodeMaterielResponseDto edit(String id, CodeMaterielRequestDto codeMaterielRequestDto);
}