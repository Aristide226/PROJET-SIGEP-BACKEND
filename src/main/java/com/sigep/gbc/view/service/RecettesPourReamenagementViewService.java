package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.RecettesPourReamenagementViewDto;


@Service
public interface RecettesPourReamenagementViewService {
	public List<RecettesPourReamenagementViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget);
}
