package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewService;
import com.sigep.gbc.view.dto.LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/lignesModifieesRecettesPourAnnulerValidationModificationBudgetView")
@RequiredArgsConstructor
@CrossOrigin
public class LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewController {
	private final LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewService service;

	@GetMapping("/getLignesModifieesRecettesPourAnnulerValidationModificationBudget/{gestion}/{idBudget}/{codBma}")
	public ResponseEntity<List<LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewDto>> getLignesModifieesRecettesPourAnnulerValidationModificationBudget(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Long codBma) {
		List<LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewDto> list = service.getLignesModifieesRecettesPourAnnulerValidationModificationBudget(gestion, idBudget, codBma);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
