package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.ContratsPourCreationEngagementViewService;
import com.sigep.gbc.view.dto.ContratsPourCreationEngagementViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/contratsPourCreationEngagementView")
@RequiredArgsConstructor
@CrossOrigin
public class ContratsPourCreationEngagementViewController {
	private final ContratsPourCreationEngagementViewService service;

	@GetMapping("/getByGestionAndIdBudget/{gestion}/{idBudget}")
	public ResponseEntity<List<ContratsPourCreationEngagementViewDto>> getByGestionAndIdBudget(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<ContratsPourCreationEngagementViewDto> list = service.getByGestionAndIdBudget(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
