package com.sigep.common.controller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("serverDate")
@RequiredArgsConstructor
@CrossOrigin
public class DateController {

	// Renvoie une chaîne ISO 8601 (e.g., "2026-01-19T10:30:00Z")
	@GetMapping("/getServerDate")
	public ResponseEntity<String> getServerDate() {
		String result = Instant.now().toString(); 
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// Alternative : Renvoie le timestamp en millisecondes
	@GetMapping("/getServerTimeMillis")
	public ResponseEntity<Long> getServerTimeMillis() {
		Long result = Instant.now().toEpochMilli();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}	
}
