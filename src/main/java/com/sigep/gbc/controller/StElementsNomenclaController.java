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

import com.sigep.gbc.dto.StElementsNomenclaDto;
import com.sigep.gbc.service.StElementsNomenclaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/stElementsNomencla")
@RequiredArgsConstructor
@CrossOrigin
public class StElementsNomenclaController {
	private final StElementsNomenclaService service;

	@PostMapping("/add")
	public ResponseEntity<StElementsNomenclaDto> add(@RequestBody final StElementsNomenclaDto stElementsNomenclaDto) {
		StElementsNomenclaDto responseDto = service.add(stElementsNomenclaDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<StElementsNomenclaDto>> getAll() {
		List<StElementsNomenclaDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{idStElts}/{gestion}/{idPlan}")
	public ResponseEntity<StElementsNomenclaDto> getById(@PathVariable final String idStElts, @PathVariable final Short gestion, @PathVariable final String idPlan) {
		StElementsNomenclaDto responseDto = service.getById(idStElts, gestion, idPlan);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{idStElts}/{gestion}/{idPlan}")
	public ResponseEntity<StElementsNomenclaDto> delete(@PathVariable final String idStElts, @PathVariable final Short gestion, @PathVariable final String idPlan) {
		StElementsNomenclaDto responseDto = service.delete(idStElts, gestion, idPlan);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/get/{idStElts}/{gestion}")
	public ResponseEntity< List<StElementsNomenclaDto>> getByIdStEltsAndGestion(@PathVariable final String idStElts, @PathVariable final Short gestion) {
		List<StElementsNomenclaDto> list = service.getByIdStEltsAndGestion(idStElts, gestion);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
}
