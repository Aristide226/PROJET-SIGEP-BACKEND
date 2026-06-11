package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.TypeBienStatistiqueDto;
import com.sigep.gim.dto.requestDto.CodeBudgTypeRequestDto;
import com.sigep.gim.dto.responseDto.CodeBudgTypeResponseDto;
import com.sigep.gim.entity.CategorieBien;
import com.sigep.gim.entity.CodeBudgType;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimCodeBudgTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimCodeBudgTypeServiceImpl implements GimCodeBudgTypeService {
	
	private final GimCodeBudgTypeRepository repository;
	private final GimCategorieBienService gimCategorieBienService;
	
	@Override
	@Transactional
	public CodeBudgTypeResponseDto add(CodeBudgTypeRequestDto codeBudgTypeRequestDto) {
		CodeBudgType entity = new CodeBudgType();
		int codType = findMaxCodTyp()+1;
		entity.setCodTyp(codType);
		entity.setIntituleTyp(codeBudgTypeRequestDto.getIntituleTyp());
		entity.setCodTypActif(codeBudgTypeRequestDto.getCodTypActif());
		
		if(codeBudgTypeRequestDto.getCodCategorie() == null) {
			throw new IllegalArgumentException("CodeBudgType need a CategorieBien");
		}
		CategorieBien categorieBien = gimCategorieBienService.get(codeBudgTypeRequestDto.getCodCategorie());
		entity.setCategorieBien(categorieBien);
		
		repository.save(entity);
		return GimMapper.CodeBudgTypeToCodeBudgTypeResponseDto(entity);
	}
	
	@Override
	public List<CodeBudgTypeResponseDto> getAll() {
		List<CodeBudgType> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.CodeBudgTypeToCodeBudgTypeResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public CodeBudgType get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("CodeBudgType with id "+id+"could not be found")
		);
	}
	
	@Override
	public CodeBudgTypeResponseDto getById(int id) {
		CodeBudgType entity = get(id);
		return GimMapper.CodeBudgTypeToCodeBudgTypeResponseDto(entity);
	}
	
	@Override
	@Transactional
	public CodeBudgTypeResponseDto delete(int id) {
		CodeBudgType entity = get(id);
		repository.delete(entity);
		return GimMapper.CodeBudgTypeToCodeBudgTypeResponseDto(entity);
	}
	
	@Override
	@Transactional
	public CodeBudgTypeResponseDto edit(int id,CodeBudgTypeRequestDto codeBudgTypeRequestDto) {
		CodeBudgType entity = get(id);
		entity.setIntituleTyp(codeBudgTypeRequestDto.getIntituleTyp());
		entity.setCodTypActif(codeBudgTypeRequestDto.getCodTypActif());
		
		if(codeBudgTypeRequestDto.getCodCategorie() != null) {
			CategorieBien categorieBien = gimCategorieBienService.get(codeBudgTypeRequestDto.getCodCategorie());
			entity.setCategorieBien(categorieBien);
		}
		
		return GimMapper.CodeBudgTypeToCodeBudgTypeResponseDto(entity);
	}
	
	@Override
	@Transactional
	public Integer findMaxCodTyp() {
		return repository.findMaxCodTyp();
	}
	
	@Override
	@Transactional
	public List<TypeBienStatistiqueDto>	getTypeBienStatistiqueDto() {
		return repository.getTypeBienStatistiqueDto();
	}
}
