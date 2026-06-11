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

import com.sigep.gim.dto.SiteStatistiqueDto;
import com.sigep.gim.dto.requestDto.SitesRequestDto;
import com.sigep.gim.dto.responseDto.SitesResponseDto;
import com.sigep.gim.service.GimSitesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gim/sites")
@RequiredArgsConstructor
@CrossOrigin
public class GimSitesController {
	
	private final GimSitesService service;
	
	@PostMapping("/add")
	public ResponseEntity<SitesResponseDto> add(@RequestBody final SitesRequestDto sitesRequestDto) {
		SitesResponseDto responseDto = service.add(sitesRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<SitesResponseDto>> getAll() {
		List<SitesResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<SitesResponseDto> getById(@PathVariable final int id) {
		SitesResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<SitesResponseDto> delete(@PathVariable final int id) {
		SitesResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<SitesResponseDto> edit(@PathVariable final int id, @RequestBody final SitesRequestDto sitesRequestDto) {
		SitesResponseDto responseDto = service.edit(id, sitesRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/stat")
	public ResponseEntity<List<SiteStatistiqueDto>> getStatistiquesPatrimoineParSite(){
		List<SiteStatistiqueDto> list = service.getStatistiquesPatrimoineParCategorie();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
