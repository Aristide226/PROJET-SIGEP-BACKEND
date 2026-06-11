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

import com.sigep.gbc.dto.DecisionSArticleDto;

import com.sigep.gbc.service.DecisionSArticleService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/decisionSArticle")
@RequiredArgsConstructor
@CrossOrigin
public class DecisionSArticleController {
	private final DecisionSArticleService service;

	@PostMapping("/add")
	public ResponseEntity<DecisionSArticleDto> add(@RequestBody final DecisionSArticleDto decisionSArticleDto) {
		DecisionSArticleDto responseDto = service.add(decisionSArticleDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<DecisionSArticleDto>> getAll() {
		List<DecisionSArticleDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<DecisionSArticleDto> getById(@PathVariable final Integer id) {
		DecisionSArticleDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DecisionSArticleDto> delete(@PathVariable final Integer id) {
		DecisionSArticleDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{newId}/{oldId}")
	public ResponseEntity<DecisionSArticleDto> edit(@PathVariable final Integer newId, @PathVariable final Integer oldId, @RequestBody final DecisionSArticleDto decisionSArticleDto) {
		DecisionSArticleDto responseDto = service.edit(newId, oldId, decisionSArticleDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/existsById/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable final Integer id) {
		Boolean result = service.existsById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
