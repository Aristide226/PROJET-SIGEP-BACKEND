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

import com.sigep.gim.dto.requestDto.DirectionsRequestDto;
import com.sigep.gim.dto.responseDto.DirectionsResponseDto;
import com.sigep.gim.service.GimDirectionsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/directions")
@RequiredArgsConstructor
@CrossOrigin
public class GimDirectionsController {
	
	final private GimDirectionsService service;
	
	@PostMapping("/add")
	public ResponseEntity<DirectionsResponseDto> add(@RequestBody DirectionsRequestDto directionsRequestDto) {
		DirectionsResponseDto responseDto = service.add(directionsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<DirectionsResponseDto>> getAll() {
		List<DirectionsResponseDto> responseDtos = service.getAll();
		return new ResponseEntity<>(responseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<DirectionsResponseDto> getById(@PathVariable final int id) {
		DirectionsResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DirectionsResponseDto> delete(@PathVariable final int id) {
		DirectionsResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<DirectionsResponseDto> edit(@PathVariable final int id, @RequestBody DirectionsRequestDto directionsRequestDto) {
		DirectionsResponseDto responseDto = service.edit(id, directionsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
