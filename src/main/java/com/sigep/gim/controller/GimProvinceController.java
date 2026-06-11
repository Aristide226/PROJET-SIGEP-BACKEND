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

import com.sigep.gim.dto.requestDto.ProvinceRequestDto;
import com.sigep.gim.dto.responseDto.ProvinceResponseDto;
import com.sigep.gim.service.GimProvinceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/province")
@RequiredArgsConstructor
@CrossOrigin
public class GimProvinceController {
	
	private final GimProvinceService service;
	
	@PostMapping("/add")
	public ResponseEntity<ProvinceResponseDto> add(@RequestBody final ProvinceRequestDto provinceRequestDto) {
		ProvinceResponseDto responseDto = service.add(provinceRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ProvinceResponseDto>> getAll() {
		List<ProvinceResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ProvinceResponseDto> getById(@PathVariable final int id) {
		ProvinceResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ProvinceResponseDto> delete(@PathVariable final int id) {
		ProvinceResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<ProvinceResponseDto> edit(@PathVariable final int id, @RequestBody final ProvinceRequestDto provinceRequestDto) {
		ProvinceResponseDto responseDto = service.edit(id, provinceRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
