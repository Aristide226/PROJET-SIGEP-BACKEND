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

import com.sigep.gim.dto.requestDto.HistoEtatRequestDto;
import com.sigep.gim.dto.responseDto.HistoEtatResponseDto;
import com.sigep.gim.service.GimHistoEtatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/histoEtat")
@RequiredArgsConstructor
@CrossOrigin
public class GimHistoEtatController {
	
	private final GimHistoEtatService service;
	
	@PostMapping("/add")
	public ResponseEntity<HistoEtatResponseDto> add(@RequestBody final HistoEtatRequestDto histoEtatRequestDto) {
		HistoEtatResponseDto responseDto = service.add(histoEtatRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<HistoEtatResponseDto>> getAll() {
		List<HistoEtatResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{etat}/{idFiche}/{dateEtat}")
	public ResponseEntity<HistoEtatResponseDto> getById(@PathVariable final String etat, @PathVariable final long idFiche, @PathVariable final Date dateEtat) {
		HistoEtatResponseDto responseDto = service.getById(etat, idFiche, dateEtat);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{etat}/{idFiche}/{dateEtat}")
	public ResponseEntity<HistoEtatResponseDto> delete(@PathVariable final String etat, @PathVariable final long idFiche, @PathVariable final Date dateEtat) {
		HistoEtatResponseDto responseDto = service.delete(etat, idFiche, dateEtat);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{etat}/{idFiche}/{dateEtat}")
	public ResponseEntity<HistoEtatResponseDto> edit(@PathVariable final String etat, @PathVariable final long idFiche, @PathVariable final Date dateEtat, @RequestBody final HistoEtatRequestDto histoEtatRequestDto) {
		HistoEtatResponseDto responseDto = service.edit(etat, idFiche, dateEtat, histoEtatRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
