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

import com.sigep.gim.dto.requestDto.TypeAcquisitionRequestDto;
import com.sigep.gim.dto.responseDto.TypeAcquisitionResponseDto;
import com.sigep.gim.service.GimTypeAcquisitionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/typeAcquisition")
@RequiredArgsConstructor
@CrossOrigin
public class GimTypeAcquisitionController {
	
	private final GimTypeAcquisitionService service;
	
	@PostMapping("/add")
	public ResponseEntity<TypeAcquisitionResponseDto> add(@RequestBody final TypeAcquisitionRequestDto typeAcquisitionRequestDto) {
		TypeAcquisitionResponseDto responseDto = service.add(typeAcquisitionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<TypeAcquisitionResponseDto>> getAll() {
		List<TypeAcquisitionResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<TypeAcquisitionResponseDto> getById(@PathVariable final int id) {
		TypeAcquisitionResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TypeAcquisitionResponseDto> delete(@PathVariable final int id) {
		TypeAcquisitionResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<TypeAcquisitionResponseDto> edit(@PathVariable final int id, @RequestBody final TypeAcquisitionRequestDto typeAcquisitionRequestDto) {
		TypeAcquisitionResponseDto responseDto = service.edit(id, typeAcquisitionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
