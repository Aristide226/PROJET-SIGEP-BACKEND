package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewService;
import com.sigep.gbc.view.dto.LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/lignesModifieesDepensesPourAnnulerValidationModificationBudgetView")
@RequiredArgsConstructor
@CrossOrigin
public class LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewController {
	private final LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewService service;

	@GetMapping("/getLignesModifieesDepensesPourAnnulerValidationModificationBudget/{gestion}/{idBudget}/{codBma}")
	public ResponseEntity<List<LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewDto>> getLignesModifieesDepensesPourAnnulerValidationModificationBudget(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Long codBma) {
		List<LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewDto> list = service.getLignesModifieesDepensesPourAnnulerValidationModificationBudget(gestion, idBudget, codBma);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
