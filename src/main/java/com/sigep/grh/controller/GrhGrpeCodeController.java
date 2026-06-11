package com.sigep.grh.controller;

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

import com.sigep.grh.dto.requestDto.GrpeCodeRequestDto;
import com.sigep.grh.dto.responseDto.GrpeCodeResponseDto;
import com.sigep.grh.service.GrhGrpeCodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/grh/grpeCode")
@RequiredArgsConstructor
@CrossOrigin
public class GrhGrpeCodeController {
private final GrhGrpeCodeService service;
	
	@PostMapping("/add")
	public ResponseEntity<GrpeCodeResponseDto> add(@RequestBody final GrpeCodeRequestDto grpeCodeRequestDto) {
		GrpeCodeResponseDto grpeCodeResponseDto = service.add(grpeCodeRequestDto);
		return new ResponseEntity<>(grpeCodeResponseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<GrpeCodeResponseDto>> getAll() {
		List<GrpeCodeResponseDto> grpeCodeResponseDtos = service.getAll();
		return new ResponseEntity<>(grpeCodeResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<GrpeCodeResponseDto>  getById(@PathVariable final String id) {
		GrpeCodeResponseDto grpeCodeResponseDto = service.getById(id);
		return new ResponseEntity<>(grpeCodeResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GrpeCodeResponseDto>  delete(@PathVariable final String id) {
		GrpeCodeResponseDto grpeCodeResponseDto = service.delete(id);
		return new ResponseEntity<>(grpeCodeResponseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<GrpeCodeResponseDto>  edit(@PathVariable final String id, @RequestBody final GrpeCodeRequestDto grpeCodeRequestDto) {
		GrpeCodeResponseDto grpeCodeResponseDto = service.edit(id, grpeCodeRequestDto);
		return new ResponseEntity<>(grpeCodeResponseDto, HttpStatus.OK);
	}
}
