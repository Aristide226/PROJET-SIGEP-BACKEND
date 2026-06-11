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

import com.sigep.gbc.dto.requestDto.MotifsRejetDossierRequestDto;
import com.sigep.gbc.dto.responseDto.MotifsRejetDossierResponseDto;
import com.sigep.gbc.service.MotifsRejetDossierService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/motifsRejetDossier")
@RequiredArgsConstructor
@CrossOrigin
public class MotifsRejetDossierController {
	private final MotifsRejetDossierService service;

	@PostMapping("/add")
	public ResponseEntity<MotifsRejetDossierResponseDto> add(@RequestBody final MotifsRejetDossierRequestDto motifsRejetDossierRequestDto) {
		MotifsRejetDossierResponseDto responseDto = service.add(motifsRejetDossierRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<MotifsRejetDossierResponseDto>> getAll() {
		List<MotifsRejetDossierResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<MotifsRejetDossierResponseDto> getById(@PathVariable final String id) {
		MotifsRejetDossierResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<MotifsRejetDossierResponseDto> delete(@PathVariable final String id) {
		MotifsRejetDossierResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<MotifsRejetDossierResponseDto> edit(@PathVariable final String id, @RequestBody final MotifsRejetDossierRequestDto motifsRejetDossierRequestDto) {
		MotifsRejetDossierResponseDto responseDto = service.edit(id, motifsRejetDossierRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/setActifToFalse/{numBe}")
	public ResponseEntity<Boolean> setActifToFalse(@PathVariable final Long numBe) {
		Boolean result = service.setActifToFalse(numBe);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
