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

import com.sigep.gbc.dto.requestDto.DirectionServiceRequestDto;
import com.sigep.gbc.dto.responseDto.DirectionServiceResponseDto;
import com.sigep.gbc.service.DirectionServiceService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/directionService")
@RequiredArgsConstructor
@CrossOrigin
public class DirectionServiceController {
	private final DirectionServiceService service;

	@PostMapping("/add")
	public ResponseEntity<DirectionServiceResponseDto> add(@RequestBody final DirectionServiceRequestDto directionServiceRequestDto) {
		DirectionServiceResponseDto directionServiceResponseDto = service.add(directionServiceRequestDto);
		return new ResponseEntity<>(directionServiceResponseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<DirectionServiceResponseDto>> getAll() {
		List<DirectionServiceResponseDto> directionServiceResponseDtos = service.getAll();
		return new ResponseEntity<>(directionServiceResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<DirectionServiceResponseDto> getById(@PathVariable final Integer id) {
		DirectionServiceResponseDto directionServiceResponseDto = service.getById(id);
		return new ResponseEntity<>(directionServiceResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DirectionServiceResponseDto> delete(@PathVariable final Integer id) {
		DirectionServiceResponseDto directionServiceResponseDto = service.delete(id);
		return new ResponseEntity<>(directionServiceResponseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<DirectionServiceResponseDto> edit(@PathVariable final Integer id, @RequestBody final DirectionServiceRequestDto directionServiceRequestDto) {
		DirectionServiceResponseDto directionServiceResponseDto = service.edit(id, directionServiceRequestDto);
		return new ResponseEntity<>(directionServiceResponseDto, HttpStatus.OK);
	}
}
