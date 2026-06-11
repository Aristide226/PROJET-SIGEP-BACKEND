//Aristide
package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.DepensesLignesBudgetaireEnFonctionDePpmViewDto;

@Service
public interface DepensesLignesBudgetaireEnFonctionDePpmViewService {
	public List<DepensesLignesBudgetaireEnFonctionDePpmViewDto> getByGestionAndIdBudgetAndIdPpm(Short gestion, Integer idBudget,String idPpm);
}
