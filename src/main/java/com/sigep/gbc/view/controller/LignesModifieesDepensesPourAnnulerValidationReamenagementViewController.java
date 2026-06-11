package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.LignesModifieesDepensesPourAnnulerValidationReamenagementViewService;
import com.sigep.gbc.view.dto.LignesModifieesDepensesPourAnnulerValidationReamenagementViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/lignesModifieesDepensesPourAnnulerValidationReamenagementView")
@RequiredArgsConstructor
@CrossOrigin
public class LignesModifieesDepensesPourAnnulerValidationReamenagementViewController {
	private final LignesModifieesDepensesPourAnnulerValidationReamenagementViewService service;

	@GetMapping("/getLignesModifieesDepensesPourAnnulerValidationReamenagement/{gestion}/{idBudget}/{codReam}")
	public ResponseEntity<List<LignesModifieesDepensesPourAnnulerValidationReamenagementViewDto>> getLignesModifieesDepensesPourAnnulerValidationReamenagement(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Long codReam) {
		List<LignesModifieesDepensesPourAnnulerValidationReamenagementViewDto> list = service.getLignesModifieesDepensesPourAnnulerValidationReamenagement(gestion, idBudget, codReam);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
