package com.sigep.gbc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.dto.HistoActionSHistoConSDto;
import com.sigep.gbc.dto.requestDto.HistoActionSRequestDto;
import com.sigep.gbc.dto.responseDto.HistoActionSResponseDto;
import com.sigep.gbc.service.HistoActionSService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/histoActionS")
@RequiredArgsConstructor
@CrossOrigin
public class HistoActionSController {
	private final HistoActionSService service;

	@PostMapping("/add")
	public ResponseEntity<HistoActionSResponseDto> add(@RequestBody final HistoActionSRequestDto histoActionSRequestDto) {
		HistoActionSResponseDto responseDto = service.add(histoActionSRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<HistoActionSResponseDto>> getAll() {
		List<HistoActionSResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getHistoActionSHistoConS")
	public ResponseEntity<List<HistoActionSHistoConSDto>> getHistoActionSHistoConS() {
		List<HistoActionSHistoConSDto> list = service.getHistoActionSHistoConS();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
