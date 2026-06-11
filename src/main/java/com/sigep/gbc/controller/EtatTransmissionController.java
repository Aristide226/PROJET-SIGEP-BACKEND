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

import com.sigep.gbc.dto.requestDto.EtatTransmissionRequestDto;
import com.sigep.gbc.dto.responseDto.EtatTransmissionResponseDto;
import com.sigep.gbc.service.EtatTransmissionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/etatTransmission")
@RequiredArgsConstructor
@CrossOrigin
public class EtatTransmissionController {
	private final EtatTransmissionService service;

	@PostMapping("/add")
	public ResponseEntity<EtatTransmissionResponseDto> add(@RequestBody final EtatTransmissionRequestDto etatTransmissionRequestDto) {
		EtatTransmissionResponseDto responseDto = service.add(etatTransmissionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<EtatTransmissionResponseDto> > getAll() {
		List<EtatTransmissionResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<EtatTransmissionResponseDto> getById(@PathVariable final Integer id) {
		EtatTransmissionResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<EtatTransmissionResponseDto> delete(@PathVariable final Integer id) {
		EtatTransmissionResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<EtatTransmissionResponseDto> edit(@PathVariable final Integer id, @RequestBody final EtatTransmissionRequestDto etatTransmissionRequestDto) {
		EtatTransmissionResponseDto responseDto = service.edit(id, etatTransmissionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
}
