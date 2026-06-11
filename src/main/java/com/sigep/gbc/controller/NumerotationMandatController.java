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

import com.sigep.gbc.dto.requestDto.NumerotationMandatRequestDto;
import com.sigep.gbc.dto.responseDto.NumerotationMandatResponseDto;
import com.sigep.gbc.service.NumerotationMandatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/numerotationMandat")
@RequiredArgsConstructor
@CrossOrigin
public class NumerotationMandatController {
	
	private final NumerotationMandatService service;

	@PostMapping("/add")
	public ResponseEntity<NumerotationMandatResponseDto> add(@RequestBody final NumerotationMandatRequestDto numerotationMandatRequestDto) {
		NumerotationMandatResponseDto numerotationMandatResponseDto = service.add(numerotationMandatRequestDto);
		return new ResponseEntity<>(numerotationMandatResponseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<NumerotationMandatResponseDto>> getAll() {
		List<NumerotationMandatResponseDto> numerotationMandatResponseDtos = service.getAll();
		return new ResponseEntity<>(numerotationMandatResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<NumerotationMandatResponseDto> getById(@PathVariable final int id) {
		NumerotationMandatResponseDto numerotationMandatResponseDto = service.getById(id);
		return new ResponseEntity<>(numerotationMandatResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<NumerotationMandatResponseDto> delete(@PathVariable final int id) {
		NumerotationMandatResponseDto numerotationMandatResponseDto = service.delete(id);
		return new ResponseEntity<>(numerotationMandatResponseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<NumerotationMandatResponseDto> edit(@PathVariable final int id, @RequestBody final NumerotationMandatRequestDto numerotationMandatRequestDto) {
		NumerotationMandatResponseDto numerotationMandatResponseDto = service.edit(id, numerotationMandatRequestDto);
		return new ResponseEntity<>(numerotationMandatResponseDto, HttpStatus.OK);
	}
}
