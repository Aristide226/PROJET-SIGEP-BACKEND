package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sigep.gbc.view.service.AccesLigneBudgetaireNomenclatureDBudgetViewService;
import com.sigep.gbc.view.dto.AccesLigneBudgetaireNomenclatureDBudgetViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/accesLigneBudgetaireNomenclatureDBudgetView")
@RequiredArgsConstructor
@CrossOrigin
public class AccesLigneBudgetaireNomenclatureDBudgetaireViewController {
	private final AccesLigneBudgetaireNomenclatureDBudgetViewService service;

	@GetMapping("/get/{userName}/{gestion}/{idBudget}")
	public ResponseEntity<List<AccesLigneBudgetaireNomenclatureDBudgetViewDto>> getByUserNameAndGestionAndIdBudget(@PathVariable final String userName, @PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<AccesLigneBudgetaireNomenclatureDBudgetViewDto> accesLigneBudgetaireNomenclatureDBudgetViewDtos = service.findByUserNameAndGestionAndIdBudget(userName, gestion, idBudget);
		return new ResponseEntity<>(accesLigneBudgetaireNomenclatureDBudgetViewDtos, HttpStatus.OK);
	}

}
