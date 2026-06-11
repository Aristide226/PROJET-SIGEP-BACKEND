package com.sigep.gim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.CodeAccesAgentDto;
import com.sigep.gim.dto.CodeAccesDto;
import com.sigep.gim.entity.CodeAcces;

@Service
public interface GimCodeAccesService {
	public CodeAccesDto add(CodeAccesDto codeAccesDto);
	public List<CodeAccesDto> getAll();
	public CodeAcces get(int id);
	public CodeAccesDto getById(int id);
	public CodeAccesDto delete(int id);
	public CodeAccesDto edit(int id, CodeAccesDto codeAccesDto);
	
	public List<CodeAccesAgentDto> getUtilisateur();
	public CodeAccesDto getByUserName(String username);
}
