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

import com.sigep.gbc.dto.DecisionSVisaDto;
import com.sigep.gbc.service.DecisionSVisaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/decisionSVisa")
@RequiredArgsConstructor
@CrossOrigin
public class DecisionSVisaController {
	private final DecisionSVisaService service;

	@PostMapping("/add")
	public ResponseEntity<DecisionSVisaDto> add(@RequestBody final DecisionSVisaDto decisionSVisaDto) {
		DecisionSVisaDto responseDto = service.add(decisionSVisaDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<DecisionSVisaDto>> getAll() {
		List<DecisionSVisaDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<DecisionSVisaDto>  getById(@PathVariable final Integer id) {
		DecisionSVisaDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DecisionSVisaDto> delete(@PathVariable final Integer id) {
		DecisionSVisaDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{newId}/{oldId}")
	public ResponseEntity<DecisionSVisaDto>  edit(@PathVariable final Integer newId, @PathVariable final Integer oldId, @RequestBody final DecisionSVisaDto decisionSVisaDto) {
		DecisionSVisaDto responseDto = service.edit(newId, oldId, decisionSVisaDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/existsById/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable final Integer id) {
		Boolean result = service.existsById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}	
}
