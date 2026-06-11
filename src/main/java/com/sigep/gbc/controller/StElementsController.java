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

import com.sigep.gbc.dto.requestDto.StElementsRequestDto;
import com.sigep.gbc.dto.responseDto.StElementsResponseDto;
import com.sigep.gbc.service.StElementsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/stElements")
@RequiredArgsConstructor
@CrossOrigin
public class StElementsController {
	private final StElementsService service;

	@PostMapping("/add")
	public ResponseEntity<StElementsResponseDto> add(@RequestBody final StElementsRequestDto stElementsRequestDto) {
		StElementsResponseDto responseDto = service.add(stElementsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<StElementsResponseDto>> getAll() {
		List<StElementsResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<StElementsResponseDto> getById(@PathVariable final String id) {
		StElementsResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<StElementsResponseDto> delete(@PathVariable final String id) {
		StElementsResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<StElementsResponseDto> edit(@PathVariable final String id, @RequestBody final StElementsRequestDto stElementsRequestDto) {
		StElementsResponseDto responseDto = service.edit(id, stElementsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
