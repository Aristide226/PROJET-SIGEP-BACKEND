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

import com.sigep.gim.dto.requestDto.MagasinEntrepotRequestDto;
import com.sigep.gim.dto.responseDto.MagasinEntrepotResponseDto;
import com.sigep.gim.service.GimMagasinEntrepotService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/magasinEntrepot")
@RequiredArgsConstructor
@CrossOrigin
public class GimMagasinEntrepotController {
	
	private final GimMagasinEntrepotService service;
	
	@PostMapping("/add")
	public ResponseEntity<MagasinEntrepotResponseDto> add(@RequestBody final MagasinEntrepotRequestDto magasinEntrepotRequestDto) {
		MagasinEntrepotResponseDto responseDto = service.add(magasinEntrepotRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<MagasinEntrepotResponseDto>> getAll() {
		List<MagasinEntrepotResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<MagasinEntrepotResponseDto> getById(@PathVariable final int id) {
		MagasinEntrepotResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<MagasinEntrepotResponseDto> delete(@PathVariable final int id) {
		MagasinEntrepotResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<MagasinEntrepotResponseDto> edit(@PathVariable final int id, @RequestBody final MagasinEntrepotRequestDto magasinEntrepotRequestDto) {
		MagasinEntrepotResponseDto responseDto = service.edit(id, magasinEntrepotRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
