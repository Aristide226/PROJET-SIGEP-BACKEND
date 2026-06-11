package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.LignesModifieesRecettesPourAnnulerValidationReamenagementViewDto;


@Service
public interface LignesModifieesRecettesPourAnnulerValidationReamenagementViewService {
	public List<LignesModifieesRecettesPourAnnulerValidationReamenagementViewDto> getLignesModifieesRecettesPourAnnulerValidationReamenagement(Short gestion, Integer idBudget, Long codReam);
}
