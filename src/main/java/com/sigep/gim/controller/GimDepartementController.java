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

import com.sigep.gim.dto.requestDto.DepartementRequestDto;
import com.sigep.gim.dto.responseDto.DepartementResponseDto;
import com.sigep.gim.service.GimDepartementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/departement")
@RequiredArgsConstructor
@CrossOrigin
public class GimDepartementController {
	
	private final GimDepartementService service;
	
	@PostMapping("/add")
	public ResponseEntity<DepartementResponseDto> add(@RequestBody final DepartementRequestDto departementRequestDto) {
		DepartementResponseDto responseDto = service.add(departementRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<DepartementResponseDto>> getAll() {
		List<DepartementResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<DepartementResponseDto> getById(@PathVariable final int id) {
		DepartementResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DepartementResponseDto> delete(@PathVariable final int id) {
		DepartementResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<DepartementResponseDto> edit(@PathVariable final int id, @RequestBody final DepartementRequestDto departementRequestDto) {
		DepartementResponseDto responseDto = service.edit(id, departementRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
