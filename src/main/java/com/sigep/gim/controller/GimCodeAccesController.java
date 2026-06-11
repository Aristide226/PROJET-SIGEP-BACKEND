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

import com.sigep.gim.dto.CodeAccesAgentDto;
import com.sigep.gim.dto.CodeAccesDto;
import com.sigep.gim.service.GimCodeAccesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/codeAcces")
@RequiredArgsConstructor
@CrossOrigin
public class GimCodeAccesController {
	
	private final GimCodeAccesService service;
	
	@PostMapping("/add")
	public ResponseEntity<CodeAccesDto> add(@RequestBody CodeAccesDto codeAccesDto) {
		CodeAccesDto responseDto = service.add(codeAccesDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CodeAccesDto>> getAll() {
		List<CodeAccesDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/get/{idUser}")
	public ResponseEntity<CodeAccesDto> getById(@PathVariable final int idUser) {
		CodeAccesDto codeAccesDto = service.getById(idUser);
		return new ResponseEntity<>(codeAccesDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{idUser}")
	public ResponseEntity<CodeAccesDto> delete(@PathVariable final int idUser) {
		CodeAccesDto codeAccesDto = service.delete(idUser);
		return new ResponseEntity<>(codeAccesDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{idUser}")
	public ResponseEntity<CodeAccesDto> edit(@PathVariable final int idUser, @RequestBody CodeAccesDto codeAccesDto) {
		CodeAccesDto responseDto = service.edit(idUser, codeAccesDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getUtilisateur")
	public ResponseEntity<List<CodeAccesAgentDto>> getUtilisateur() {
		List<CodeAccesAgentDto> list = service.getUtilisateur();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getByUserName/{userName}")
	public ResponseEntity<CodeAccesDto> getByUserName(@PathVariable final String userName) {
		CodeAccesDto codeAccesDto = service.getByUserName(userName);
		return new ResponseEntity<>(codeAccesDto, HttpStatus.OK);
	}
}
