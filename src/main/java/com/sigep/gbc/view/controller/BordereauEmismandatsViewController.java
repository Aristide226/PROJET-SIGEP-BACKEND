package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.BordereauEmismandatsViewService;
import com.sigep.gbc.view.dto.BordereauEmismandatsViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/bordereauEmismandatsView")
@RequiredArgsConstructor
@CrossOrigin
public class BordereauEmismandatsViewController {
	private final BordereauEmismandatsViewService service;

	@GetMapping("/getByGestionAndIdBudgetAndDossier/{gestion}/{idBudget}/{dossier}")
	public ResponseEntity<List<BordereauEmismandatsViewDto>> getByGestionAndIdBudgetAndDossier(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final String dossier) {
		List<BordereauEmismandatsViewDto> list = service.getByGestionAndIdBudgetAndDossier(gestion, idBudget, dossier);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
