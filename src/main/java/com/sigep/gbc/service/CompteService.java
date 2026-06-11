package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.CompteDto;
import com.sigep.gbc.entity.Compte;


@Service
public interface CompteService {
	public CompteDto add(CompteDto compteDto);
	public List<CompteDto> getAll();
	public Compte get(String id);
	public CompteDto getById(String id);
	public CompteDto delete(String id);
	public CompteDto edit(String id, CompteDto coDto);
}
