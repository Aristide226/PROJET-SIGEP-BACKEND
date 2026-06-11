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

import com.sigep.gim.dto.requestDto.T13RequestDto;
import com.sigep.gim.dto.responseDto.T13ResponseDto;
import com.sigep.gim.service.GimT13Service;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/t13")
@RequiredArgsConstructor
@CrossOrigin
public class GimT13Controller {
	
	private final GimT13Service service;
	
	@PostMapping("/add")
	public ResponseEntity<T13ResponseDto> add(@RequestBody final T13RequestDto t13RequestDto) {
		T13ResponseDto responseDto = service.add(t13RequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<T13ResponseDto>> getAll() {
		List<T13ResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<T13ResponseDto> getById(@PathVariable final String id) {
		T13ResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<T13ResponseDto> delete(@PathVariable final String id) {
		T13ResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<T13ResponseDto> edit(@PathVariable final String id, @RequestBody final T13RequestDto t13RequestDto) {
		T13ResponseDto responseDto = service.edit(id, t13RequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
