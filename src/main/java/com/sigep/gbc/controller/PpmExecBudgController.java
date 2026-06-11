//Aristide
package com.sigep.gbc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.gbc.dto.requestDto.PpmExecBudgRequestDto;
import com.sigep.gbc.dto.responseDto.PpmExecBudgResponseDto;
import com.sigep.gbc.service.PpmExecBudgService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/ppmExecBudg")
@RequiredArgsConstructor
public class PpmExecBudgController {
    
    private final PpmExecBudgService service;
    
    private static final String BASE_ID_PATH = "/{idPpmExe}/{idLot}/{idBudget}/{exercice}/{codBud}/{idSrceFin}";

    @PostMapping("/add")
    public ResponseEntity<PpmExecBudgResponseDto> add(@RequestBody PpmExecBudgRequestDto ppmExecBudgRequestDto) {
        PpmExecBudgResponseDto responseDto = service.add(ppmExecBudgRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PpmExecBudgResponseDto>> getAll() {
        List<PpmExecBudgResponseDto> responseDtos = service.getAll();
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @GetMapping("/getById"+BASE_ID_PATH)
    public ResponseEntity<PpmExecBudgResponseDto> getById(
        @PathVariable int idPpmExe, @PathVariable int idLot, @PathVariable Integer idBudget, 
        @PathVariable short exercice, @PathVariable String codBud, @PathVariable String idSrceFin) {
        
        PpmExecBudgResponseDto responseDto = service.getById(idPpmExe, idLot, idBudget, exercice, codBud, idSrceFin);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/edit"+BASE_ID_PATH)
    public ResponseEntity<PpmExecBudgResponseDto> edit(
        @PathVariable int idPpmExe, @PathVariable int idLot, @PathVariable Integer idBudget, 
        @PathVariable short exercice, @PathVariable String codBud, @PathVariable String idSrceFin,
        @RequestBody PpmExecBudgRequestDto requestDto) {
        
        PpmExecBudgResponseDto responseDto = service.edit(idPpmExe, idLot, idBudget, exercice, codBud, idSrceFin, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete"+BASE_ID_PATH)
    public ResponseEntity<PpmExecBudgResponseDto> delete(
        @PathVariable int idPpmExe, @PathVariable int idLot, @PathVariable Integer idBudget, 
        @PathVariable short exercice, @PathVariable String codBud, @PathVariable String idSrceFin) {
        
        service.delete(idPpmExe, idLot, idBudget, exercice, codBud, idSrceFin);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/getLignesByLot/{idPpmExe}/{idLot}/{idBudget}/{exercice}")
    public ResponseEntity<List<PpmExecBudgResponseDto>> getLignesByLot(@PathVariable int idPpmExe, @PathVariable int idLot, @PathVariable Integer idBudget, @PathVariable short exercice) {
    	List<PpmExecBudgResponseDto> responseDto = service.getLignesByLot(idPpmExe, idLot, idBudget, exercice);
    	return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}




