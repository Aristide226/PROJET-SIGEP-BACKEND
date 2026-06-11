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

import com.sigep.gbc.dto.requestDto.FactureDetailRequestDto;
import com.sigep.gbc.dto.responseDto.FactureDetailResponseDto;
import com.sigep.gbc.service.FactureDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/factureDetail")
@RequiredArgsConstructor
@CrossOrigin
public class FactureDetailController {
	private final FactureDetailService service;

	@PostMapping("/add")
	public ResponseEntity<FactureDetailResponseDto> add(@RequestBody final FactureDetailRequestDto factureDetailRequestDto) {
		FactureDetailResponseDto responseDto = service.add(factureDetailRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<FactureDetailResponseDto>> getAll() {
		List<FactureDetailResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<FactureDetailResponseDto> getById(@PathVariable final String id) {
		FactureDetailResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<FactureDetailResponseDto> delete(@PathVariable final String id) {
		FactureDetailResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<FactureDetailResponseDto> edit(@PathVariable final String id, @RequestBody final FactureDetailRequestDto factureDetailRequestDto) {
		FactureDetailResponseDto responseDto = service.edit(id, factureDetailRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
