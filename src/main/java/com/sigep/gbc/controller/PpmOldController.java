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

import com.sigep.gbc.dto.requestDto.PpmOldRequestDto;
import com.sigep.gbc.dto.responseDto.PpmOldResponseDto;
import com.sigep.gbc.service.PpmOldService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/ppmOld")
@RequiredArgsConstructor
@CrossOrigin
public class PpmOldController {
	private final PpmOldService service;

	@PostMapping("/add")
	public ResponseEntity<PpmOldResponseDto>  add(@RequestBody final PpmOldRequestDto ppmOldRequestDto) {
		PpmOldResponseDto responseDto = service.add(ppmOldRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PpmOldResponseDto>> getAll() {
		List<PpmOldResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{idPpmM}/{idPpm}")
	public ResponseEntity<PpmOldResponseDto>  getById(@PathVariable final String idPpmM, @PathVariable final String idPpm) {
		PpmOldResponseDto responseDto = service.getById(idPpmM, idPpm);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/get/{idPpmM}/{idPpm}")
	public ResponseEntity<PpmOldResponseDto>  delete(@PathVariable final String idPpmM, @PathVariable final String idPpm) {
		PpmOldResponseDto responseDto = service.delete(idPpmM, idPpm);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/get/{idPpmM}/{idPpm}")
	public ResponseEntity<PpmOldResponseDto> edit(@PathVariable final String idPpmM, @PathVariable final String idPpm, @RequestBody final PpmOldRequestDto ppmOldRequestDto) {
		PpmOldResponseDto responseDto = service.edit(idPpmM, idPpm, ppmOldRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
