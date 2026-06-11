//Aristide
package com.sigep.gbc.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PpmExecRequestDto;
import com.sigep.gbc.dto.responseDto.PpmExecResponseDto;
import com.sigep.gbc.entity.PpmExec;

import net.sf.jasperreports.engine.JRException;

@Service
public interface PpmExecService  {
	public PpmExecResponseDto add(PpmExecRequestDto ppmExecRequestDto);
	public List<PpmExecResponseDto> getAll();
	public PpmExec get(int idPpmExec,int idLot, Integer idBudget, short exercice);
	public PpmExecResponseDto getById(int idPpmExec,int idLot, Integer idBudget, short exercice);
	public void delete(int idPpmExec,int idLot, Integer idBudget, short exercice);
	public PpmExecResponseDto edit(int idPpmExec,int idLot, Integer idBudget, short exercice, PpmExecRequestDto ppmExecRequestDto);
	public List<PpmExecResponseDto> getAllLotsByIdPpmAndIdBudgetAndExercice(String idPpm, Integer idBudget, short exercice);
	public List<PpmExecResponseDto> getAllLotsByIdPpmExecAndIdBudgetAndExercice(int idPpmExec,Integer idBudget, short exercice);
	public byte[] generatePpmExecReport(Integer anneePPM) throws JRException, FileNotFoundException;
	public byte[] generateVisibilitePrm(Integer anneePPM) throws JRException, FileNotFoundException;
}
