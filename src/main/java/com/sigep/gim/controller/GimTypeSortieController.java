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

import com.sigep.gim.dto.requestDto.TypeSortieRequestDto;
import com.sigep.gim.dto.responseDto.TypeSortieResponseDto;
import com.sigep.gim.service.GimTypeSortieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/typeSortie")
@RequiredArgsConstructor
@CrossOrigin
public class GimTypeSortieController {
	
	private final GimTypeSortieService service;
	
	@PostMapping("/add")
	public ResponseEntity<TypeSortieResponseDto> add(@RequestBody final TypeSortieRequestDto typeSortieRequestDto) {
		TypeSortieResponseDto responseDto = service.add(typeSortieRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<TypeSortieResponseDto>> getAll() {
		List<TypeSortieResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<TypeSortieResponseDto> getById(@PathVariable final short id) {
		TypeSortieResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TypeSortieResponseDto> delete(@PathVariable final short id) {
		TypeSortieResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<TypeSortieResponseDto> edit(@PathVariable final short id, @RequestBody final TypeSortieRequestDto typeSortieRequestDto) {
		TypeSortieResponseDto responseDto = service.edit(id, typeSortieRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
