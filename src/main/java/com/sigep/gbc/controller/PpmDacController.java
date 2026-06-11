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

import com.sigep.gbc.dto.requestDto.PpmDacRequestDto;
import com.sigep.gbc.dto.responseDto.PpmDacResponseDto;
import com.sigep.gbc.service.PpmDacService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/ppmDac")
@RequiredArgsConstructor
@CrossOrigin
public class PpmDacController {
	private final PpmDacService service;

	@PostMapping("/add")
	public ResponseEntity<PpmDacResponseDto>  add(@RequestBody final PpmDacRequestDto ppmDacRequestDto) {
		PpmDacResponseDto responseDto = service.add(ppmDacRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PpmDacResponseDto>> getAll() {
		List<PpmDacResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PpmDacResponseDto>  getById(@PathVariable final String id) {
		PpmDacResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PpmDacResponseDto>  delete(@PathVariable final String id) {
		PpmDacResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<PpmDacResponseDto> edit(@PathVariable final String id, @RequestBody final PpmDacRequestDto ppmDacRequestDto) {
		PpmDacResponseDto responseDto = service.edit(id, ppmDacRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	
}
