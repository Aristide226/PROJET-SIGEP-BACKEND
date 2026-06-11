package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.DepensesPourReamenagementViewService;
import com.sigep.gbc.view.dto.DepensesPourReamenagementViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/depensesPourReamenagementView")
@RequiredArgsConstructor
@CrossOrigin
public class DepensesPourReamenagementViewController {
	private final DepensesPourReamenagementViewService service;

	@GetMapping("/getByGestionAndIdBudget/{gestion}/{idBudget}")
	public ResponseEntity<List<DepensesPourReamenagementViewDto>> getByGestionAndIdBudget(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<DepensesPourReamenagementViewDto> list = service.getByGestionAndIdBudget(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
