package com.sigep.gbc.controller;

import java.io.FileNotFoundException;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.dto.requestDto.PpmRequestDto;
import com.sigep.gbc.dto.responseDto.PpmResponseDto;
import com.sigep.gbc.service.PpmService;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/gbc/ppm")
@RequiredArgsConstructor
@CrossOrigin

public class PpmController {
	private final PpmService service;

	@PostMapping("/add")
	public ResponseEntity<PpmResponseDto> add(@RequestBody final PpmRequestDto ppmRequestDto) {
		PpmResponseDto responseDto = service.add(ppmRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PpmResponseDto>> getAll() {
		List<PpmResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PpmResponseDto> getById(@PathVariable final String id) {
		PpmResponseDto responseDto = service.getById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PpmResponseDto> delete(@PathVariable final String id) {
		PpmResponseDto responseDto = service.delete(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<PpmResponseDto> edit(@PathVariable final String id, @RequestBody final PpmRequestDto ppmRequestDto) {
		PpmResponseDto responseDto = service.edit(id, ppmRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	
	//Aristide
	@GetMapping("/getByIdBudgetAndExercice/{idBudget}/{exercice}")
	public ResponseEntity<List<PpmResponseDto>> getByIdBudgetAndExercice(@PathVariable final Integer idBudget, @PathVariable final Short exercice) {
		List <PpmResponseDto> list = service.getByIdBudgetAndExercice(idBudget, exercice);
		return new ResponseEntity<> (list, HttpStatus.OK);
	}
	
	@GetMapping("/getNextNum")
	public ResponseEntity<Integer> getNextNumForBudgetAndExercice(
			@RequestParam int idBudget,
			@RequestParam short exercice){
		int nextNum= service.getNextNumForBudgetAndExercice(idBudget, exercice);
		return ResponseEntity.ok(nextNum);
	}
	
	@PostMapping("/addReam")
	public ResponseEntity<PpmResponseDto> addReam(@RequestBody final PpmRequestDto ppmRequestDto) {
		PpmResponseDto responseDto = service.addReam(ppmRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@PutMapping("/editReam/{id}")
	public ResponseEntity<PpmResponseDto> editReam(@PathVariable final String id, @RequestBody final PpmRequestDto ppmRequestDto) {
		PpmResponseDto responseDto = service.editReam(id, ppmRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/download")
	public ResponseEntity<byte[]> generatePpmReportPdf(@RequestParam("annee") Integer annee) {
		try {
			byte[] reportData = service.generatePpmReport(annee);
			
			//configuration des headers pour le téléchargement
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			String filename = "PPM_"+ annee + ".pdf";
			headers.setContentDispositionFormData(filename, filename);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check");
			
			return ResponseEntity.ok()
					.headers(headers)
					.body(reportData);
		} catch (FileNotFoundException e) {
			return ResponseEntity.badRequest().body(("Fichier de rapport non trouvé").getBytes());
		} catch (JRException e) {
			String errorMessage = "Erreur détaillée: " + e.getMessage() + "\n" + "Cause: " + (e.getCause() != null ? e.getCause().getMessage() : "null") + "\n" + "StackTrace: " + Arrays.toString(e.getStackTrace());
	        System.err.println(errorMessage);
	        
	        return ResponseEntity.internalServerError()
	                .contentType(MediaType.TEXT_PLAIN)
	                .body(errorMessage.getBytes());
		} catch (Exception e) {
			String errorMessage = "Erreur détaillée: " + e.getMessage() + "\n" + "Cause: " + (e.getCause() != null ? e.getCause().getMessage() : "null") + "\n" + "StackTrace: " + Arrays.toString(e.getStackTrace());
		        System.err.println(errorMessage);
		        
		        return ResponseEntity.internalServerError()
		                .contentType(MediaType.TEXT_PLAIN)
		                .body(errorMessage.getBytes());
		}
	}
	
	
}


