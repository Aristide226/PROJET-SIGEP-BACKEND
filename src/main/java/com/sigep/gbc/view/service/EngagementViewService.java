package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.EngagementViewDto;


@Service
public interface EngagementViewService {
	public List<EngagementViewDto> getEngagementModifiables(Short gestion, Integer idBudget);
	public List<EngagementViewDto> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(Short gestion, Integer idBudget);
	public List<EngagementViewDto> getEngagementValidables(Short gestion, Integer idBudget);
	public List<EngagementViewDto> getEngagementRetrogradables(Short gestion, Integer idBudget, String idUser);
	public List<EngagementViewDto> getEngagementValideEtNonTransmis(Short gestion, Integer idBudget);
	public List<EngagementViewDto> getEngagementValideEtTransmisEtReceptionne(Short gestion, Integer idBudget);
	public List<EngagementViewDto> getEngagementValideAE2EtNonTransmis(Short gestion, Integer idBudget);
	public List<EngagementViewDto> getEngagementRejeteAE3EtNonTransmis(Short gestion, Integer idBudget);
}
