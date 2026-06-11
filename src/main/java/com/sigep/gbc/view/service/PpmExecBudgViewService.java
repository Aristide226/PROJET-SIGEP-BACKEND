package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sigep.gbc.view.dto.PpmExecBudgViewDto;


@Service
public interface PpmExecBudgViewService {
	public List<PpmExecBudgViewDto> getByExerciceAndIdBudget(Short exercice, Integer idBudget);
}
