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

import com.sigep.gbc.dto.requestDto.BudgetModifActeRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetModifActeResponseDto;
import com.sigep.gbc.service.BudgetModifActeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/budgetModifActe")
@RequiredArgsConstructor
@CrossOrigin
public class BudgetModifActeController {
	private final BudgetModifActeService service;

	@PostMapping("/add")
	public ResponseEntity<BudgetModifActeResponseDto> add(@RequestBody final BudgetModifActeRequestDto budgetModifActeRequestDto) {
		BudgetModifActeResponseDto responseDto = service.add(budgetModifActeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BudgetModifActeResponseDto>> getAll() {
		List<BudgetModifActeResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<BudgetModifActeResponseDto> getById(@PathVariable final Long id) {
		BudgetModifActeResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BudgetModifActeResponseDto> delete(@PathVariable final Long id) {
		BudgetModifActeResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<BudgetModifActeResponseDto> edit(@PathVariable final Long id, @RequestBody final BudgetModifActeRequestDto budgetModifActeRequestDto) {
		BudgetModifActeResponseDto responseDto = service.edit(id, budgetModifActeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/existsByGestionAndIdBudgetAndValide/{gestion}/{idBudget}/{valide}")
	public ResponseEntity<Boolean> existsByGestionAndIdBudgetAndValide(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Boolean valide) {
		Boolean result = service.existsByGestionAndIdBudgetAndValide(gestion, idBudget, valide);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/getByGestionAndIdBudgetAndValide/{gestion}/{idBudget}/{valide}")
	public ResponseEntity<List<BudgetModifActeResponseDto>> getByGestionAndIdBudgetAndValide(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Boolean valide) {
		List<BudgetModifActeResponseDto> list = service.getByGestionAndIdBudgetAndValide(gestion, idBudget, valide);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}	
	
}
