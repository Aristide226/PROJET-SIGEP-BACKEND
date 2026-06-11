package com.sigep.gim.service;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.CodeAccesHistoRequestDto;
import com.sigep.gim.dto.responseDto.CodeAccesHistoResponseDto;
import com.sigep.gim.entity.CodeAccesHisto;

@Service
public interface GimCodeAccesHistoService {
	public CodeAccesHistoResponseDto add(CodeAccesHistoRequestDto codeAccesHistoRequestDto);
	public List<CodeAccesHistoResponseDto> getAll();
	public CodeAccesHisto get(int id, Date dateChangement);
	public CodeAccesHistoResponseDto getById(int id, Date dateChangement);
	public CodeAccesHistoResponseDto delete(int id, Date dateChangement);
	public CodeAccesHistoResponseDto edit(int id, Date dateChangement, CodeAccesHistoRequestDto codeAccesHistoRequestDto);
	public Integer findMaxId();
}