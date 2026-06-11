package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.LignesModifieesDepensesPourValidationReamenagementViewDto;


@Service
public interface LignesModifieesDepensesPourValidationReamenagementViewService {
	public List<LignesModifieesDepensesPourValidationReamenagementViewDto> getLignesModifieesDepensesPourValidationReamenagement(Short gestion, Integer idBudget, Long codReam);
}
