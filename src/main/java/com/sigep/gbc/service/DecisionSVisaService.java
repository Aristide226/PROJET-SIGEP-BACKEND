package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.DecisionSVisaDto;
import com.sigep.gbc.entity.DecisionSvisa;


@Service
public interface DecisionSVisaService {
	public DecisionSVisaDto add(DecisionSVisaDto decisionSVisaDto);
	public List<DecisionSVisaDto> getAll();
	public DecisionSvisa get(Integer id);
	public DecisionSVisaDto getById(Integer id);
	public DecisionSVisaDto delete(Integer id);
	public DecisionSVisaDto edit(Integer newId, Integer oldId, DecisionSVisaDto decisionSVisaDto);
	public Boolean existsById(Integer id);
}
