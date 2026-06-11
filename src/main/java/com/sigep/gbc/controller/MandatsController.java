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


import com.sigep.gbc.dto.requestDto.MandatsRequestDto;
import com.sigep.gbc.dto.responseDto.MandatsResponseDto;
import com.sigep.gbc.model.IdMandsIdBordEmis;
import com.sigep.gbc.model.InfosPourAbandonnerLiquidation;
import com.sigep.gbc.model.InfosPourRetrograderLiquidation;
import com.sigep.gbc.model.InfosPourValiderLiquidation;
import com.sigep.gbc.service.MandatsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/mandats")
@RequiredArgsConstructor
@CrossOrigin
public class MandatsController {
	private final MandatsService service;

	@PostMapping("/add")
	public ResponseEntity<MandatsResponseDto> add(@RequestBody final MandatsRequestDto mandatsRequestDto) {
		MandatsResponseDto responseDto = service.add(mandatsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<MandatsResponseDto>> getAll() {
		List<MandatsResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<MandatsResponseDto> getById(@PathVariable final Long id) {
		MandatsResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<MandatsResponseDto> delete(@PathVariable final Long id) {
		MandatsResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<MandatsResponseDto> edit(@PathVariable final Long id, @RequestBody final MandatsRequestDto mandatsRequestDto) {
		MandatsResponseDto responseDto = service.edit(id, mandatsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PostMapping("/abandonnerLiquidation")
	public ResponseEntity<Boolean> abandonnerLiquidation(@RequestBody final InfosPourAbandonnerLiquidation infosPourAbandonnerLiquidation) {
		Boolean result = service.abandonnerLiquidation(infosPourAbandonnerLiquidation);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/validerLiquidation")
	public ResponseEntity<Boolean> validerLiquidation(@RequestBody final InfosPourValiderLiquidation infosPourValiderLiquidation) {
		Boolean result = service.validerLiquidation(infosPourValiderLiquidation);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/retrograderLiquidation")
	public ResponseEntity<Boolean> retrograderLiquidation(@RequestBody final InfosPourRetrograderLiquidation infosPourRetrograderLiquidation) {
		Boolean result = service.retrograderLiquidation(infosPourRetrograderLiquidation);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/transmettre")
	public ResponseEntity<Boolean> transmettre(@RequestBody final IdMandsIdBordEmis idMandsIdBordEmis) {
		Boolean result = service.transmettre(idMandsIdBordEmis);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
