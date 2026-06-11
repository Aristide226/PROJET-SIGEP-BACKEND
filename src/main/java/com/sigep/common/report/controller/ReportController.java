package com.sigep.common.report.controller;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigep.common.report.exception.ReportNotFoundException;
import com.sigep.common.report.exception.ReprotGenerationException;
import com.sigep.common.report.model.Report;
import com.sigep.common.report.service.ReportService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
@CrossOrigin
public class ReportController {
	private final ReportService reportService;
	
	@PostMapping("/createReport")
	public ResponseEntity<byte[]> createReport(@RequestBody final Report report) {
		try {
			byte[] pdfBytes = reportService.createReport(report);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDisposition(ContentDisposition.attachment().filename(report.getName() + ".pdf").build());
			headers.setCacheControl("must-revalidate, post-check=0, pre-check");
			
			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
		} catch (ReportNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (ReprotGenerationException e) {
			return ResponseEntity.badRequest().body(e.getMessage().getBytes());
		} 
	}
}
