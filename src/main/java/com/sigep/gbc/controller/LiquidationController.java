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

import com.sigep.gbc.dto.requestDto.LiquidationRequestDto;
import com.sigep.gbc.dto.responseDto.LiquidationResponseDto;
import com.sigep.gbc.service.LiquidationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/liquidation")
@RequiredArgsConstructor
@CrossOrigin
public class LiquidationController {
	private final LiquidationService service;

	@PostMapping("/add")
	public ResponseEntity<LiquidationResponseDto> add(@RequestBody final LiquidationRequestDto liquidationRequestDto) {
		LiquidationResponseDto responseDto = service.add(liquidationRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<LiquidationResponseDto>> getAll() {
		List<LiquidationResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<LiquidationResponseDto> getById(@PathVariable final Long id) {
		LiquidationResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<LiquidationResponseDto> delete(@PathVariable final Long id) {
		LiquidationResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<LiquidationResponseDto> edit(@PathVariable final Long id, @RequestBody final LiquidationRequestDto liquidationRequestDto) {
		LiquidationResponseDto responseDto = service.edit(id, liquidationRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
}
