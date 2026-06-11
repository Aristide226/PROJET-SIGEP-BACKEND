package com.sigep.gim.controller;

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

import com.sigep.gim.dto.requestDto.NiveauCodeBudgetaireRequestDto;
import com.sigep.gim.dto.responseDto.NiveauCodeBudgetaireResponseDto;
import com.sigep.gim.service.GimNiveauCodeBudgetaireService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/niveauCodeBudgetaire")
@RequiredArgsConstructor
@CrossOrigin
public class GimNiveauCodeBudgetaireController {
	
	private final GimNiveauCodeBudgetaireService service;
	
	@PostMapping("/add")
	public ResponseEntity<NiveauCodeBudgetaireResponseDto> add(@RequestBody final NiveauCodeBudgetaireRequestDto niveauCodeBudgetaireRequestDto) {
		NiveauCodeBudgetaireResponseDto responseDto = service.add(niveauCodeBudgetaireRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<NiveauCodeBudgetaireResponseDto>> getAll() {
		List<NiveauCodeBudgetaireResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<NiveauCodeBudgetaireResponseDto> getById(@PathVariable final int id) {
		NiveauCodeBudgetaireResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<NiveauCodeBudgetaireResponseDto> delete(@PathVariable final int id) {
		NiveauCodeBudgetaireResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<NiveauCodeBudgetaireResponseDto> edit(@PathVariable final int id, @RequestBody final NiveauCodeBudgetaireRequestDto niveauCodeBudgetaireRequestDto) {
		NiveauCodeBudgetaireResponseDto responseDto = service.edit(id, niveauCodeBudgetaireRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
