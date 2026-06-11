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

import com.sigep.gbc.dto.BordMandDto;
import com.sigep.gbc.model.IdMandsIdBordEmis;
import com.sigep.gbc.service.BordMandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/bordMand")
@RequiredArgsConstructor
@CrossOrigin
public class BordMandController {
	private final BordMandService service;

	@PostMapping("/add")
	public ResponseEntity<BordMandDto> add(@RequestBody final BordMandDto bordMandDto) {
		BordMandDto responseDto = service.add(bordMandDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BordMandDto>> getAll() {
		List<BordMandDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{idBord}/{numMand}")
	public ResponseEntity<BordMandDto> getById(@PathVariable final String idBord, @PathVariable final Long numMand) {
		BordMandDto responseDto = service.getById(idBord, numMand);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{idBord}/{numMand}")
	public ResponseEntity<BordMandDto> delete(@PathVariable final String idBord, @PathVariable final Long numMand) {
		BordMandDto responseDto = service.delete(idBord, numMand);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{idBord}/{numMand}")
	public ResponseEntity<BordMandDto> edit(@PathVariable final String idBord, @PathVariable final Long numMand, @RequestBody final BordMandDto bordMandDto) {
		BordMandDto responseDto = service.edit(idBord, numMand, bordMandDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PostMapping("/adds")
	public ResponseEntity<Boolean> adds(@RequestBody final IdMandsIdBordEmis idMandsIdBordEmis) {
		Boolean result = service.adds(idMandsIdBordEmis);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/deleteBordereauEmismandats/{idBord}")
	public ResponseEntity<Boolean> deleteBordereauEmismandats(@PathVariable final String idBord) {
		Boolean result = service.deleteBordereauEmismandats(idBord);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
