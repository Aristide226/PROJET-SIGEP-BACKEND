package com.sigep.gbc.controller;

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

import com.sigep.gbc.dto.requestDto.ReamHampliationRequestDto;
import com.sigep.gbc.dto.responseDto.ReamHampliationResponseDto;
import com.sigep.gbc.service.ReamHampliationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/reamHampliation")
@RequiredArgsConstructor
@CrossOrigin
public class ReamHampliationController {
	private final ReamHampliationService service;

	@PostMapping("/add")
	public ResponseEntity<ReamHampliationResponseDto> add(@RequestBody final ReamHampliationRequestDto reamHampliationRequestDto) {
		ReamHampliationResponseDto responseDto = service.add(reamHampliationRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ReamHampliationResponseDto>> getAll() {
		List<ReamHampliationResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{codReam}/{ampliataireReam}")
	public ResponseEntity<ReamHampliationResponseDto> getById(@PathVariable final Long codReam, @PathVariable final String ampliataireReam) {
		ReamHampliationResponseDto responseDto = service.getById(codReam, ampliataireReam);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/get/{codReam}/{ampliataireReam}")
	public ResponseEntity<ReamHampliationResponseDto> delete(@PathVariable final Long codReam, @PathVariable final String ampliataireReam) {
		ReamHampliationResponseDto responseDto = service.delete(codReam, ampliataireReam);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
