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

import com.sigep.gbc.dto.requestDto.PpmProcedureRequestDto;
import com.sigep.gbc.dto.responseDto.PpmProcedureResponseDto;
import com.sigep.gbc.service.PpmProcedureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/ppmProcedure")
@RequiredArgsConstructor
@CrossOrigin
public class PpmProcedureController {
	private final PpmProcedureService service;

	@PostMapping("/add")
	public ResponseEntity<PpmProcedureResponseDto> add(@RequestBody final PpmProcedureRequestDto ppmProcedureRequestDto) {
		PpmProcedureResponseDto responseDto = service.add(ppmProcedureRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PpmProcedureResponseDto>> getAll() {
		List<PpmProcedureResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PpmProcedureResponseDto> getById(@PathVariable final Integer id) {
		PpmProcedureResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PpmProcedureResponseDto> delete(@PathVariable final Integer id) {
		PpmProcedureResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<PpmProcedureResponseDto> edit(@PathVariable final Integer id, @RequestBody final PpmProcedureRequestDto ppmProcedureRequestDto) {
		PpmProcedureResponseDto responseDto = service.edit(id, ppmProcedureRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
