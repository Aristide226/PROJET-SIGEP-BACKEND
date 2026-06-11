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

import com.sigep.gbc.dto.requestDto.EnteteStructureRequestDto;
import com.sigep.gbc.dto.responseDto.EnteteStructureResponseDto;
import com.sigep.gbc.service.EnteteStructureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/enteteStructure")
@RequiredArgsConstructor
@CrossOrigin
public class EnteteStructureController {
	
	private final EnteteStructureService service;

	@PostMapping("/add")
	public ResponseEntity<EnteteStructureResponseDto> add(@RequestBody final EnteteStructureRequestDto enteteStructureRequestDto) {
		EnteteStructureResponseDto enteteStructureResponseDto = service.add(enteteStructureRequestDto);
		return new ResponseEntity<>(enteteStructureResponseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<EnteteStructureResponseDto>> getAll() {
		List<EnteteStructureResponseDto> enteteStructureResponseDtos = service.getAll();
		return new ResponseEntity<>(enteteStructureResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<EnteteStructureResponseDto> getById(@PathVariable final String id) {
		EnteteStructureResponseDto enteteStructureResponseDto = service.getById(id);
		return new ResponseEntity<>(enteteStructureResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<EnteteStructureResponseDto> delete(@PathVariable final String id) {
		EnteteStructureResponseDto enteteStructureResponseDto = service.delete(id);
		return new ResponseEntity<>(enteteStructureResponseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{newId}/{oldId}")
	public ResponseEntity<EnteteStructureResponseDto> edit(@PathVariable final String newId, @PathVariable final String oldId, @RequestBody final EnteteStructureRequestDto enteteStructureRequestDto) {
		EnteteStructureResponseDto enteteStructureResponseDto = service.edit(newId, oldId, enteteStructureRequestDto);
		return new ResponseEntity<>(enteteStructureResponseDto, HttpStatus.OK);
	}

	@PostMapping("/addNumerotationMandat/{nmId}/toEnteteStructure/{esId}")
	public ResponseEntity<EnteteStructureResponseDto> addNmToEs(@PathVariable final String esId, @PathVariable final int nmId) {
		EnteteStructureResponseDto enteteStructureResponseDto = service.addNmToEs(esId, nmId);
		return new ResponseEntity<>(enteteStructureResponseDto, HttpStatus.OK);
	}

	@PutMapping("/removeNumerotationMandat/{esId}")
	public ResponseEntity<EnteteStructureResponseDto> removeNmFromEs(@PathVariable final String esId) {
		EnteteStructureResponseDto enteteStructureResponseDto = service.removeNmFromEs(esId);
		return new ResponseEntity<>(enteteStructureResponseDto, HttpStatus.OK);
	}	
}
