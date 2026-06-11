package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.LignesModifieesRecettesPourAnnulerValidationReamenagementViewService;
import com.sigep.gbc.view.dto.LignesModifieesRecettesPourAnnulerValidationReamenagementViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/lignesModifieesRecettesPourAnnulerValidationReamenagementView")
@RequiredArgsConstructor
@CrossOrigin
public class LignesModifieesRecettesPourAnnulerValidationReamenagementViewController {
	private final LignesModifieesRecettesPourAnnulerValidationReamenagementViewService service;

	@GetMapping("/getLignesModifieesRecettesPourAnnulerValidationReamenagement/{gestion}/{idBudget}/{codReam}")
	public ResponseEntity<List<LignesModifieesRecettesPourAnnulerValidationReamenagementViewDto>> getLignesModifieesRecettesPourAnnulerValidationReamenagement(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Long codReam) {
		List<LignesModifieesRecettesPourAnnulerValidationReamenagementViewDto> list = service.getLignesModifieesRecettesPourAnnulerValidationReamenagement(gestion, idBudget, codReam);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
