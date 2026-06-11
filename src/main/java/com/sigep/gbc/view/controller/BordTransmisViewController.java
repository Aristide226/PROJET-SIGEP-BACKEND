package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.BordTransmisViewService;
import com.sigep.gbc.view.dto.BordTransmisViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/bordTransmisView")
@RequiredArgsConstructor
@CrossOrigin
public class BordTransmisViewController {
	private final BordTransmisViewService service;
	
	@GetMapping("/getBordTransmisEtNonReceptionne/{gestion}/{idBudget}")
	public ResponseEntity<List<BordTransmisViewDto>> getBordTransmisEtNonReceptionne(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<BordTransmisViewDto> list = service.getBordTransmisEtNonReceptionne(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
