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

import com.sigep.gbc.dto.CompteDestinataireInstitutFinAgenceDto;
import com.sigep.gbc.dto.requestDto.CompteDestinataireRequestDto;
import com.sigep.gbc.dto.responseDto.CompteDestinataireResponseDto;
import com.sigep.gbc.service.CompteDestinataireService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/compteDestinataire")
@RequiredArgsConstructor
@CrossOrigin
public class CompteDestinataireController {
	private final CompteDestinataireService service;

	@PostMapping("/add")
	public ResponseEntity<CompteDestinataireResponseDto> add(@RequestBody final CompteDestinataireRequestDto compteDestinataireRequestDto) {
		CompteDestinataireResponseDto responseDto = service.add(compteDestinataireRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CompteDestinataireResponseDto>> getAll() {
		List<CompteDestinataireResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CompteDestinataireResponseDto> getById(@PathVariable final String id) {
		CompteDestinataireResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CompteDestinataireResponseDto> delete(@PathVariable final String id) {
		CompteDestinataireResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<CompteDestinataireResponseDto> edit(@PathVariable final String id, @RequestBody final CompteDestinataireRequestDto compteDestinataireRequestDto) {
		CompteDestinataireResponseDto responseDto = service.edit(id, compteDestinataireRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getByDestinataires/{idDest}")
	public ResponseEntity<List<CompteDestinataireInstitutFinAgenceDto>> getByDestinataires(@PathVariable final Long idDest) {
		List<CompteDestinataireInstitutFinAgenceDto> list = service.getByDestinataires(idDest);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}	
	
	
}
