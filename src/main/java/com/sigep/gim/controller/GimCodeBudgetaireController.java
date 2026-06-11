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

import com.sigep.gim.dto.CodeBudgetaireStatistiqueDto;
import com.sigep.gim.dto.requestDto.CodeBudgetaireRequestDto;
import com.sigep.gim.dto.responseDto.CodeBudgetaireResponseDto;
import com.sigep.gim.service.GimCodeBudgetaireService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/codeBudgetaire")
@RequiredArgsConstructor
@CrossOrigin
public class GimCodeBudgetaireController {
	
	private final GimCodeBudgetaireService service;
	
	@PostMapping("/add")
	public ResponseEntity<CodeBudgetaireResponseDto> add(@RequestBody final CodeBudgetaireRequestDto codeBudgetaireRequestDto) {
		CodeBudgetaireResponseDto responseDto = service.add(codeBudgetaireRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CodeBudgetaireResponseDto>> getAll() {
		List<CodeBudgetaireResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CodeBudgetaireResponseDto> getById(@PathVariable final int id) {
		CodeBudgetaireResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CodeBudgetaireResponseDto> delete(@PathVariable final int id) {
		CodeBudgetaireResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<CodeBudgetaireResponseDto> edit(@PathVariable final int id, @RequestBody final CodeBudgetaireRequestDto codeBudgetaireRequestDto) {
		CodeBudgetaireResponseDto responseDto = service.edit(id, codeBudgetaireRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/stat")
	public ResponseEntity<List<CodeBudgetaireStatistiqueDto>> getCodeBudgetaireStatistiqueDto() {
		List<CodeBudgetaireStatistiqueDto> list = service.getCodeBudgetaireStatistiqueDto();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
