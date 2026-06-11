package com.sigep.gim.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.CodeAccesHistoRequestDto;
import com.sigep.gim.dto.responseDto.CodeAccesHistoResponseDto;
import com.sigep.gim.entity.CodeAccesHisto;
import com.sigep.gim.entity.CodeAccesHistoId;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimCodeAccesHistoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimCodeAccesHistoServiceImpl implements GimCodeAccesHistoService {
	
	private final GimCodeAccesHistoRepository repository;
	
	@Override
	@Transactional
	public CodeAccesHistoResponseDto add(CodeAccesHistoRequestDto codeAccesHistoRequestDto) {
		int id = findMaxId() + 1;
		CodeAccesHisto entity = new CodeAccesHisto();
		entity.setId(new CodeAccesHistoId(
				id,
				codeAccesHistoRequestDto.getDateChangement()
		));
		entity.setMotPasse(codeAccesHistoRequestDto.getMotPasse());
		repository.save(entity);
		return GimMapper.CodeAccesHistoToCodeAccesHistoResponseDto(entity);
	}
	
	@Override
	public List<CodeAccesHistoResponseDto> getAll() {
		List<CodeAccesHisto> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.CodeAccesHistoToCodeAccesHistoResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public CodeAccesHisto get(int id, Date dateChangement) {
		CodeAccesHistoId idCodeAccesHisto = new CodeAccesHistoId();
		idCodeAccesHisto.setId(id);
		idCodeAccesHisto.setDateChangement(dateChangement);
		return repository.findById(idCodeAccesHisto).orElseThrow(() -> 
			new IllegalArgumentException("CodeAccesHisto with id "+id+"could not be found")
		);
	}
	
	@Override
	public CodeAccesHistoResponseDto getById(int id, Date dateChangement) {
		CodeAccesHisto entity = get(id,dateChangement);
		return GimMapper.CodeAccesHistoToCodeAccesHistoResponseDto(entity);
	}
	
	@Override
	@Transactional
	public CodeAccesHistoResponseDto delete(int id, Date dateChangement) {
		CodeAccesHisto entity = get(id,dateChangement);
		repository.delete(entity);
		return GimMapper.CodeAccesHistoToCodeAccesHistoResponseDto(entity);
	}
	
	@Override
	@Transactional
	public CodeAccesHistoResponseDto edit(int id, Date dateChangement,CodeAccesHistoRequestDto codeAccesHistoRequestDto) {
		CodeAccesHisto entity = get(id,dateChangement);
		entity.setMotPasse(codeAccesHistoRequestDto.getMotPasse());
		return GimMapper.CodeAccesHistoToCodeAccesHistoResponseDto(entity);
	}
	
	@Override
	@Transactional
	public Integer findMaxId() {
		return repository.findMaxId();
	}
}
