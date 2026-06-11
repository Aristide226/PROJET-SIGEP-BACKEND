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

import com.sigep.gim.dto.requestDto.SignataireParDefautRequestDto;
import com.sigep.gim.dto.responseDto.SignataireParDefautResponseDto;
import com.sigep.gim.service.GimSignataireParDefautService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/signataireParDefaut")
@RequiredArgsConstructor
@CrossOrigin
public class GimSignataireParDefautController {
	
	private final GimSignataireParDefautService service;
	
	@PostMapping("/add")
	public ResponseEntity<SignataireParDefautResponseDto> add(@RequestBody final SignataireParDefautRequestDto signataireParDefautRequestDto) {
		SignataireParDefautResponseDto responseDto = service.add(signataireParDefautRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<SignataireParDefautResponseDto>> getAll() {
		List<SignataireParDefautResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<SignataireParDefautResponseDto> getById(@PathVariable final String id) {
		SignataireParDefautResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<SignataireParDefautResponseDto> delete(@PathVariable final String id) {
		SignataireParDefautResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<SignataireParDefautResponseDto> edit(@PathVariable final String id, @RequestBody final SignataireParDefautRequestDto signataireParDefautRequestDto) {
		SignataireParDefautResponseDto responseDto = service.edit(id, signataireParDefautRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
