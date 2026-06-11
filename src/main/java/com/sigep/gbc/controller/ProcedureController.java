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

import com.sigep.gbc.dto.requestDto.ProcedureRequestDto;
import com.sigep.gbc.dto.responseDto.ProcedureResponseDto;
import com.sigep.gbc.service.ProcedureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/procedure")
@RequiredArgsConstructor
@CrossOrigin
public class ProcedureController {
	private final ProcedureService service;

	@PostMapping("/add")
	public ResponseEntity<ProcedureResponseDto> add(@RequestBody final ProcedureRequestDto procedureRequestDto) {
		ProcedureResponseDto responseDto = service.add(procedureRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ProcedureResponseDto>> getAll() {
		List<ProcedureResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ProcedureResponseDto> getById(@PathVariable final String id) {
		ProcedureResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ProcedureResponseDto> delete(@PathVariable final String id) {
		ProcedureResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<ProcedureResponseDto> edit(@PathVariable final String id, @RequestBody final ProcedureRequestDto procedureRequestDto) {
		ProcedureResponseDto responseDto = service.edit(id, procedureRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
