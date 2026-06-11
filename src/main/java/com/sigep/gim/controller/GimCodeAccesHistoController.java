package com.sigep.gim.controller;

import java.util.Date;
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

import com.sigep.gim.dto.requestDto.CodeAccesHistoRequestDto;
import com.sigep.gim.dto.responseDto.CodeAccesHistoResponseDto;
import com.sigep.gim.service.GimCodeAccesHistoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/codeAccesHisto")
@RequiredArgsConstructor
@CrossOrigin
public class GimCodeAccesHistoController {
	
	private final GimCodeAccesHistoService service;
	
	@PostMapping("/add")
	public ResponseEntity<CodeAccesHistoResponseDto> add(@RequestBody final CodeAccesHistoRequestDto codeAccesHistoRequestDto) {
		CodeAccesHistoResponseDto responseDto = service.add(codeAccesHistoRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CodeAccesHistoResponseDto>> getAll() {
		List<CodeAccesHistoResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}/{dateChangement}")
	public ResponseEntity<CodeAccesHistoResponseDto> getById(@PathVariable final int id, @PathVariable final Date dateChangement) {
		CodeAccesHistoResponseDto responseDto = service.getById(id,dateChangement);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}/{dateChangement}")
	public ResponseEntity<CodeAccesHistoResponseDto> delete(@PathVariable final int id, @PathVariable final Date dateChangement) {
		CodeAccesHistoResponseDto responseDto = service.delete(id,dateChangement);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}/{dateChangement}")
	public ResponseEntity<CodeAccesHistoResponseDto> edit(@PathVariable final int id, @PathVariable final Date dateChangement, @RequestBody final CodeAccesHistoRequestDto codeAccesHistoRequestDto) {
		CodeAccesHistoResponseDto responseDto = service.edit(id,dateChangement,codeAccesHistoRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
