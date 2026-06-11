package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.AgentsDirectionServiceSDestinatairesViewDto;


@Service
public interface AgentsDirectionServiceSDestinatairesViewService {
	public List<AgentsDirectionServiceSDestinatairesViewDto> getAll();
}
