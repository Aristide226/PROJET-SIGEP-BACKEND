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

import com.sigep.gim.dto.requestDto.TableRapportRequestDto;
import com.sigep.gim.dto.responseDto.TableRapportResponseDto;
import com.sigep.gim.service.GimTableRapportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/tableRapport")
@RequiredArgsConstructor
@CrossOrigin
public class GimTableRapportController {
	
	private final GimTableRapportService service;
	
	@PostMapping("/add")
	public ResponseEntity<TableRapportResponseDto> add(@RequestBody final TableRapportRequestDto tableRapportRequestDto) {
		TableRapportResponseDto responseDto = service.add(tableRapportRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<TableRapportResponseDto>> getAll() {
		List<TableRapportResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<TableRapportResponseDto> getById(@PathVariable final String id) {
		TableRapportResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TableRapportResponseDto> delete(@PathVariable final String id) {
		TableRapportResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<TableRapportResponseDto> edit(@PathVariable final String id, @RequestBody final TableRapportRequestDto tableRapportRequestDto) {
		TableRapportResponseDto responseDto = service.edit(id, tableRapportRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
