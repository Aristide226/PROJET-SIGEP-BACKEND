package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.TypeBienStatistiqueDto;
import com.sigep.gim.dto.requestDto.CodeBudgTypeRequestDto;
import com.sigep.gim.dto.responseDto.CodeBudgTypeResponseDto;
import com.sigep.gim.entity.CodeBudgType;

@Service
public interface GimCodeBudgTypeService {
	public CodeBudgTypeResponseDto add(CodeBudgTypeRequestDto codeBudgTypeRequestDto);
	public List<CodeBudgTypeResponseDto> getAll();
	public CodeBudgType get(int id);
	public CodeBudgTypeResponseDto getById(int id);
	public CodeBudgTypeResponseDto delete(int id);
	public CodeBudgTypeResponseDto edit(int id, CodeBudgTypeRequestDto codeBudgTypeRequestDto);
	public Integer findMaxCodTyp();
	public List<TypeBienStatistiqueDto>	getTypeBienStatistiqueDto();
}