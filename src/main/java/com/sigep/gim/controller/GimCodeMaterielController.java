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

import com.sigep.gim.dto.requestDto.CodeMaterielRequestDto;
import com.sigep.gim.dto.responseDto.CodeMaterielResponseDto;
import com.sigep.gim.service.GimCodeMaterielService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/codeMateriel")
@RequiredArgsConstructor
@CrossOrigin
public class GimCodeMaterielController {
	
	private final GimCodeMaterielService service;
	
	@PostMapping("/add")
	public ResponseEntity<CodeMaterielResponseDto> add(@RequestBody final CodeMaterielRequestDto codeMaterielRequestDto) {
		CodeMaterielResponseDto responseDto = service.add(codeMaterielRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CodeMaterielResponseDto>> getAll() {
		List<CodeMaterielResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CodeMaterielResponseDto> getById(@PathVariable final String id) {
		CodeMaterielResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CodeMaterielResponseDto> delete(@PathVariable final String id) {
		CodeMaterielResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<CodeMaterielResponseDto> edit(@PathVariable final String id, @RequestBody final CodeMaterielRequestDto codeMaterielRequestDto) {
		CodeMaterielResponseDto responseDto = service.edit(id, codeMaterielRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
