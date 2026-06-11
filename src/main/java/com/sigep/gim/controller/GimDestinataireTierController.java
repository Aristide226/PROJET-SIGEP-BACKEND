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

import com.sigep.gim.dto.requestDto.DestinataireTierRequestDto;
import com.sigep.gim.dto.responseDto.DestinataireTierResponseDto;
import com.sigep.gim.service.GimDestinataireTierService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/destinataireTier")
@RequiredArgsConstructor
@CrossOrigin
public class GimDestinataireTierController {
	
	private final GimDestinataireTierService service;
	
	@PostMapping("/add")
	public ResponseEntity<DestinataireTierResponseDto> add(@RequestBody final DestinataireTierRequestDto destinataireTierRequestDto) {
		DestinataireTierResponseDto responseDto = service.add(destinataireTierRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<DestinataireTierResponseDto>> getAll() {
		List<DestinataireTierResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<DestinataireTierResponseDto> getById(@PathVariable final int id) {
		DestinataireTierResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DestinataireTierResponseDto> delete(@PathVariable final int id) {
		DestinataireTierResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<DestinataireTierResponseDto> edit(@PathVariable final int id, @RequestBody final DestinataireTierRequestDto destinataireTierRequestDto) {
		DestinataireTierResponseDto responseDto = service.edit(id, destinataireTierRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
