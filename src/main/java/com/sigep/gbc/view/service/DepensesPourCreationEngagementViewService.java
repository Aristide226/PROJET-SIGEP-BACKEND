package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.DepensesPourCreationEngagementViewDto;


@Service
public interface DepensesPourCreationEngagementViewService {
	public List<DepensesPourCreationEngagementViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget);
}
