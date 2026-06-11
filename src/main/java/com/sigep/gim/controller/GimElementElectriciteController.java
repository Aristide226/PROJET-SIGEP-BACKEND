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

import com.sigep.gim.dto.requestDto.ElementElectriciteRequestDto;
import com.sigep.gim.dto.responseDto.ElementElectriciteResponseDto;
import com.sigep.gim.service.GimElementElectriciteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/elementElectricite")
@RequiredArgsConstructor
@CrossOrigin
public class GimElementElectriciteController {
	
	private final GimElementElectriciteService service;
	
	@PostMapping("/add")
	public ResponseEntity<ElementElectriciteResponseDto> add(@RequestBody final ElementElectriciteRequestDto elementElectriciteRequestDto) {
		ElementElectriciteResponseDto responseDto = service.add(elementElectriciteRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ElementElectriciteResponseDto>> getAll() {
		List<ElementElectriciteResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ElementElectriciteResponseDto> getById(@PathVariable final int id) {
		ElementElectriciteResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ElementElectriciteResponseDto> delete(@PathVariable final int id) {
		ElementElectriciteResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<ElementElectriciteResponseDto> edit(@PathVariable final int id, @RequestBody final ElementElectriciteRequestDto elementElectriciteRequestDto) {
		ElementElectriciteResponseDto responseDto = service.edit(id, elementElectriciteRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
