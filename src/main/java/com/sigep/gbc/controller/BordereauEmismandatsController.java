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

import com.sigep.gbc.dto.requestDto.BordereauEmismandatsRequestDto;
import com.sigep.gbc.dto.responseDto.BordereauEmismandatsResponseDto;
import com.sigep.gbc.service.BordereauEmismandatsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/bordereauEmismandats")
@RequiredArgsConstructor
@CrossOrigin
public class BordereauEmismandatsController {
	private final BordereauEmismandatsService service;

	@PostMapping("/add")
	public ResponseEntity<BordereauEmismandatsResponseDto> add(@RequestBody final BordereauEmismandatsRequestDto bordereauEmismandatsRequestDto) {
		BordereauEmismandatsResponseDto responseDto = service.add(bordereauEmismandatsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BordereauEmismandatsResponseDto>> getAll() {
		List<BordereauEmismandatsResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<BordereauEmismandatsResponseDto> getById(@PathVariable final String id) {
		BordereauEmismandatsResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BordereauEmismandatsResponseDto> delete(@PathVariable final String id) {
		BordereauEmismandatsResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<BordereauEmismandatsResponseDto> edit(@PathVariable final String id, @RequestBody final BordereauEmismandatsRequestDto bordereauEmismandatsRequestDto) {
		BordereauEmismandatsResponseDto responseDto = service.edit(id, bordereauEmismandatsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getByGestionAndIdBudgetAndDossier/{gestion}/{idBudget}/{dossier}")
	public ResponseEntity<List<BordereauEmismandatsResponseDto>> getByGestionAndIdBudgetAndDossier(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final String dossier) {
		List<BordereauEmismandatsResponseDto> list = service.getByGestionAndIdBudgetAndDossier(gestion, idBudget, dossier);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
