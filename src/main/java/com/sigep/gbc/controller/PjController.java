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

import com.sigep.gbc.dto.requestDto.PjRequestDto;
import com.sigep.gbc.dto.responseDto.PjResponseDto;
import com.sigep.gbc.service.PjService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/pj")
@RequiredArgsConstructor
@CrossOrigin
public class PjController {
	private final PjService service;

	@PostMapping("/add")
	public ResponseEntity<PjResponseDto> add(@RequestBody final PjRequestDto pjRequestDto) {
		PjResponseDto responseDto = service.add(pjRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PjResponseDto>> getAll() {
		List<PjResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PjResponseDto>  getById(@PathVariable final Integer id) {
		PjResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PjResponseDto> delete(@PathVariable final Integer id) {
		PjResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<PjResponseDto>  edit(@PathVariable final Integer id, @RequestBody final PjRequestDto pjRequestDto) {
		PjResponseDto responseDto = service.edit(id, pjRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
