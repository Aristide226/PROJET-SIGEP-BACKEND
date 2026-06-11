package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.LignesModifieesRecettesPourValidationReamenagementViewService;
import com.sigep.gbc.view.dto.LignesModifieesRecettesPourValidationReamenagementViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/lignesModifieesRecettesPourValidationReamenagementView")
@RequiredArgsConstructor
@CrossOrigin
public class LignesModifieesRecettesPourValidationReamenagementViewController {
	private final LignesModifieesRecettesPourValidationReamenagementViewService service;

	@GetMapping("/getLignesModifieesRecettesPourValidationReamenagement/{gestion}/{idBudget}/{codReam}")
	public ResponseEntity<List<LignesModifieesRecettesPourValidationReamenagementViewDto>> getLignesModifieesRecettesPourValidationReamenagement(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Long codReam) {
		List<LignesModifieesRecettesPourValidationReamenagementViewDto> list = service.getLignesModifieesRecettesPourValidationReamenagement(gestion, idBudget, codReam);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
