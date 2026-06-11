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

import com.sigep.gbc.dto.RetenuTypeDto;
import com.sigep.gbc.service.RetenuTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/retenuType")
@RequiredArgsConstructor
@CrossOrigin
public class RetenuTypeController {
	private final RetenuTypeService service;

	@PostMapping("/add")
	public ResponseEntity<RetenuTypeDto> add(@RequestBody final RetenuTypeDto retenuTypeDto) {
		RetenuTypeDto responseDto = service.add(retenuTypeDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public List<RetenuTypeDto> getAll() {
		return service.getAll();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<RetenuTypeDto> getById(@PathVariable final Integer id) {
		RetenuTypeDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<RetenuTypeDto> delete(@PathVariable final Integer id) {
		RetenuTypeDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<RetenuTypeDto> edit(@PathVariable final Integer id, @RequestBody final RetenuTypeDto retenuTypeDto) {
		RetenuTypeDto responseDto = service.edit(id, retenuTypeDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
