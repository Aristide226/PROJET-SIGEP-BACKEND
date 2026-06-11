package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.CodeMaterielRequestDto;
import com.sigep.gim.dto.responseDto.CodeMaterielResponseDto;
import com.sigep.gim.entity.CodeBudgetaire;
import com.sigep.gim.entity.CodeMateriel;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimCodeMaterielRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimCodeMaterielServiceImpl implements GimCodeMaterielService {
	
	private final GimCodeMaterielRepository repository;
	private final GimCodeBudgetaireService gimCodeBudgetaireService;
	
	@Override
	@Transactional
	public CodeMaterielResponseDto add(CodeMaterielRequestDto codeMaterielRequestDto) {
		CodeMateriel entity = new CodeMateriel();
		entity.setCodMat(codeMaterielRequestDto.getCodMat());
		entity.setNum(codeMaterielRequestDto.getNum());
		entity.setIntituleMateriel(codeMaterielRequestDto.getIntituleMateriel());
		entity.setDureeVieAn(codeMaterielRequestDto.getDureeVieAn());
		entity.setArt(codeMaterielRequestDto.getArt());
		
		if(codeMaterielRequestDto.getCodBud() == null) {
			throw new IllegalArgumentException("CodeMateriel need a CodeBudgetaire");
		}
		CodeBudgetaire codeBudgetaire = gimCodeBudgetaireService.get(codeMaterielRequestDto.getCodBud());
		entity.setCodeBudgetaire(codeBudgetaire);
		repository.save(entity);
		return GimMapper.CodeMaterielToCodeMaterielResponseDto(entity);
	}
	
	@Override
	public List<CodeMaterielResponseDto> getAll() {
		List<CodeMateriel> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.CodeMaterielToCodeMaterielResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public CodeMateriel get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("CodeMateriel with id "+id+"could not be found")
		);
	}
	
	@Override
	public CodeMaterielResponseDto getById(String id) {
		CodeMateriel entity = get(id);
		return GimMapper.CodeMaterielToCodeMaterielResponseDto(entity);
	}
	
	@Override
	@Transactional
	public CodeMaterielResponseDto delete(String id) {
		CodeMateriel entity = get(id);
		repository.delete(entity);
		return GimMapper.CodeMaterielToCodeMaterielResponseDto(entity);
	}
	
	@Override
	@Transactional
	public CodeMaterielResponseDto edit(String id,CodeMaterielRequestDto codeMaterielRequestDto) {
		CodeMateriel entity = get(id);
		entity.setCodMat(codeMaterielRequestDto.getCodMat());
		entity.setNum(codeMaterielRequestDto.getNum());
		entity.setIntituleMateriel(codeMaterielRequestDto.getIntituleMateriel());
		entity.setDureeVieAn(codeMaterielRequestDto.getDureeVieAn());
		entity.setArt(codeMaterielRequestDto.getArt());
		
		if(codeMaterielRequestDto.getCodBud() != null) {
			CodeBudgetaire codeBudgetaire = gimCodeBudgetaireService.get(codeMaterielRequestDto.getCodBud());
			entity.setCodeBudgetaire(codeBudgetaire);
		}
		
		return GimMapper.CodeMaterielToCodeMaterielResponseDto(entity);
	}
}
