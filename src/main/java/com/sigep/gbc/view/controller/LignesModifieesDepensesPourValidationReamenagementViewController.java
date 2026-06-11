package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.LignesModifieesDepensesPourValidationReamenagementViewService;
import com.sigep.gbc.view.dto.LignesModifieesDepensesPourValidationReamenagementViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/lignesModifieesDepensesPourValidationReamenagementView")
@RequiredArgsConstructor
@CrossOrigin
public class LignesModifieesDepensesPourValidationReamenagementViewController {
	private final LignesModifieesDepensesPourValidationReamenagementViewService service;

	@GetMapping("/getLignesModifieesDepensesPourValidationReamenagement/{gestion}/{idBudget}/{codReam}")
	public ResponseEntity<List<LignesModifieesDepensesPourValidationReamenagementViewDto>> getLignesModifieesDepensesPourValidationReamenagement(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Long codReam) {
		List<LignesModifieesDepensesPourValidationReamenagementViewDto> list = service.getLignesModifieesDepensesPourValidationReamenagement(gestion, idBudget, codReam);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
