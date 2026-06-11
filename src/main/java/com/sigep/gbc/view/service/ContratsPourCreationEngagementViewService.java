package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.ContratsPourCreationEngagementViewDto;


@Service
public interface ContratsPourCreationEngagementViewService {
	public List<ContratsPourCreationEngagementViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget);
}
