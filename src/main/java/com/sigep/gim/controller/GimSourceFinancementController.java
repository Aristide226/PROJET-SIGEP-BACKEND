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

import com.sigep.gim.dto.FinancementStatistiqueDto;
import com.sigep.gim.dto.requestDto.SourceFinancementRequestDto;
import com.sigep.gim.dto.responseDto.SourceFinancementResponseDto;
import com.sigep.gim.service.GimSourceFinancementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/sourceFinancement")
@RequiredArgsConstructor
@CrossOrigin
public class GimSourceFinancementController {
	
	private final GimSourceFinancementService service;
	
	@PostMapping("/add")
	public ResponseEntity<SourceFinancementResponseDto> add(@RequestBody final SourceFinancementRequestDto sourceFinancementRequestDto) {
		SourceFinancementResponseDto responseDto = service.add(sourceFinancementRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<SourceFinancementResponseDto>> getAll() {
		List<SourceFinancementResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<SourceFinancementResponseDto> getById(@PathVariable final String id) {
		SourceFinancementResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<SourceFinancementResponseDto> delete(@PathVariable final String id) {
		SourceFinancementResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<SourceFinancementResponseDto> edit(@PathVariable final String id, @RequestBody final SourceFinancementRequestDto sourceFinancementRequestDto) {
		SourceFinancementResponseDto responseDto = service.edit(id, sourceFinancementRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/stat")
	public ResponseEntity<List<FinancementStatistiqueDto>> getFinancementStatistiqueParCategorie(){
		List<FinancementStatistiqueDto> list = service.getFinancementStatistiqueParCategorie();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
