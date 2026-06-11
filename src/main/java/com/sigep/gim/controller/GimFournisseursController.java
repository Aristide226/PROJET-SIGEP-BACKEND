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

import com.sigep.gim.dto.requestDto.FournisseursRequestDto;
import com.sigep.gim.dto.responseDto.FournisseursResponseDto;
import com.sigep.gim.service.GimFournisseursService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/fournisseurs")
@RequiredArgsConstructor
@CrossOrigin
public class GimFournisseursController {
	
	private final GimFournisseursService service;
	
	@PostMapping("/add")
	public ResponseEntity<FournisseursResponseDto> add(@RequestBody final FournisseursRequestDto fournisseursRequestDto) {
		FournisseursResponseDto responseDto = service.add(fournisseursRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<FournisseursResponseDto>> getAll() {
		List<FournisseursResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<FournisseursResponseDto> getById(@PathVariable final long id) {
		FournisseursResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<FournisseursResponseDto> delete(@PathVariable final long id) {
		FournisseursResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<FournisseursResponseDto> edit(@PathVariable final long id, @RequestBody final FournisseursRequestDto fournisseursRequestDto) {
		FournisseursResponseDto responseDto = service.edit(id, fournisseursRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
