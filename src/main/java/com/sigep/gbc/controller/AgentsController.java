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

import com.sigep.gbc.dto.requestDto.AgentsRequestDto;
import com.sigep.gbc.dto.responseDto.AgentsResponseDto;
import com.sigep.gbc.service.AgentsService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/agents")
@RequiredArgsConstructor
@CrossOrigin
public class AgentsController {
	private final AgentsService service;

	@PostMapping("/add")
	public ResponseEntity<AgentsResponseDto> add(@RequestBody final AgentsRequestDto agentsRequestDto) {
		AgentsResponseDto agentsResponseDto = service.add(agentsRequestDto);
		return new ResponseEntity<>(agentsResponseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<AgentsResponseDto>> getAll() {
		List<AgentsResponseDto> agentsResponseDtos = service.getAll();
		return new ResponseEntity<>(agentsResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<AgentsResponseDto> getById(@PathVariable final Long id) {
		AgentsResponseDto agentsResponseDto = service.getById(id);
		return new ResponseEntity<>(agentsResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AgentsResponseDto> delete(@PathVariable final Long id) {
		AgentsResponseDto agentsResponseDto = service.delete(id);
		return new ResponseEntity<>(agentsResponseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<AgentsResponseDto> edit(@PathVariable final Long id, @RequestBody final AgentsRequestDto agentsRequestDto) {
		AgentsResponseDto agentsResponseDto = service.edit(id, agentsRequestDto);
		return new ResponseEntity<>(agentsResponseDto, HttpStatus.OK);
	}
}
