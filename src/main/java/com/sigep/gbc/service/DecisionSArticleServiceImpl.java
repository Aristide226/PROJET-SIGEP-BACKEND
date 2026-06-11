package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.DecisionSArticleDto;
import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.entity.DecisionSarticle;
import com.sigep.gbc.repository.DecisionSArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DecisionSArticleServiceImpl implements DecisionSArticleService {
	
	private final DecisionSArticleRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public DecisionSArticleDto add(DecisionSArticleDto decisionSArticleDto) {
		DecisionSarticle entity = new DecisionSarticle();
		entity.setNumArticle(decisionSArticleDto.getNumArticle());
		entity.setIntituleArticle(decisionSArticleDto.getIntituleArticle());
		entity.setIntituleArticleReam(decisionSArticleDto.getIntituleArticleReam());
		
		repository.save(entity);
		return GbcMapper.dsaToDsaDto(entity);
	}

	@Override
	public List<DecisionSArticleDto> getAll() {
		List<DecisionSarticle> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.dsaToDsaDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public DecisionSarticle get(Integer id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("DecisionSarticle with id: " + id + " could not be found"));
	}

	@Override
	public DecisionSArticleDto getById(Integer id) {
		DecisionSarticle entity = get(id);
		return GbcMapper.dsaToDsaDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public DecisionSArticleDto delete(Integer id) {
		DecisionSarticle entity = get(id);
		repository.delete(entity);
		return GbcMapper.dsaToDsaDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public DecisionSArticleDto edit(Integer newId, Integer oldId, DecisionSArticleDto decisionSArticleDto) {
		repository.update(
				newId,
				oldId, 
				decisionSArticleDto.getIntituleArticle(), 
				decisionSArticleDto.getIntituleArticleReam()
			);
		
		DecisionSarticle entity = get(newId);
		return GbcMapper.dsaToDsaDto(entity);
	}
	
	@Override
	public Boolean existsById(Integer id) {
		return repository.existsById(id);
	}
}
