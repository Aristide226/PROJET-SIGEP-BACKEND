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

import com.sigep.gbc.dto.requestDto.CodSourceFinRequestDto;
import com.sigep.gbc.dto.responseDto.CodSourceFinResponseDto;
import com.sigep.gbc.service.CodSourceFinService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/codSourceFin")
@RequiredArgsConstructor
@CrossOrigin
public class CodSourceFinController {
	private final CodSourceFinService service;

	@PostMapping("/add")
	public ResponseEntity<CodSourceFinResponseDto> add(@RequestBody final CodSourceFinRequestDto codSourceFinRequestDto) {
		CodSourceFinResponseDto responseDto = service.add(codSourceFinRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CodSourceFinResponseDto>> getAll() {
		List<CodSourceFinResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CodSourceFinResponseDto> getById(@PathVariable final String id) {
		CodSourceFinResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CodSourceFinResponseDto> delete(@PathVariable final String id) {
		CodSourceFinResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<CodSourceFinResponseDto> edit(@PathVariable final String id, @RequestBody final CodSourceFinRequestDto codSourceFinRequestDto) {
		CodSourceFinResponseDto responseDto = service.edit(id, codSourceFinRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
