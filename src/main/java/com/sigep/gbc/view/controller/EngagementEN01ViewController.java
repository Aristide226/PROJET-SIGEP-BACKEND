package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.EngagementEN01ViewService;
import com.sigep.gbc.view.dto.EngagementEN01ViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/engagementEN01View")
@RequiredArgsConstructor
@CrossOrigin
public class EngagementEN01ViewController {
	private final EngagementEN01ViewService service;

	@GetMapping("/getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementEN01ViewDto>> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementEN01ViewDto> list = service.getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getByGestionAndIdBudgetAndBenum/{gestion}/{idBudget}/{benum}")
	public ResponseEntity<EngagementEN01ViewDto> getByGestionAndIdBudgetAndBenum(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Integer benum) {
		EngagementEN01ViewDto responseDto = service.getByGestionAndIdBudgetAndBenum(gestion, idBudget, benum);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getEngagementModifiables/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementEN01ViewDto>> getEngagementModifiables(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementEN01ViewDto> list = service.getEngagementModifiables(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getLesEngagementsPartiellementLiquides/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementEN01ViewDto>> getLesEngagementsPartiellementLiquides(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementEN01ViewDto> list = service.getLesEngagementsPartiellementLiquides(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getBonDAnnulationModifiables/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementEN01ViewDto>> getBonDAnnulationModifiables(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementEN01ViewDto> list = service.getBonDAnnulationModifiables(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getByNumBe/{numbe}")
	public ResponseEntity<EngagementEN01ViewDto> getByNumBe(@PathVariable final Long numbe) {
		EngagementEN01ViewDto responseDto = service.getByNumBe(numbe);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getEngagementEN01ValideAE2EtTransmisEtPartiellementLiquides/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementEN01ViewDto>> getEngagementEN01ValideAE2EtTransmisEtPartiellementLiquides(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementEN01ViewDto> list = service.getEngagementEN01ValideAE2EtTransmisEtPartiellementLiquides(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
