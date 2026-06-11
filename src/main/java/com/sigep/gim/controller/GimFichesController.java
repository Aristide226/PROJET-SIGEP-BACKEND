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

import com.sigep.gim.dto.requestDto.FichesRequestDto;
import com.sigep.gim.dto.responseDto.FichesResponseDto;
import com.sigep.gim.service.GimFichesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/fiches")
@RequiredArgsConstructor
@CrossOrigin
public class GimFichesController {
	
	private final GimFichesService service;
	
	@PostMapping("/add")
	public ResponseEntity<FichesResponseDto> add(@RequestBody final FichesRequestDto fichesRequestDto) {
		FichesResponseDto responseDto = service.add(fichesRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<FichesResponseDto>> getAll() {
		List<FichesResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<FichesResponseDto> getById(@PathVariable final long id) {
		FichesResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<FichesResponseDto> delete(@PathVariable final long id) {
		FichesResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<FichesResponseDto> edit(@PathVariable final long id, @RequestBody final FichesRequestDto fichesRequestDto) {
		FichesResponseDto responseDto = service.edit(id, fichesRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
