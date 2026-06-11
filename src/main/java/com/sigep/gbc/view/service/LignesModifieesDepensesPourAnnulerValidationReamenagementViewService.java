package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.LignesModifieesDepensesPourAnnulerValidationReamenagementViewDto;


@Service
public interface LignesModifieesDepensesPourAnnulerValidationReamenagementViewService {
	public List<LignesModifieesDepensesPourAnnulerValidationReamenagementViewDto> getLignesModifieesDepensesPourAnnulerValidationReamenagement(Short gestion, Integer idBudget, Long codReam);
}
