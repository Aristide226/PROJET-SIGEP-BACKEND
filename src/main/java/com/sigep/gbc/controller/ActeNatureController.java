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

import com.sigep.gbc.dto.requestDto.ActeNatureRequestDto;
import com.sigep.gbc.dto.responseDto.ActeNatureResponseDto;
import com.sigep.gbc.service.ActeNatureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/acteNature")
@RequiredArgsConstructor
@CrossOrigin
public class ActeNatureController {
	private final ActeNatureService service;

	@PostMapping("/add")
	public ResponseEntity<ActeNatureResponseDto> add(@RequestBody final ActeNatureRequestDto acteNatureRequestDto) {
		ActeNatureResponseDto responseDto = service.add(acteNatureRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ActeNatureResponseDto>> getAll() {
		List<ActeNatureResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ActeNatureResponseDto> getById(@PathVariable final Integer id) {
		ActeNatureResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ActeNatureResponseDto> delete(@PathVariable final Integer id) {
		ActeNatureResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<ActeNatureResponseDto> edit(@PathVariable final Integer id, @RequestBody final ActeNatureRequestDto acteNatureRequestDto) {
		ActeNatureResponseDto responseDto = service.edit(id, acteNatureRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
