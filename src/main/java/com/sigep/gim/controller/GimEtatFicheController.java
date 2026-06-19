package com.sigep.gim.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.sigep.gim.dto.requestDto.EtatFicheRequestDto;
import com.sigep.gim.dto.responseDto.EtatFicheResponseDto;
import com.sigep.gim.service.GimEtatFicheService;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/gim/etatFiche")
@RequiredArgsConstructor
@CrossOrigin
public class GimEtatFicheController {
	
	private final GimEtatFicheService service;
	
	@PostMapping("/add")
	public ResponseEntity<EtatFicheResponseDto> add(@RequestBody final EtatFicheRequestDto etatFicheRequestDto) {
		EtatFicheResponseDto responseDto = service.add(etatFicheRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EtatFicheResponseDto>> getAll() {
		List<EtatFicheResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<EtatFicheResponseDto> getById(@PathVariable final String id) {
		EtatFicheResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<EtatFicheResponseDto> delete(@PathVariable final String id) {
		EtatFicheResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<EtatFicheResponseDto> edit(@PathVariable final String id, @RequestBody final EtatFicheRequestDto etatFicheRequestDto) {
		EtatFicheResponseDto responseDto = service.edit(id, etatFicheRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/etatFicheReport")
	public ResponseEntity<byte[]> etatFicheReport() {
		try {
	        byte[] reportData = service.etatFicheReport();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        headers.setContentDispositionFormData("inline", "EtatFiche.pdf");
	        headers.setContentLength(reportData.length);

	        return ResponseEntity.ok().headers(headers).body(reportData);

	    } catch (FileNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	    } catch (JRException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
}
