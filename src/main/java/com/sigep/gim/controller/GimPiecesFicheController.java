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

import com.sigep.gim.dto.requestDto.PiecesFicheRequestDto;
import com.sigep.gim.dto.responseDto.PiecesFicheResponseDto;
import com.sigep.gim.service.GimPiecesFicheService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/piecesFiche")
@RequiredArgsConstructor
@CrossOrigin
public class GimPiecesFicheController {
	
	private final GimPiecesFicheService service;
	
	@PostMapping("/add")
	public ResponseEntity<PiecesFicheResponseDto> add(@RequestBody final PiecesFicheRequestDto piecesFicheRequestDto) {
		PiecesFicheResponseDto responseDto = service.add(piecesFicheRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PiecesFicheResponseDto>> getAll() {
		List<PiecesFicheResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PiecesFicheResponseDto> getById(@PathVariable final long id) {
		PiecesFicheResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PiecesFicheResponseDto> delete(@PathVariable final long id) {
		PiecesFicheResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<PiecesFicheResponseDto> edit(@PathVariable final long id, @RequestBody final PiecesFicheRequestDto piecesFicheRequestDto) {
		PiecesFicheResponseDto responseDto = service.edit(id, piecesFicheRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
