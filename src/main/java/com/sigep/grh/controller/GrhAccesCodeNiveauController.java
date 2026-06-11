package com.sigep.grh.controller;

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

import com.sigep.grh.dto.requestDto.AccesCodeNiveauRequestDto;
import com.sigep.grh.dto.responseDto.AccesCodeNiveauResponseDto;
import com.sigep.grh.service.GrhAccesCodeNiveauService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/grh/accesCodeNiveau")
@RequiredArgsConstructor
@CrossOrigin
public class GrhAccesCodeNiveauController {
	private final GrhAccesCodeNiveauService service;

	@PostMapping("/add")
	public ResponseEntity<AccesCodeNiveauResponseDto> add(@RequestBody final AccesCodeNiveauRequestDto accesCodeNiveauRequestDto) {
		AccesCodeNiveauResponseDto accesCodeNiveauResponseDto = service.add(accesCodeNiveauRequestDto);
		return new ResponseEntity<>(accesCodeNiveauResponseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<AccesCodeNiveauResponseDto>> getAll() {
		List<AccesCodeNiveauResponseDto> accesCodeNiveauResponseDtos = service.getAll();
		return new ResponseEntity<>(accesCodeNiveauResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<AccesCodeNiveauResponseDto>  getById(@PathVariable final String id) {
		AccesCodeNiveauResponseDto accesCodeNiveauResponseDto = service.getById(id);
		return new ResponseEntity<>(accesCodeNiveauResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AccesCodeNiveauResponseDto>  delete(@PathVariable final String id) {
		AccesCodeNiveauResponseDto accesCodeNiveauResponseDto = service.delete(id);
		return new ResponseEntity<>(accesCodeNiveauResponseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<AccesCodeNiveauResponseDto>  edit(@PathVariable final String id, @RequestBody final AccesCodeNiveauRequestDto accesCodeNiveauRequestDto) {
		AccesCodeNiveauResponseDto accesCodeNiveauResponseDto = service.edit(id, accesCodeNiveauRequestDto);
		return new ResponseEntity<>(accesCodeNiveauResponseDto, HttpStatus.OK);
	}
}
