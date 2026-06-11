package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.AgentAccesCodeAccesCodeNiveauGrpeCodeViewDto;


@Service
public interface AgentAccesCodeAccesCodeNiveauGrpeCodeViewService {
	public List<AgentAccesCodeAccesCodeNiveauGrpeCodeViewDto> getByCode(String code);
}
