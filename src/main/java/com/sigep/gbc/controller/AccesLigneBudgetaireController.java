package com.sigep.gbc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.dto.requestDto.AccesLigneBudgetaireRequestDto;
import com.sigep.gbc.dto.responseDto.AccesLigneBudgetaireResponseDto;
import com.sigep.gbc.service.AccesLigneBudgetaireService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/accesLigneBudgetaire")
@RequiredArgsConstructor
@CrossOrigin
public class AccesLigneBudgetaireController {
	private final AccesLigneBudgetaireService service;

	@PostMapping("/add")
	public ResponseEntity<AccesLigneBudgetaireResponseDto> add(@RequestBody final AccesLigneBudgetaireRequestDto accesLigneBudgetaireRequestDto) {
		AccesLigneBudgetaireResponseDto accesLigneBudgetaireResponseDto = service.add(accesLigneBudgetaireRequestDto);
		return new ResponseEntity<>(accesLigneBudgetaireResponseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<AccesLigneBudgetaireResponseDto>> getAll() {
		List<AccesLigneBudgetaireResponseDto> accesLigneBudgetaireResponseDtos = service.getAll();
		return new ResponseEntity<>(accesLigneBudgetaireResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{userName}/{gestion}/{numNo}")
	public ResponseEntity<AccesLigneBudgetaireResponseDto> getById(@PathVariable final String userName, @PathVariable final Short gestion, @PathVariable final String numNo) {
		AccesLigneBudgetaireResponseDto accesLigneBudgetaireResponseDto = service.getById(userName, gestion, numNo);
		return new ResponseEntity<>(accesLigneBudgetaireResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userName}/{gestion}/{numNo}")
	public ResponseEntity<AccesLigneBudgetaireResponseDto> delete(@PathVariable final String userName, @PathVariable final Short gestion, @PathVariable final String numNo) {
		AccesLigneBudgetaireResponseDto accesLigneBudgetaireResponseDto = service.delete(userName, gestion, numNo);
		return new ResponseEntity<>(accesLigneBudgetaireResponseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteByUserNameAndGestionAndIdBudget/{userName}/{gestion}/{idBudget}")
	public ResponseEntity<Void> deleteByUserNameAndGestionAndIdBudget(@PathVariable final String userName, @PathVariable final Short gestion, @PathVariable final Integer idBudget) {
		service.deleteByUserNameAndGestionAndIdBuget(userName, gestion, idBudget);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
