package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sigep.gbc.view.service.AgentAccesCodeAccesCodeNiveauGrpeCodeViewService;
import com.sigep.gbc.view.dto.AgentAccesCodeAccesCodeNiveauGrpeCodeViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/agentAccesCodeAccesCodeNiveauGrpeCodeView")
@RequiredArgsConstructor
@CrossOrigin
public class AgentAccesCodeAccesCodeNiveauGrpeCodeViewController {
	private final AgentAccesCodeAccesCodeNiveauGrpeCodeViewService service;

	@GetMapping("/get/{code}")
	public ResponseEntity<List<AgentAccesCodeAccesCodeNiveauGrpeCodeViewDto>> getByCode(@PathVariable final String code) {
		List<AgentAccesCodeAccesCodeNiveauGrpeCodeViewDto> list = service.getByCode(code);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	

}
