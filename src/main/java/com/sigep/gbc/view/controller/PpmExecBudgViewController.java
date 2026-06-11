package com.sigep.gbc.view.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sigep.gbc.view.service.PpmExecBudgViewService;
import com.sigep.gbc.view.dto.PpmExecBudgViewDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gbc/view/ppmExecBudgView")
@RequiredArgsConstructor
@CrossOrigin
public class PpmExecBudgViewController {
	private final PpmExecBudgViewService service;
	
	@GetMapping("/getByExerciceAndIdBudget/{exercice}/{idBudget}")
	public ResponseEntity<List<PpmExecBudgViewDto>> getByExerciceAndIdBudget(@PathVariable final Short exercice, @PathVariable final Integer idBudget) {
		List<PpmExecBudgViewDto> list = service.getByExerciceAndIdBudget(exercice, idBudget);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
