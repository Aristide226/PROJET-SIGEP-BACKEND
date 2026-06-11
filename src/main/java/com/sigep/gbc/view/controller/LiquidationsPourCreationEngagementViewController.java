package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.LiquidationsPourCreationEngagementViewService;
import com.sigep.gbc.view.dto.LiquidationsPourCreationEngagementViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/liquidationsPourCreationEngagementView")
@RequiredArgsConstructor
@CrossOrigin
public class LiquidationsPourCreationEngagementViewController {
	private final LiquidationsPourCreationEngagementViewService service;

	@GetMapping("/getByGestion/{gestion}")
	public ResponseEntity<List<LiquidationsPourCreationEngagementViewDto>> getByGestion(@PathVariable final Short gestion) {
		List<LiquidationsPourCreationEngagementViewDto> list = service.getByGestion(gestion);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
