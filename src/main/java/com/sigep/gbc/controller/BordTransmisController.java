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


import com.sigep.gbc.dto.requestDto.BordTransmisRequestDto;
import com.sigep.gbc.dto.responseDto.BordTransmisResponseDto;
import com.sigep.gbc.model.InfosPourReceptionnerBordTransmis;
import com.sigep.gbc.service.BordTransmisService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/bordTransmis")
@RequiredArgsConstructor
@CrossOrigin
public class BordTransmisController {
	private final BordTransmisService service;

	@PostMapping("/add")
	public ResponseEntity<BordTransmisResponseDto> add(@RequestBody final BordTransmisRequestDto bordTransmisRequestDto) {
		BordTransmisResponseDto responseDto = service.add(bordTransmisRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BordTransmisResponseDto>> getAll() {
		List<BordTransmisResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<BordTransmisResponseDto> getById(@PathVariable final Long id) {
		BordTransmisResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BordTransmisResponseDto> delete(@PathVariable final Long id) {
		BordTransmisResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<BordTransmisResponseDto> edit(@PathVariable final Long id, @RequestBody final BordTransmisRequestDto bordTransmisRequestDto) {
		BordTransmisResponseDto responseDto = service.edit(id, bordTransmisRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getByGestionAndIdBudgetAndExpeditaire/{gestion}/{idBudget}/{expeditaire}")
	public ResponseEntity<List<BordTransmisResponseDto>> getByGestionAndIdBudgetAndExpeditaire(@PathVariable final Short gestion, @PathVariable final Integer idBudget, @PathVariable final String expeditaire) {
		List<BordTransmisResponseDto> list = service.getByGestionAndIdBudgetAndExpeditaire(gestion, idBudget, expeditaire);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/receptionner")
	public ResponseEntity<Boolean> receptionner(@RequestBody final InfosPourReceptionnerBordTransmis infosPourReceptionnerBordTransmis) {
		Boolean result = service.receptionner(infosPourReceptionnerBordTransmis);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
