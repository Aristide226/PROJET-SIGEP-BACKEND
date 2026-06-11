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

import com.sigep.gbc.dto.requestDto.EngagementsRequestDto;
import com.sigep.gbc.dto.responseDto.EngagementsResponseDto;
import com.sigep.gbc.model.IdEngsCodBord;
import com.sigep.gbc.model.InfosPourAbandonnerEngagement;
import com.sigep.gbc.model.InfosPourRetrograderEngagement;
import com.sigep.gbc.model.InfosPourValiderEngagement;
import com.sigep.gbc.model.InfosPourValiderOuRejeterEngagement;
import com.sigep.gbc.service.EngagementsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/engagements")
@RequiredArgsConstructor
@CrossOrigin
public class EngagementsController {
	private final EngagementsService service;

	@PostMapping("/add")
	public ResponseEntity<EngagementsResponseDto> add(@RequestBody final EngagementsRequestDto engagementsRequestDto) {
		EngagementsResponseDto responseDto = service.add(engagementsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<EngagementsResponseDto>> getAll() {
		List<EngagementsResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<EngagementsResponseDto> getById(@PathVariable final Long id) {
		EngagementsResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<EngagementsResponseDto> delete(@PathVariable final Long id) {
		EngagementsResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<EngagementsResponseDto> edit(@PathVariable final Long id, @RequestBody final EngagementsRequestDto engagementsRequestDto) {
		EngagementsResponseDto responseDto = service.edit(id, engagementsRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PostMapping("/abandonner")
	public ResponseEntity<Boolean> abandonner(@RequestBody final InfosPourAbandonnerEngagement infosPourAbandonnerEngagement) {
		Boolean result = service.abandonner(infosPourAbandonnerEngagement);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/valider")
	public ResponseEntity<Boolean> valider(@RequestBody final InfosPourValiderEngagement infosPourValiderEngagement) {
		Boolean result = service.valider(infosPourValiderEngagement);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/retrograder")
	public ResponseEntity<Boolean> retrograder(@RequestBody final InfosPourRetrograderEngagement infosPourRetrograderEngagement) {
		Boolean result = service.retrograder(infosPourRetrograderEngagement);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/validerOuRejeter")
	public ResponseEntity<Boolean> validerOuRejeter(@RequestBody final InfosPourValiderOuRejeterEngagement infosPourValiderOuRejeterEngagement) {
		Boolean result = service.validerOuRejeter(infosPourValiderOuRejeterEngagement);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/transmettre")
	public ResponseEntity<Boolean> transmettre(@RequestBody final IdEngsCodBord idEngsCodBord) {
		Boolean result = service.transmettre(idEngsCodBord);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/receptionner")
	public ResponseEntity<Boolean> receptionner(@RequestBody final List<Long> codBords) {
		Boolean result = service.receptionner(codBords);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
