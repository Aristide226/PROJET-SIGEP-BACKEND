package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.CodeBudgetaireStatistiqueDto;
import com.sigep.gim.dto.requestDto.CodeBudgetaireRequestDto;
import com.sigep.gim.dto.responseDto.CodeBudgetaireResponseDto;
import com.sigep.gim.entity.CodeBudgType;
import com.sigep.gim.entity.CodeBudgetaire;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimCodeBudgetaireRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimCodeBudgetaireServiceImpl implements GimCodeBudgetaireService {
	
	private final GimCodeBudgetaireRepository repository;
	private final GimCodeBudgTypeService gimCodeBudgTypeService;
	
	@Override
	@Transactional
	public CodeBudgetaireResponseDto add(CodeBudgetaireRequestDto codeBudgetaireRequestDto) {
		CodeBudgetaire entity = new CodeBudgetaire();
		entity.setCodBud(codeBudgetaireRequestDto.getCodBud());
		entity.setIntituleCodBud(codeBudgetaireRequestDto.getIntituleCodBud());
		entity.setCodBudActif(codeBudgetaireRequestDto.isCodBudActif());
		
		if(codeBudgetaireRequestDto.getCodTyp() == null) {
			throw new IllegalArgumentException("CodeBudgetaire need a CodeBudgType");
		}
		CodeBudgType codeBudgType = gimCodeBudgTypeService.get(codeBudgetaireRequestDto.getCodTyp());
		entity.setCodeBudgType(codeBudgType);
		repository.save(entity);
		return GimMapper.CodeBudgetaireToCodeBudgetaireResponseDto(entity);
	}
	
	@Override
	public List<CodeBudgetaireResponseDto> getAll() {
		List<CodeBudgetaire> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.CodeBudgetaireToCodeBudgetaireResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public CodeBudgetaire get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("CodeBudgetaire with id "+id+"could not be found")
		);
	}
	
	@Override
	public CodeBudgetaireResponseDto getById(int id) {
		CodeBudgetaire entity = get(id);
		return GimMapper.CodeBudgetaireToCodeBudgetaireResponseDto(entity);
	}
	
	@Override
	@Transactional
	public CodeBudgetaireResponseDto delete(int id) {
		CodeBudgetaire entity = get(id);
		repository.delete(entity);
		return GimMapper.CodeBudgetaireToCodeBudgetaireResponseDto(entity);
	}
	
	@Override
	@Transactional
	public CodeBudgetaireResponseDto edit(int id,CodeBudgetaireRequestDto codeBudgetaireRequestDto) {
		CodeBudgetaire entity = get(id);
		entity.setIntituleCodBud(codeBudgetaireRequestDto.getIntituleCodBud());
		entity.setCodBudActif(codeBudgetaireRequestDto.isCodBudActif());
		
		if(codeBudgetaireRequestDto.getCodTyp() != null) {
			CodeBudgType codeBudgType = gimCodeBudgTypeService.get(codeBudgetaireRequestDto.getCodTyp());
			entity.setCodeBudgType(codeBudgType);
		}
		
		return GimMapper.CodeBudgetaireToCodeBudgetaireResponseDto(entity);
	}
	
	@Override
	@Transactional
	public List<CodeBudgetaireStatistiqueDto> getCodeBudgetaireStatistiqueDto() {
		return repository.getCodeBudgetaireStatistiqueDto();
	}
}
