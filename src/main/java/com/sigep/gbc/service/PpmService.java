package com.sigep.gbc.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PpmRequestDto;
import com.sigep.gbc.dto.responseDto.PpmResponseDto;
import com.sigep.gbc.entity.Ppm;

import net.sf.jasperreports.engine.JRException;


@Service
public interface PpmService {
	public PpmResponseDto add(PpmRequestDto ppmRequestDto);
	public List<PpmResponseDto> getAll();
	public Ppm get(String id);
	public PpmResponseDto getById(String id);
	public PpmResponseDto delete(String id);
	public PpmResponseDto edit(String id, PpmRequestDto ppmRequestDto);
	
	//Aristide
	public List<PpmResponseDto> getByIdBudgetAndExercice(Integer idBudget, Short exercice);
	int getNextNumForBudgetAndExercice(int idBudget, short exercice);
	public PpmResponseDto addReam(PpmRequestDto ppmRequestDto);
	public PpmResponseDto editReam(String id, PpmRequestDto ppmRequestDto);
	public byte[] generatePpmReport(Integer anneePPM) throws JRException, FileNotFoundException;
	
}
