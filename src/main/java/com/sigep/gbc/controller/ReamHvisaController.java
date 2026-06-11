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

import com.sigep.gbc.dto.requestDto.ReamHvisaResquestDto;
import com.sigep.gbc.dto.responseDto.ReamHvisaResponseDto;
import com.sigep.gbc.service.ReamHvisaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/reamHvisa")
@RequiredArgsConstructor
@CrossOrigin
public class ReamHvisaController {
	private final ReamHvisaService service;

	@PostMapping("/add")
	public ResponseEntity<ReamHvisaResponseDto> add(@RequestBody final ReamHvisaResquestDto reamHvisaResquestDto) {
		ReamHvisaResponseDto responseDto = service.add(reamHvisaResquestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ReamHvisaResponseDto>> getAll() {
		List<ReamHvisaResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{codReam}/{rangVisa}")
	public ResponseEntity<ReamHvisaResponseDto> getById(@PathVariable final Long codReam, @PathVariable final Integer rangVisa) {
		ReamHvisaResponseDto responseDto = service.getById(codReam, rangVisa);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/get/{codReam}/{rangVisa}")
	public ResponseEntity<ReamHvisaResponseDto> delete(@PathVariable final Long codReam, @PathVariable final Integer rangVisa) {
		ReamHvisaResponseDto responseDto = service.delete(codReam, rangVisa);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/get/{codReam}/{rangVisa}")
	public ResponseEntity<ReamHvisaResponseDto> edit(@PathVariable final Long codReam, @PathVariable final Integer rangVisa, @RequestBody final ReamHvisaResquestDto reamHvisaResquestDto) {
		ReamHvisaResponseDto responseDto = service.edit(codReam, rangVisa, reamHvisaResquestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
