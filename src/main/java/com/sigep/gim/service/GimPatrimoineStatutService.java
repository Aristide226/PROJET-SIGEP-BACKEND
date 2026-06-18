package com.sigep.gim.service;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PatrimoineStatutRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineStatutResponseDto;
import com.sigep.gim.entity.PatrimoineStatut;

import net.sf.jasperreports.engine.JRException;

@Service
public interface GimPatrimoineStatutService {
	public PatrimoineStatutResponseDto add(PatrimoineStatutRequestDto patrimoineStatutRequestDto);
	public List<PatrimoineStatutResponseDto> getAll();
	public PatrimoineStatut get(String id);
	public PatrimoineStatutResponseDto getById(String id);
	public PatrimoineStatutResponseDto delete(String id);
	public PatrimoineStatutResponseDto edit(String id, PatrimoineStatutRequestDto patrimoineStatutRequestDto);
	public byte[] statutBienReport() throws JRException, FileNotFoundException;
}