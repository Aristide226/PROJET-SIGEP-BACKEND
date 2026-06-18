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

import com.sigep.gim.dto.requestDto.PatrimoineStatutRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineStatutResponseDto;
import com.sigep.gim.service.GimPatrimoineStatutService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/gim/patrimoineStatut")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class GimPatrimoineStatutController {
	
	private final GimPatrimoineStatutService service;
	
	@PostMapping("/add")
	public ResponseEntity<PatrimoineStatutResponseDto> add(@RequestBody final PatrimoineStatutRequestDto patrimoineStatutRequestDto) {
		PatrimoineStatutResponseDto responseDto = service.add(patrimoineStatutRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PatrimoineStatutResponseDto>> getAll() {
		List<PatrimoineStatutResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PatrimoineStatutResponseDto> getById(@PathVariable final String id) {
		PatrimoineStatutResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PatrimoineStatutResponseDto> delete(@PathVariable final String id) {
		PatrimoineStatutResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<PatrimoineStatutResponseDto> edit(@PathVariable final String id, @RequestBody final PatrimoineStatutRequestDto patrimoineStatutRequestDto) {
		PatrimoineStatutResponseDto responseDto = service.edit(id, patrimoineStatutRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/statutBienReport")
	public ResponseEntity<byte[]> statutBienReport() {
		try {
	        byte[] reportData = service.statutBienReport();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        headers.setContentDispositionFormData("inline", "StatutDeBien.pdf");
	        headers.setContentLength(reportData.length);

	        return ResponseEntity.ok().headers(headers).body(reportData);

	    } catch (FileNotFoundException e) {
	        log.error("Fichier JRXML introuvable : {}", e.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	    } catch (JRException e) {
	        log.error("Erreur génération rapport : {}", e.getMessage());
	        if (e.getCause() != null) {
	            log.error("Cause racine : {}", e.getCause().getMessage());
	            e.getCause().printStackTrace();
	        }

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
}
