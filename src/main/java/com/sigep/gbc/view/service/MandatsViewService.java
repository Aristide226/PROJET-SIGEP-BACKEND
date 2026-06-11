package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.MandatsViewDto;


@Service
public interface MandatsViewService {
	public List<MandatsViewDto> getMandatValideAE2EtSansBordereaus(Short gestion, Integer idBudget);
}
