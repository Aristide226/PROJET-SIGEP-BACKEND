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

import com.sigep.gbc.dto.requestDto.NiveauPlanComptableRequestDto;
import com.sigep.gbc.dto.responseDto.NiveauPlanComptableResponseDto;
import com.sigep.gbc.service.NiveauPlanComptableService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/niveauPlanComptable")
@RequiredArgsConstructor
@CrossOrigin
public class NiveauPlanComptableController {
	private final NiveauPlanComptableService service;

	@PostMapping("/add")
	public ResponseEntity<NiveauPlanComptableResponseDto> add(@RequestBody final NiveauPlanComptableRequestDto niveauPlanComptableRequestDto) {
		NiveauPlanComptableResponseDto responseDto = service.add(niveauPlanComptableRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<NiveauPlanComptableResponseDto>> getAll() {
		List<NiveauPlanComptableResponseDto> responseDtos = service.getAll();
		return new ResponseEntity<>(responseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<NiveauPlanComptableResponseDto> getById(@PathVariable final Integer id) {
		NiveauPlanComptableResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<NiveauPlanComptableResponseDto>delete(@PathVariable final Integer id) {
		NiveauPlanComptableResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<NiveauPlanComptableResponseDto> edit(@PathVariable final Integer id, @RequestBody final NiveauPlanComptableRequestDto niveauPlanComptableRequestDto) {
		NiveauPlanComptableResponseDto responseDto = service.edit(id, niveauPlanComptableRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
