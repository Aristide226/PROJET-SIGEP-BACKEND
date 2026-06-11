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

import com.sigep.gim.dto.requestDto.InventaireRequestDto;
import com.sigep.gim.dto.responseDto.InventaireResponseDto;
import com.sigep.gim.service.GimInventaireService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/inventaire")
@RequiredArgsConstructor
@CrossOrigin
public class GimInventaireController {
	
	private final GimInventaireService service;
	
	@PostMapping("/add")
	public ResponseEntity<InventaireResponseDto> add(@RequestBody final InventaireRequestDto inventaireRequestDto) {
		InventaireResponseDto responseDto = service.add(inventaireRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<InventaireResponseDto>> getAll() {
		List<InventaireResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<InventaireResponseDto> getById(@PathVariable final long id) {
		InventaireResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<InventaireResponseDto> delete(@PathVariable final long id) {
		InventaireResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<InventaireResponseDto> edit(@PathVariable final long id, @RequestBody final InventaireRequestDto inventaireRequestDto) {
		InventaireResponseDto responseDto = service.edit(id, inventaireRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
