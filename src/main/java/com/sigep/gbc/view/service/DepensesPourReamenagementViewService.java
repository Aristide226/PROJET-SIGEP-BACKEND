package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.DepensesPourReamenagementViewDto;


@Service
public interface DepensesPourReamenagementViewService {
	public List<DepensesPourReamenagementViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget);
}
