package com.sigep.grh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.grh.dto.AccesCodeDto;
import com.sigep.grh.entity.AccesCode;

@Service
public interface GrhAccesCodeService {
	public AccesCodeDto add(AccesCodeDto accesCodeDto);
	public List<AccesCodeDto> getAll();
	public AccesCode get(String id);
	public AccesCodeDto getById(String id);
	public AccesCodeDto delete(String id);
	public AccesCodeDto edit(String id, AccesCodeDto accesCodeDto);
	public List<AccesCodeDto> getByAccesCodeNiveau(String code);
	
	public Integer getMaxRangCod(String code);
}
