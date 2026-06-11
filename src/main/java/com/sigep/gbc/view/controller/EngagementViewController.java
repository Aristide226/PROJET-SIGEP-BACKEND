package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.EngagementViewService;
import com.sigep.gbc.view.dto.EngagementViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/engagementView")
@RequiredArgsConstructor
@CrossOrigin
public class EngagementViewController {
	private final EngagementViewService service;

	@GetMapping("/getEngagementModifiables/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementViewDto>> getEngagementModifiables(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementViewDto> list = service.getEngagementModifiables(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementViewDto>> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementViewDto> list = service.getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getEngagementValidables/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementViewDto>> getEngagementValidables(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementViewDto> list = service.getEngagementValidables(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getEngagementRetrogradables/{gestion}/{idBudget}/{idUser}")
	public ResponseEntity<List<EngagementViewDto>> getEngagementRetrogradables(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final String idUser) {
		List<EngagementViewDto> list = service.getEngagementRetrogradables(gestion, idBudget, idUser);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getEngagementValideEtNonTransmis/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementViewDto>> getEngagementValideEtNonTransmis(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementViewDto> list = service.getEngagementValideEtNonTransmis(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getEngagementValideEtTransmisEtReceptionne/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementViewDto>> getEngagementValideEtTransmisEtReceptionne(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementViewDto> list = service.getEngagementValideEtTransmisEtReceptionne(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getEngagementValideAE2EtNonTransmis/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementViewDto>> getEngagementValideAE2EtNonTransmis(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementViewDto> list = service.getEngagementValideAE2EtNonTransmis(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getEngagementRejeteAE3EtNonTransmis/{gestion}/{idBudget}")
	public ResponseEntity<List<EngagementViewDto>> getEngagementRejeteAE3EtNonTransmis(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<EngagementViewDto> list = service.getEngagementRejeteAE3EtNonTransmis(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
