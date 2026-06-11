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

import com.sigep.gim.dto.requestDto.FournisseurTypeRequestDto;
import com.sigep.gim.dto.responseDto.FournisseurTypeResponseDto;
import com.sigep.gim.service.GimFournisseurTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/fournisseurType")
@RequiredArgsConstructor
@CrossOrigin
public class GimFournisseurTypeController {
	
	private final GimFournisseurTypeService service;
	
	@PostMapping("/add")
	public ResponseEntity<FournisseurTypeResponseDto> add(@RequestBody final FournisseurTypeRequestDto fournisseurTypeRequestDto) {
		FournisseurTypeResponseDto responseDto = service.add(fournisseurTypeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<FournisseurTypeResponseDto>> getAll() {
		List<FournisseurTypeResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<FournisseurTypeResponseDto> getById(@PathVariable final String id) {
		FournisseurTypeResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<FournisseurTypeResponseDto> delete(@PathVariable final String id) {
		FournisseurTypeResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<FournisseurTypeResponseDto> edit(@PathVariable final String id, @RequestBody final FournisseurTypeRequestDto fournisseurTypeRequestDto) {
		FournisseurTypeResponseDto responseDto = service.edit(id, fournisseurTypeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
