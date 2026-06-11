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

import com.sigep.gbc.dto.requestDto.BudgetRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetResponseDto;
import com.sigep.gbc.service.BudgetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/budget")
@RequiredArgsConstructor
@CrossOrigin
public class BudgetController {
	private final BudgetService service;

	@PostMapping("/add")
	public ResponseEntity<BudgetResponseDto> add(@RequestBody final BudgetRequestDto budgetRequestDto) {
		BudgetResponseDto responseDto = service.add(budgetRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK); 
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BudgetResponseDto>> getAll() {
		List<BudgetResponseDto> responseDtos = service.getAll();
		return new ResponseEntity<>(responseDtos, HttpStatus.OK); 
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<BudgetResponseDto> getById(@PathVariable final String id) {
		BudgetResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BudgetResponseDto> delete(@PathVariable final String id) {
		BudgetResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<BudgetResponseDto> edit(@PathVariable final String id, @RequestBody final BudgetRequestDto budgetRequestDto) {
		BudgetResponseDto responseDto = service.edit(id, budgetRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/get/{gestion}/{idBudget}")
	public ResponseEntity<List<BudgetResponseDto>> getByGestionAndIdBudget(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<BudgetResponseDto> responseDtos = service.getByGestionAndIdBudget(gestion, idBudget);
		return new ResponseEntity<>(responseDtos, HttpStatus.OK); 
	}

	@GetMapping("/getByNumNo/{numNo}")
	public ResponseEntity<List<BudgetResponseDto>> getByNumNo(@PathVariable final String numNo) {
		List<BudgetResponseDto> responseDtos = service.getByNumNo(numNo);
		return new ResponseEntity<>(responseDtos, HttpStatus.OK); 
	}

	@GetMapping("/exists/{gestion}/{idBudget}")
	public ResponseEntity<Boolean> exits(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		Boolean result = service.exits(gestion, idBudget);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/creerBudgetSuivantAPartirDuBudgetPrecent/{gestion}/{idBudget}")
	public ResponseEntity<List<BudgetResponseDto>> creerBudgetSuivantAPartirDuBudgetPrecent(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<BudgetResponseDto> responseDtos = service.creerBudgetSuivantAPartirDuBudgetPrecent(gestion, idBudget);
		return new ResponseEntity<>(responseDtos, HttpStatus.OK); 
	}

	@PostMapping("/creerBudgetSuivantAPartirDesRecettesEtDepenses/{gestion}/{idBudget}")
	public ResponseEntity<List<BudgetResponseDto>> creerBudgetSuivantAPartirDesRecettesEtDepenses(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<BudgetResponseDto> responseDtos = service.creerBudgetSuivantAPartirDesRecettesEtDepenses(gestion, idBudget);
		return new ResponseEntity<>(responseDtos, HttpStatus.OK); 
	}

	@GetMapping("/getRecettes/{gestion}/{idBudget}")
	public ResponseEntity<List<BudgetResponseDto>> getRecettes(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<BudgetResponseDto> responseDtos = service.getRecettes(gestion, idBudget);
		return new ResponseEntity<>(responseDtos, HttpStatus.OK);
	}

	@GetMapping("/getDepenses/{gestion}/{idBudget}")
	public ResponseEntity<List<BudgetResponseDto>> getDepenses(@PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		List<BudgetResponseDto> responseDtos = service.getDepenses(gestion, idBudget);
		return new ResponseEntity<>(responseDtos, HttpStatus.OK);
	}
}
