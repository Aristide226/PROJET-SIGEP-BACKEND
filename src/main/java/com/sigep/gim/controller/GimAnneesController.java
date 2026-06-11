package com.sigep.gim.controller;

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

import com.sigep.gim.dto.requestDto.AnneesRequestDto;
import com.sigep.gim.dto.responseDto.AnneesResponseDto;
import com.sigep.gim.service.GimAnneesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/annees")
@RequiredArgsConstructor
@CrossOrigin
public class GimAnneesController {
	
	private final GimAnneesService service;
	
	@PostMapping("/add")
	public ResponseEntity<AnneesResponseDto> add(@RequestBody final AnneesRequestDto anneesRequestDto) {
		AnneesResponseDto responseDto = service.add(anneesRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<AnneesResponseDto>> getAll() {
		List<AnneesResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<AnneesResponseDto> getById(@PathVariable final short id) {
		AnneesResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AnneesResponseDto> delete(@PathVariable final short id) {
		AnneesResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
