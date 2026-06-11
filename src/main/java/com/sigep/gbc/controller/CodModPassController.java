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

import com.sigep.gbc.dto.requestDto.CodModPassRequestDto;
import com.sigep.gbc.dto.responseDto.CodModPassResponseDto;
import com.sigep.gbc.service.CodModPassService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/codModPass")
@RequiredArgsConstructor
@CrossOrigin
public class CodModPassController {
	private final CodModPassService service;

	@PostMapping("/add")
	public ResponseEntity<CodModPassResponseDto> add(@RequestBody final CodModPassRequestDto codModPassRequestDto) {
		CodModPassResponseDto responseDto = service.add(codModPassRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CodModPassResponseDto>> getAll() {
		List<CodModPassResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CodModPassResponseDto> getById(@PathVariable final String id) {
		CodModPassResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CodModPassResponseDto> delete(@PathVariable final String id) {
		CodModPassResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<CodModPassResponseDto> edit(@PathVariable final String id, @RequestBody final CodModPassRequestDto codModPassRequestDto) {
		CodModPassResponseDto responseDto = service.edit(id, codModPassRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
