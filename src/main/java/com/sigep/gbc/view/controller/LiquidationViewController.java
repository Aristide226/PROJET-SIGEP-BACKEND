package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sigep.gbc.view.service.LiquidationViewService;
import com.sigep.gbc.view.dto.LiquidationViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/liquidationView")
@RequiredArgsConstructor
@CrossOrigin
public class LiquidationViewController {
	private final LiquidationViewService service;
	
	@GetMapping("/getByGestionAndIdBudgetOrderByNumBlDesc/{gestion}/{idBudget}")
	public ResponseEntity<List<LiquidationViewDto>> getByGestionAndIdBudgetOrderByNumBlDesc(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<LiquidationViewDto> list = service.getByGestionAndIdBudgetOrderByNumBlDesc(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getReçuModifiables/{gestion}/{idBudget}")
	public ResponseEntity<List<LiquidationViewDto>> getReçuModifiables(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<LiquidationViewDto> list = service.getReçuModifiables(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getReçuSansMandats/{gestion}/{idBudget}")
	public ResponseEntity<List<LiquidationViewDto>> getReçuSansMandats(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<LiquidationViewDto> list = service.getReçuSansMandats(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getLiquidationModifiables/{gestion}/{idBudget}")
	public ResponseEntity<List<LiquidationViewDto>> getLiquidationModifiables(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<LiquidationViewDto> list = service.getLiquidationModifiables(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getByGestionAndIdBudgetOrderByNumBeDesc/{gestion}/{idBudget}")
	public ResponseEntity<List<LiquidationViewDto>> getByGestionAndIdBudgetOrderByNumBeDesc(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<LiquidationViewDto> list = service.getByGestionAndIdBudgetOrderByNumBeDesc(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getLiquidationValidables/{gestion}/{idBudget}")
	public ResponseEntity<List<LiquidationViewDto>> getLiquidationValidables(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<LiquidationViewDto> list = service.getLiquidationValidables(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getLiquidationRetrogradables/{gestion}/{idBudget}/{idUser}")
	public ResponseEntity<List<LiquidationViewDto>> getLiquidationRetrogradables(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final String idUser) {
		List<LiquidationViewDto> list = service.getLiquidationRetrogradables(gestion, idBudget, idUser);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
