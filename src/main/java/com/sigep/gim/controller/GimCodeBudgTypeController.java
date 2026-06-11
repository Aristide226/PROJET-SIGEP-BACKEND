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

import com.sigep.gim.dto.TypeBienStatistiqueDto;
import com.sigep.gim.dto.requestDto.CodeBudgTypeRequestDto;
import com.sigep.gim.dto.responseDto.CodeBudgTypeResponseDto;
import com.sigep.gim.service.GimCodeBudgTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/codeBudgType")
@RequiredArgsConstructor
@CrossOrigin
public class GimCodeBudgTypeController {
	
	private final GimCodeBudgTypeService service;
	
	@PostMapping("/add")
	public ResponseEntity<CodeBudgTypeResponseDto> add(@RequestBody final CodeBudgTypeRequestDto codeBudgTypeRequestDto) {
		CodeBudgTypeResponseDto responseDto = service.add(codeBudgTypeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CodeBudgTypeResponseDto>> getAll() {
		List<CodeBudgTypeResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CodeBudgTypeResponseDto> getById(@PathVariable final int id) {
		CodeBudgTypeResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CodeBudgTypeResponseDto> delete(@PathVariable final int id) {
		CodeBudgTypeResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<CodeBudgTypeResponseDto> edit(@PathVariable final int id, @RequestBody final CodeBudgTypeRequestDto codeBudgTypeRequestDto) {
		CodeBudgTypeResponseDto responseDto = service.edit(id, codeBudgTypeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/stat")
	public ResponseEntity<List<TypeBienStatistiqueDto>> getTypeBienStatistiqueDto() {
		List<TypeBienStatistiqueDto> list = service.getTypeBienStatistiqueDto();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
