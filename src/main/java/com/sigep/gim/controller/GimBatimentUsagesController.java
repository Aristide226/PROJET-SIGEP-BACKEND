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

import com.sigep.gim.dto.requestDto.BatimentUsagesRequestDto;
import com.sigep.gim.dto.responseDto.BatimentUsagesResponseDto;
import com.sigep.gim.service.GimBatimentUsagesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/batimentUsages")
@RequiredArgsConstructor
@CrossOrigin
public class GimBatimentUsagesController {
	
	private final GimBatimentUsagesService service;
	
	@PostMapping("/add")
	public ResponseEntity<BatimentUsagesResponseDto> add(@RequestBody final BatimentUsagesRequestDto batimentUsagesRequestDto) {
		BatimentUsagesResponseDto responseDto = service.add(batimentUsagesRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<BatimentUsagesResponseDto>> getAll() {
		List<BatimentUsagesResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<BatimentUsagesResponseDto> getById(@PathVariable final int id) {
		BatimentUsagesResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BatimentUsagesResponseDto> delete(@PathVariable final int id) {
		BatimentUsagesResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<BatimentUsagesResponseDto> edit(@PathVariable final int id, @RequestBody final BatimentUsagesRequestDto batimentUsagesRequestDto) {
		BatimentUsagesResponseDto responseDto = service.edit(id, batimentUsagesRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
