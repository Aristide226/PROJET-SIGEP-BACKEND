package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.view.entity.PpmExecBudgView;
import com.sigep.gbc.view.dto.PpmExecBudgViewDto;
import com.sigep.gbc.view.repository.PpmExecBudgViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class PpmExecBudgViewServiceImpl implements PpmExecBudgViewService{
	private final PpmExecBudgViewRepository repository;
	
	@Override
	public List<PpmExecBudgViewDto> getByExerciceAndIdBudget(Short exercice, Integer idBudget) {
		List<PpmExecBudgView> list = repository.getByExerciceAndIdBudget(exercice, idBudget);
		return list
				.stream().map(element  -> GbcMapper2.ppmExecBudgViewToPpmExecBudgViewDto(element))
				.collect(Collectors.toList());
	}
}
