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

import com.sigep.gbc.dto.CompteDto;
import com.sigep.gbc.service.CompteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/compte")
@RequiredArgsConstructor
@CrossOrigin
public class CompteController {
	private final CompteService service;

	@PostMapping("/add")
	public ResponseEntity<CompteDto> add(@RequestBody final CompteDto compteDto) {
		CompteDto responseDto = service.add(compteDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK); 
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CompteDto>> getAll() {
		List<CompteDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK); 
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CompteDto> getById(@PathVariable String id) {
		CompteDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK); 
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CompteDto> delete(@PathVariable final String id) {
		CompteDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK); 
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<CompteDto> edit(@PathVariable final String id, @RequestBody final CompteDto compteDto) {
		CompteDto responseDto = service.edit(id, compteDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK); 
	}

	
}
