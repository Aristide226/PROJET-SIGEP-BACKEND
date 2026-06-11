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

import com.sigep.gbc.dto.requestDto.RetenueCategorieRequestDto;
import com.sigep.gbc.dto.responseDto.RetenueCategorieResponseDto;
import com.sigep.gbc.service.RetenueCategorieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/retenueCategorie")
@RequiredArgsConstructor
@CrossOrigin
public class RetenueCategorieController {
	private final RetenueCategorieService service;

	@PostMapping("/add")
	public ResponseEntity<RetenueCategorieResponseDto> add(@RequestBody final RetenueCategorieRequestDto requestDto) {
		RetenueCategorieResponseDto responseDto = service.add(requestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<RetenueCategorieResponseDto>> getAll() {
		List<RetenueCategorieResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<RetenueCategorieResponseDto> getById(@PathVariable final String id) {
		RetenueCategorieResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<RetenueCategorieResponseDto> delete(@PathVariable final String id) {
		RetenueCategorieResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<RetenueCategorieResponseDto> edit(@PathVariable final String id, @RequestBody final RetenueCategorieRequestDto requestDto) {
		RetenueCategorieResponseDto responseDto = service.edit(id, requestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
