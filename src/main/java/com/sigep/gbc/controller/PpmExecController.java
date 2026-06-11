//Aristide
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

import com.sigep.gbc.dto.requestDto.PpmExecRequestDto;
import com.sigep.gbc.dto.responseDto.PpmExecResponseDto;
import com.sigep.gbc.service.PpmExecService;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/gbc/ppmExec")
@RequiredArgsConstructor
@CrossOrigin
public class PpmExecController {
	private final PpmExecService service;
	
	@PostMapping("/add")
	public ResponseEntity <PpmExecResponseDto> add(@RequestBody final PpmExecRequestDto ppmExecRequestDto) {
		PpmExecResponseDto responseDto = service.add(ppmExecRequestDto);
		return new ResponseEntity<> (responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PpmExecResponseDto>> getAll() {
		List<PpmExecResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/get/{idPpmExec}/{idLot}/{idBudget}/{exercice}")
	public ResponseEntity <PpmExecResponseDto> getById(@PathVariable final int idPpmExec,@PathVariable final int idLot, @PathVariable final Integer idBudget, @PathVariable final short exercice ) {
		PpmExecResponseDto responseDto = service.getById(idPpmExec, idLot, idBudget, exercice);
		return new ResponseEntity<> (responseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{idPpmExec}/{idLot}/{idBudget}/{exercice}")
	public ResponseEntity <Void> delete(@PathVariable final int idPpmExec,@PathVariable final int idLot, @PathVariable final Integer idBudget, @PathVariable final short exercice ){
		service.delete(idPpmExec, idLot, idBudget, exercice);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/edit/{idPpmExec}/{idLot}/{idBudget}/{exercice}")
	public ResponseEntity <PpmExecResponseDto> edit(@PathVariable final int idPpmExec ,@PathVariable final int idLot, @PathVariable final Integer idBudget, @PathVariable final short exercice, @RequestBody final PpmExecRequestDto ppmExecRequestDto ) {
		PpmExecResponseDto responseDto = service.edit(idPpmExec, idLot, idBudget, exercice, ppmExecRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAllLotsByIdPpmAndIdBudgetAndExercice/{idPpm}/{idBudget}/{exercice}")
	public ResponseEntity<List<PpmExecResponseDto>> getById( @PathVariable final String idPpm, @PathVariable final Integer idBudget,  @PathVariable final short exercice ) {
	    List<PpmExecResponseDto> responseDtos = service.getAllLotsByIdPpmAndIdBudgetAndExercice(idPpm, idBudget, exercice);
	    
	    return new ResponseEntity<> (responseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/getAllLotsByIdPpmExecAndIdBudgetAndExercice/{idPpmExec}/{idBudget}/{exercice}")
	public ResponseEntity<List<PpmExecResponseDto>> getAllLotsByIdPpmExecAndIdBudgetAndExercice( @PathVariable final int idPpmExec, @PathVariable final Integer idBudget,  @PathVariable final short exercice ) {
	    List<PpmExecResponseDto> responseDtos = service.getAllLotsByIdPpmExecAndIdBudgetAndExercice(idPpmExec, idBudget, exercice);
	    
	    return new ResponseEntity<> (responseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/download")
	public ResponseEntity<byte[]> generatePdfReport(@RequestParam("annee") Integer annee) {
		try {
			byte[] reportData = service.generatePpmExecReport(annee);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			String filename = "PPM_EXEC_"+annee+".pdf";
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
		}
	} 
	
	@GetMapping("/download/visibilitePrm")
	public ResponseEntity<byte[]> generateVisibilitePrm(@RequestParam("annee") Integer annee) {
		try {
			byte[] reportData = service.generateVisibilitePrm(annee);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			String filename = "PPM_EXEC_VISIBILITE_PRM_"+annee+".pdf";
			headers.setContentDispositionFormData(filename, filename);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check");
			
			return ResponseEntity.ok()
					.headers(headers)
					.body(reportData);
		} catch (FileNotFoundException e) {
			return ResponseEntity.badRequest().body(("Fichier de rapport non trouvé").getBytes());
		} catch (JRException e) {
			return ResponseEntity.internalServerError().body(("Erreur lors de la génération du rapport JasperReports").getBytes());
		}
	}
}









