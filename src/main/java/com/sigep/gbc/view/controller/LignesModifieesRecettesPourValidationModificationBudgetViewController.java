package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.LignesModifieesRecettesPourValidationModificationBudgetViewService;
import com.sigep.gbc.view.dto.LignesModifieesRecettesPourValidationModificationBudgetViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/lignesModifieesRecettesPourValidationModificationBudgetView")
@RequiredArgsConstructor
@CrossOrigin
public class LignesModifieesRecettesPourValidationModificationBudgetViewController {
	private final LignesModifieesRecettesPourValidationModificationBudgetViewService service;

	@GetMapping("/getLignesModifieesRecettesPourValidationModificationBudget/{gestion}/{idBudget}/{codBma}")
	public ResponseEntity<List<LignesModifieesRecettesPourValidationModificationBudgetViewDto>> getLignesModifieesRecettesPourValidationModificationBudget(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Long codBma) {
		List<LignesModifieesRecettesPourValidationModificationBudgetViewDto> list = service.getLignesModifieesRecettesPourValidationModificationBudget(gestion, idBudget, codBma);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
