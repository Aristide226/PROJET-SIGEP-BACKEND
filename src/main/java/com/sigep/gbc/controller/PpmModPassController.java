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

import com.sigep.gbc.dto.requestDto.PpmModPassRequestDto;
import com.sigep.gbc.dto.responseDto.PpmModPassResponseDto;
import com.sigep.gbc.service.PpmModPassService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/ppmModPass")
@RequiredArgsConstructor
@CrossOrigin
public class PpmModPassController {
	private final PpmModPassService service;

	@PostMapping("/add")
	public ResponseEntity<PpmModPassResponseDto> add(@RequestBody final PpmModPassRequestDto ppmModPassRequestDto) {
		PpmModPassResponseDto responseDto = service.add(ppmModPassRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PpmModPassResponseDto>> getAll() {
		List<PpmModPassResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PpmModPassResponseDto> getById(@PathVariable final String id) {
		PpmModPassResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PpmModPassResponseDto> delete(@PathVariable final String id) {
		PpmModPassResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<PpmModPassResponseDto> edit(@PathVariable final String id, @RequestBody final PpmModPassRequestDto ppmModPassRequestDto) {
		PpmModPassResponseDto responseDto = service.edit(id, ppmModPassRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
