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

import com.sigep.gbc.dto.requestDto.InstitutFinancierRequestDto;
import com.sigep.gbc.dto.responseDto.InstitutFinancierResponseDto;
import com.sigep.gbc.service.InstitutFinancierService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/institutFinancier")
@RequiredArgsConstructor
@CrossOrigin
public class InstitutFinancierController {
	private final InstitutFinancierService service;

	@PostMapping("/add")
	public ResponseEntity<InstitutFinancierResponseDto> add(@RequestBody final InstitutFinancierRequestDto institutFinancierRequestDto) {
		InstitutFinancierResponseDto responseDto = service.add(institutFinancierRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<InstitutFinancierResponseDto>> getAll() {
		List<InstitutFinancierResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<InstitutFinancierResponseDto> getById(@PathVariable final String id) {
		InstitutFinancierResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<InstitutFinancierResponseDto> delete(@PathVariable final String id) {
		InstitutFinancierResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<InstitutFinancierResponseDto> edit(@PathVariable final String id, @RequestBody final InstitutFinancierRequestDto institutFinancierRequestDto) {
		InstitutFinancierResponseDto responseDto = service.edit(id, institutFinancierRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	
}
