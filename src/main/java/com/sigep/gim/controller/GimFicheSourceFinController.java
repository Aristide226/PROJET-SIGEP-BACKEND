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

import com.sigep.gim.dto.requestDto.FicheSourceFinRequestDto;
import com.sigep.gim.dto.responseDto.FicheSourceFinResponseDto;
import com.sigep.gim.service.GimFicheSourceFinService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/ficheSourceFin")
@RequiredArgsConstructor
@CrossOrigin
public class GimFicheSourceFinController {
	
	private final GimFicheSourceFinService service;
	
	@PostMapping("/add")
	public ResponseEntity<FicheSourceFinResponseDto> add(@RequestBody final FicheSourceFinRequestDto ficheSourceFinRequestDto) {
		FicheSourceFinResponseDto responseDto = service.add(ficheSourceFinRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<FicheSourceFinResponseDto>> getAll() {
		List<FicheSourceFinResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{idFiche}/{idSourceFin}")
	public ResponseEntity<FicheSourceFinResponseDto> getById(@PathVariable final long idFiche, @PathVariable final String idSourceFin) {
		FicheSourceFinResponseDto responseDto = service.getById(idFiche,idSourceFin);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{idFiche}/{idSourceFin}")
	public ResponseEntity<FicheSourceFinResponseDto> delete(@PathVariable final long idFiche, @PathVariable final String idSourceFin) {
		FicheSourceFinResponseDto responseDto = service.delete(idFiche,idSourceFin);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{idFiche}/{idSourceFin}")
	public ResponseEntity<FicheSourceFinResponseDto> edit(@PathVariable final long idFiche, @PathVariable final String idSourceFin, @RequestBody final FicheSourceFinRequestDto ficheSourceFinRequestDto) {
		FicheSourceFinResponseDto responseDto = service.edit(idFiche,idSourceFin,ficheSourceFinRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
