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

import com.sigep.gim.dto.requestDto.PatrimoineBatimentsRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineBatimentsResponseDto;
import com.sigep.gim.service.GimPatrimoineBatimentsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/patrimoineBatiments")
@RequiredArgsConstructor
@CrossOrigin
public class GimPatrimoineBatimentsController {
	
	private final GimPatrimoineBatimentsService service;
	
	@PostMapping("/add")
	public ResponseEntity<PatrimoineBatimentsResponseDto> add(@RequestBody final PatrimoineBatimentsRequestDto patrimoineBatimentsRequestDto) {
		PatrimoineBatimentsResponseDto responseDto = service.add(patrimoineBatimentsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PatrimoineBatimentsResponseDto>> getAll() {
		List<PatrimoineBatimentsResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PatrimoineBatimentsResponseDto> getById(@PathVariable final String id) {
		PatrimoineBatimentsResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PatrimoineBatimentsResponseDto> delete(@PathVariable final String id) {
		PatrimoineBatimentsResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<PatrimoineBatimentsResponseDto> edit(@PathVariable final String id, @RequestBody final PatrimoineBatimentsRequestDto patrimoineBatimentsRequestDto) {
		PatrimoineBatimentsResponseDto responseDto = service.edit(id, patrimoineBatimentsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
