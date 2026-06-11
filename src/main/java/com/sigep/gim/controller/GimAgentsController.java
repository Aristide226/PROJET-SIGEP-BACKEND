package com.sigep.gim.controller;

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

import com.sigep.gim.dto.requestDto.AgentsRequestDto;
import com.sigep.gim.dto.responseDto.AgentsResponseDto;
import com.sigep.gim.service.GimAgentsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/agents")
@RequiredArgsConstructor
@CrossOrigin
public class GimAgentsController {
	
	private final GimAgentsService service;
	
	@PostMapping("/add")
	public ResponseEntity<AgentsResponseDto> add(@RequestBody AgentsRequestDto agentsRequestDto) {
		AgentsResponseDto responseDto = service.add(agentsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<AgentsResponseDto>> getAll() {
		List<AgentsResponseDto> responseDtos = service.getAll();
		return new ResponseEntity<>(responseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<AgentsResponseDto> getById(@PathVariable final String id) {
		AgentsResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AgentsResponseDto> delete(@PathVariable final String id) {
		AgentsResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<AgentsResponseDto> edit(@PathVariable final String id, @RequestBody AgentsRequestDto agentsRequestDto) {
		AgentsResponseDto responseDto = service.edit(id, agentsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
