package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.ContratsViewDto;


@Service
public interface ContratsViewService {
	public List<ContratsViewDto> getByIdBudget(Integer idBudget);
	public List<ContratsViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget);
	public List<ContratsViewDto> getContratsPartiellementEngages(Short gestion, Integer idBudget);
	public ContratsViewDto getByIdContrat(Long idContrat);
}
