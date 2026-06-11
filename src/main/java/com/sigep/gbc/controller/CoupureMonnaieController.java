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

import com.sigep.gbc.dto.CoupureMonnaieDto;
import com.sigep.gbc.service.CoupureMonnaieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/coupureMonnaie")
@RequiredArgsConstructor
@CrossOrigin
public class CoupureMonnaieController {
	private final CoupureMonnaieService service;

	@PostMapping("/add")
	public ResponseEntity<CoupureMonnaieDto> add(@RequestBody final CoupureMonnaieDto coupureMonnaieDto) {
		CoupureMonnaieDto responseDto = service.add(coupureMonnaieDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK); 
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CoupureMonnaieDto>> getAll() {
		List<CoupureMonnaieDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{designa}/{idCoupure}")
	public ResponseEntity<CoupureMonnaieDto> getById(@PathVariable final String designa, @PathVariable final Long idCoupure) {
		CoupureMonnaieDto responseDto = service.getById(designa, idCoupure);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{designa}/{idCoupure}")
	public ResponseEntity<CoupureMonnaieDto> delete(@PathVariable final String designa, @PathVariable final Long idCoupure) {
		CoupureMonnaieDto responseDto = service.delete(designa, idCoupure);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{designa}/{idCoupure}")
	public ResponseEntity<Void> edit(@PathVariable final String designa, @PathVariable final Long idCoupure, @RequestBody final CoupureMonnaieDto coupureMonnaieDto) {
		service.edit(designa, idCoupure, coupureMonnaieDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}
