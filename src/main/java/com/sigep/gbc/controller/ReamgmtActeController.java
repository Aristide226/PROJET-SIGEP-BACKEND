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

import com.sigep.gbc.dto.requestDto.ReamgmtActeRequestDto;
import com.sigep.gbc.dto.responseDto.ReamgmtActeResponseDto;
import com.sigep.gbc.service.ReamgmtActeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/reamgmtActe")
@RequiredArgsConstructor
@CrossOrigin
public class ReamgmtActeController {
	private final ReamgmtActeService service;

	@PostMapping("/add")
	public ResponseEntity<ReamgmtActeResponseDto> add(@RequestBody final ReamgmtActeRequestDto reamgmtActeRequestDto) {
		ReamgmtActeResponseDto responseDto = service.add(reamgmtActeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ReamgmtActeResponseDto>> getAll() {
		List<ReamgmtActeResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ReamgmtActeResponseDto> getById(@PathVariable final Long id) {
		ReamgmtActeResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ReamgmtActeResponseDto> delete(@PathVariable Long id) {
		ReamgmtActeResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<ReamgmtActeResponseDto> edit(@PathVariable Long id, @RequestBody final ReamgmtActeRequestDto reamgmtActeRequestDto) {
		ReamgmtActeResponseDto responseDto = service.edit(id, reamgmtActeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/existsByGestionAndIdBudgetAndValide/{gestion}/{idBudget}/{valide}")
	public ResponseEntity<Boolean> existsByGestionAndIdBudgetAndValide(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Boolean valide) {
		Boolean result = service.existsByGestionAndIdBudgetAndValide(gestion, idBudget, valide);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/getByGestionAndIdBudgetAndValide/{gestion}/{idBudget}/{valide}")
	public ResponseEntity<List<ReamgmtActeResponseDto>> getByGestionAndIdBudgetAndValide(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final Boolean valide) {
		List<ReamgmtActeResponseDto> list = service.getByGestionAndIdBudgetAndValide(gestion, idBudget, valide);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
