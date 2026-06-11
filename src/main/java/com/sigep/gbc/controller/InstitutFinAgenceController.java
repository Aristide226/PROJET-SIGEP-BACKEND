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

import com.sigep.gbc.dto.InstitutFinAgenceDto;
import com.sigep.gbc.service.InstitutFinAgenceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/institutFinAgence")
@RequiredArgsConstructor
@CrossOrigin
public class InstitutFinAgenceController {
	private final InstitutFinAgenceService service;

	@PostMapping("/add")
	public ResponseEntity<InstitutFinAgenceDto> add(@RequestBody final InstitutFinAgenceDto institutFinAgenceDto) {
		InstitutFinAgenceDto responseDto = service.add(institutFinAgenceDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<InstitutFinAgenceDto>> getAll() {
		List<InstitutFinAgenceDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<InstitutFinAgenceDto> getById(@PathVariable final String id) {
		InstitutFinAgenceDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<InstitutFinAgenceDto> delete(@PathVariable final String id) {
		InstitutFinAgenceDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<InstitutFinAgenceDto> edit(@PathVariable final String id, @RequestBody final InstitutFinAgenceDto institutFinAgenceDto) {
		InstitutFinAgenceDto responseDto = service.edit(id, institutFinAgenceDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getByAbreviation/{abreviation}")
	public ResponseEntity<List<InstitutFinAgenceDto>> getByAbreviation(@PathVariable final String abreviation) {
		List<InstitutFinAgenceDto> list = service.getByAbreviation(abreviation);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	
}
