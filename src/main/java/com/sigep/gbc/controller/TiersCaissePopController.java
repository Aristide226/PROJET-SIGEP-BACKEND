package com.sigep.gbc.controller;

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

import com.sigep.gbc.dto.requestDto.TiersCaissePopRequestDto;
import com.sigep.gbc.dto.responseDto.TiersCaissePopResponseDto;
import com.sigep.gbc.service.TiersCaissePopService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/tiersCaissePop")
@RequiredArgsConstructor
@CrossOrigin
public class TiersCaissePopController {
	private final TiersCaissePopService service;

	@PostMapping("/add")
	public ResponseEntity<TiersCaissePopResponseDto> add(@RequestBody final TiersCaissePopRequestDto tiersCaissePopRequestDto) {
		TiersCaissePopResponseDto responseDto = service.add(tiersCaissePopRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<TiersCaissePopResponseDto>> getAll() {
		List<TiersCaissePopResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<TiersCaissePopResponseDto> getById(@PathVariable final Long id) {
		TiersCaissePopResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TiersCaissePopResponseDto> delete(@PathVariable final Long id) {
		TiersCaissePopResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<TiersCaissePopResponseDto> edit(@PathVariable final Long id, @RequestBody final TiersCaissePopRequestDto tiersCaissePopRequestDto) {
		TiersCaissePopResponseDto responseDto = service.edit(id, tiersCaissePopRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
