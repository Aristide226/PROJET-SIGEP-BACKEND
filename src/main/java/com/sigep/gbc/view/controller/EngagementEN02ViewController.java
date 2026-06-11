package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.EngagementEN02ViewService;
import com.sigep.gbc.view.dto.EngagementEN02ViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/engagementEN02View")
@RequiredArgsConstructor
@CrossOrigin
public class EngagementEN02ViewController {
	private final EngagementEN02ViewService service;

	@GetMapping("/getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementEN02ViewDto>> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementEN02ViewDto> list = service.getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getByGestionAndIdBudgetAndBenum/{gestion}/{idBudget}/{benum}")
	public ResponseEntity<EngagementEN02ViewDto> getByGestionAndIdBudgetAndBenum(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Integer benum) {
		EngagementEN02ViewDto responseDto = service.getByGestionAndIdBudgetAndBenum(gestion, idBudget, benum);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getEngagementModifiables/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementEN02ViewDto>> getEngagementModifiables(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementEN02ViewDto> list = service.getEngagementModifiables(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
