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

import com.sigep.gbc.dto.requestDto.PlanComptableRequestDto;
import com.sigep.gbc.dto.responseDto.PlanComptableResponseDto;
import com.sigep.gbc.service.PlanComptableService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/planComptable")
@RequiredArgsConstructor
@CrossOrigin
public class PlanComptableController {
	private final PlanComptableService service;

	@PostMapping("/add")
	public ResponseEntity<PlanComptableResponseDto> add(@RequestBody final PlanComptableRequestDto planComptableRequestDto) {
		PlanComptableResponseDto responseDto = service.add(planComptableRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PlanComptableResponseDto>> getAll() {
		List<PlanComptableResponseDto> responseDtos = service.getAll();
		return new ResponseEntity<>(responseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PlanComptableResponseDto> getById(@PathVariable final String id) {
		PlanComptableResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PlanComptableResponseDto> delete(@PathVariable final String id) {
		PlanComptableResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<PlanComptableResponseDto> edit(@PathVariable final String id, @RequestBody final PlanComptableRequestDto planComptableRequestDto) {
		PlanComptableResponseDto responseDto = service.edit(id, planComptableRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getCompteTiers")
	public ResponseEntity<List<PlanComptableResponseDto>> getCompteTiers() {
		List<PlanComptableResponseDto> responseDtos = service.getCompteTiers();
		return new ResponseEntity<>(responseDtos, HttpStatus.OK);
	}
	
}
