package com.sigep.grh.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.grh.dto.AccesCodeDto;
import com.sigep.grh.orchestration.GrhLoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/grh/grhLogin")
@RequiredArgsConstructor
@CrossOrigin
public class GrhLoginController {
	private final GrhLoginService service;

	@GetMapping("/getAllAccesCodesForLogin")
	public ResponseEntity<List<AccesCodeDto>> getAllAccesCodesForLogin() {
		List<AccesCodeDto> accesCodeDtos = service.getAllAccesCodesForLogin();
		return new ResponseEntity<>(accesCodeDtos, HttpStatus.OK);
	}
}
