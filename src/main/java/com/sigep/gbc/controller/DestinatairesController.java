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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.dto.requestDto.DestinatairesRequestDto;
import com.sigep.gbc.dto.responseDto.DestinatairesResponseDto;
import com.sigep.gbc.service.DestinatairesService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/destinataires")
@RequiredArgsConstructor
@CrossOrigin
public class DestinatairesController {
	private final DestinatairesService service;

	@PostMapping("/add")
	public ResponseEntity<Void> add(@RequestBody final DestinatairesRequestDto destinatairesRequestDto) {
		service.add(destinatairesRequestDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<DestinatairesResponseDto>> getAll() {
		List<DestinatairesResponseDto> destinatairesResponseDtos = service.getAll();
		return new ResponseEntity<>(destinatairesResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<DestinatairesResponseDto>  getById(@PathVariable final long id) {
		DestinatairesResponseDto destinatairesResponseDto = service.getById(id);
		return new ResponseEntity<>(destinatairesResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DestinatairesResponseDto>  delete(@PathVariable final long id) {
		DestinatairesResponseDto destinatairesResponseDto = service.delete(id);
		return new ResponseEntity<>(destinatairesResponseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Void>  edit(@PathVariable final long id, @RequestBody final DestinatairesRequestDto destinatairesRequestDto) {
		service.edit(id, destinatairesRequestDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getDestinataireSansAgents")
	public ResponseEntity<List<DestinatairesResponseDto>> getDestinataireSansAgents() {
		List<DestinatairesResponseDto> destinatairesResponseDtos = service.getDestinataireSansAgents();
		return new ResponseEntity<>(destinatairesResponseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/existsByIfumleAndIfumleNot")
	public ResponseEntity<Boolean> existsByIfumleAndIfumleNot(@RequestParam(required = false) String ifumle, @RequestParam String excludedValue) {
		Boolean result = service.existsByIfumleAndIfumleNot(ifumle, excludedValue);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/existsByIfumleAndIfumleNotOrNom")
	public ResponseEntity<Boolean> existsByIfumleAndIfumleNotOrNom(@RequestParam(required = false) String ifumle, @RequestParam String excludedValue, @RequestParam String nom) {
		Boolean result = service.existsByIfumleAndIfumleNotOrNom(ifumle, excludedValue, nom);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/existsByIfumleAndIfumleNotAndIdDestNotOrNomAndIdDestNot")
	public ResponseEntity<Boolean> existsByIfumleAndIfumleNotAndIdDestNotOrNomAndIdDestNot(@RequestParam(required = false) String ifumle, @RequestParam String excludedValue, @RequestParam Long idDest1, @RequestParam String nom, @RequestParam Long idDest2) {
		Boolean result = service.existsByIfumleAndIfumleNotAndIdDestNotOrNomAndIdDestNot(ifumle, excludedValue, idDest1, nom, idDest2);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//Aristide
	@GetMapping("/getAllFournisseurs")
	public ResponseEntity<List<DestinatairesResponseDto>> getAllFournisseurs() {
		List<DestinatairesResponseDto> destinatairesResponseDto = service.getAllFournisseurs();
		return new ResponseEntity<>(destinatairesResponseDto, HttpStatus.OK); 
	}
	
}
