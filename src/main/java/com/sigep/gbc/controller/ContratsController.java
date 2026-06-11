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

import com.sigep.gbc.dto.requestDto.ContratsRequestDto;
import com.sigep.gbc.dto.responseDto.ContratsResponseDto;
import com.sigep.gbc.service.ContratsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/contrats")
@RequiredArgsConstructor
@CrossOrigin
public class ContratsController {
	private final ContratsService service;

	@PostMapping("/add")
	public ResponseEntity<ContratsResponseDto> add(@RequestBody final ContratsRequestDto contratsRequestDto) {
		ContratsResponseDto responseDto = service.add(contratsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ContratsResponseDto>> getAll() {
		List<ContratsResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ContratsResponseDto> getById(@PathVariable final Long id) {
		ContratsResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ContratsResponseDto> delete(@PathVariable final Long id) {
		ContratsResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<ContratsResponseDto> edit(@PathVariable final Long id, @RequestBody final ContratsRequestDto contratsRequestDto) {
		ContratsResponseDto responseDto = service.edit(id, contratsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
