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

import com.sigep.gim.dto.requestDto.LivreJournalRequestDto;
import com.sigep.gim.dto.responseDto.LivreJournalResponseDto;
import com.sigep.gim.service.GimLivreJournalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/livreJournal")
@RequiredArgsConstructor
@CrossOrigin
public class GimLivreJournalController {
	
	private final GimLivreJournalService service;
	
	@PostMapping("/add")
	public ResponseEntity<LivreJournalResponseDto> add(@RequestBody final LivreJournalRequestDto livreJournalRequestDto) {
		LivreJournalResponseDto responseDto = service.add(livreJournalRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<LivreJournalResponseDto>> getAll() {
		List<LivreJournalResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<LivreJournalResponseDto> getById(@PathVariable final long id) {
		LivreJournalResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<LivreJournalResponseDto> delete(@PathVariable final long id) {
		LivreJournalResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<LivreJournalResponseDto> edit(@PathVariable final long id, @RequestBody final LivreJournalRequestDto livreJournalRequestDto) {
		LivreJournalResponseDto responseDto = service.edit(id, livreJournalRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
