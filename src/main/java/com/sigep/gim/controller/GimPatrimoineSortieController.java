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

import com.sigep.gim.dto.requestDto.PatrimoineSortieRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineSortieResponseDto;
import com.sigep.gim.service.GimPatrimoineSortieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/patrimoineSortie")
@RequiredArgsConstructor
@CrossOrigin
public class GimPatrimoineSortieController {
	
	private final GimPatrimoineSortieService service;
	
	@PostMapping("/add")
	public ResponseEntity<PatrimoineSortieResponseDto> add(@RequestBody final PatrimoineSortieRequestDto patrimoineSortieRequestDto) {
		PatrimoineSortieResponseDto responseDto = service.add(patrimoineSortieRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PatrimoineSortieResponseDto>> getAll() {
		List<PatrimoineSortieResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{idFiche}/{mle}")
	public ResponseEntity<PatrimoineSortieResponseDto> getById(@PathVariable final long idFiche, @PathVariable final String mle) {
		PatrimoineSortieResponseDto responseDto = service.getById(idFiche,mle);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{idFiche}/{mle}")
	public ResponseEntity<PatrimoineSortieResponseDto> delete(@PathVariable final long idFiche, @PathVariable final String mle) {
		PatrimoineSortieResponseDto responseDto = service.delete(idFiche,mle);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{idFiche}/{mle}")
	public ResponseEntity<PatrimoineSortieResponseDto> edit(@PathVariable final long idFiche, @PathVariable final String mle, @RequestBody final PatrimoineSortieRequestDto patrimoineSortieRequestDto) {
		PatrimoineSortieResponseDto responseDto = service.edit(idFiche,mle,patrimoineSortieRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
