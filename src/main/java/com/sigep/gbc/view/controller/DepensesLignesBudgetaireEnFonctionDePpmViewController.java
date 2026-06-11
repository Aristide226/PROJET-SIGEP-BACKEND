//Aristide
package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.dto.DepensesLignesBudgetaireEnFonctionDePpmViewDto;
import com.sigep.gbc.view.service.DepensesLignesBudgetaireEnFonctionDePpmViewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/depensesLignesBudgetaireEnFonctionDePpmView")
@RequiredArgsConstructor
@CrossOrigin
public class DepensesLignesBudgetaireEnFonctionDePpmViewController {
	private final DepensesLignesBudgetaireEnFonctionDePpmViewService service;
	
	@GetMapping("/getByGestionAndIdBudgetAndIdPpm/{gestion}/{idBudget}/{idPpm}")
	public ResponseEntity<List<DepensesLignesBudgetaireEnFonctionDePpmViewDto>> getByGestionAndIdBudgetAndIdPpm(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final String idPpm) {
		List<DepensesLignesBudgetaireEnFonctionDePpmViewDto> list = service.getByGestionAndIdBudgetAndIdPpm(gestion, idBudget,idPpm);
		return new ResponseEntity <> (list , HttpStatus.OK);
	}
}
