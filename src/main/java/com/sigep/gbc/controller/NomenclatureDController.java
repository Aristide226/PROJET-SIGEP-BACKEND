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

import com.sigep.gbc.dto.requestDto.NomenclatureDRequestDto;
import com.sigep.gbc.dto.responseDto.NomenclatureDResponseDto;
import com.sigep.gbc.service.NomenclatureDService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/nomenclatured")
@RequiredArgsConstructor
@CrossOrigin
public class NomenclatureDController {
	private final NomenclatureDService service;

	@PostMapping("/add")
	public ResponseEntity<Void> add(@RequestBody final NomenclatureDRequestDto nomenclatureDRequestDto) {
		service.add(nomenclatureDRequestDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<NomenclatureDResponseDto>> getAll() {
		List<NomenclatureDResponseDto> nomenclatureDResponseDtos = service.getAll();
		return new ResponseEntity<>(nomenclatureDResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<NomenclatureDResponseDto> getById(@PathVariable final String id) {
		NomenclatureDResponseDto nomenclatureDResponseDto = service.getById(id);
		return new ResponseEntity<>(nomenclatureDResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<NomenclatureDResponseDto> delete(@PathVariable final String id) {
		NomenclatureDResponseDto nomenclatureDResponseDto = service.delete(id);
		return new ResponseEntity<>(nomenclatureDResponseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Void> edit(@PathVariable final String id, @RequestBody final NomenclatureDRequestDto nomenclatureDRequestDto) {
		service.edit(id, nomenclatureDRequestDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/exists/titre/{titre}/sect/{sect}/chap/{chap}/art/{art}/parag/{parag}/rub/{rub}")
	public ResponseEntity<Boolean> exists(@PathVariable final String titre, @PathVariable final String sect, @PathVariable final String chap, @PathVariable final String art, @PathVariable final String parag, @PathVariable final String rub) {
		Boolean result = service.exists(titre, sect, chap, art, parag, rub);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/getRecettesEtDepenses")
	public ResponseEntity<List<NomenclatureDResponseDto>> getRecettesEtDepenses() {
		List<NomenclatureDResponseDto> nomenclatureDResponseDtos = service.getRecettesEtDepenses();
		return new ResponseEntity<>(nomenclatureDResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/getRecettes")
	public ResponseEntity<List<NomenclatureDResponseDto>> getRecettes() {
		List<NomenclatureDResponseDto> nomenclatureDResponseDtos = service.getRecettes();
		return new ResponseEntity<>(nomenclatureDResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/getDepenses")
	public ResponseEntity<List<NomenclatureDResponseDto>> getDepenses() {
		List<NomenclatureDResponseDto> nomenclatureDResponseDtos = service.getDepenses();
		return new ResponseEntity<>(nomenclatureDResponseDtos, HttpStatus.OK);
	}
	
	
	
}
