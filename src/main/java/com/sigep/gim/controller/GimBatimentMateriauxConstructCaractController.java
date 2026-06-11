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

import com.sigep.gim.dto.requestDto.BatimentMateriauxConstructCaractRequestDto;
import com.sigep.gim.dto.responseDto.BatimentMateriauxConstructCaractResponseDto;
import com.sigep.gim.service.GimBatimentMateriauxConstructCaractService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/batimentMateriauxConstructCaract")
@RequiredArgsConstructor
@CrossOrigin
public class GimBatimentMateriauxConstructCaractController {
	
	private final GimBatimentMateriauxConstructCaractService service;
	
	@PostMapping("/add")
	public ResponseEntity<BatimentMateriauxConstructCaractResponseDto> add(@RequestBody final BatimentMateriauxConstructCaractRequestDto batimentMateriauxConstructCaractRequestDto) {
		BatimentMateriauxConstructCaractResponseDto responseDto = service.add(batimentMateriauxConstructCaractRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<BatimentMateriauxConstructCaractResponseDto>> getAll() {
		List<BatimentMateriauxConstructCaractResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<BatimentMateriauxConstructCaractResponseDto> getById(@PathVariable final int id) {
		BatimentMateriauxConstructCaractResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BatimentMateriauxConstructCaractResponseDto> delete(@PathVariable final int id) {
		BatimentMateriauxConstructCaractResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<BatimentMateriauxConstructCaractResponseDto> edit(@PathVariable final int id, @RequestBody final BatimentMateriauxConstructCaractRequestDto batimentMateriauxConstructCaractRequestDto) {
		BatimentMateriauxConstructCaractResponseDto responseDto = service.edit(id, batimentMateriauxConstructCaractRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
