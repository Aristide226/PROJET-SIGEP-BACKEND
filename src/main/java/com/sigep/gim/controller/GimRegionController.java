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

import com.sigep.gim.dto.requestDto.RegionRequestDto;
import com.sigep.gim.dto.responseDto.RegionResponseDto;
import com.sigep.gim.service.GimRegionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/region")
@RequiredArgsConstructor
@CrossOrigin
public class GimRegionController {
	
	private final GimRegionService service;
	
	@PostMapping("/add")
	public ResponseEntity<RegionResponseDto> add(@RequestBody final RegionRequestDto regionRequestDto) {
		RegionResponseDto responseDto = service.add(regionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<RegionResponseDto>> getAll() {
		List<RegionResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<RegionResponseDto> getById(@PathVariable final int id) {
		RegionResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<RegionResponseDto> delete(@PathVariable final int id) {
		RegionResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<RegionResponseDto> edit(@PathVariable final int id, @RequestBody final RegionRequestDto regionRequestDto) {
		RegionResponseDto responseDto = service.edit(id, regionRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
