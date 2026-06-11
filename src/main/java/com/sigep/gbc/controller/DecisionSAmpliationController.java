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

import com.sigep.gbc.dto.requestDto.DecisionSAmpliationRequestDto;
import com.sigep.gbc.dto.responseDto.DecisionSAmpliationResponseDto;
import com.sigep.gbc.service.DecisionSAmpliationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/decisionSAmpliation")
@RequiredArgsConstructor
@CrossOrigin
public class DecisionSAmpliationController {
	private final DecisionSAmpliationService service;

	@PostMapping("/add")
	public ResponseEntity<DecisionSAmpliationResponseDto> add(@RequestBody final DecisionSAmpliationRequestDto decisionSAmpliationRequestDto) {
		DecisionSAmpliationResponseDto responseDto = service.add(decisionSAmpliationRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<DecisionSAmpliationResponseDto>> getAll() {
		List<DecisionSAmpliationResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<DecisionSAmpliationResponseDto> getById(@PathVariable final Integer id) {
		DecisionSAmpliationResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DecisionSAmpliationResponseDto> delete(@PathVariable final Integer id) {
		DecisionSAmpliationResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<DecisionSAmpliationResponseDto> edit(@PathVariable final Integer id, @RequestBody final DecisionSAmpliationRequestDto decisionSAmpliationRequestDto) {
		DecisionSAmpliationResponseDto responseDto = service.edit(id, decisionSAmpliationRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
