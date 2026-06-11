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

import com.sigep.gbc.dto.requestDto.FacturesRequestDto;
import com.sigep.gbc.dto.responseDto.FacturesResponseDto;
import com.sigep.gbc.service.FacturesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/factures")
@RequiredArgsConstructor
@CrossOrigin
public class FacturesController {
	private final FacturesService service;

	@PostMapping("/add")
	public ResponseEntity<FacturesResponseDto> add(@RequestBody final FacturesRequestDto facturesRequestDto) {
		FacturesResponseDto responseDto = service.add(facturesRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<FacturesResponseDto>> getAll() {
		List<FacturesResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<FacturesResponseDto> getById(@PathVariable final Long id) {
		FacturesResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<FacturesResponseDto> delete(@PathVariable final Long id) {
		FacturesResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<FacturesResponseDto> edit(@PathVariable final Long id, @RequestBody final FacturesRequestDto facturesRequestDto) {
		FacturesResponseDto responseDto = service.edit(id, facturesRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
