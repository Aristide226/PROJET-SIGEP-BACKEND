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

import com.sigep.gim.dto.requestDto.InventaireTypeRequestDto;
import com.sigep.gim.dto.responseDto.InventaireTypeResponseDto;
import com.sigep.gim.service.GimInventaireTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/inventaireType")
@RequiredArgsConstructor
@CrossOrigin
public class GimInventaireTypeController {
	
	private final GimInventaireTypeService service;
	
	@PostMapping("/add")
	public ResponseEntity<InventaireTypeResponseDto> add(@RequestBody final InventaireTypeRequestDto inventaireTypeRequestDto) {
		InventaireTypeResponseDto responseDto = service.add(inventaireTypeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<InventaireTypeResponseDto>> getAll() {
		List<InventaireTypeResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<InventaireTypeResponseDto> getById(@PathVariable final short id) {
		InventaireTypeResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<InventaireTypeResponseDto> delete(@PathVariable final short id) {
		InventaireTypeResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<InventaireTypeResponseDto> edit(@PathVariable final short id, @RequestBody final InventaireTypeRequestDto inventaireTypeRequestDto) {
		InventaireTypeResponseDto responseDto = service.edit(id, inventaireTypeRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
