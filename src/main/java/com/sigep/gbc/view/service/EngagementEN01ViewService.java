package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.EngagementEN01ViewDto;


@Service
public interface EngagementEN01ViewService {
	public List<EngagementEN01ViewDto> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(Short gestion, Integer idBudget);
	public EngagementEN01ViewDto getByGestionAndIdBudgetAndBenum(Short gestion, Integer idBudget, Integer benum);
	
	public List<EngagementEN01ViewDto> getEngagementModifiables(Short gestion, Integer idBudget);
	
	public List<EngagementEN01ViewDto> getLesEngagementsPartiellementLiquides(Short gestion, Integer idBudget);

	public List<EngagementEN01ViewDto> getBonDAnnulationModifiables(Short gestion, Integer idBudget);
	
	public EngagementEN01ViewDto getByNumBe(Long numbe);

	public List<EngagementEN01ViewDto> getEngagementEN01ValideAE2EtTransmisEtPartiellementLiquides(Short gestion, Integer idBudget);
}
