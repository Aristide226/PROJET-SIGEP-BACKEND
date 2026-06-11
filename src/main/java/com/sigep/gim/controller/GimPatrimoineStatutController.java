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

import com.sigep.gim.dto.requestDto.PatrimoineStatutRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineStatutResponseDto;
import com.sigep.gim.service.GimPatrimoineStatutService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/patrimoineStatut")
@RequiredArgsConstructor
@CrossOrigin
public class GimPatrimoineStatutController {
	
	private final GimPatrimoineStatutService service;
	
	@PostMapping("/add")
	public ResponseEntity<PatrimoineStatutResponseDto> add(@RequestBody final PatrimoineStatutRequestDto patrimoineStatutRequestDto) {
		PatrimoineStatutResponseDto responseDto = service.add(patrimoineStatutRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PatrimoineStatutResponseDto>> getAll() {
		List<PatrimoineStatutResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PatrimoineStatutResponseDto> getById(@PathVariable final String id) {
		PatrimoineStatutResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PatrimoineStatutResponseDto> delete(@PathVariable final String id) {
		PatrimoineStatutResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<PatrimoineStatutResponseDto> edit(@PathVariable final String id, @RequestBody final PatrimoineStatutRequestDto patrimoineStatutRequestDto) {
		PatrimoineStatutResponseDto responseDto = service.edit(id, patrimoineStatutRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
