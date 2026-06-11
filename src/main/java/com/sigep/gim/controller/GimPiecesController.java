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

import com.sigep.gim.dto.requestDto.PiecesRequestDto;
import com.sigep.gim.dto.responseDto.PiecesResponseDto;
import com.sigep.gim.service.GimPiecesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/pieces")
@RequiredArgsConstructor
@CrossOrigin
public class GimPiecesController {
	
	private final GimPiecesService service;
	
	@PostMapping("/add")
	public ResponseEntity<PiecesResponseDto> add(@RequestBody final PiecesRequestDto piecesRequestDto) {
		PiecesResponseDto responseDto = service.add(piecesRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PiecesResponseDto>> getAll() {
		List<PiecesResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PiecesResponseDto> getById(@PathVariable final long id) {
		PiecesResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PiecesResponseDto> delete(@PathVariable final long id) {
		PiecesResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<PiecesResponseDto> edit(@PathVariable final long id, @RequestBody final PiecesRequestDto piecesRequestDto) {
		PiecesResponseDto responseDto = service.edit(id, piecesRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
