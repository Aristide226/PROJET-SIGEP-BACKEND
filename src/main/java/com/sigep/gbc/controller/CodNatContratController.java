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

import com.sigep.gbc.dto.requestDto.CodNatContratRequestDto;
import com.sigep.gbc.dto.responseDto.CodNatContratResponseDto;
import com.sigep.gbc.service.CodNatContratService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/codNatContrat")
@RequiredArgsConstructor
@CrossOrigin
public class CodNatContratController {
	private final CodNatContratService service;

	@PostMapping("/add")
	public ResponseEntity<CodNatContratResponseDto> add(@RequestBody final CodNatContratRequestDto codNatContratRequestDto) {
		CodNatContratResponseDto responseDto = service.add(codNatContratRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CodNatContratResponseDto>> getAll() {
		List<CodNatContratResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CodNatContratResponseDto> getById(@PathVariable final String id) {
		CodNatContratResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CodNatContratResponseDto> delete(@PathVariable final String id) {
		CodNatContratResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<CodNatContratResponseDto> edit(@PathVariable final String id, @RequestBody final CodNatContratRequestDto codNatContratRequestDto) {
		CodNatContratResponseDto responseDto = service.edit(id, codNatContratRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
