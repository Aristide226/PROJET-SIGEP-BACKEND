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

import com.sigep.gbc.dto.responseDto.ContratTypeResponseDto;
import com.sigep.gbc.service.ContratTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/contratType")
@RequiredArgsConstructor
@CrossOrigin
public class ContratTypeController {
	private final ContratTypeService service;

	@PostMapping("/add")
	public ResponseEntity<ContratTypeResponseDto> add(@RequestBody final ContratTypeResponseDto contratTypeResponseDto) {
		ContratTypeResponseDto responseDto = service.add(contratTypeResponseDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ContratTypeResponseDto>> getAll() {
		List<ContratTypeResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ContratTypeResponseDto> getById(@PathVariable final String id) {
		ContratTypeResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ContratTypeResponseDto> delete(@PathVariable final String id) {
		ContratTypeResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<ContratTypeResponseDto> edit(@PathVariable final String id, @RequestBody final ContratTypeResponseDto contratTypeResponseDto) {
		ContratTypeResponseDto responseDto = service.edit(id, contratTypeResponseDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
