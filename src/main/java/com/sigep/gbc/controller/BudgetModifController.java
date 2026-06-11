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

import com.sigep.gbc.dto.BudgetModifBudgetDto;
import com.sigep.gbc.dto.requestDto.BudgetModifRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetModifResponseDto;
import com.sigep.gbc.service.BudgetModifService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/budgetModif")
@RequiredArgsConstructor
@CrossOrigin
public class BudgetModifController {
	private final BudgetModifService service;

	@PostMapping("/add")
	public ResponseEntity<BudgetModifResponseDto> add(@RequestBody final BudgetModifRequestDto budgetModifRequestDto) {
		BudgetModifResponseDto responseDto = service.add(budgetModifRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BudgetModifResponseDto>> getAll() {
		List<BudgetModifResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{codBma}/{codBud}")
	public ResponseEntity<BudgetModifResponseDto> getById(@PathVariable final Long codBma, @PathVariable final String codBud) {
		BudgetModifResponseDto responseDto = service.getById(codBma, codBud);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{codBma}/{codBud}")
	public ResponseEntity<BudgetModifResponseDto> delete(@PathVariable final Long codBma, @PathVariable final String codBud) {
		BudgetModifResponseDto responseDto = service.delete(codBma, codBud);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{codBma}/{codBud}")
	public ResponseEntity<BudgetModifResponseDto> edit(@PathVariable final Long codBma, @PathVariable final String codBud, @RequestBody final BudgetModifRequestDto budgetModifRequestDto) {
		BudgetModifResponseDto responseDto = service.edit(codBma, codBud, budgetModifRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getByCodBma/{codBma}")
	public ResponseEntity<List<BudgetModifResponseDto>> getByCodBma(@PathVariable Long codBma) {
		List<BudgetModifResponseDto> list = service.getByCodBma(codBma);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getLigneModifieesRecettesDepenses/{codBma}")
	public ResponseEntity<List<BudgetModifBudgetDto>> getLigneModifieesRecettesDepenses(@PathVariable final Long codBma) {
		List<BudgetModifBudgetDto> list = service.getLigneModifieesRecettesDepenses(codBma);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/addLignesModifiees")
	public ResponseEntity<Boolean> addLignesModifiees(@RequestBody final List<BudgetModifRequestDto> budgetModifRequestDtos) {
		Boolean result = service.addLignesModifiees(budgetModifRequestDtos);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/deleteLignesModifiees/{codBma}")
	public ResponseEntity<Boolean> deleteLignesModifiees(@PathVariable final Long codBma) {
		Boolean result = service.deleteLignesModifiees(codBma);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/exists/{codBma}/{codBud}")
	public ResponseEntity<Boolean> exists(@PathVariable final Long codBma, @PathVariable final String codBud) {
		Boolean result = service.exists(codBma, codBud);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/editAllCAAjoutCAAnnul/{codBma}")
	public ResponseEntity<Boolean> editAllCAAjoutCAAnnul(@PathVariable final Long codBma) {
		Boolean result = service.editAllCAAjoutCAAnnul(codBma);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
