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

import com.sigep.common.histoGbk.dto.requestDto.EnteteRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.EnteteResponseDto;
import com.sigep.common.histoGbk.service.HistoGbkEnteteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/histoGbk/entete")
@RequiredArgsConstructor
@CrossOrigin
public class HistoGbkEnteteController {
	
	private final HistoGbkEnteteService service;

	@PostMapping("/add")
	public ResponseEntity<EnteteResponseDto> add(@RequestBody final EnteteRequestDto enteteRequestDto) {
		EnteteResponseDto enteteResponseDto = service.add(enteteRequestDto);
		return new ResponseEntity<>(enteteResponseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<EnteteResponseDto>> getAll() {
		List<EnteteResponseDto> enteteResponseDtos = service.getAll();
		return new ResponseEntity<>(enteteResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<EnteteResponseDto> getById(@PathVariable final String id) {
		EnteteResponseDto enteteResponseDto = service.getById(id);
		return new ResponseEntity<>(enteteResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<EnteteResponseDto> delete(@PathVariable final String id) {
		EnteteResponseDto enteteResponseDto = service.delete(id);
		return new ResponseEntity<>(enteteResponseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<EnteteResponseDto> edit(@PathVariable final String id, @RequestBody final EnteteRequestDto enteteRequestDto) {
		EnteteResponseDto enteteResponseDto = service.edit(id, enteteRequestDto);
		return new ResponseEntity<>(enteteResponseDto, HttpStatus.OK);
	}

	@PostMapping("/addEnteteStructure/{esId}/toEntete/{eId}")
	public ResponseEntity<EnteteResponseDto> addEsToE(@PathVariable final String eId, @PathVariable final String esId) {
		EnteteResponseDto enteteResponseDto = service.addEsToE(eId, esId);
		return new ResponseEntity<>(enteteResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/removeEnteteStructure/{eId}")
	public ResponseEntity<EnteteResponseDto> removeEsFromE(@PathVariable final String eId) {
		EnteteResponseDto enteteResponseDto = service.removeEsFromE(eId);
		return new ResponseEntity<>(enteteResponseDto, HttpStatus.OK);
	}
}
