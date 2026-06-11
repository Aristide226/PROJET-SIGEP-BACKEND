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

import com.sigep.gbc.dto.requestDto.BudgetTypeGestionRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetTypeGestionResponseDto;
import com.sigep.gbc.service.BudgetTypeGestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/budgetTypeGestion")
@RequiredArgsConstructor
@CrossOrigin
public class BudgetTypeGestionController {
	private final BudgetTypeGestionService service;

	@PostMapping("/add")
	public ResponseEntity<BudgetTypeGestionResponseDto> add(@RequestBody final BudgetTypeGestionRequestDto budgetTypeGestionRequestDto) {
		BudgetTypeGestionResponseDto responseDto = service.add(budgetTypeGestionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BudgetTypeGestionResponseDto>> getAll() {
		List<BudgetTypeGestionResponseDto> responseDtos = service.getAll();
		return new ResponseEntity<>(responseDtos, HttpStatus.OK); 
	}

	@GetMapping("/get/{idBudget}/{annee}")
	public ResponseEntity<BudgetTypeGestionResponseDto> getById(@PathVariable final Integer idBudget, @PathVariable final Short annee) {
		BudgetTypeGestionResponseDto responseDto = service.getById(idBudget, annee);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{idBudget}/{annee}")
	public ResponseEntity<BudgetTypeGestionResponseDto> delete(@PathVariable final Integer idBudget, @PathVariable final Short annee) {
		BudgetTypeGestionResponseDto responseDto = service.delete(idBudget, annee);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{idBudget}/{annee}")
	public ResponseEntity<BudgetTypeGestionResponseDto> edit(@PathVariable final Integer idBudget, @PathVariable final Short annee, @RequestBody final BudgetTypeGestionRequestDto budgetTypeGestionRequestDto) {
		BudgetTypeGestionResponseDto responseDto = service.edit(idBudget, annee, budgetTypeGestionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	
	
}
