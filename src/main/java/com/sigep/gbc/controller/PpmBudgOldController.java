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

import com.sigep.gbc.dto.requestDto.PpmBudgOldRequestDto;
import com.sigep.gbc.dto.responseDto.PpmBudgOldResponseDto;
import com.sigep.gbc.service.PpmBudgOldService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/ppmBudgOld")
@RequiredArgsConstructor
@CrossOrigin
public class PpmBudgOldController {
	private final PpmBudgOldService service;

	@PostMapping("/add")
	public ResponseEntity<PpmBudgOldResponseDto> add(@PathVariable final PpmBudgOldRequestDto ppmBudgOldRequestDto) {
		PpmBudgOldResponseDto responseDto = service.add(ppmBudgOldRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PpmBudgOldResponseDto>> getAll() {
		List<PpmBudgOldResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{idPpmM}/{idPpm}/{codBud}/{idSrceFin}")
	public ResponseEntity<PpmBudgOldResponseDto> getById(@PathVariable final String idPpmM, @PathVariable final String idPpm, @PathVariable final String codBud, @PathVariable final String idSrceFin) {
		PpmBudgOldResponseDto responseDto = service.getById(idPpmM, idPpm, codBud, idSrceFin);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/get/{idPpmM}/{idPpm}/{codBud}/{idSrceFin}")
	public ResponseEntity<PpmBudgOldResponseDto> delete(@PathVariable final String idPpmM, @PathVariable final String idPpm, @PathVariable final String codBud, @PathVariable final String idSrceFin) {
		PpmBudgOldResponseDto responseDto = service.delete(idPpmM, idPpm, codBud, idSrceFin);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/get/{idPpmM}/{idPpm}/{codBud}/{idSrceFin}")
	public ResponseEntity<PpmBudgOldResponseDto> edit(@PathVariable final String idPpmM, @PathVariable final String idPpm, @PathVariable final String codBud, @PathVariable final String idSrceFin, @RequestBody final PpmBudgOldRequestDto ppmBudgOldRequestDto) {
		PpmBudgOldResponseDto responseDto = service.edit(idPpmM, idPpm, codBud, idSrceFin, ppmBudgOldRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
