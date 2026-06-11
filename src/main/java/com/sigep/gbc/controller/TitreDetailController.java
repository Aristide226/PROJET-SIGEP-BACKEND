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

import com.sigep.gbc.dto.requestDto.TitreDetailRequestDto;
import com.sigep.gbc.dto.responseDto.TitreDetailResponseDto;
import com.sigep.gbc.service.TitreDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/titreDetail")
@RequiredArgsConstructor
@CrossOrigin
public class TitreDetailController {
	private final TitreDetailService service;

	@PostMapping("/add")
	public ResponseEntity<TitreDetailResponseDto> add(@RequestBody final TitreDetailRequestDto titreDetailRequestDto) {
		TitreDetailResponseDto responseDto = service.add(titreDetailRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<TitreDetailResponseDto>> getAll() {
		List<TitreDetailResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<TitreDetailResponseDto> getById(@PathVariable final Long id) {
		TitreDetailResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TitreDetailResponseDto> delete(@PathVariable final Long id) {
		TitreDetailResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<TitreDetailResponseDto> edit(@PathVariable final Long id, @RequestBody final TitreDetailRequestDto titreDetailRequestDto) {
		TitreDetailResponseDto responseDto = service.edit(id, titreDetailRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	
}
