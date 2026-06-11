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

import com.sigep.gbc.dto.requestDto.TypeDecisionRequestDto;
import com.sigep.gbc.dto.responseDto.TypeDecisionResponseDto;
import com.sigep.gbc.service.TypeDecisionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/typeDecision")
@RequiredArgsConstructor
@CrossOrigin
public class TypeDecisionController {
	private final TypeDecisionService service;

	@PostMapping("/add")
	public ResponseEntity<TypeDecisionResponseDto> add(@RequestBody final TypeDecisionRequestDto typeDecisionRequestDto) {
		TypeDecisionResponseDto responseDto = service.add(typeDecisionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<TypeDecisionResponseDto>> getAll() {
		List<TypeDecisionResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<TypeDecisionResponseDto> getById(@PathVariable final Integer id) {
		TypeDecisionResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TypeDecisionResponseDto> delete(@PathVariable final Integer id) {
		TypeDecisionResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<TypeDecisionResponseDto> edit(@PathVariable final Integer id, @RequestBody final TypeDecisionRequestDto typeDecisionRequestDto) {
		TypeDecisionResponseDto responseDto = service.edit(id, typeDecisionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
