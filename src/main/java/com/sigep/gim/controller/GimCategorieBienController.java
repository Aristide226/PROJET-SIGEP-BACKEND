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

import com.sigep.gim.dto.requestDto.CategorieBienRequestDto;
import com.sigep.gim.dto.responseDto.CategorieBienResponseDto;
import com.sigep.gim.service.GimCategorieBienService;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/gim/categorieBien")
@RequiredArgsConstructor
@CrossOrigin
public class GimCategorieBienController {
	
	private final GimCategorieBienService service;
	
	@PostMapping("/add")
	public ResponseEntity<CategorieBienResponseDto> add(@RequestBody final CategorieBienRequestDto categorieBienRequestDto) {
		CategorieBienResponseDto responseDto = service.add(categorieBienRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CategorieBienResponseDto>> getAll() {
		List<CategorieBienResponseDto> responseDto = service.getAll();
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CategorieBienResponseDto> getById(@PathVariable final int id) {
		CategorieBienResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CategorieBienResponseDto> delete(@PathVariable final int id) {
		CategorieBienResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<CategorieBienResponseDto> edit(@PathVariable final int id, @RequestBody final CategorieBienRequestDto categorieBienRequestDto) {
		CategorieBienResponseDto responseDto = service.edit(id, categorieBienRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/categorieBienReport")
	public ResponseEntity<byte[]> categorieBienReport() {
		try {
	        byte[] reportData = service.categorieBienReport();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        headers.setContentDispositionFormData("inline", "CatBien.pdf");
	        headers.setContentLength(reportData.length);

	        return ResponseEntity.ok().headers(headers).body(reportData);

	    } catch (FileNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	    } catch (JRException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
}
