package com.sigep.gbc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.dto.requestDto.GestionRequestDto;
import com.sigep.gbc.dto.responseDto.GestionResponsetDto;
import com.sigep.gbc.service.GestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/gestion")
@RequiredArgsConstructor
@CrossOrigin
public class GestionController {
	private final GestionService service;

	@PostMapping("/add")
	public ResponseEntity<GestionResponsetDto> add(@RequestBody final GestionRequestDto gestionRequestDto) {
		GestionResponsetDto gestionResponsetDto = service.add(gestionRequestDto);
		return new ResponseEntity<>(gestionResponsetDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<GestionResponsetDto>> getAll() {
		List<GestionResponsetDto> gestionResponsetDtos = service.getAll();
		return new ResponseEntity<>(gestionResponsetDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<GestionResponsetDto> getById(@PathVariable final Short id) {
		GestionResponsetDto gestionResponsetDto = service.getById(id);
		return new ResponseEntity<>(gestionResponsetDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GestionResponsetDto> delete(@PathVariable final Short id) {
		GestionResponsetDto gestionResponsetDto = service.delete(id);
		return new ResponseEntity<>(gestionResponsetDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<GestionResponsetDto> edit(@PathVariable final Short id, @RequestBody final GestionRequestDto gestionRequestDto) {
		GestionResponsetDto gestionResponsetDto = service.edit(id, gestionRequestDto);
		return new ResponseEntity<>(gestionResponsetDto, HttpStatus.OK);
	}

	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> exists(@PathVariable final Short id) {
		Boolean result = service.exists(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/getLastByEtat/{etat}")
	public ResponseEntity<GestionResponsetDto> getLastByEtat(@PathVariable final String etat) {
		GestionResponsetDto gestionResponsetDto = service.getLastByEtat(etat);
		return new ResponseEntity<>(gestionResponsetDto, HttpStatus.OK);
	}

	@GetMapping("/getAllByEtatOrderByCouranteDesc/{etat}")
	public ResponseEntity<List<GestionResponsetDto>> getAllByEtatOrderByCouranteDesc(@PathVariable final String etat) {
		List<GestionResponsetDto> gestionResponsetDtos = service.getAllByEtatOrderByCouranteDesc(etat);
		return new ResponseEntity<>(gestionResponsetDtos, HttpStatus.OK);
	}

}
