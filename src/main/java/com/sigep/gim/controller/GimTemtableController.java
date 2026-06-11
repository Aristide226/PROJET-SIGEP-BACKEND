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

import com.sigep.gim.dto.requestDto.TemtableRequestDto;
import com.sigep.gim.dto.responseDto.TemtableResponseDto;
import com.sigep.gim.service.GimTemtableService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/temtable")
@RequiredArgsConstructor
@CrossOrigin
public class GimTemtableController {
	
	private final GimTemtableService service;
	
	@PostMapping("/add")
	public ResponseEntity<TemtableResponseDto> add(@RequestBody final TemtableRequestDto temtableRequestDto) {
		TemtableResponseDto responseDto = service.add(temtableRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<TemtableResponseDto>> getAll() {
		List<TemtableResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<TemtableResponseDto> getById(@PathVariable final String id) {
		TemtableResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TemtableResponseDto> delete(@PathVariable final String id) {
		TemtableResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<TemtableResponseDto> edit(@PathVariable final String id, @RequestBody final TemtableRequestDto temtableRequestDto) {
		TemtableResponseDto responseDto = service.edit(id, temtableRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
