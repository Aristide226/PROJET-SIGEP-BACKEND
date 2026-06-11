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

import com.sigep.gim.dto.requestDto.PatrimoineRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineResponseDto;
import com.sigep.gim.service.GimPatrimoineService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/patrimoine")
@RequiredArgsConstructor
@CrossOrigin
public class GimPatrimoineController {
	
	private final GimPatrimoineService service;
	
	@PostMapping("/add")
	public ResponseEntity<PatrimoineResponseDto> add(@RequestBody final PatrimoineRequestDto patrimoineRequestDto) {
		PatrimoineResponseDto responseDto = service.add(patrimoineRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PatrimoineResponseDto>> getAll() {
		List<PatrimoineResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PatrimoineResponseDto> getById(@PathVariable final String id) {
		PatrimoineResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PatrimoineResponseDto> delete(@PathVariable final String id) {
		PatrimoineResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<PatrimoineResponseDto> edit(@PathVariable final String id, @RequestBody final PatrimoineRequestDto patrimoineRequestDto) {
		PatrimoineResponseDto responseDto = service.edit(id, patrimoineRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
