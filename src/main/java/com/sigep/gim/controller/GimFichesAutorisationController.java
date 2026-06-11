package com.sigep.gim.controller;

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

import com.sigep.gim.dto.requestDto.FichesAutorisationRequestDto;
import com.sigep.gim.dto.responseDto.FichesAutorisationResponseDto;
import com.sigep.gim.service.GimFichesAutorisationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/fichesAutorisation")
@RequiredArgsConstructor
@CrossOrigin
public class GimFichesAutorisationController {
	
	private final GimFichesAutorisationService service;
	
	@PostMapping("/add")
	public ResponseEntity<FichesAutorisationResponseDto> add(@RequestBody final FichesAutorisationRequestDto fichesAutorisationRequestDto) {
		FichesAutorisationResponseDto responseDto = service.add(fichesAutorisationRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<FichesAutorisationResponseDto>> getAll() {
		List<FichesAutorisationResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<FichesAutorisationResponseDto> getById(@PathVariable final long id) {
		FichesAutorisationResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<FichesAutorisationResponseDto> delete(@PathVariable final long id) {
		FichesAutorisationResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<FichesAutorisationResponseDto> edit(@PathVariable final long id, @RequestBody final FichesAutorisationRequestDto fichesAutorisationRequestDto) {
		FichesAutorisationResponseDto responseDto = service.edit(id, fichesAutorisationRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
