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

import com.sigep.gim.dto.requestDto.TypFicheRequestDto;
import com.sigep.gim.dto.responseDto.TypFicheResponseDto;
import com.sigep.gim.service.GimTypFicheService;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/gim/typFiche")
@RequiredArgsConstructor
@CrossOrigin
public class GimTypFicheController {
	
	private final GimTypFicheService service;
	
	@PostMapping("/add")
	public ResponseEntity<TypFicheResponseDto> add(@RequestBody final TypFicheRequestDto typFicheRequestDto) {
		TypFicheResponseDto responseDto = service.add(typFicheRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<TypFicheResponseDto>> getAll() {
		List<TypFicheResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<TypFicheResponseDto> getById(@PathVariable final String id) {
		TypFicheResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TypFicheResponseDto> delete(@PathVariable final String id) {
		TypFicheResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<TypFicheResponseDto> edit(@PathVariable final String id, @RequestBody final TypFicheRequestDto typFicheRequestDto) {
		TypFicheResponseDto responseDto = service.edit(id, typFicheRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/typFicheReport")
	public ResponseEntity<byte[]> typFicheReport() {
		try {
	        byte[] reportData = service.typFicheReport();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        headers.setContentDispositionFormData("inline", "Fiche.pdf");
	        headers.setContentLength(reportData.length);

	        return ResponseEntity.ok().headers(headers).body(reportData);

	    } catch (FileNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	    } catch (JRException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
}
