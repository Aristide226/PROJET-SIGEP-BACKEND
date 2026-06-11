package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.RetenuTypeDto;
import com.sigep.gbc.entity.RetenuType;


@Service
public interface RetenuTypeService {
	public RetenuTypeDto add(RetenuTypeDto retenuTypeDto);
	public List<RetenuTypeDto> getAll();
	public RetenuType get(Integer id);
	public RetenuTypeDto getById(Integer id);
	public RetenuTypeDto delete(Integer id);
	public RetenuTypeDto edit(Integer id, RetenuTypeDto retenuTypeDto);
}
