package com.sigep.gbc.controller;

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

import com.sigep.gbc.dto.requestDto.PieceJustifRequestDto;
import com.sigep.gbc.dto.responseDto.PieceJustifResponseDto;
import com.sigep.gbc.service.PieceJustifService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/pieceJustif")
@RequiredArgsConstructor
@CrossOrigin
public class PieceJustifController {
	private final PieceJustifService service;

	@PostMapping("/add")
	public ResponseEntity<PieceJustifResponseDto> add(@RequestBody final PieceJustifRequestDto pieceJustifRequestDto) {
		PieceJustifResponseDto responseDto = service.add(pieceJustifRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PieceJustifResponseDto>> getAll() {
		List<PieceJustifResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PieceJustifResponseDto> getById(@PathVariable final String id) {
		PieceJustifResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PieceJustifResponseDto> delete(@PathVariable final String id) {
		PieceJustifResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<PieceJustifResponseDto> edit(@PathVariable final String id, @RequestBody final PieceJustifRequestDto pieceJustifRequestDto) {
		PieceJustifResponseDto responseDto = service.edit(id, pieceJustifRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PostMapping("/addPiecesJustificatives/{numBe}")
	public ResponseEntity<Boolean> addPiecesJustificatives(@PathVariable final Long numBe, @RequestBody final List<PieceJustifRequestDto> pieceJustifRequestDtos) {
		Boolean result = service.addPiecesJustificatives(numBe, pieceJustifRequestDtos);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/getByNumBeOrderByPieceJustificative/{numBe}")
	public ResponseEntity<List<PieceJustifResponseDto>> getByNumBeOrderByPieceJustificative(@PathVariable final Long numBe) {
		List<PieceJustifResponseDto> list = service.getByNumBeOrderByPieceJustificative(numBe);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/deleteByNumBe/{numBe}")
	public ResponseEntity<List<PieceJustifResponseDto>> deleteByNumBe(@PathVariable final Long numBe) {
		List<PieceJustifResponseDto> list = service.deleteByNumBe(numBe);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/addPiecesJustificativesRDL/{codLiq}")
	public ResponseEntity<Boolean> addPiecesJustificativesRDL(@PathVariable final Long codLiq, @RequestBody final List<PieceJustifRequestDto> pieceJustifRequestDtos) {
		Boolean result = service.addPiecesJustificativesRDL(codLiq, pieceJustifRequestDtos);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/getByCodLiqOrderByPieceJustificative/{codLiq}")
	public ResponseEntity<List<PieceJustifResponseDto>> getByCodLiqOrderByPieceJustificative(@PathVariable final Long codLiq) {
		List<PieceJustifResponseDto> list = service.getByCodLiqOrderByPieceJustificative(codLiq);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/deleteByCodLiq/{codLiq}")
	public ResponseEntity<List<PieceJustifResponseDto>> deleteByCodLiq(@PathVariable final Long codLiq) {
		List<PieceJustifResponseDto> list = service.deleteByCodLiq(codLiq);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/addPiecesJustificativesLiquidation/{numMand}")
	public ResponseEntity<Boolean> addPiecesJustificativesLiquidation(@PathVariable final Long numMand, @RequestBody final List<PieceJustifRequestDto> pieceJustifRequestDtos) {
		Boolean result = service.addPiecesJustificativesLiquidation(numMand, pieceJustifRequestDtos);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/getByNumMandOrderByPieceJustificative/{numMand}")
	public ResponseEntity<List<PieceJustifResponseDto>> getByNumMandOrderByPieceJustificative(@PathVariable final Long numMand) {
		List<PieceJustifResponseDto> list = service.getByNumMandOrderByPieceJustificative(numMand);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/deleteByNumMand/{numMand}")
	public ResponseEntity<List<PieceJustifResponseDto>> deleteByNumMand(@PathVariable final Long numMand) {
		List<PieceJustifResponseDto> list = service.deleteByNumMand(numMand);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
