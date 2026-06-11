package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.AccesCodeAgentDto;
import com.sigep.gbc.dto.AccesCodeDto;
import com.sigep.gbc.entity.AccesCode;


@Service
public interface AccesCodeService {
	public AccesCodeDto add(AccesCodeDto accesCodeDto);
	public List<AccesCodeDto> getAll();
	public AccesCode get(String id);
	public AccesCodeDto getById(String id);
	public AccesCodeDto delete(String id);
	public AccesCodeDto edit(String id, AccesCodeDto accesCodeDto);
	public List<AccesCodeDto> getByAccesCodeNiveau(String code);
	
	public Integer getMaxRangCod(String code);
	
	public List<AccesCodeAgentDto> getUtilisateur();
}
