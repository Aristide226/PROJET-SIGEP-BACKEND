package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.DecisionSArticleDto;
import com.sigep.gbc.entity.DecisionSarticle;


@Service
public interface DecisionSArticleService {
	public DecisionSArticleDto add(DecisionSArticleDto decisionSArticleDto);
	public List<DecisionSArticleDto> getAll();
	public DecisionSarticle get(Integer id);
	public DecisionSArticleDto getById(Integer id);
	public DecisionSArticleDto delete(Integer id);
	public DecisionSArticleDto edit(Integer newId, Integer oldId, DecisionSArticleDto decisionSArticleDto);
	public Boolean existsById(Integer id);
}
