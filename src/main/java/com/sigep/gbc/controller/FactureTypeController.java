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

import com.sigep.gbc.dto.requestDto.FactureTypeRequestDto;
import com.sigep.gbc.dto.responseDto.FactureTypeResponseDto;
import com.sigep.gbc.service.FactureTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/factureType")
@RequiredArgsConstructor
@CrossOrigin
public class FactureTypeController {
	private final FactureTypeService service;

	@PostMapping("/add")
	public ResponseEntity<FactureTypeResponseDto> add(@PathVariable final FactureTypeRequestDto factureTypeRequestDto) {
		FactureTypeResponseDto responseDto = service.add(factureTypeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<FactureTypeResponseDto>> getAll() {
		List<FactureTypeResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<FactureTypeResponseDto> getById(@PathVariable final String id) {
		FactureTypeResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<FactureTypeResponseDto> delete(@PathVariable final String id) {
		FactureTypeResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<FactureTypeResponseDto> edit(@PathVariable final String id, @RequestBody final FactureTypeRequestDto factureTypeRequestDto) {
		FactureTypeResponseDto responseDto = service.edit(id, factureTypeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
