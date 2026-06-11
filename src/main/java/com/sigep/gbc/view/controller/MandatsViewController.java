package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sigep.gbc.view.service.MandatsViewService;
import com.sigep.gbc.view.dto.MandatsViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/mandatsView")
@RequiredArgsConstructor
@CrossOrigin
public class MandatsViewController {
	private final MandatsViewService service;
	
	@GetMapping("/getMandatValideAE2EtSansBordereaus/{gestion}/{idBudget}")
	public ResponseEntity<List<MandatsViewDto>> getMandatValideAE2EtSansBordereaus(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<MandatsViewDto> list = service.getMandatValideAE2EtSansBordereaus(gestion, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
