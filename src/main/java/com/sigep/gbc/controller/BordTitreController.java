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

import com.sigep.gbc.dto.BordTitreDto;
import com.sigep.gbc.service.BordTitreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/bordTitre")
@RequiredArgsConstructor
@CrossOrigin
public class BordTitreController {
	private final BordTitreService service;

	@PostMapping("/add")
	public ResponseEntity<BordTitreDto> add(@RequestBody final BordTitreDto bordTitreDto) {
		BordTitreDto responseDto = service.add(bordTitreDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BordTitreDto>> getAll() {
		List<BordTitreDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{idbord}/{idDetailTitre}")
	public ResponseEntity<BordTitreDto> getById(@PathVariable final String idBord, @PathVariable final Long idDetailTitre) {
		BordTitreDto responseDto = service.getById(idBord, idDetailTitre);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{idbord}/{idDetailTitre}")
	public ResponseEntity<BordTitreDto> delete(@PathVariable final String idBord, @PathVariable final Long idDetailTitre) {
		BordTitreDto responseDto = service.delete(idBord, idDetailTitre);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{idbord}/{idDetailTitre}")
	public ResponseEntity<BordTitreDto> edit(@PathVariable final String idBord, @PathVariable final Long idDetailTitre, @RequestBody final BordTitreDto bordTitreDto) {
		BordTitreDto responseDto = service.edit(idBord, idDetailTitre, bordTitreDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}	
}
