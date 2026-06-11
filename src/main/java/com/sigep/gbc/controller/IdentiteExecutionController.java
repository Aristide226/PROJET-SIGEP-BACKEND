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

import com.sigep.gbc.dto.requestDto.IdentiteExecutionRequestDto;
import com.sigep.gbc.dto.responseDto.IdentiteExecutionResponseDto;
import com.sigep.gbc.service.IdentiteExecutionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/identiteExecution")
@RequiredArgsConstructor
@CrossOrigin
public class IdentiteExecutionController {
	private final IdentiteExecutionService service;

	@PostMapping("/add")
	public ResponseEntity<IdentiteExecutionResponseDto> add(@RequestBody final IdentiteExecutionRequestDto identiteExecutionRequestDto) {
		IdentiteExecutionResponseDto responseDto = service.add(identiteExecutionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<IdentiteExecutionResponseDto>> getAll() {
		List<IdentiteExecutionResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<IdentiteExecutionResponseDto> getById(@PathVariable final String id) {
		IdentiteExecutionResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<IdentiteExecutionResponseDto> delete(@PathVariable final String id) {
		IdentiteExecutionResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<IdentiteExecutionResponseDto> edit(@PathVariable final String id, @RequestBody final IdentiteExecutionRequestDto identiteExecutionRequestDto) {
		IdentiteExecutionResponseDto responseDto = service.edit(id, identiteExecutionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
