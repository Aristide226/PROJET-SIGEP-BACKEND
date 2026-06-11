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

import com.sigep.gbc.dto.requestDto.PpmBudgRequestDto;
import com.sigep.gbc.dto.responseDto.PpmBudgResponseDto;
import com.sigep.gbc.service.PpmBudgService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/ppmBudg")
@RequiredArgsConstructor
@CrossOrigin
public class PpmBudgController {
	private final PpmBudgService service;

	@PostMapping("/add")
	public ResponseEntity<PpmBudgResponseDto> add(@RequestBody final PpmBudgRequestDto ppmBudgRequestDto) {
		PpmBudgResponseDto responseDto = service.add(ppmBudgRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PpmBudgResponseDto>> getAll() {
		List<PpmBudgResponseDto> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{idPpm}/{codBud}/{idSrceFin}")
	public ResponseEntity<PpmBudgResponseDto> getById(@PathVariable final String idPpm, @PathVariable final String codBud, @PathVariable final String idSrceFin) {
		PpmBudgResponseDto responseDto = service.getById(idPpm, codBud, idSrceFin);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	

	@DeleteMapping("/delete/{idPpm}/{codBud}/{idSrceFin}")
	public ResponseEntity<PpmBudgResponseDto> delete(@PathVariable final String idPpm, @PathVariable final String codBud, @PathVariable final String idSrceFin) {
		PpmBudgResponseDto responseDto = service.delete(idPpm, codBud, idSrceFin);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/edit/{idPpm}/{codBud}/{idSrceFin}")
	public ResponseEntity<PpmBudgResponseDto> edit(@PathVariable final String idPpm, @PathVariable final String codBud, @PathVariable final String idSrceFin, @RequestBody final PpmBudgRequestDto ppmBudgRequestDto) {
		PpmBudgResponseDto responseDto = service.edit(idPpm, codBud, idSrceFin, ppmBudgRequestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	//Arisitde
	 @GetMapping("/getByIdPpm/{idPpm}")
	    public ResponseEntity<List<PpmBudgResponseDto>> getByIdPpm(
	            @PathVariable("idPpm") String idPpm) {
	        try {
	            List<PpmBudgResponseDto> responseDtos = service.getByIdPpm(idPpm);
	            if (responseDtos.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity<>(responseDtos, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 @PostMapping("/addReam")
		public ResponseEntity<PpmBudgResponseDto> addReam(@RequestBody final PpmBudgRequestDto ppmBudgRequestDto) {
			PpmBudgResponseDto responseDto = service.addReam(ppmBudgRequestDto);
			return new ResponseEntity<>(responseDto, HttpStatus.OK);
		}
	 	
}
