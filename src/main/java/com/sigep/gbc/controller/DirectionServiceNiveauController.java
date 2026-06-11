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

import com.sigep.gbc.dto.requestDto.DirectionServiceNiveauRequestDto;
import com.sigep.gbc.dto.responseDto.DirectionServiceNiveauResponseDto;
import com.sigep.gbc.service.DirectionServiceNiveauService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/directionServiceNiveau")
@RequiredArgsConstructor
@CrossOrigin
public class DirectionServiceNiveauController {
	private final DirectionServiceNiveauService service;

	@PostMapping("/add")
	public ResponseEntity<DirectionServiceNiveauResponseDto> add(@RequestBody final DirectionServiceNiveauRequestDto directionServiceNiveauRequestDto) {
		DirectionServiceNiveauResponseDto directionServiceNiveauResponseDto = service.add(directionServiceNiveauRequestDto);
		return new ResponseEntity<>(directionServiceNiveauResponseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<DirectionServiceNiveauResponseDto>> getAll() {
		List<DirectionServiceNiveauResponseDto> directionServiceNiveauResponseDtos = service.getAll();
		return new ResponseEntity<>(directionServiceNiveauResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<DirectionServiceNiveauResponseDto> getById(@PathVariable final Integer id) {
		DirectionServiceNiveauResponseDto directionServiceNiveauResponseDto = service.getById(id);
		return new ResponseEntity<>(directionServiceNiveauResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DirectionServiceNiveauResponseDto> delete(@PathVariable final Integer id) {
		DirectionServiceNiveauResponseDto directionServiceNiveauResponseDto = service.delete(id);
		return new ResponseEntity<>(directionServiceNiveauResponseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<DirectionServiceNiveauResponseDto> edit(@PathVariable final Integer id,
			@RequestBody final DirectionServiceNiveauRequestDto directionServiceNiveauRequestDto) {
		DirectionServiceNiveauResponseDto directionServiceNiveauResponseDto = service.edit(id, directionServiceNiveauRequestDto);
		return new ResponseEntity<>(directionServiceNiveauResponseDto, HttpStatus.OK);
	}
}
