package com.sigep.gim.controller;

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

import com.sigep.gim.dto.requestDto.AmorCoefficientsRequestDto;
import com.sigep.gim.dto.responseDto.AmorCoefficientsResponseDto;
import com.sigep.gim.service.GimAmorCoefficientsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/amorCoefficients")
@RequiredArgsConstructor
@CrossOrigin
public class GimAmorCoefficientsController {
	
	private final GimAmorCoefficientsService service;
	
	@PostMapping("/add")
	public ResponseEntity<AmorCoefficientsResponseDto> add(@RequestBody final AmorCoefficientsRequestDto amorCoefficientsRequestDto) {
		AmorCoefficientsResponseDto responseDto = service.add(amorCoefficientsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<AmorCoefficientsResponseDto>> getAll() {
		List<AmorCoefficientsResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{amorType}/{dureeMin}")
	public ResponseEntity<AmorCoefficientsResponseDto> getById(@PathVariable final char amorType, @PathVariable final int dureeMin) {
		AmorCoefficientsResponseDto responseDto = service.getById(amorType,dureeMin);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{amorType}/{dureeMin}")
	public ResponseEntity<AmorCoefficientsResponseDto> delete(@PathVariable final char amorType, @PathVariable final int dureeMin) {
		AmorCoefficientsResponseDto responseDto = service.delete(amorType,dureeMin);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{amorType}/{dureeMin}")
	public ResponseEntity<AmorCoefficientsResponseDto> edit(@PathVariable final char amorType, @PathVariable final int dureeMin, @RequestBody final AmorCoefficientsRequestDto amorCoefficientsRequestDto) {
		AmorCoefficientsResponseDto responseDto = service.edit(amorType,dureeMin,amorCoefficientsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
