package com.sigep.gim.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gim.dto.requestDto.EtatBienRequestDto;
import com.sigep.gim.dto.responseDto.EtatBienResponseDto;
import com.sigep.gim.service.GimEtatBienService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/etatBien")
@RequiredArgsConstructor
@CrossOrigin
public class GimEtatBienController {
	
	private final GimEtatBienService service;
	
	@PostMapping("/add")
	public ResponseEntity<EtatBienResponseDto> add(@RequestBody final EtatBienRequestDto etatBienRequestDto) {
		EtatBienResponseDto responseDto = service.add(etatBienRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EtatBienResponseDto>> getAll() {
		List<EtatBienResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<EtatBienResponseDto> getById(@PathVariable final String id) {
		EtatBienResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<EtatBienResponseDto> delete(@PathVariable final String id) {
		EtatBienResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
