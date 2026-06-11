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

import com.sigep.gbc.dto.ReamgmtBudgetDto;
import com.sigep.gbc.dto.requestDto.ReamgmtRequestDto;
import com.sigep.gbc.dto.responseDto.ReamgmtResponseDto;
import com.sigep.gbc.service.ReamgmtService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/reamgmt")
@RequiredArgsConstructor
@CrossOrigin
public class ReamgmtController {
	private final ReamgmtService service;

	@PostMapping("/add")
	public ResponseEntity<ReamgmtResponseDto> add(@RequestBody final ReamgmtRequestDto reamgmtRequestDto) {
		ReamgmtResponseDto responseDto = service.add(reamgmtRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ReamgmtResponseDto>> getAll() {
		List<ReamgmtResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{codReam}/{codBud}")
	public ResponseEntity<ReamgmtResponseDto> getById(@PathVariable final Long codReam, @PathVariable final String codBud) {
		ReamgmtResponseDto responseDto = service.getById(codReam, codBud);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{codReam}/{codBud}")
	public ResponseEntity<ReamgmtResponseDto> delete(@PathVariable final Long codReam, @PathVariable final String codBud) {
		ReamgmtResponseDto responseDto = service.delete(codReam, codBud);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{codReam}/{codBud}")
	public ResponseEntity<ReamgmtResponseDto> edit(@PathVariable final Long codReam, @PathVariable final String codBud, @RequestBody final ReamgmtRequestDto reamgmtRequestDto) {
		ReamgmtResponseDto responseDto = service.edit(codReam, codBud, reamgmtRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getByCodReam/{codReam}")
	public ResponseEntity<List<ReamgmtResponseDto>> getByCodReam(@PathVariable final Long codReam) {
		List<ReamgmtResponseDto> list = service.getByCodReam(codReam);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getLigneModifieesRecettesDepenses/{codReam}")
	public ResponseEntity<List<ReamgmtBudgetDto>> getLigneModifieesRecettesDepenses(@PathVariable final Long codReam) {
		List<ReamgmtBudgetDto> list = service.getLigneModifieesRecettesDepenses(codReam);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/addLignesModifiees")
	public ResponseEntity<Boolean> addLignesModifiees(@RequestBody final List<ReamgmtRequestDto> reamgmtRequestDtos) {
		Boolean result = service.addLignesModifiees(reamgmtRequestDtos);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/deleteLignesModifiees/{codReam}")
	public ResponseEntity<Boolean> deleteLignesModifiees(@PathVariable final Long codReam) {
		Boolean result = service.deleteLignesModifiees(codReam);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/exists/{codReam}/{codBud}")
	public ResponseEntity<Boolean> exists(@PathVariable final Long codReam, @PathVariable final String codBud) {
		Boolean result = service.exists(codReam, codBud);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/editAllReam/{codReam}")
	public ResponseEntity<Boolean> editAllReam(@PathVariable final Long codReam) {
		Boolean result = service.editAllReam(codReam);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
