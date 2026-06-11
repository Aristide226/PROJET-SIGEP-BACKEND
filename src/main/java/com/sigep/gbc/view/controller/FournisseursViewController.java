package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sigep.gbc.view.service.FournisseursViewService;
import com.sigep.gbc.view.dto.FournisseursViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/fournisseurView")
@RequiredArgsConstructor
@CrossOrigin
public class FournisseursViewController {
	private final FournisseursViewService service;

	@GetMapping("/getAll")
	public ResponseEntity<List<FournisseursViewDto>> getAll() {
		List<FournisseursViewDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
