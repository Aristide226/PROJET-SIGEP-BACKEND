package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.view.service.AgentsDirectionServiceSDestinatairesViewService;
import com.sigep.gbc.view.dto.AgentsDirectionServiceSDestinatairesViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/agentsDirectionServiceSDestinatairesView")
@RequiredArgsConstructor
@CrossOrigin
public class AgentsDirectionServiceSDestinatairesViewController {
	private final AgentsDirectionServiceSDestinatairesViewService service;

	@GetMapping("/getAll")
	public ResponseEntity<List<AgentsDirectionServiceSDestinatairesViewDto>> getAll() {
		List<AgentsDirectionServiceSDestinatairesViewDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
