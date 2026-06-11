package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.LignesModifieesDepensesPourValidationModificationBudgetViewService;
import com.sigep.gbc.view.dto.LignesModifieesDepensesPourValidationModificationBudgetViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/lignesModifieesDepensesPourValidationModificationBudgetView")
@RequiredArgsConstructor
@CrossOrigin
public class LignesModifieesDepensesPourValidationModificationBudgetViewController {
	private final LignesModifieesDepensesPourValidationModificationBudgetViewService service;

	@GetMapping("/getLignesModifieesDepensesPourValidationModificationBudget/{gestion}/{idBudget}/{codBma}")
	public ResponseEntity<List<LignesModifieesDepensesPourValidationModificationBudgetViewDto>> getLignesModifieesDepensesPourValidationModificationBudget(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Long codBma) {
		List<LignesModifieesDepensesPourValidationModificationBudgetViewDto> list = service.getLignesModifieesDepensesPourValidationModificationBudget(gestion, idBudget, codBma);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
