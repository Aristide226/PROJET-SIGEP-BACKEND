package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.InstitutFinAgenceDto;
import com.sigep.gbc.entity.InstitutFinAgence;


@Service
public interface InstitutFinAgenceService {
	public InstitutFinAgenceDto add(InstitutFinAgenceDto institutFinAgenceDto);
	public List<InstitutFinAgenceDto> getAll();
	public InstitutFinAgence get(String id);
	public InstitutFinAgenceDto getById(String id);
	public InstitutFinAgenceDto delete(String id);
	public InstitutFinAgenceDto edit(String id, InstitutFinAgenceDto institutFinAgenceDto);
	public List<InstitutFinAgenceDto> getByAbreviation(String abreviation);
}
