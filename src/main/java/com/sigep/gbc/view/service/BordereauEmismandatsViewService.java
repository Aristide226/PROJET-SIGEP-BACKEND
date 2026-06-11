package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.BordereauEmismandatsViewDto;


@Service
public interface BordereauEmismandatsViewService {
	public List<BordereauEmismandatsViewDto> getByGestionAndIdBudgetAndDossier(Short gestion, Integer idBudget, String dossier);
}
