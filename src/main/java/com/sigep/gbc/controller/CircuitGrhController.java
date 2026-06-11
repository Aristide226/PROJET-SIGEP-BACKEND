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

import com.sigep.gbc.entity.CircuitGrh;
import com.sigep.gbc.service.CircuitGrhService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/circuitGrh")
@RequiredArgsConstructor
@CrossOrigin
public class CircuitGrhController {
	private final CircuitGrhService service;

	@PostMapping("/add")
	public ResponseEntity<CircuitGrh> add(@RequestBody final CircuitGrh circuitGrh) {
		CircuitGrh circuitGrh2 = service.add(circuitGrh);
		return new ResponseEntity<>(circuitGrh2, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CircuitGrh>> getAll() {
		List<CircuitGrh> circuitGrhs = service.getAll();
		return new ResponseEntity<>(circuitGrhs, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CircuitGrh> getById(@PathVariable final int id) {
		CircuitGrh circuitGrh = service.getById(id);
		return new ResponseEntity<>(circuitGrh, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CircuitGrh> delete(@PathVariable final int id) {
		CircuitGrh circuitGrh = service.delete(id);
		return new ResponseEntity<>(circuitGrh, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<CircuitGrh> edit(@PathVariable final int id, @RequestBody final CircuitGrh circuitGrh) {
		CircuitGrh circuitGrh2 =  service.edit(id, circuitGrh);
		return new ResponseEntity<>(circuitGrh2, HttpStatus.OK);
	}
}
