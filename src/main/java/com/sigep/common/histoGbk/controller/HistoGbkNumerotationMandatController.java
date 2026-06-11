package com.sigep.common.histoGbk.controller;

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

import com.sigep.common.histoGbk.dto.requestDto.NumerotationMandatRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.NumerotationMandatResponseDto;
import com.sigep.common.histoGbk.service.HistoGbkNumerotationMandatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/histoGbk/numerotationMandat")
@RequiredArgsConstructor
@CrossOrigin
public class HistoGbkNumerotationMandatController {
	
	private final HistoGbkNumerotationMandatService service;

	@PostMapping("/add")
	public ResponseEntity<NumerotationMandatResponseDto> add(@RequestBody final NumerotationMandatRequestDto numerotationMandatRequestDto) {
		NumerotationMandatResponseDto responseDto = service.add(numerotationMandatRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<NumerotationMandatResponseDto>> getAll() {
		List<NumerotationMandatResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<NumerotationMandatResponseDto> getById(@PathVariable final int id) {
		NumerotationMandatResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<NumerotationMandatResponseDto> delete(@PathVariable final int id) {
		NumerotationMandatResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<NumerotationMandatResponseDto> edit(@PathVariable final int id, @RequestBody final NumerotationMandatRequestDto numerotationMandatRequestDto) {
		NumerotationMandatResponseDto responseDto = service.edit(id, numerotationMandatRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
