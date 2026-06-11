package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.ContratsViewService;
import com.sigep.gbc.view.dto.ContratsViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/contratsView")
@RequiredArgsConstructor
@CrossOrigin
public class ContratsViewController {
	private final ContratsViewService service;
	
	@GetMapping("/getByIdBudget/{idBudget}")
	public ResponseEntity<List<ContratsViewDto>> getByIdBudget(@PathVariable final Integer idBudget) {
		List<ContratsViewDto> list = service.getByIdBudget(idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getByGestionAndIdBudget/{gestion}/{idBudget}")
	public ResponseEntity<List<ContratsViewDto>> getByGestionAndIdBudget(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<ContratsViewDto> list = service.getByGestionAndIdBudget(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getContratsPartiellementEngages/{gestion}/{idBudget}")
	public ResponseEntity<List<ContratsViewDto>> getContratsPartiellementEngages(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<ContratsViewDto> list = service.getContratsPartiellementEngages(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getByIdContrat/{idContrat}")
	public ResponseEntity<ContratsViewDto> getByIdContrat(@PathVariable final Long idContrat) {
		ContratsViewDto dto = service.getByIdContrat(idContrat);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
