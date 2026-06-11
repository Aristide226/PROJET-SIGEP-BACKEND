package com.sigep.gbc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.dto.requestDto.HistoConSRequestDto;
import com.sigep.gbc.dto.responseDto.HistoConSResponseDto;
import com.sigep.gbc.service.HistoConSService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/histoConS")
@RequiredArgsConstructor
@CrossOrigin
public class HistoConSController {
	private final HistoConSService service;

	@PostMapping("/add")
	public ResponseEntity<HistoConSResponseDto> add(@RequestBody final HistoConSRequestDto histoConSRequestDto) {
		HistoConSResponseDto responseDto = service.add(histoConSRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<HistoConSResponseDto>> getAll() {
		List<HistoConSResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<HistoConSResponseDto> getById(@PathVariable final String id) {
		HistoConSResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
