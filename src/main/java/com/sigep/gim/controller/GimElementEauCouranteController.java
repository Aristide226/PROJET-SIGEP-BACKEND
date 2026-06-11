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

import com.sigep.gim.dto.requestDto.ElementEauCouranteRequestDto;
import com.sigep.gim.dto.responseDto.ElementEauCouranteResponseDto;
import com.sigep.gim.service.GimElementEauCouranteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/elementEauCourante")
@RequiredArgsConstructor
@CrossOrigin
public class GimElementEauCouranteController {
	
	private final GimElementEauCouranteService service;
	
	@PostMapping("/add")
	public ResponseEntity<ElementEauCouranteResponseDto> add(@RequestBody final ElementEauCouranteRequestDto elementEauCouranteRequestDto) {
		ElementEauCouranteResponseDto responseDto = service.add(elementEauCouranteRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ElementEauCouranteResponseDto>> getAll() {
		List<ElementEauCouranteResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ElementEauCouranteResponseDto> getById(@PathVariable final int id) {
		ElementEauCouranteResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ElementEauCouranteResponseDto> delete(@PathVariable final int id) {
		ElementEauCouranteResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<ElementEauCouranteResponseDto> edit(@PathVariable final int id, @RequestBody final ElementEauCouranteRequestDto elementEauCouranteRequestDto) {
		ElementEauCouranteResponseDto responseDto = service.edit(id, elementEauCouranteRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
