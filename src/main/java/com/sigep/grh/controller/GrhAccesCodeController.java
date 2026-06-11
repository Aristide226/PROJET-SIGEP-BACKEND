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

import com.sigep.grh.dto.AccesCodeDto;
import com.sigep.grh.service.GrhAccesCodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/grh/accesCode")
@RequiredArgsConstructor
@CrossOrigin
public class GrhAccesCodeController {
	private final GrhAccesCodeService service;

	@PostMapping("/add")
	public ResponseEntity<AccesCodeDto> add(@RequestBody final AccesCodeDto accesCodeDto) {
		AccesCodeDto accesCodeDto2 = service.add(accesCodeDto);
		return new ResponseEntity<>(accesCodeDto2, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<AccesCodeDto>> getAll() {
		List<AccesCodeDto> accesCodeDtos = service.getAll();
		return new ResponseEntity<>(accesCodeDtos, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<AccesCodeDto> getById(@PathVariable final String id) {
		AccesCodeDto accesCodeDto2 = service.getById(id);
		return new ResponseEntity<>(accesCodeDto2, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AccesCodeDto> delete(@PathVariable final String id) {
		AccesCodeDto accesCodeDto2 = service.delete(id);
		return new ResponseEntity<>(accesCodeDto2, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<AccesCodeDto> edit(@PathVariable final String id, @RequestBody final AccesCodeDto accesCodeDto) {
		AccesCodeDto accesCodeDto2 = service.edit(id, accesCodeDto);
		return new ResponseEntity<>(accesCodeDto2, HttpStatus.OK);
	}

	@GetMapping("/getByAccesCodeNiveau/{code}")
	public ResponseEntity<List<AccesCodeDto>> getByAccesCodeNiveau(@PathVariable final String code) {
		List<AccesCodeDto> accesCodeDtos = service.getByAccesCodeNiveau(code);
		return new ResponseEntity<>(accesCodeDtos, HttpStatus.OK);
	}
}
