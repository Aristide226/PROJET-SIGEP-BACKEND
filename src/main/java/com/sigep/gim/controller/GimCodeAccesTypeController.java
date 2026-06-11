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

import com.sigep.gim.dto.requestDto.CodeAccesTypeRequestDto;
import com.sigep.gim.dto.responseDto.CodeAccesTypeResponseDto;
import com.sigep.gim.service.GimCodeAccesTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/codeAccesType")
@RequiredArgsConstructor
@CrossOrigin
public class GimCodeAccesTypeController {
	
	private final GimCodeAccesTypeService service;
	
	@PostMapping("/add")
	public ResponseEntity<CodeAccesTypeResponseDto> add(@RequestBody CodeAccesTypeRequestDto codeAccesTypeRequestDto) {
		CodeAccesTypeResponseDto responseDto = service.add(codeAccesTypeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CodeAccesTypeResponseDto>> getAll() {
		List<CodeAccesTypeResponseDto> responseDtos = service.getAll();
		return new ResponseEntity<>(responseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CodeAccesTypeResponseDto> getById(@PathVariable final char id) {
		CodeAccesTypeResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CodeAccesTypeResponseDto> delete(@PathVariable final char id) {
		CodeAccesTypeResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<CodeAccesTypeResponseDto> edit(@PathVariable final char id, @RequestBody CodeAccesTypeRequestDto codeAccesTypeRequestDto) {
		CodeAccesTypeResponseDto responseDto = service.edit(id, codeAccesTypeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
