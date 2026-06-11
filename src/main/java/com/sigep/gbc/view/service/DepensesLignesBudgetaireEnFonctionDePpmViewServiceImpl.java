//Aristide
package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.DepensesLignesBudgetaireEnFonctionDePpmView;
import com.sigep.gbc.view.dto.DepensesLignesBudgetaireEnFonctionDePpmViewDto;
import com.sigep.gbc.view.repository.DepensesLignesBudgetaireEnFonctionDePpmViewRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class DepensesLignesBudgetaireEnFonctionDePpmViewServiceImpl implements DepensesLignesBudgetaireEnFonctionDePpmViewService {
	private final DepensesLignesBudgetaireEnFonctionDePpmViewRepository repository;
	
	private final ModelMapper modelMapper;
	
	@Override
	public List<DepensesLignesBudgetaireEnFonctionDePpmViewDto> getByGestionAndIdBudgetAndIdPpm(Short gestion, Integer idBudget,String idPpm) {
		List<DepensesLignesBudgetaireEnFonctionDePpmView> list = repository.findByGestionAndIdBudgetAndIdPPM(gestion, idBudget,idPpm);
		return list
				.stream().map(element -> modelMapper.map(element, DepensesLignesBudgetaireEnFonctionDePpmViewDto.class))
				.collect(Collectors.toList());
	}
}
